package com.baidu.mapapi;

import android.os.Handler;
import com.baidu.platform.comjni.engine.a;

public class MessageCenter
{
  public static void registMessage(int paramInt, Handler paramHandler)
  {
    a.a(paramInt, paramHandler);
  }
  
  public static void unregistMessage(int paramInt, Handler paramHandler)
  {
    a.b(paramInt, paramHandler);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/MessageCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */