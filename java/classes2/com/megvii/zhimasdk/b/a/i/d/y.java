package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f.h;
import com.megvii.zhimasdk.b.a.f.i;
import com.megvii.zhimasdk.b.a.f.j;
import java.util.Collection;

public class y
  implements i, j
{
  private final String[] a;
  private final boolean b;
  
  public y()
  {
    this(null, false);
  }
  
  public y(String[] paramArrayOfString, boolean paramBoolean)
  {
    this.a = paramArrayOfString;
    this.b = paramBoolean;
  }
  
  public h a(com.megvii.zhimasdk.b.a.l.e parame)
  {
    if (parame != null)
    {
      localObject = (Collection)parame.a("http.protocol.cookie-datepatterns");
      if (localObject == null) {
        break label65;
      }
    }
    label65:
    for (Object localObject = (String[])((Collection)localObject).toArray(new String[((Collection)localObject).size()]);; localObject = null)
    {
      return new x((String[])localObject, parame.a("http.protocol.single-cookie-header", false));
      return new x();
    }
  }
  
  public h a(com.megvii.zhimasdk.b.a.n.e parame)
  {
    return new x(this.a, this.b);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */