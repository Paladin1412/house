package com.baidu.location.a;

import android.location.Location;
import com.baidu.location.Jni;
import com.baidu.location.b.b;
import com.baidu.location.b.d;
import com.baidu.location.b.g;
import com.baidu.location.b.h;
import com.baidu.location.d.e;
import com.baidu.location.d.i;
import com.baidu.location.d.j;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class s
{
  private static s A = null;
  private static ArrayList<String> b = new ArrayList();
  private static ArrayList<String> c = new ArrayList();
  private static ArrayList<String> d = new ArrayList();
  private static String e = i.a + "/yo.dat";
  private static final String f = i.a + "/yoh.dat";
  private static final String g = i.a + "/yom.dat";
  private static final String h = i.a + "/yol.dat";
  private static final String i = i.a + "/yor.dat";
  private static File j = null;
  private static int k = 8;
  private static int l = 8;
  private static int m = 16;
  private static int n = 1024;
  private static double o = 0.0D;
  private static double p = 0.1D;
  private static double q = 30.0D;
  private static double r = 100.0D;
  private static int s = 0;
  private static int t = 64;
  private static int u = 128;
  private static Location v = null;
  private static Location w = null;
  private static Location x = null;
  private static g y = null;
  private int B = 0;
  long a = 0L;
  private a z = null;
  
  private static int a(List<String> paramList, int paramInt)
  {
    if ((paramList == null) || (paramInt > 256) || (paramInt < 0))
    {
      paramInt = -1;
      return paramInt;
    }
    for (;;)
    {
      int i2;
      int i1;
      try
      {
        if (j == null)
        {
          j = new File(e);
          if (!j.exists())
          {
            j = null;
            paramInt = -2;
            break;
          }
        }
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(j, "rw");
        if (localRandomAccessFile.length() < 1L)
        {
          localRandomAccessFile.close();
          paramInt = -3;
          break;
        }
        localRandomAccessFile.seek(paramInt);
        int i3 = localRandomAccessFile.readInt();
        i2 = localRandomAccessFile.readInt();
        int i4 = localRandomAccessFile.readInt();
        int i5 = localRandomAccessFile.readInt();
        long l1 = localRandomAccessFile.readLong();
        if ((!a(i3, i2, i4, i5, l1)) || (i2 < 1))
        {
          localRandomAccessFile.close();
          paramInt = -4;
          break;
        }
        byte[] arrayOfByte = new byte[n];
        i1 = k;
        if ((i1 > 0) && (i2 > 0))
        {
          localRandomAccessFile.seek((i3 + i2 - 1) % i4 * i5 + l1);
          int i6 = localRandomAccessFile.readInt();
          if ((i6 > 0) && (i6 < i5))
          {
            localRandomAccessFile.read(arrayOfByte, 0, i6);
            if (arrayOfByte[(i6 - 1)] == 0) {
              paramList.add(new String(arrayOfByte, 0, i6 - 1));
            }
          }
        }
        else
        {
          localRandomAccessFile.seek(paramInt);
          localRandomAccessFile.writeInt(i3);
          localRandomAccessFile.writeInt(i2);
          localRandomAccessFile.writeInt(i4);
          localRandomAccessFile.writeInt(i5);
          localRandomAccessFile.writeLong(l1);
          localRandomAccessFile.close();
          paramInt = k;
          paramInt -= i1;
          break;
        }
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        paramInt = -5;
        break;
      }
      finally {}
      i1 -= 1;
      i2 -= 1;
    }
  }
  
  public static s a()
  {
    try
    {
      if (A == null) {
        A = new s();
      }
      s locals = A;
      return locals;
    }
    finally {}
  }
  
  /* Error */
  public static String a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iload_0
    //   3: iconst_1
    //   4: if_icmpne +17 -> 21
    //   7: getstatic 81	com/baidu/location/a/s:f	Ljava/lang/String;
    //   10: astore_1
    //   11: getstatic 54	com/baidu/location/a/s:b	Ljava/util/ArrayList;
    //   14: astore_2
    //   15: aload_2
    //   16: ifnonnull +55 -> 71
    //   19: aconst_null
    //   20: areturn
    //   21: iload_0
    //   22: iconst_2
    //   23: if_icmpne +14 -> 37
    //   26: getstatic 85	com/baidu/location/a/s:g	Ljava/lang/String;
    //   29: astore_1
    //   30: getstatic 56	com/baidu/location/a/s:c	Ljava/util/ArrayList;
    //   33: astore_2
    //   34: goto -19 -> 15
    //   37: iload_0
    //   38: iconst_3
    //   39: if_icmpne +14 -> 53
    //   42: getstatic 89	com/baidu/location/a/s:h	Ljava/lang/String;
    //   45: astore_1
    //   46: getstatic 58	com/baidu/location/a/s:d	Ljava/util/ArrayList;
    //   49: astore_2
    //   50: goto -35 -> 15
    //   53: iload_0
    //   54: iconst_4
    //   55: if_icmpne +14 -> 69
    //   58: getstatic 93	com/baidu/location/a/s:i	Ljava/lang/String;
    //   61: astore_1
    //   62: getstatic 58	com/baidu/location/a/s:d	Ljava/util/ArrayList;
    //   65: astore_2
    //   66: goto -51 -> 15
    //   69: aconst_null
    //   70: areturn
    //   71: aload_2
    //   72: invokeinterface 217 1 0
    //   77: iconst_1
    //   78: if_icmpge +9 -> 87
    //   81: aload_1
    //   82: aload_2
    //   83: invokestatic 220	com/baidu/location/a/s:a	(Ljava/lang/String;Ljava/util/List;)Z
    //   86: pop
    //   87: ldc 2
    //   89: monitorenter
    //   90: aload_2
    //   91: invokeinterface 217 1 0
    //   96: istore_0
    //   97: iload_0
    //   98: ifle +47 -> 145
    //   101: aload_2
    //   102: iload_0
    //   103: iconst_1
    //   104: isub
    //   105: invokeinterface 224 2 0
    //   110: checkcast 190	java/lang/String
    //   113: astore_1
    //   114: aload_2
    //   115: iload_0
    //   116: iconst_1
    //   117: isub
    //   118: invokeinterface 227 2 0
    //   123: pop
    //   124: ldc 2
    //   126: monitorexit
    //   127: aload_1
    //   128: areturn
    //   129: astore_1
    //   130: ldc 2
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    //   135: astore_1
    //   136: aload_3
    //   137: astore_1
    //   138: goto -14 -> 124
    //   141: astore_2
    //   142: goto -4 -> 138
    //   145: aconst_null
    //   146: astore_1
    //   147: goto -23 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramInt	int
    //   10	118	1	str	String
    //   129	5	1	localObject1	Object
    //   135	1	1	localException1	Exception
    //   137	10	1	localObject2	Object
    //   14	101	2	localArrayList	ArrayList
    //   141	1	2	localException2	Exception
    //   1	136	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   90	97	129	finally
    //   101	114	129	finally
    //   114	124	129	finally
    //   124	127	129	finally
    //   130	133	129	finally
    //   101	114	135	java/lang/Exception
    //   114	124	141	java/lang/Exception
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    Object localObject1;
    ArrayList localArrayList;
    label20:
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = f;
      if (paramBoolean) {
        return;
      }
      localArrayList = b;
      localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists()) {
        a((String)localObject1);
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new RandomAccessFile((File)localObject2, "rw");
        ((RandomAccessFile)localObject1).seek(4L);
        int i6 = ((RandomAccessFile)localObject1).readInt();
        int i7 = ((RandomAccessFile)localObject1).readInt();
        i2 = ((RandomAccessFile)localObject1).readInt();
        i3 = ((RandomAccessFile)localObject1).readInt();
        i1 = ((RandomAccessFile)localObject1).readInt();
        i4 = localArrayList.size();
        if (i4 <= l) {
          break label483;
        }
        if (!paramBoolean) {
          break label480;
        }
        i1 += 1;
        if (i2 < i6)
        {
          ((RandomAccessFile)localObject1).seek(i7 * i2 + 128);
          localObject2 = ((String)localArrayList.get(0) + '\000').getBytes();
          ((RandomAccessFile)localObject1).writeInt(localObject2.length);
          ((RandomAccessFile)localObject1).write((byte[])localObject2, 0, localObject2.length);
          localArrayList.remove(0);
          i5 = i2 + 1;
          i2 = i3;
          i3 = i5;
          i5 = i4 - 1;
          i4 = i3;
          i3 = i2;
          i2 = i4;
          i4 = i5;
          continue;
          if (paramInt == 2)
          {
            localObject1 = g;
            if (paramBoolean)
            {
              localArrayList = b;
              break label20;
            }
            localArrayList = c;
            break label20;
          }
          if (paramInt == 3)
          {
            localObject1 = h;
            if (paramBoolean)
            {
              localArrayList = c;
              break label20;
            }
            localArrayList = d;
            break label20;
          }
          if (paramInt != 4) {
            break;
          }
          localObject1 = i;
          if (!paramBoolean) {
            break;
          }
          localArrayList = d;
          break label20;
        }
        if (!paramBoolean) {
          break label502;
        }
        long l1 = i3 * i7 + 128;
        ((RandomAccessFile)localObject1).seek(l1);
        localObject2 = ((String)localArrayList.get(0) + '\000').getBytes();
        ((RandomAccessFile)localObject1).writeInt(localObject2.length);
        ((RandomAccessFile)localObject1).write((byte[])localObject2, 0, localObject2.length);
        localArrayList.remove(0);
        i5 = i3 + 1;
        i3 = i5;
        if (i5 <= i2) {
          break label489;
        }
        i3 = 0;
      }
      catch (Exception localException)
      {
        int i1;
        return;
      }
      ((RandomAccessFile)localObject1).seek(12L);
      ((RandomAccessFile)localObject1).writeInt(i2);
      ((RandomAccessFile)localObject1).writeInt(i3);
      ((RandomAccessFile)localObject1).writeInt(i1);
      ((RandomAccessFile)localObject1).close();
      if ((i4 == 0) || (paramInt >= 4)) {
        break;
      }
      a(paramInt + 1, true);
      return;
      label480:
      continue;
      label483:
      int i4 = 0;
      continue;
      label489:
      int i5 = i2;
      int i2 = i3;
      int i3 = i5;
      continue;
      label502:
      i4 = 1;
    }
  }
  
  public static void a(com.baidu.location.b.a parama, g paramg, Location paramLocation, String paramString)
  {
    Object localObject2 = null;
    if ((j.s == 3) && (!a(paramLocation, paramg)) && (!a(paramLocation, false))) {}
    label303:
    label434:
    label435:
    for (;;)
    {
      return;
      Object localObject1;
      if ((parama != null) && (parama.a()))
      {
        localObject1 = paramg;
        if (!a(paramLocation, paramg)) {
          localObject1 = null;
        }
        parama = j.a(parama, (g)localObject1, paramLocation, paramString, 1);
        if (parama != null)
        {
          c(Jni.encode(parama));
          w = paramLocation;
          v = paramLocation;
          if (localObject1 != null) {
            y = (g)localObject1;
          }
        }
      }
      else
      {
        if ((paramg != null) && (paramg.h()) && (a(paramLocation, paramg)))
        {
          if ((!a(paramLocation)) && (!b.a().d())) {
            localObject1 = "&cfr=1" + paramString;
          }
          for (;;)
          {
            parama = j.a(parama, paramg, paramLocation, (String)localObject1, 2);
            if (parama == null) {
              break;
            }
            d(Jni.encode(parama));
            x = paramLocation;
            v = paramLocation;
            if (paramg == null) {
              break;
            }
            y = paramg;
            return;
            if ((!a(paramLocation)) && (b.a().d()))
            {
              localObject1 = "&cfr=3" + paramString;
            }
            else
            {
              localObject1 = paramString;
              if (b.a().d()) {
                localObject1 = "&cfr=2" + paramString;
              }
            }
          }
        }
        if ((!a(paramLocation)) && (!b.a().d()))
        {
          localObject1 = "&cfr=1" + paramString;
          if (a(paramLocation, paramg)) {
            break label434;
          }
          paramg = (g)localObject2;
        }
        for (;;)
        {
          if ((parama == null) && (paramg == null)) {
            break label435;
          }
          parama = j.a(parama, paramg, paramLocation, (String)localObject1, 3);
          if (parama == null) {
            break;
          }
          e(Jni.encode(parama));
          v = paramLocation;
          if (paramg == null) {
            break;
          }
          y = paramg;
          return;
          if ((!a(paramLocation)) && (b.a().d()))
          {
            localObject1 = "&cfr=3" + paramString;
            break label303;
          }
          localObject1 = paramString;
          if (!b.a().d()) {
            break label303;
          }
          localObject1 = "&cfr=2" + paramString;
          break label303;
        }
      }
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      File localFile = new File(paramString);
      if (!localFile.exists())
      {
        paramString = new File(i.a);
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        paramString = localFile;
        if (!localFile.createNewFile()) {
          paramString = null;
        }
        paramString = new RandomAccessFile(paramString, "rw");
        paramString.seek(0L);
        paramString.writeInt(32);
        paramString.writeInt(2048);
        paramString.writeInt(1040);
        paramString.writeInt(0);
        paramString.writeInt(0);
        paramString.writeInt(0);
        paramString.close();
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  private static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    if ((paramInt1 < 0) || (paramInt1 >= paramInt3)) {}
    while ((paramInt2 < 0) || (paramInt2 > paramInt3) || (paramInt3 < 0) || (paramInt3 > 1024) || (paramInt4 < 128) || (paramInt4 > 1024)) {
      return false;
    }
    return true;
  }
  
  private static boolean a(Location paramLocation)
  {
    boolean bool = true;
    if (paramLocation == null) {
      bool = false;
    }
    double d1;
    double d2;
    double d3;
    double d4;
    do
    {
      return bool;
      if ((w == null) || (v == null))
      {
        w = paramLocation;
        return true;
      }
      d1 = paramLocation.distanceTo(w);
      d2 = j.P;
      d3 = j.Q;
      d4 = j.R;
    } while (paramLocation.distanceTo(v) > d1 * d3 + d2 * d1 * d1 + d4);
    return false;
  }
  
  private static boolean a(Location paramLocation, g paramg)
  {
    if ((paramLocation == null) || (paramg == null) || (paramg.a == null) || (paramg.a.isEmpty())) {}
    while (paramg.b(y)) {
      return false;
    }
    if (x == null)
    {
      x = paramLocation;
      return true;
    }
    return true;
  }
  
  public static boolean a(Location paramLocation, boolean paramBoolean)
  {
    return d.a(v, paramLocation, paramBoolean);
  }
  
  public static boolean a(String paramString, List<String> paramList)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return false;
    }
    for (;;)
    {
      int i1;
      int i2;
      int i3;
      boolean bool2;
      try
      {
        paramString = new RandomAccessFile(paramString, "rw");
        paramString.seek(8L);
        int i5 = paramString.readInt();
        i1 = paramString.readInt();
        i4 = paramString.readInt();
        byte[] arrayOfByte = new byte[n];
        i2 = l;
        i2 += 1;
        bool1 = false;
        long l1;
        if ((i2 > 0) && (i1 > 0))
        {
          i3 = i4;
          if (i1 < i4) {
            i3 = 0;
          }
          l1 = (i1 - 1) * i5 + 128;
        }
        try
        {
          paramString.seek(l1);
          i4 = paramString.readInt();
          bool2 = bool1;
          if (i4 <= 0) {
            break label220;
          }
          bool2 = bool1;
          if (i4 >= i5) {
            break label220;
          }
          paramString.read(arrayOfByte, 0, i4);
          bool2 = bool1;
          if (arrayOfByte[(i4 - 1)] != 0) {
            break label220;
          }
          paramList.add(0, new String(arrayOfByte, 0, i4 - 1));
          bool2 = true;
        }
        catch (Exception paramString)
        {
          return bool1;
        }
        paramString.seek(12L);
        paramString.writeInt(i1);
        paramString.writeInt(i4);
        paramString.close();
        return bool1;
      }
      catch (Exception paramString)
      {
        return false;
      }
      label220:
      i2 -= 1;
      i1 -= 1;
      boolean bool1 = bool2;
      int i4 = i3;
    }
  }
  
  public static String b()
  {
    return d();
  }
  
  public static void b(String paramString)
  {
    for (;;)
    {
      int i1;
      try
      {
        boolean bool = paramString.contains("err!");
        if (bool) {
          return;
        }
        i1 = j.n;
        if (i1 == 1)
        {
          localArrayList = b;
          if (localArrayList == null) {
            continue;
          }
          if (localArrayList.size() <= m) {
            localArrayList.add(paramString);
          }
          if (localArrayList.size() >= m) {
            a(i1, false);
          }
          if (localArrayList.size() > m)
          {
            localArrayList.remove(0);
            continue;
          }
          continue;
        }
        if (i1 != 2) {
          break label114;
        }
      }
      finally {}
      ArrayList localArrayList = c;
      continue;
      label114:
      if (i1 == 3) {
        localArrayList = d;
      }
    }
  }
  
  private static void c(String paramString)
  {
    b(paramString);
  }
  
  public static String d()
  {
    String str1 = null;
    int i1 = 1;
    String str2;
    if (i1 < 5)
    {
      str1 = a(i1);
      if (str1 != null) {
        str2 = str1;
      }
    }
    do
    {
      do
      {
        do
        {
          return str2;
          i1 += 1;
          break;
          a(d, t);
          if (d.size() > 0)
          {
            str1 = (String)d.get(0);
            d.remove(0);
          }
          str2 = str1;
        } while (str1 != null);
        a(d, s);
        if (d.size() > 0)
        {
          str1 = (String)d.get(0);
          d.remove(0);
        }
        str2 = str1;
      } while (str1 != null);
      a(d, u);
      str2 = str1;
    } while (d.size() <= 0);
    str1 = (String)d.get(0);
    d.remove(0);
    return str1;
  }
  
  private static void d(String paramString)
  {
    b(paramString);
  }
  
  public static void e()
  {
    l = 0;
    a(1, false);
    a(2, false);
    a(3, false);
    l = 8;
  }
  
  private static void e(String paramString)
  {
    b(paramString);
  }
  
  public static String f()
  {
    Object localObject5 = null;
    Object localObject3 = null;
    Object localObject6 = new File(g);
    Object localObject1 = localObject3;
    if (((File)localObject6).exists()) {
      localObject1 = localObject5;
    }
    try
    {
      localObject6 = new RandomAccessFile((File)localObject6, "rw");
      localObject1 = localObject5;
      ((RandomAccessFile)localObject6).seek(20L);
      localObject1 = localObject5;
      i1 = ((RandomAccessFile)localObject6).readInt();
      if (i1 > 128)
      {
        localObject1 = localObject5;
        localObject3 = "&p1=" + i1;
        localObject1 = localObject3;
        ((RandomAccessFile)localObject6).seek(20L);
        localObject1 = localObject3;
        ((RandomAccessFile)localObject6).writeInt(0);
        localObject1 = localObject3;
        ((RandomAccessFile)localObject6).close();
        return (String)localObject3;
      }
      localObject1 = localObject5;
      ((RandomAccessFile)localObject6).close();
      localObject1 = localObject3;
    }
    catch (Exception localException3)
    {
      int i1;
      Object localObject2;
      Object localObject4;
      for (;;) {}
      return localException3;
    }
    localObject5 = new File(h);
    localObject3 = localObject1;
    if (((File)localObject5).exists())
    {
      localObject3 = localObject1;
      try
      {
        localObject5 = new RandomAccessFile((File)localObject5, "rw");
        localObject3 = localObject1;
        ((RandomAccessFile)localObject5).seek(20L);
        localObject3 = localObject1;
        i1 = ((RandomAccessFile)localObject5).readInt();
        if (i1 > 256)
        {
          localObject3 = localObject1;
          localObject1 = "&p2=" + i1;
          localObject3 = localObject1;
          ((RandomAccessFile)localObject5).seek(20L);
          localObject3 = localObject1;
          ((RandomAccessFile)localObject5).writeInt(0);
          localObject3 = localObject1;
          ((RandomAccessFile)localObject5).close();
          return (String)localObject1;
        }
      }
      catch (Exception localException1) {}
    }
    for (;;)
    {
      localObject5 = new File(i);
      if (!((File)localObject5).exists()) {
        return localObject3;
      }
      localObject2 = localObject3;
      try
      {
        localObject5 = new RandomAccessFile((File)localObject5, "rw");
        localObject2 = localObject3;
        ((RandomAccessFile)localObject5).seek(20L);
        localObject2 = localObject3;
        i1 = ((RandomAccessFile)localObject5).readInt();
        if (i1 <= 512) {
          break;
        }
        localObject2 = localObject3;
        localObject3 = "&p3=" + i1;
        localObject2 = localObject3;
        ((RandomAccessFile)localObject5).seek(20L);
        localObject2 = localObject3;
        ((RandomAccessFile)localObject5).writeInt(0);
        localObject2 = localObject3;
        ((RandomAccessFile)localObject5).close();
        return (String)localObject3;
      }
      catch (Exception localException2)
      {
        return (String)localObject2;
      }
      localObject4 = localObject2;
      ((RandomAccessFile)localObject5).close();
      localObject4 = localObject2;
    }
    localObject2 = localObject4;
    ((RandomAccessFile)localObject5).close();
    return (String)localObject4;
  }
  
  public void c()
  {
    if (!h.h()) {
      return;
    }
    this.z.b();
  }
  
  private class a
    extends e
  {
    boolean a = false;
    int b = 0;
    int c = 0;
    private ArrayList<String> e = null;
    
    public a()
    {
      this.k = new HashMap();
    }
    
    public void a()
    {
      this.h = j.c();
      this.i = 2;
      if (this.e != null)
      {
        int i = 0;
        if (i < this.e.size())
        {
          if (this.b == 1) {
            this.k.put("cldc[" + i + "]", this.e.get(i));
          }
          for (;;)
          {
            i += 1;
            break;
            this.k.put("cltr[" + i + "]", this.e.get(i));
          }
        }
        String str = String.format(Locale.CHINA, "%d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        this.k.put("trtm", str);
      }
    }
    
    public void a(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.j != null) && (this.e != null)) {
        this.e.clear();
      }
      if (this.k != null) {
        this.k.clear();
      }
      this.a = false;
    }
    
    public void b()
    {
      if (this.a) {
        return;
      }
      if ((o > 4) && (this.c < o))
      {
        this.c += 1;
        return;
      }
      this.c = 0;
      this.a = true;
      this.b = 0;
      int i;
      if ((this.e == null) || (this.e.size() < 1))
      {
        if (this.e == null) {
          this.e = new ArrayList();
        }
        this.b = 0;
        i = 0;
        if (this.b >= 2) {
          break label216;
        }
      }
      Object localObject;
      label174:
      label211:
      label216:
      for (String str = s.b();; localObject = null)
      {
        if ((str == null) && (this.b != 1)) {
          this.b = 2;
        }
        for (;;)
        {
          try
          {
            str = f.b();
            if (str != null) {
              break label174;
            }
            if ((this.e != null) && (this.e.size() >= 1)) {
              break label211;
            }
            this.e = null;
            this.a = false;
            return;
          }
          catch (Exception localException)
          {
            localObject = null;
            continue;
          }
          this.b = 1;
          continue;
          if (((String)localObject).contains("err!")) {
            break;
          }
          this.e.add(localObject);
          int j = i + ((String)localObject).length();
          i = j;
          if (j < com.baidu.location.d.a.i) {
            break;
          }
        }
        e();
        return;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */