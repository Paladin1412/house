package com.alipay.sdk.auth;

import android.webkit.SslErrorHandler;
import com.alipay.sdk.k.d;

final class f
  implements Runnable
{
  f(AuthActivity.b paramb, SslErrorHandler paramSslErrorHandler) {}
  
  public final void run()
  {
    d.a(this.b.a, "安全警告", "由于您的设备缺少根证书，将无法校验该访问站点的安全性，可能存在风险，请选择是否继续？", "继续", new g(this), "退出", new h(this));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/sdk/auth/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */