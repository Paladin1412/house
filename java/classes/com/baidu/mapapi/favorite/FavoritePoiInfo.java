package com.baidu.mapapi.favorite;

import com.baidu.mapapi.model.LatLng;

public class FavoritePoiInfo
{
  String a;
  String b;
  LatLng c;
  String d;
  String e;
  String f;
  long g;
  
  public FavoritePoiInfo addr(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public FavoritePoiInfo cityName(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public String getAddr()
  {
    return this.d;
  }
  
  public String getCityName()
  {
    return this.e;
  }
  
  public String getID()
  {
    return this.a;
  }
  
  public String getPoiName()
  {
    return this.b;
  }
  
  public LatLng getPt()
  {
    return this.c;
  }
  
  public long getTimeStamp()
  {
    return this.g;
  }
  
  public String getUid()
  {
    return this.f;
  }
  
  public FavoritePoiInfo poiName(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public FavoritePoiInfo pt(LatLng paramLatLng)
  {
    this.c = paramLatLng;
    return this;
  }
  
  public FavoritePoiInfo uid(String paramString)
  {
    this.f = paramString;
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/favorite/FavoritePoiInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */