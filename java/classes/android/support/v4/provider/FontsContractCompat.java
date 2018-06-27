package android.support.v4.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.graphics.TypefaceCompat;
import android.support.v4.graphics.TypefaceCompatUtil;
import android.support.v4.util.LruCache;
import android.support.v4.util.Preconditions;
import android.support.v4.util.SimpleArrayMap;
import android.widget.TextView;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class FontsContractCompat
{
  private static final int BACKGROUND_THREAD_KEEP_ALIVE_DURATION_MS = 10000;
  public static final String PARCEL_FONT_RESULTS = "font_results";
  public static final int RESULT_CODE_PROVIDER_NOT_FOUND = -1;
  public static final int RESULT_CODE_WRONG_CERTIFICATES = -2;
  private static final String TAG = "FontsContractCompat";
  private static final SelfDestructiveThread sBackgroundThread;
  private static final Comparator<byte[]> sByteArrayComparator = new Comparator()
  {
    public int compare(byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2)
    {
      int k = 0;
      int i;
      if (paramAnonymousArrayOfByte1.length != paramAnonymousArrayOfByte2.length)
      {
        i = paramAnonymousArrayOfByte1.length - paramAnonymousArrayOfByte2.length;
        return i;
      }
      int j = 0;
      for (;;)
      {
        i = k;
        if (j >= paramAnonymousArrayOfByte1.length) {
          break;
        }
        if (paramAnonymousArrayOfByte1[j] != paramAnonymousArrayOfByte2[j]) {
          return paramAnonymousArrayOfByte1[j] - paramAnonymousArrayOfByte2[j];
        }
        j += 1;
      }
    }
  };
  private static final Object sLock;
  private static final SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<Typeface>>> sPendingReplies;
  private static final LruCache<String, Typeface> sTypefaceCache = new LruCache(16);
  
  static
  {
    sBackgroundThread = new SelfDestructiveThread("fonts", 10, 10000);
    sLock = new Object();
    sPendingReplies = new SimpleArrayMap();
  }
  
  public static Typeface buildTypeface(Context paramContext, CancellationSignal paramCancellationSignal, FontInfo[] paramArrayOfFontInfo)
  {
    return TypefaceCompat.createFromFontInfo(paramContext, paramCancellationSignal, paramArrayOfFontInfo, 0);
  }
  
  private static List<byte[]> convertToByteArrayList(Signature[] paramArrayOfSignature)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfSignature.length)
    {
      localArrayList.add(paramArrayOfSignature[i].toByteArray());
      i += 1;
    }
    return localArrayList;
  }
  
  private static boolean equalsByteArrayList(List<byte[]> paramList1, List<byte[]> paramList2)
  {
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList1.size()) {
        break label62;
      }
      if (!Arrays.equals((byte[])paramList1.get(i), (byte[])paramList2.get(i))) {
        break;
      }
      i += 1;
    }
    label62:
    return true;
  }
  
  public static FontFamilyResult fetchFonts(Context paramContext, CancellationSignal paramCancellationSignal, FontRequest paramFontRequest)
    throws PackageManager.NameNotFoundException
  {
    ProviderInfo localProviderInfo = getProvider(paramContext.getPackageManager(), paramFontRequest, paramContext.getResources());
    if (localProviderInfo == null) {
      return new FontFamilyResult(1, null);
    }
    return new FontFamilyResult(0, getFontFromProvider(paramContext, paramFontRequest, localProviderInfo.authority, paramCancellationSignal));
  }
  
  private static List<List<byte[]>> getCertificates(FontRequest paramFontRequest, Resources paramResources)
  {
    if (paramFontRequest.getCertificates() != null) {
      return paramFontRequest.getCertificates();
    }
    return FontResourcesParserCompat.readCerts(paramResources, paramFontRequest.getCertificatesArrayResId());
  }
  
  static FontInfo[] getFontFromProvider(Context paramContext, FontRequest paramFontRequest, String paramString, CancellationSignal paramCancellationSignal)
  {
    ArrayList localArrayList = new ArrayList();
    Uri localUri1 = new Uri.Builder().scheme("content").authority(paramString).build();
    Uri localUri2 = new Uri.Builder().scheme("content").authority(paramString).appendPath("file").build();
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT <= 16) {
          continue;
        }
        paramContext = paramContext.getContentResolver();
        paramFontRequest = paramFontRequest.getQuery();
        paramContext = paramContext.query(localUri1, new String[] { "_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code" }, "query = ?", new String[] { paramFontRequest }, null, paramCancellationSignal);
        if (paramContext == null) {
          continue;
        }
        try
        {
          if (paramContext.getCount() <= 0) {
            continue;
          }
          int m = paramContext.getColumnIndex("result_code");
          paramString = new ArrayList();
          int n = paramContext.getColumnIndex("_id");
          i1 = paramContext.getColumnIndex("file_id");
          int i2 = paramContext.getColumnIndex("font_ttc_index");
          int i3 = paramContext.getColumnIndex("font_weight");
          int i4 = paramContext.getColumnIndex("font_italic");
          paramFontRequest = paramString;
          if (!paramContext.moveToNext()) {
            continue;
          }
          if (m == -1) {
            continue;
          }
          i = paramContext.getInt(m);
          if (i2 == -1) {
            continue;
          }
          j = paramContext.getInt(i2);
          if (i1 != -1) {
            continue;
          }
          paramFontRequest = ContentUris.withAppendedId(localUri1, paramContext.getLong(n));
          if (i3 == -1) {
            continue;
          }
          k = paramContext.getInt(i3);
          if ((i4 == -1) || (paramContext.getInt(i4) != 1)) {
            continue;
          }
          bool = true;
          paramString.add(new FontInfo(paramFontRequest, j, k, bool, i));
          continue;
          if (paramFontRequest == null) {
            continue;
          }
        }
        finally
        {
          paramFontRequest = paramContext;
          paramContext = paramString;
        }
      }
      finally
      {
        int i1;
        int i;
        int j;
        int k;
        boolean bool;
        paramFontRequest = null;
        continue;
      }
      paramFontRequest.close();
      throw paramContext;
      paramContext = paramContext.getContentResolver();
      paramFontRequest = paramFontRequest.getQuery();
      paramContext = paramContext.query(localUri1, new String[] { "_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code" }, "query = ?", new String[] { paramFontRequest }, null);
      continue;
      i = 0;
      continue;
      j = 0;
      continue;
      paramFontRequest = ContentUris.withAppendedId(localUri2, paramContext.getLong(i1));
      continue;
      k = 400;
      continue;
      bool = false;
    }
    paramFontRequest = localArrayList;
    if (paramContext != null) {
      paramContext.close();
    }
    return (FontInfo[])paramFontRequest.toArray(new FontInfo[0]);
  }
  
  private static Typeface getFontInternal(Context paramContext, FontRequest paramFontRequest, int paramInt)
  {
    Object localObject = null;
    try
    {
      FontFamilyResult localFontFamilyResult = fetchFonts(paramContext, null, paramFontRequest);
      paramFontRequest = (FontRequest)localObject;
      if (localFontFamilyResult.getStatusCode() == 0) {
        paramFontRequest = TypefaceCompat.createFromFontInfo(paramContext, null, localFontFamilyResult.getFonts(), paramInt);
      }
      return paramFontRequest;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static Typeface getFontSync(Context paramContext, FontRequest arg1, final TextView paramTextView, int paramInt1, int paramInt2, final int paramInt3)
  {
    final String str = ???.getIdentifier() + "-" + paramInt3;
    Object localObject = (Typeface)sTypefaceCache.get(str);
    if (localObject != null) {
      return (Typeface)localObject;
    }
    if (paramInt1 == 0) {}
    for (paramInt1 = 1; (paramInt1 != 0) && (paramInt2 == -1); paramInt1 = 0) {
      return getFontInternal(paramContext, ???, paramInt3);
    }
    paramContext = new Callable()
    {
      public Typeface call()
        throws Exception
      {
        Typeface localTypeface = FontsContractCompat.getFontInternal(this.val$context, paramFontRequest, paramInt3);
        if (localTypeface != null) {
          FontsContractCompat.sTypefaceCache.put(str, localTypeface);
        }
        return localTypeface;
      }
    };
    if (paramInt1 != 0) {
      try
      {
        paramContext = (Typeface)sBackgroundThread.postAndWait(paramContext, paramInt2);
        return paramContext;
      }
      catch (InterruptedException paramContext)
      {
        return null;
      }
    }
    paramTextView = new SelfDestructiveThread.ReplyCallback()
    {
      public void onReply(Typeface paramAnonymousTypeface)
      {
        if ((TextView)this.val$textViewWeak.get() != null) {
          paramTextView.setTypeface(paramAnonymousTypeface, paramInt3);
        }
      }
    };
    synchronized (sLock)
    {
      if (sPendingReplies.containsKey(str))
      {
        ((ArrayList)sPendingReplies.get(str)).add(paramTextView);
        return null;
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramTextView);
      sPendingReplies.put(str, localObject);
      sBackgroundThread.postAndReply(paramContext, new SelfDestructiveThread.ReplyCallback()
      {
        public void onReply(Typeface paramAnonymousTypeface)
        {
          synchronized (FontsContractCompat.sLock)
          {
            ArrayList localArrayList = (ArrayList)FontsContractCompat.sPendingReplies.get(this.val$id);
            FontsContractCompat.sPendingReplies.remove(this.val$id);
            int i = 0;
            if (i < localArrayList.size())
            {
              ((SelfDestructiveThread.ReplyCallback)localArrayList.get(i)).onReply(paramAnonymousTypeface);
              i += 1;
            }
          }
        }
      });
      return null;
    }
  }
  
  public static ProviderInfo getProvider(PackageManager paramPackageManager, FontRequest paramFontRequest, Resources paramResources)
    throws PackageManager.NameNotFoundException
  {
    String str = paramFontRequest.getProviderAuthority();
    ProviderInfo localProviderInfo = paramPackageManager.resolveContentProvider(str, 0);
    if (localProviderInfo == null) {
      throw new PackageManager.NameNotFoundException("No package found for authority: " + str);
    }
    if (!localProviderInfo.packageName.equals(paramFontRequest.getProviderPackage())) {
      throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + paramFontRequest.getProviderPackage());
    }
    paramPackageManager = convertToByteArrayList(paramPackageManager.getPackageInfo(localProviderInfo.packageName, 64).signatures);
    Collections.sort(paramPackageManager, sByteArrayComparator);
    paramFontRequest = getCertificates(paramFontRequest, paramResources);
    int i = 0;
    while (i < paramFontRequest.size())
    {
      paramResources = new ArrayList((Collection)paramFontRequest.get(i));
      Collections.sort(paramResources, sByteArrayComparator);
      if (equalsByteArrayList(paramPackageManager, paramResources)) {
        return localProviderInfo;
      }
      i += 1;
    }
    return null;
  }
  
  public static Map<Uri, ByteBuffer> prepareFontData(Context paramContext, FontInfo[] paramArrayOfFontInfo, CancellationSignal paramCancellationSignal)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayOfFontInfo.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramArrayOfFontInfo[i];
      if (((FontInfo)localObject).getResultCode() != 0) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = ((FontInfo)localObject).getUri();
        if (!localHashMap.containsKey(localObject)) {
          localHashMap.put(localObject, TypefaceCompatUtil.mmap(paramContext, paramCancellationSignal, (Uri)localObject));
        }
      }
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public static void requestFont(Context paramContext, final FontRequest paramFontRequest, final FontRequestCallback paramFontRequestCallback, Handler paramHandler)
  {
    paramHandler.post(new Runnable()
    {
      public void run()
      {
        try
        {
          FontsContractCompat.FontFamilyResult localFontFamilyResult = FontsContractCompat.fetchFonts(this.val$context, null, paramFontRequest);
          if (localFontFamilyResult.getStatusCode() == 0) {
            break label117;
          }
          switch (localFontFamilyResult.getStatusCode())
          {
          default: 
            this.val$callerThreadHandler.post(new Runnable()
            {
              public void run()
              {
                FontsContractCompat.4.this.val$callback.onTypefaceRequestFailed(-3);
              }
            });
            return;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          this.val$callerThreadHandler.post(new Runnable()
          {
            public void run()
            {
              FontsContractCompat.4.this.val$callback.onTypefaceRequestFailed(-1);
            }
          });
          return;
        }
        this.val$callerThreadHandler.post(new Runnable()
        {
          public void run()
          {
            FontsContractCompat.4.this.val$callback.onTypefaceRequestFailed(-2);
          }
        });
        return;
        this.val$callerThreadHandler.post(new Runnable()
        {
          public void run()
          {
            FontsContractCompat.4.this.val$callback.onTypefaceRequestFailed(-3);
          }
        });
        return;
        label117:
        final Object localObject1 = localNameNotFoundException.getFonts();
        if ((localObject1 == null) || (localObject1.length == 0))
        {
          this.val$callerThreadHandler.post(new Runnable()
          {
            public void run()
            {
              FontsContractCompat.4.this.val$callback.onTypefaceRequestFailed(1);
            }
          });
          return;
        }
        int j = localObject1.length;
        final int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (((FontsContractCompat.FontInfo)localObject2).getResultCode() != 0)
          {
            i = ((FontsContractCompat.FontInfo)localObject2).getResultCode();
            if (i < 0)
            {
              this.val$callerThreadHandler.post(new Runnable()
              {
                public void run()
                {
                  FontsContractCompat.4.this.val$callback.onTypefaceRequestFailed(-3);
                }
              });
              return;
            }
            this.val$callerThreadHandler.post(new Runnable()
            {
              public void run()
              {
                FontsContractCompat.4.this.val$callback.onTypefaceRequestFailed(i);
              }
            });
            return;
          }
          i += 1;
        }
        localObject1 = FontsContractCompat.buildTypeface(this.val$context, null, (FontsContractCompat.FontInfo[])localObject1);
        if (localObject1 == null)
        {
          this.val$callerThreadHandler.post(new Runnable()
          {
            public void run()
            {
              FontsContractCompat.4.this.val$callback.onTypefaceRequestFailed(-3);
            }
          });
          return;
        }
        this.val$callerThreadHandler.post(new Runnable()
        {
          public void run()
          {
            FontsContractCompat.4.this.val$callback.onTypefaceRetrieved(localObject1);
          }
        });
      }
    });
  }
  
  public static final class Columns
    implements BaseColumns
  {
    public static final String FILE_ID = "file_id";
    public static final String ITALIC = "font_italic";
    public static final String RESULT_CODE = "result_code";
    public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
    public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
    public static final int RESULT_CODE_MALFORMED_QUERY = 3;
    public static final int RESULT_CODE_OK = 0;
    public static final String TTC_INDEX = "font_ttc_index";
    public static final String VARIATION_SETTINGS = "font_variation_settings";
    public static final String WEIGHT = "font_weight";
  }
  
  public static class FontFamilyResult
  {
    public static final int STATUS_OK = 0;
    public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
    public static final int STATUS_WRONG_CERTIFICATES = 1;
    private final FontsContractCompat.FontInfo[] mFonts;
    private final int mStatusCode;
    
    public FontFamilyResult(int paramInt, FontsContractCompat.FontInfo[] paramArrayOfFontInfo)
    {
      this.mStatusCode = paramInt;
      this.mFonts = paramArrayOfFontInfo;
    }
    
    public FontsContractCompat.FontInfo[] getFonts()
    {
      return this.mFonts;
    }
    
    public int getStatusCode()
    {
      return this.mStatusCode;
    }
    
    @Retention(RetentionPolicy.SOURCE)
    static @interface FontResultStatus {}
  }
  
  public static class FontInfo
  {
    private final boolean mItalic;
    private final int mResultCode;
    private final int mTtcIndex;
    private final Uri mUri;
    private final int mWeight;
    
    public FontInfo(Uri paramUri, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      this.mUri = ((Uri)Preconditions.checkNotNull(paramUri));
      this.mTtcIndex = paramInt1;
      this.mWeight = paramInt2;
      this.mItalic = paramBoolean;
      this.mResultCode = paramInt3;
    }
    
    public int getResultCode()
    {
      return this.mResultCode;
    }
    
    public int getTtcIndex()
    {
      return this.mTtcIndex;
    }
    
    public Uri getUri()
    {
      return this.mUri;
    }
    
    public int getWeight()
    {
      return this.mWeight;
    }
    
    public boolean isItalic()
    {
      return this.mItalic;
    }
  }
  
  public static class FontRequestCallback
  {
    public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
    public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
    public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
    public static final int FAIL_REASON_MALFORMED_QUERY = 3;
    public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
    public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;
    
    public void onTypefaceRequestFailed(int paramInt) {}
    
    public void onTypefaceRetrieved(Typeface paramTypeface) {}
    
    @Retention(RetentionPolicy.SOURCE)
    static @interface FontRequestFailReason {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v4/provider/FontsContractCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */