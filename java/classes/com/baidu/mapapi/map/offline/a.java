package com.baidu.mapapi.map.offline;

import com.baidu.platform.comapi.map.t;
import com.baidu.platform.comapi.map.x;
import java.util.Iterator;
import java.util.List;

class a
  implements x
{
  a(MKOfflineMap paramMKOfflineMap) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 5: 
    case 7: 
    case 9: 
    case 10: 
    case 11: 
    default: 
    case 12: 
    case 6: 
    case 4: 
      do
      {
        return;
        MKOfflineMap.a(this.a).a(true, false);
        return;
        MKOfflineMap.b(this.a).onGetOfflineMapState(6, paramInt2);
        return;
        localObject = this.a.getAllUpdateInfo();
      } while (localObject == null);
      Object localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MKOLUpdateElement localMKOLUpdateElement = (MKOLUpdateElement)((Iterator)localObject).next();
        if (localMKOLUpdateElement.update) {
          MKOfflineMap.b(this.a).onGetOfflineMapState(4, localMKOLUpdateElement.cityID);
        }
      }
    }
    MKOfflineMap.b(this.a).onGetOfflineMapState(0, 0xFFFF & paramInt2 >> 16);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/offline/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */