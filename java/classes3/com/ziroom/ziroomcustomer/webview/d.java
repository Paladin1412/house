package com.ziroom.ziroomcustomer.webview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;

public class d
  extends WebChromeClient
{
  private ValueCallback<Uri> a;
  private Activity b;
  
  public d(Activity paramActivity)
  {
    this.b = paramActivity;
  }
  
  private void a(ValueCallback<Uri> paramValueCallback)
  {
    this.a = paramValueCallback;
    paramValueCallback = new Intent("android.intent.action.GET_CONTENT");
    paramValueCallback.addCategory("android.intent.category.OPENABLE");
    paramValueCallback.setType("image/*");
    this.b.startActivityForResult(Intent.createChooser(paramValueCallback, "完成操作需要使用"), 10);
  }
  
  public ValueCallback<Uri> getUploadMsg()
  {
    return this.a;
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback)
  {
    a(paramValueCallback);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString)
  {
    a(paramValueCallback);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    a(paramValueCallback);
  }
  
  public void setUploadMsg(ValueCallback<Uri> paramValueCallback)
  {
    this.a = paramValueCallback;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/webview/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */