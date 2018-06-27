package com.mob.tools.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.opengl.GLES10;
import android.text.TextUtils;
import android.view.View;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.HttpConnection;
import com.mob.tools.network.HttpResponseCallback;
import com.mob.tools.network.NetworkHelper;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BitmapHelper
{
  private static final int DEFAULT_MAX_BITMAP_DIMENSION = 2048;
  private static int maxBitmapHeight;
  private static int maxBitmapWidth;
  
  static
  {
    int[] arrayOfInt = new int[1];
    GLES10.glGetIntegerv(3379, arrayOfInt, 0);
    int i = Math.max(arrayOfInt[0], 2048);
    maxBitmapWidth = i;
    maxBitmapHeight = i;
  }
  
  public static Bitmap blur(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    paramInt1 = (int)(paramInt1 / paramInt2 + 0.5F);
    Bitmap localBitmap = Bitmap.createBitmap((int)(i / paramInt2 + 0.5F), (int)(j / paramInt2 + 0.5F), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.scale(1.0F / paramInt2, 1.0F / paramInt2);
    Paint localPaint = new Paint();
    localPaint.setFlags(2);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    blur(localBitmap, paramInt1, true);
    return localBitmap;
  }
  
  private static Bitmap blur(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    while (paramInt < 1)
    {
      return null;
      paramBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
    }
    int i12 = paramBitmap.getWidth();
    int i13 = paramBitmap.getHeight();
    int[] arrayOfInt1 = new int[i12 * i13];
    paramBitmap.getPixels(arrayOfInt1, 0, i12, 0, 0, i12, i13);
    int i11 = i12 - 1;
    int i14 = i13 - 1;
    int i = i12 * i13;
    int i15 = paramInt + paramInt + 1;
    int[] arrayOfInt2 = new int[i];
    int[] arrayOfInt3 = new int[i];
    int[] arrayOfInt4 = new int[i];
    int[] arrayOfInt5 = new int[Math.max(i12, i13)];
    i = i15 + 1 >> 1;
    int j = i * i;
    int[] arrayOfInt6 = new int[j * 256];
    i = 0;
    while (i < j * 256)
    {
      arrayOfInt6[i] = (i / j);
      i += 1;
    }
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i15, 3 });
    int i16 = paramInt + 1;
    int i7 = 0;
    i = 0;
    int i6 = 0;
    int i8;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int k;
    int i9;
    int[] arrayOfInt7;
    int i10;
    int i17;
    while (i6 < i13)
    {
      j = 0;
      i8 = -paramInt;
      m = 0;
      n = 0;
      i1 = 0;
      i2 = 0;
      i3 = 0;
      i4 = 0;
      i5 = 0;
      k = 0;
      if (i8 <= paramInt)
      {
        i9 = arrayOfInt1[(Math.min(i11, Math.max(i8, 0)) + i)];
        arrayOfInt7 = arrayOfInt[(i8 + paramInt)];
        arrayOfInt7[0] = ((0xFF0000 & i9) >> 16);
        arrayOfInt7[1] = ((0xFF00 & i9) >> 8);
        arrayOfInt7[2] = (i9 & 0xFF);
        i9 = i16 - Math.abs(i8);
        i5 += arrayOfInt7[0] * i9;
        i4 += arrayOfInt7[1] * i9;
        i3 += i9 * arrayOfInt7[2];
        if (i8 > 0)
        {
          m += arrayOfInt7[0];
          k += arrayOfInt7[1];
          j += arrayOfInt7[2];
        }
        for (;;)
        {
          i8 += 1;
          break;
          i2 += arrayOfInt7[0];
          i1 += arrayOfInt7[1];
          n += arrayOfInt7[2];
        }
      }
      i8 = i4;
      i10 = 0;
      i4 = paramInt;
      i9 = i5;
      i5 = i3;
      i3 = i10;
      while (i3 < i12)
      {
        arrayOfInt2[i] = arrayOfInt6[i9];
        arrayOfInt3[i] = arrayOfInt6[i8];
        arrayOfInt4[i] = arrayOfInt6[i5];
        arrayOfInt7 = arrayOfInt[((i4 - paramInt + i15) % i15)];
        int i18 = arrayOfInt7[0];
        i17 = arrayOfInt7[1];
        i10 = arrayOfInt7[2];
        if (i6 == 0) {
          arrayOfInt5[i3] = Math.min(i3 + paramInt + 1, i11);
        }
        int i19 = arrayOfInt1[(arrayOfInt5[i3] + i7)];
        arrayOfInt7[0] = ((0xFF0000 & i19) >> 16);
        arrayOfInt7[1] = ((0xFF00 & i19) >> 8);
        arrayOfInt7[2] = (i19 & 0xFF);
        m += arrayOfInt7[0];
        k += arrayOfInt7[1];
        j += arrayOfInt7[2];
        i9 = i9 - i2 + m;
        i8 = i8 - i1 + k;
        i5 = i5 - n + j;
        i4 = (i4 + 1) % i15;
        arrayOfInt7 = arrayOfInt[(i4 % i15)];
        i2 = i2 - i18 + arrayOfInt7[0];
        i1 = i1 - i17 + arrayOfInt7[1];
        n = n - i10 + arrayOfInt7[2];
        m -= arrayOfInt7[0];
        k -= arrayOfInt7[1];
        j -= arrayOfInt7[2];
        i += 1;
        i3 += 1;
      }
      i7 += i12;
      i6 += 1;
    }
    i = 0;
    while (i < i12)
    {
      i5 = 0;
      i7 = -paramInt * i12;
      i6 = -paramInt;
      i3 = 0;
      n = 0;
      i1 = 0;
      i2 = 0;
      j = 0;
      m = 0;
      k = 0;
      i4 = 0;
      if (i6 <= paramInt)
      {
        i8 = Math.max(0, i7) + i;
        arrayOfInt7 = arrayOfInt[(i6 + paramInt)];
        arrayOfInt7[0] = arrayOfInt2[i8];
        arrayOfInt7[1] = arrayOfInt3[i8];
        arrayOfInt7[2] = arrayOfInt4[i8];
        i9 = i16 - Math.abs(i6);
        i10 = arrayOfInt2[i8];
        i11 = arrayOfInt3[i8];
        i17 = arrayOfInt4[i8];
        if (i6 > 0)
        {
          i3 += arrayOfInt7[0];
          i4 += arrayOfInt7[1];
          i5 += arrayOfInt7[2];
        }
        for (;;)
        {
          i8 = i7;
          if (i6 < i14) {
            i8 = i7 + i12;
          }
          i6 += 1;
          j = i17 * i9 + j;
          m = i11 * i9 + m;
          k = i10 * i9 + k;
          i7 = i8;
          break;
          i2 += arrayOfInt7[0];
          i1 += arrayOfInt7[1];
          n += arrayOfInt7[2];
        }
      }
      i9 = m;
      i10 = k;
      i11 = 0;
      k = i;
      i6 = i5;
      i7 = i4;
      i8 = i3;
      m = n;
      n = i1;
      i1 = i2;
      i2 = paramInt;
      i5 = i10;
      i4 = i9;
      i3 = j;
      j = i11;
      while (j < i13)
      {
        arrayOfInt1[k] = (0xFF000000 & arrayOfInt1[k] | arrayOfInt6[i5] << 16 | arrayOfInt6[i4] << 8 | arrayOfInt6[i3]);
        arrayOfInt7 = arrayOfInt[((i2 - paramInt + i15) % i15)];
        i11 = arrayOfInt7[0];
        i10 = arrayOfInt7[1];
        i9 = arrayOfInt7[2];
        if (i == 0) {
          arrayOfInt5[j] = (Math.min(j + i16, i14) * i12);
        }
        i17 = arrayOfInt5[j] + i;
        arrayOfInt7[0] = arrayOfInt2[i17];
        arrayOfInt7[1] = arrayOfInt3[i17];
        arrayOfInt7[2] = arrayOfInt4[i17];
        i8 += arrayOfInt7[0];
        i7 += arrayOfInt7[1];
        i6 += arrayOfInt7[2];
        i5 = i5 - i1 + i8;
        i4 = i4 - n + i7;
        i3 = i3 - m + i6;
        i2 = (i2 + 1) % i15;
        arrayOfInt7 = arrayOfInt[i2];
        i1 = i1 - i11 + arrayOfInt7[0];
        n = n - i10 + arrayOfInt7[1];
        m = m - i9 + arrayOfInt7[2];
        i8 -= arrayOfInt7[0];
        i7 -= arrayOfInt7[1];
        i6 -= arrayOfInt7[2];
        k += i12;
        j += 1;
      }
      i += 1;
    }
    paramBitmap.setPixels(arrayOfInt1, 0, i12, 0, 0, i12, i13);
    return paramBitmap;
  }
  
  private static boolean bytesStartWith(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramArrayOfByte1 == paramArrayOfByte2) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramArrayOfByte1 == null);
        bool1 = bool2;
      } while (paramArrayOfByte2 == null);
      bool1 = bool2;
    } while (paramArrayOfByte1.length < paramArrayOfByte2.length);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte2.length) {
        break label63;
      }
      bool1 = bool2;
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        break;
      }
      i += 1;
    }
    label63:
    return true;
  }
  
  public static Bitmap captureView(View paramView, int paramInt1, int paramInt2)
    throws Throwable
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(localBitmap));
    return localBitmap;
  }
  
  public static Bitmap compressByQuality(Bitmap paramBitmap, int paramInt)
  {
    return compressByQuality(paramBitmap, paramInt, false);
  }
  
  public static Bitmap compressByQuality(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    if (isEmptyBitmap(paramBitmap)) {
      return null;
    }
    Object localObject = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, (OutputStream)localObject);
    localObject = ((ByteArrayOutputStream)localObject).toByteArray();
    if ((paramBoolean) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
    return BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
  }
  
  public static Bitmap compressByQuality(Bitmap paramBitmap, long paramLong)
  {
    return compressByQuality(paramBitmap, paramLong, false);
  }
  
  public static Bitmap compressByQuality(Bitmap paramBitmap, long paramLong, boolean paramBoolean)
  {
    int k = 100;
    if ((isEmptyBitmap(paramBitmap)) || (paramLong <= 0L)) {
      return null;
    }
    Object localObject = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
    if (((ByteArrayOutputStream)localObject).size() <= paramLong) {}
    for (localObject = ((ByteArrayOutputStream)localObject).toByteArray();; localObject = ((ByteArrayOutputStream)localObject).toByteArray())
    {
      if ((paramBoolean) && (!paramBitmap.isRecycled())) {
        paramBitmap.recycle();
      }
      return BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
      ((ByteArrayOutputStream)localObject).reset();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 0, (OutputStream)localObject);
      if (((ByteArrayOutputStream)localObject).size() < paramLong) {
        break;
      }
    }
    int i = 0;
    int j = 0;
    for (;;)
    {
      int m;
      if (j < k)
      {
        i = (j + k) / 2;
        ((ByteArrayOutputStream)localObject).reset();
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, i, (OutputStream)localObject);
        m = ((ByteArrayOutputStream)localObject).size();
        if (m != paramLong) {}
      }
      else
      {
        if (k == i - 1)
        {
          ((ByteArrayOutputStream)localObject).reset();
          paramBitmap.compress(Bitmap.CompressFormat.JPEG, j, (OutputStream)localObject);
        }
        localObject = ((ByteArrayOutputStream)localObject).toByteArray();
        break;
      }
      if (m > paramLong) {
        k = i - 1;
      } else {
        j = i + 1;
      }
    }
  }
  
  public static Bitmap cropBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws Throwable
  {
    paramInt3 = paramBitmap.getWidth() - paramInt1 - paramInt3;
    paramInt4 = paramBitmap.getHeight() - paramInt2 - paramInt4;
    if ((paramInt3 == paramBitmap.getWidth()) && (paramInt4 == paramBitmap.getHeight())) {
      return paramBitmap;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localCanvas.drawBitmap(paramBitmap, -paramInt1, -paramInt2, localPaint);
    return localBitmap;
  }
  
  public static String downloadBitmap(final Context paramContext, String paramString)
    throws Throwable
  {
    paramContext = ResHelper.getCachePath(paramContext, "images");
    final Object localObject = new File(paramContext, Data.MD5(paramString));
    if (((File)localObject).exists()) {
      return ((File)localObject).getAbsolutePath();
    }
    localObject = new HashMap();
    new NetworkHelper().rawGet(paramString, new HttpResponseCallback()
    {
      public void onResponse(HttpConnection paramAnonymousHttpConnection)
        throws Throwable
      {
        int i = paramAnonymousHttpConnection.getResponseCode();
        if (i == 200)
        {
          localObject2 = BitmapHelper.getFileName(paramAnonymousHttpConnection, this.val$imageUrl);
          localObject1 = new File(paramContext, (String)localObject2);
          if (((File)localObject1).exists())
          {
            localObject.put("bitmap", ((File)localObject1).getAbsolutePath());
            return;
          }
          if (!((File)localObject1).getParentFile().exists()) {
            ((File)localObject1).getParentFile().mkdirs();
          }
          if (((File)localObject1).exists()) {
            ((File)localObject1).delete();
          }
          for (;;)
          {
            FileOutputStream localFileOutputStream;
            try
            {
              paramAnonymousHttpConnection = BitmapHelper.getBitmap(new FilterInputStream(paramAnonymousHttpConnection.getInputStream())
              {
                public long skip(long paramAnonymous2Long)
                  throws IOException
                {
                  long l2;
                  for (long l1 = 0L;; l1 += l2) {
                    if (l1 < paramAnonymous2Long)
                    {
                      l2 = this.in.skip(paramAnonymous2Long - l1);
                      if (l2 != 0L) {}
                    }
                    else
                    {
                      return l1;
                    }
                  }
                }
              }, 1);
              if ((paramAnonymousHttpConnection == null) || (paramAnonymousHttpConnection.isRecycled())) {
                break;
              }
              localFileOutputStream = new FileOutputStream((File)localObject1);
              if ((((String)localObject2).toLowerCase().endsWith(".gif")) || (((String)localObject2).toLowerCase().endsWith(".png")))
              {
                paramAnonymousHttpConnection.compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
                localFileOutputStream.flush();
                localFileOutputStream.close();
                localObject.put("bitmap", ((File)localObject1).getAbsolutePath());
                return;
              }
            }
            catch (Throwable paramAnonymousHttpConnection)
            {
              if (((File)localObject1).exists()) {
                ((File)localObject1).delete();
              }
              throw paramAnonymousHttpConnection;
            }
            paramAnonymousHttpConnection.compress(Bitmap.CompressFormat.JPEG, 80, localFileOutputStream);
          }
        }
        Object localObject1 = new StringBuilder();
        Object localObject2 = new BufferedReader(new InputStreamReader(paramAnonymousHttpConnection.getErrorStream(), Charset.forName("utf-8")));
        for (paramAnonymousHttpConnection = ((BufferedReader)localObject2).readLine(); paramAnonymousHttpConnection != null; paramAnonymousHttpConnection = ((BufferedReader)localObject2).readLine())
        {
          if (((StringBuilder)localObject1).length() > 0) {
            ((StringBuilder)localObject1).append('\n');
          }
          ((StringBuilder)localObject1).append(paramAnonymousHttpConnection);
        }
        ((BufferedReader)localObject2).close();
        paramAnonymousHttpConnection = new HashMap();
        paramAnonymousHttpConnection.put("error", ((StringBuilder)localObject1).toString());
        paramAnonymousHttpConnection.put("status", Integer.valueOf(i));
        throw new Throwable(new Hashon().fromHashMap(paramAnonymousHttpConnection));
      }
    }, null);
    return (String)((HashMap)localObject).get("bitmap");
  }
  
  public static int[] fixRect(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = new int[2];
    if (paramArrayOfInt1[0] / paramArrayOfInt1[1] > paramArrayOfInt2[0] / paramArrayOfInt2[1])
    {
      arrayOfInt[0] = paramArrayOfInt2[0];
      arrayOfInt[1] = ((int)(paramArrayOfInt1[1] * paramArrayOfInt2[0] / paramArrayOfInt1[0] + 0.5F));
      return arrayOfInt;
    }
    arrayOfInt[1] = paramArrayOfInt2[1];
    arrayOfInt[0] = ((int)(paramArrayOfInt1[0] * paramArrayOfInt2[1] / paramArrayOfInt1[1] + 0.5F));
    return arrayOfInt;
  }
  
  public static int[] fixRect_2(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = new int[2];
    if (paramArrayOfInt1[0] / paramArrayOfInt1[1] > paramArrayOfInt2[0] / paramArrayOfInt2[1])
    {
      arrayOfInt[1] = paramArrayOfInt2[1];
      arrayOfInt[0] = ((int)(paramArrayOfInt1[0] * paramArrayOfInt2[1] / paramArrayOfInt1[1] + 0.5F));
      return arrayOfInt;
    }
    arrayOfInt[0] = paramArrayOfInt2[0];
    arrayOfInt[1] = ((int)(paramArrayOfInt1[1] * paramArrayOfInt2[0] / paramArrayOfInt1[0] + 0.5F));
    return arrayOfInt;
  }
  
  public static Bitmap getBitmap(Context paramContext, String paramString)
    throws Throwable
  {
    return getBitmap(downloadBitmap(paramContext, paramString));
  }
  
  public static Bitmap getBitmap(File paramFile, int paramInt)
    throws Throwable
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return null;
    }
    paramFile = new FileInputStream(paramFile);
    Bitmap localBitmap = getBitmap(paramFile, paramInt);
    paramFile.close();
    return localBitmap;
  }
  
  public static Bitmap getBitmap(InputStream paramInputStream, int paramInt)
  {
    if (paramInputStream == null) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    localOptions.inSampleSize = paramInt;
    return BitmapFactory.decodeStream(paramInputStream, null, localOptions);
  }
  
  public static Bitmap getBitmap(String paramString)
    throws Throwable
  {
    return getBitmap(paramString, 1);
  }
  
  public static Bitmap getBitmap(String paramString, int paramInt)
    throws Throwable
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return getBitmap(new File(paramString), paramInt);
  }
  
  public static Bitmap getBitmapByCompressQuality(String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong)
    throws Throwable
  {
    Object localObject = getBitmapByCompressSize(paramString, paramInt1, paramInt2);
    if (paramInt3 >= 10)
    {
      paramInt1 = paramInt3;
      if (paramInt3 <= 100) {}
    }
    else
    {
      paramInt1 = 100;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Bitmap.CompressFormat localCompressFormat = getBmpFormat(paramString);
    ((Bitmap)localObject).compress(localCompressFormat, paramInt1, localByteArrayOutputStream);
    byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
    paramString = arrayOfByte;
    if (paramLong < 10240L) {
      localObject = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
    }
    for (;;)
    {
      try
      {
        localByteArrayOutputStream.close();
        return (Bitmap)localObject;
      }
      catch (Throwable paramString) {}
      localByteArrayOutputStream.reset();
      paramInt1 -= 6;
      ((Bitmap)localObject).compress(localCompressFormat, paramInt1, localByteArrayOutputStream);
      paramString = localByteArrayOutputStream.toByteArray();
      if ((paramString.length <= paramLong) || (paramInt1 < 11))
      {
        if (paramInt1 == 100) {}
        for (paramString = (String)localObject;; paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length))
        {
          localObject = paramString;
          if (localByteArrayOutputStream == null) {
            break;
          }
          try
          {
            localByteArrayOutputStream.close();
            return paramString;
          }
          catch (Throwable localThrowable)
          {
            return paramString;
          }
        }
      }
    }
    return localThrowable;
  }
  
  public static Bitmap getBitmapByCompressSize(String paramString, int paramInt1, int paramInt2)
    throws Throwable
  {
    float f1 = 1.0F;
    int i = 1;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    int j = localOptions.outWidth;
    int k = localOptions.outHeight;
    float f3;
    float f4;
    float f2;
    if ((paramInt1 > 1) && (paramInt2 > 1))
    {
      f3 = Math.min(j, k) * 1.0F / Math.min(paramInt1, paramInt2);
      f4 = Math.max(j, k) * 1.0F / Math.max(paramInt1, paramInt2);
      float f5 = j / k;
      f2 = f1;
      if (f5 <= 2.0F)
      {
        if (f5 >= 0.5D) {}
      }
      else
      {
        for (f2 = f1; f2 * 2.0F <= f3; f2 *= 2.0F) {}
        paramInt1 = (int)f2;
      }
    }
    for (;;)
    {
      if (paramInt1 < 1) {
        paramInt1 = i;
      }
      for (;;)
      {
        if ((j / paramInt1 > maxBitmapWidth) || (k / paramInt1 > maxBitmapHeight))
        {
          paramInt1 += 1;
          continue;
          f2 = Math.min(f3, f4);
          while (f1 * 2.0F <= f2) {
            f1 *= 2.0F;
          }
          paramInt1 = (int)f1;
          break;
        }
        localOptions = new BitmapFactory.Options();
        localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        localOptions.inSampleSize = paramInt1;
        return BitmapFactory.decodeFile(paramString, localOptions);
      }
      paramInt1 = 1;
    }
  }
  
  public static Bitmap.CompressFormat getBmpFormat(String paramString)
  {
    String str = paramString.toLowerCase();
    if ((str.endsWith("png")) || (str.endsWith("gif"))) {
      return Bitmap.CompressFormat.PNG;
    }
    if ((str.endsWith("jpg")) || (str.endsWith("jpeg")) || (str.endsWith("bmp")) || (str.endsWith("tif"))) {
      return Bitmap.CompressFormat.JPEG;
    }
    paramString = getMime(paramString);
    if ((paramString.endsWith("png")) || (paramString.endsWith("gif"))) {
      return Bitmap.CompressFormat.PNG;
    }
    return Bitmap.CompressFormat.JPEG;
  }
  
  public static Bitmap.CompressFormat getBmpFormat(byte[] paramArrayOfByte)
  {
    String str = getMime(paramArrayOfByte);
    Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.JPEG;
    paramArrayOfByte = localCompressFormat;
    if (str != null) {
      if (!str.endsWith("png"))
      {
        paramArrayOfByte = localCompressFormat;
        if (!str.endsWith("gif")) {}
      }
      else
      {
        paramArrayOfByte = Bitmap.CompressFormat.PNG;
      }
    }
    return paramArrayOfByte;
  }
  
  private static String getFileName(HttpConnection paramHttpConnection, String paramString)
    throws Throwable
  {
    Map localMap = paramHttpConnection.getHeaderFields();
    if (localMap != null)
    {
      paramHttpConnection = (List)localMap.get("Content-Disposition");
      if ((paramHttpConnection != null) && (paramHttpConnection.size() > 0))
      {
        String[] arrayOfString = ((String)paramHttpConnection.get(0)).split(";");
        int j = arrayOfString.length;
        i = 0;
        paramHttpConnection = null;
        for (;;)
        {
          localObject = paramHttpConnection;
          if (i >= j) {
            break;
          }
          localObject = arrayOfString[i];
          if (((String)localObject).trim().startsWith("filename"))
          {
            localObject = localObject.split("=")[1];
            paramHttpConnection = (HttpConnection)localObject;
            if (((String)localObject).startsWith("\""))
            {
              paramHttpConnection = (HttpConnection)localObject;
              if (((String)localObject).endsWith("\"")) {
                paramHttpConnection = ((String)localObject).substring(1, ((String)localObject).length() - 1);
              }
            }
          }
          i += 1;
        }
      }
    }
    Object localObject = null;
    paramHttpConnection = (HttpConnection)localObject;
    if (localObject == null)
    {
      localObject = Data.MD5(paramString);
      if (localMap == null) {
        break label376;
      }
      paramHttpConnection = (List)localMap.get("Content-Type");
      if ((paramHttpConnection == null) || (paramHttpConnection.size() <= 0)) {
        break label376;
      }
      paramHttpConnection = (String)paramHttpConnection.get(0);
      if (paramHttpConnection != null) {
        break label292;
      }
    }
    label292:
    for (paramHttpConnection = ""; paramHttpConnection.startsWith("image/"); paramHttpConnection = paramHttpConnection.trim())
    {
      paramString = paramHttpConnection.substring("image/".length());
      localObject = new StringBuilder().append((String)localObject).append(".");
      paramHttpConnection = paramString;
      if ("jpeg".equals(paramString)) {
        paramHttpConnection = "jpg";
      }
      paramHttpConnection = paramHttpConnection;
      return paramHttpConnection;
    }
    int i = paramString.lastIndexOf('/');
    if (i > 0) {}
    for (paramHttpConnection = paramString.substring(i + 1);; paramHttpConnection = null)
    {
      if ((paramHttpConnection != null) && (paramHttpConnection.length() > 0))
      {
        i = paramHttpConnection.lastIndexOf('.');
        if ((i > 0) && (paramHttpConnection.length() - i < 10)) {
          return (String)localObject + paramHttpConnection.substring(i);
        }
      }
      label376:
      return (String)localObject;
    }
  }
  
  public static String getMime(String paramString)
  {
    try
    {
      paramString = new FileInputStream(paramString);
      byte[] arrayOfByte = new byte[8];
      paramString.read(arrayOfByte);
      paramString.close();
      paramString = getMime(arrayOfByte);
      return paramString;
    }
    catch (Exception paramString)
    {
      MobLog.getInstance().w(paramString);
    }
    return "";
  }
  
  private static String getMime(byte[] paramArrayOfByte)
  {
    if (!bytesStartWith(paramArrayOfByte, new byte[] { -1, -40, -1, -32 }))
    {
      if (!bytesStartWith(paramArrayOfByte, new byte[] { -1, -40, -1, -31 })) {}
    }
    else {
      return "jpg";
    }
    if (bytesStartWith(paramArrayOfByte, new byte[] { -119, 80, 78, 71 })) {
      return "png";
    }
    if (bytesStartWith(paramArrayOfByte, "GIF".getBytes())) {
      return "gif";
    }
    if (bytesStartWith(paramArrayOfByte, "BM".getBytes())) {
      return "bmp";
    }
    if (!bytesStartWith(paramArrayOfByte, new byte[] { 73, 73, 42 }))
    {
      if (!bytesStartWith(paramArrayOfByte, new byte[] { 77, 77, 42 })) {}
    }
    else {
      return "tif";
    }
    return "";
  }
  
  public static boolean isBlackBitmap(Bitmap paramBitmap)
    throws Throwable
  {
    boolean bool = false;
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      bool = true;
    }
    label85:
    for (;;)
    {
      return bool;
      int[] arrayOfInt = new int[paramBitmap.getWidth() * paramBitmap.getHeight()];
      paramBitmap.getPixels(arrayOfInt, 0, paramBitmap.getWidth(), 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      int i = 0;
      if (i < arrayOfInt.length) {
        if ((arrayOfInt[i] & 0xFFFFFF) == 0) {}
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label85;
        }
        return true;
        i += 1;
        break;
      }
    }
  }
  
  private static boolean isEmptyBitmap(Bitmap paramBitmap)
  {
    return (paramBitmap == null) || (paramBitmap.getWidth() == 0) || (paramBitmap.getHeight() == 0);
  }
  
  public static int mixAlpha(int paramInt1, int paramInt2)
  {
    int i = paramInt1 >>> 24;
    int j = (((0xFF0000 & paramInt1) >>> 16) * i + ((0xFF0000 & paramInt2) >>> 16) * (255 - i)) / 255;
    int k = (((0xFF00 & paramInt1) >>> 8) * i + (255 - i) * ((0xFF00 & paramInt2) >>> 8)) / 255;
    return ((255 - i) * (paramInt2 & 0xFF) + i * (paramInt1 & 0xFF)) / 255 | j << 16 | 0xFF000000 | k << 8;
  }
  
  public static Bitmap roundBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    throws Throwable
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Rect localRect1 = new Rect(0, 0, i, j);
    if ((i != paramInt1) || (j != paramInt2)) {}
    for (Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);; localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888))
    {
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
      localPaint.setAntiAlias(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      Object localObject = new float[8];
      localObject[0] = paramFloat1;
      localObject[1] = paramFloat1;
      localObject[2] = paramFloat2;
      localObject[3] = paramFloat2;
      localObject[4] = paramFloat3;
      localObject[5] = paramFloat3;
      localObject[6] = paramFloat4;
      localObject[7] = paramFloat4;
      localObject = new ShapeDrawable(new RoundRectShape((float[])localObject, new RectF(0.0F, 0.0F, 0.0F, 0.0F), (float[])localObject));
      ((ShapeDrawable)localObject).setBounds(localRect2);
      ((ShapeDrawable)localObject).draw(localCanvas);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      return localBitmap;
    }
  }
  
  /* Error */
  public static boolean save(Bitmap paramBitmap, File paramFile, Bitmap.CompressFormat paramCompressFormat, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 145	com/mob/tools/utils/BitmapHelper:isEmptyBitmap	(Landroid/graphics/Bitmap;)Z
    //   4: ifne +10 -> 14
    //   7: aload_1
    //   8: invokestatic 530	com/mob/tools/utils/FileUtils:createFileByDeleteOldFile	(Ljava/io/File;)Z
    //   11: ifne +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: new 532	java/io/BufferedOutputStream
    //   19: dup
    //   20: new 534	java/io/FileOutputStream
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 535	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   28: invokespecial 538	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore 5
    //   33: aload 5
    //   35: astore_1
    //   36: aload_0
    //   37: aload_2
    //   38: bipush 100
    //   40: aload 5
    //   42: invokevirtual 158	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   45: istore 4
    //   47: iload_3
    //   48: ifeq +20 -> 68
    //   51: aload 5
    //   53: astore_1
    //   54: aload_0
    //   55: invokevirtual 166	android/graphics/Bitmap:isRecycled	()Z
    //   58: ifne +10 -> 68
    //   61: aload 5
    //   63: astore_1
    //   64: aload_0
    //   65: invokevirtual 169	android/graphics/Bitmap:recycle	()V
    //   68: iconst_1
    //   69: anewarray 540	java/io/Closeable
    //   72: dup
    //   73: iconst_0
    //   74: aload 5
    //   76: aastore
    //   77: invokestatic 544	com/mob/tools/utils/FileUtils:closeIO	([Ljava/io/Closeable;)V
    //   80: iload 4
    //   82: ireturn
    //   83: astore_0
    //   84: aconst_null
    //   85: astore_2
    //   86: iconst_0
    //   87: istore_3
    //   88: aload_2
    //   89: astore_1
    //   90: invokestatic 437	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   93: aload_0
    //   94: invokevirtual 547	com/mob/tools/log/NLog:d	(Ljava/lang/Throwable;)I
    //   97: pop
    //   98: iconst_1
    //   99: anewarray 540	java/io/Closeable
    //   102: dup
    //   103: iconst_0
    //   104: aload_2
    //   105: aastore
    //   106: invokestatic 544	com/mob/tools/utils/FileUtils:closeIO	([Ljava/io/Closeable;)V
    //   109: iload_3
    //   110: ireturn
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_1
    //   114: iconst_1
    //   115: anewarray 540	java/io/Closeable
    //   118: dup
    //   119: iconst_0
    //   120: aload_1
    //   121: aastore
    //   122: invokestatic 544	com/mob/tools/utils/FileUtils:closeIO	([Ljava/io/Closeable;)V
    //   125: aload_0
    //   126: athrow
    //   127: astore_0
    //   128: goto -14 -> 114
    //   131: astore_0
    //   132: iconst_0
    //   133: istore_3
    //   134: aload 5
    //   136: astore_2
    //   137: goto -49 -> 88
    //   140: astore_0
    //   141: iload 4
    //   143: istore_3
    //   144: aload 5
    //   146: astore_2
    //   147: goto -59 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramBitmap	Bitmap
    //   0	150	1	paramFile	File
    //   0	150	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	150	3	paramBoolean	boolean
    //   45	97	4	bool	boolean
    //   31	114	5	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   16	33	83	java/lang/Throwable
    //   16	33	111	finally
    //   36	47	127	finally
    //   54	61	127	finally
    //   64	68	127	finally
    //   90	98	127	finally
    //   36	47	131	java/lang/Throwable
    //   54	61	140	java/lang/Throwable
    //   64	68	140	java/lang/Throwable
  }
  
  public static boolean save(Bitmap paramBitmap, String paramString, Bitmap.CompressFormat paramCompressFormat)
  {
    return save(paramBitmap, FileUtils.getFileByPath(paramString), paramCompressFormat, false);
  }
  
  public static String saveBitmap(Context paramContext, Bitmap paramBitmap)
    throws Throwable
  {
    return saveBitmap(paramContext, paramBitmap, Bitmap.CompressFormat.JPEG, 80);
  }
  
  public static String saveBitmap(Context paramContext, Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt)
    throws Throwable
  {
    Object localObject = ResHelper.getCachePath(paramContext, "images");
    paramContext = ".jpg";
    if (paramCompressFormat == Bitmap.CompressFormat.PNG) {
      paramContext = ".png";
    }
    paramContext = new File((String)localObject, String.valueOf(System.currentTimeMillis()) + paramContext);
    localObject = new FileOutputStream(paramContext);
    paramBitmap.compress(paramCompressFormat, paramInt, (OutputStream)localObject);
    ((FileOutputStream)localObject).flush();
    ((FileOutputStream)localObject).close();
    return paramContext.getAbsolutePath();
  }
  
  public static String saveBitmapByCompress(String paramString, int paramInt1, int paramInt2, int paramInt3)
    throws Throwable
  {
    Bitmap localBitmap = getBitmapByCompressSize(paramString, paramInt1, paramInt2);
    if (paramInt3 > 100) {
      paramInt1 = 100;
    }
    for (;;)
    {
      Bitmap.CompressFormat localCompressFormat = getBmpFormat(paramString);
      Object localObject = ".jpg";
      if (localCompressFormat == Bitmap.CompressFormat.PNG) {
        localObject = ".png";
      }
      paramString = new File(new File(paramString).getParent(), String.valueOf(System.currentTimeMillis()) + (String)localObject);
      localObject = new FileOutputStream(paramString);
      localBitmap.compress(localCompressFormat, paramInt1, (OutputStream)localObject);
      ((FileOutputStream)localObject).flush();
      ((FileOutputStream)localObject).close();
      return paramString.getAbsolutePath();
      paramInt1 = paramInt3;
      if (paramInt3 < 10) {
        paramInt1 = 10;
      }
    }
  }
  
  public static String saveViewToImage(View paramView)
    throws Throwable
  {
    if (paramView == null) {}
    int i;
    int j;
    do
    {
      return null;
      i = paramView.getWidth();
      j = paramView.getHeight();
    } while ((i <= 0) || (j <= 0));
    return saveViewToImage(paramView, i, j);
  }
  
  public static String saveViewToImage(View paramView, int paramInt1, int paramInt2)
    throws Throwable
  {
    Bitmap localBitmap = captureView(paramView, paramInt1, paramInt2);
    if ((localBitmap == null) || (localBitmap.isRecycled())) {
      return null;
    }
    paramView = new File(ResHelper.getCachePath(paramView.getContext(), "screenshot"), String.valueOf(System.currentTimeMillis()) + ".jpg");
    FileOutputStream localFileOutputStream = new FileOutputStream(paramView);
    localBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
    localFileOutputStream.flush();
    localFileOutputStream.close();
    return paramView.getAbsolutePath();
  }
  
  public static Bitmap scaleBitmapByHeight(Context paramContext, int paramInt1, int paramInt2)
    throws Throwable
  {
    paramContext = BitmapFactory.decodeResource(paramContext.getResources(), paramInt1);
    if (paramInt2 != paramContext.getHeight()) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      Bitmap localBitmap = scaleBitmapByHeight(paramContext, paramInt2);
      if (paramInt1 != 0) {
        paramContext.recycle();
      }
      return localBitmap;
    }
  }
  
  public static Bitmap scaleBitmapByHeight(Bitmap paramBitmap, int paramInt)
    throws Throwable
  {
    return Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth() * paramInt / paramBitmap.getHeight(), paramInt, true);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/utils/BitmapHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */