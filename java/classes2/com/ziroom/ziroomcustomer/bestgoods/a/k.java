package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.bestgoods.model.d;
import java.util.List;

public class k
  extends BaseAdapter
{
  private Context a;
  private List<d> b;
  private int c;
  
  public k(Context paramContext, List<d> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = LayoutInflater.from(this.a).inflate(2130904131, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131694852));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a.setText(((d)this.b.get(paramInt)).getName());
      if (this.c != paramInt) {
        break label148;
      }
      if (!((d)this.b.get(paramInt)).isChecked()) {
        break;
      }
      paramViewGroup.a.setTextColor(this.a.getResources().getColor(2131624588));
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.a.setTextColor(this.a.getResources().getColor(2131624415));
    return paramView;
    label148:
    paramViewGroup.a.setTextColor(this.a.getResources().getColor(2131624415));
    return paramView;
  }
  
  public void setSelectedPos(int paramInt)
  {
    this.c = paramInt;
    notifyDataSetChanged();
  }
  
  class a
  {
    TextView a;
    
    a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */