package com.megvii.zhimasdk.b.a.o;

public final class g
{
  public static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 * 37 + paramInt2;
  }
  
  public static int a(int paramInt, Object paramObject)
  {
    if (paramObject != null) {}
    for (int i = paramObject.hashCode();; i = 0) {
      return a(paramInt, i);
    }
  }
  
  public static int a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return a(paramInt, i);
    }
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static boolean a(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (paramArrayOfObject1 == null) {
      if (paramArrayOfObject2 != null) {}
    }
    for (;;)
    {
      return true;
      return false;
      if ((paramArrayOfObject2 == null) || (paramArrayOfObject1.length != paramArrayOfObject2.length)) {
        break;
      }
      int i = 0;
      while (i < paramArrayOfObject1.length)
      {
        if (!a(paramArrayOfObject1[i], paramArrayOfObject2[i])) {
          return false;
        }
        i += 1;
      }
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/o/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */