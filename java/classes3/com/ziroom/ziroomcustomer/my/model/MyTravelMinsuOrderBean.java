package com.ziroom.ziroomcustomer.my.model;

import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import java.util.List;

public class MyTravelMinsuOrderBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public String toString()
  {
    return "MinsuOrderBean{data=" + this.data + '}';
  }
  
  public static class DataBean
  {
    public List<OrderListBean> orderList;
    public int total;
    
    public static class OrderListBean
    {
      public String cityCode;
      public String endTimeStr;
      public int evaStatus;
      public String fid;
      public String houseAddr;
      public String houseName;
      public int housingDay;
      public int isLock;
      public String landlordMobile;
      public String landlordUid;
      public int needPay;
      public String orderSn;
      public int orderStatus;
      public String orderStatusName;
      public int orderStatusShowCode;
      public String picUrl;
      public int rentWay;
      public String roomName;
      public long startTimeStamp;
      public String startTimeStr;
      
      public MyTravelOrder convertToTravelOrder()
      {
        MyTravelOrder localMyTravelOrder = new MyTravelOrder();
        localMyTravelOrder.arriveTime = this.startTimeStr;
        localMyTravelOrder.leaveTime = this.endTimeStr;
        localMyTravelOrder.createTime = this.startTimeStamp;
        localMyTravelOrder.phone = this.landlordMobile;
        localMyTravelOrder.fid = this.fid;
        localMyTravelOrder.houseAddress = this.houseAddr;
        localMyTravelOrder.houseName = this.houseName;
        localMyTravelOrder.orderType = 1;
        localMyTravelOrder.rentWay = this.rentWay;
        localMyTravelOrder.landlordUid = this.landlordUid;
        localMyTravelOrder.landlordMobile = this.landlordMobile;
        localMyTravelOrder.orderSn = this.orderSn;
        return localMyTravelOrder;
      }
      
      public String toString()
      {
        return "OrderListBean{cityCode='" + this.cityCode + '\'' + ", houseAddr='" + this.houseAddr + '\'' + ", landlordMobile='" + this.landlordMobile + '\'' + ", landlordUid='" + this.landlordUid + '\'' + ", orderStatusShowCode=" + this.orderStatusShowCode + ", startTimeStamp=" + this.startTimeStamp + ", orderSn='" + this.orderSn + '\'' + ", picUrl='" + this.picUrl + '\'' + ", rentWay=" + this.rentWay + ", fid='" + this.fid + '\'' + ", roomName='" + this.roomName + '\'' + ", houseName='" + this.houseName + '\'' + ", startTimeStr='" + this.startTimeStr + '\'' + ", endTimeStr='" + this.endTimeStr + '\'' + ", needPay=" + this.needPay + ", housingDay=" + this.housingDay + ", orderStatus=" + this.orderStatus + ", isLock=" + this.isLock + ", orderStatusName='" + this.orderStatusName + '\'' + ", evaStatus=" + this.evaStatus + '}';
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/MyTravelMinsuOrderBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */