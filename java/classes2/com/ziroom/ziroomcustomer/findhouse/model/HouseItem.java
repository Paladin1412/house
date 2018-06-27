package com.ziroom.ziroomcustomer.findhouse.model;

import java.util.List;

public class HouseItem
{
  private String area;
  private int bedroom;
  private String face;
  private String floor;
  private String floor_total;
  private String house_code;
  private String house_id;
  private String id;
  private int is_End;
  private int is_recommend;
  private double lat;
  private double lng;
  private String name;
  private int parlor;
  private String photo;
  private String photo_min;
  private String photo_min_webp;
  private String photo_webp;
  private int price;
  private String price_unit;
  private String resblock_id;
  private String resblock_name;
  private String status;
  private String subway_station_info;
  private List<TagsBean> tags;
  private int turn;
  private int type;
  private String type_text;
  private String will_unrent_date;
  
  public String getArea()
  {
    return this.area;
  }
  
  public int getBedroom()
  {
    return this.bedroom;
  }
  
  public String getFace()
  {
    return this.face;
  }
  
  public String getFloor()
  {
    return this.floor;
  }
  
  public String getFloor_total()
  {
    return this.floor_total;
  }
  
  public String getHouse_code()
  {
    return this.house_code;
  }
  
  public String getHouse_id()
  {
    return this.house_id;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public int getIs_End()
  {
    return this.is_End;
  }
  
  public int getIs_recommend()
  {
    return this.is_recommend;
  }
  
  public double getLat()
  {
    return this.lat;
  }
  
  public double getLng()
  {
    return this.lng;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getParlor()
  {
    return this.parlor;
  }
  
  public String getPhoto()
  {
    return this.photo;
  }
  
  public String getPhoto_min()
  {
    return this.photo_min;
  }
  
  public String getPhoto_min_webp()
  {
    return this.photo_min_webp;
  }
  
  public String getPhoto_webp()
  {
    return this.photo_webp;
  }
  
  public int getPrice()
  {
    return this.price;
  }
  
  public String getPrice_unit()
  {
    return this.price_unit;
  }
  
  public String getResblock_id()
  {
    return this.resblock_id;
  }
  
  public String getResblock_name()
  {
    return this.resblock_name;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public String getSubway_station_info()
  {
    return this.subway_station_info;
  }
  
  public List<TagsBean> getTags()
  {
    return this.tags;
  }
  
  public int getTurn()
  {
    return this.turn;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public String getType_text()
  {
    return this.type_text;
  }
  
  public String getWill_unrent_date()
  {
    return this.will_unrent_date;
  }
  
  public void setArea(String paramString)
  {
    this.area = paramString;
  }
  
  public void setBedroom(int paramInt)
  {
    this.bedroom = paramInt;
  }
  
  public void setFace(String paramString)
  {
    this.face = paramString;
  }
  
  public void setFloor(String paramString)
  {
    this.floor = paramString;
  }
  
  public void setFloor_total(String paramString)
  {
    this.floor_total = paramString;
  }
  
  public void setHouse_code(String paramString)
  {
    this.house_code = paramString;
  }
  
  public void setHouse_id(String paramString)
  {
    this.house_id = paramString;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setIs_End(int paramInt)
  {
    this.is_End = paramInt;
  }
  
  public void setIs_recommend(int paramInt)
  {
    this.is_recommend = paramInt;
  }
  
  public void setLat(double paramDouble)
  {
    this.lat = paramDouble;
  }
  
  public void setLng(double paramDouble)
  {
    this.lng = paramDouble;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setParlor(int paramInt)
  {
    this.parlor = paramInt;
  }
  
  public void setPhoto(String paramString)
  {
    this.photo = paramString;
  }
  
  public void setPhoto_min(String paramString)
  {
    this.photo_min = paramString;
  }
  
  public void setPhoto_min_webp(String paramString)
  {
    this.photo_min_webp = paramString;
  }
  
  public void setPhoto_webp(String paramString)
  {
    this.photo_webp = paramString;
  }
  
  public void setPrice(int paramInt)
  {
    this.price = paramInt;
  }
  
  public void setPrice_unit(String paramString)
  {
    this.price_unit = paramString;
  }
  
  public void setResblock_id(String paramString)
  {
    this.resblock_id = paramString;
  }
  
  public void setResblock_name(String paramString)
  {
    this.resblock_name = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public void setSubway_station_info(String paramString)
  {
    this.subway_station_info = paramString;
  }
  
  public void setTags(List<TagsBean> paramList)
  {
    this.tags = paramList;
  }
  
  public void setTurn(int paramInt)
  {
    this.turn = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setType_text(String paramString)
  {
    this.type_text = paramString;
  }
  
  public void setWill_unrent_date(String paramString)
  {
    this.will_unrent_date = paramString;
  }
  
  public static class TagsBean
  {
    private String title;
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/HouseItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */