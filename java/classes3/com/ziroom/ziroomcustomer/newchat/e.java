package com.ziroom.ziroomcustomer.newchat;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import java.util.List;

public class e
  extends ArrayAdapter<String>
{
  public e(Context paramContext, int paramInt, List<String> paramList)
  {
    super(paramContext, paramInt, paramList);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = View.inflate(getContext(), 2130905100, null);
    }
    paramView = (ImageView)paramViewGroup.findViewById(2131693233);
    String str = (String)getItem(paramInt);
    paramView.setImageResource(getContext().getResources().getIdentifier(str, "drawable", getContext().getPackageName()));
    return paramViewGroup;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */