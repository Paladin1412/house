package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.map.D;
import com.baidu.platform.comapi.map.E;
import com.baidu.platform.comapi.map.e;
import com.baidu.platform.comapi.map.k;
import javax.microedition.khronos.opengles.GL10;

class q
  implements k
{
  q(TextureMapView paramTextureMapView) {}
  
  public void a()
  {
    if ((TextureMapView.a(this.a) == null) || (TextureMapView.a(this.a).b() == null)) {
      return;
    }
    float f = TextureMapView.a(this.a).b().D().a;
    int i;
    if (TextureMapView.b(this.a) != f)
    {
      i = ((Integer)TextureMapView.a().get((int)f)).intValue();
      int j = (int)(i / TextureMapView.a(this.a).b().D().m);
      TextureMapView.c(this.a).setPadding(j / 2, 0, j / 2, 0);
      if (i < 1000) {
        break label184;
      }
    }
    label184:
    for (String str = String.format(" %d公里 ", new Object[] { Integer.valueOf(i / 1000) });; str = String.format(" %d米 ", new Object[] { Integer.valueOf(i) }))
    {
      TextureMapView.d(this.a).setText(str);
      TextureMapView.e(this.a).setText(str);
      TextureMapView.a(this.a, f);
      TextureMapView.f(this.a);
      this.a.requestLayout();
      return;
    }
  }
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(MotionEvent paramMotionEvent) {}
  
  public void a(GeoPoint paramGeoPoint) {}
  
  public void a(D paramD) {}
  
  public void a(String paramString) {}
  
  public void a(GL10 paramGL10, D paramD) {}
  
  public void a(boolean paramBoolean) {}
  
  public void b() {}
  
  public void b(GeoPoint paramGeoPoint) {}
  
  public void b(D paramD) {}
  
  public boolean b(String paramString)
  {
    return false;
  }
  
  public void c() {}
  
  public void c(GeoPoint paramGeoPoint) {}
  
  public void c(D paramD) {}
  
  public void d() {}
  
  public void d(GeoPoint paramGeoPoint) {}
  
  public void e() {}
  
  public void e(GeoPoint paramGeoPoint) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */