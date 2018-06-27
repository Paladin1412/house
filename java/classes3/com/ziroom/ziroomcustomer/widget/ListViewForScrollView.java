package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.ListView;

public class ListViewForScrollView
  extends ListView
{
  public ListViewForScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ListViewForScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ListViewForScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/ListViewForScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */