package com.baidu.mapapi.utils;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.a.a.a.b;
import com.baidu.a.a.a.b.a;

final class c
  implements ServiceConnection
{
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    a.d().interrupt();
    Log.d(a.b(), "onServiceConnected " + paramComponentName);
    try
    {
      if (a.e() != null) {
        a.a(null);
      }
      a.a(b.a.a(paramIBinder));
      a.e().a(new d(this));
      return;
    }
    catch (RemoteException paramComponentName)
    {
      do
      {
        Log.d(a.b(), "getComOpenClient ", paramComponentName);
      } while (a.e() == null);
      a.a(null);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    Log.d(a.b(), "onServiceDisconnected " + paramComponentName);
    if (a.e() != null)
    {
      a.a(null);
      a.b(false);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/utils/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */