package com.ziroom.ziroomcustomer.minsu.landlord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;

public class MyListView
  extends ListView
{
  public MyListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MyListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MyListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public MyListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/views/MyListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */