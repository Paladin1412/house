package com.ziroom.ziroomcustomer.signed;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.widget.TimePickerView;
import com.ziroom.ziroomcustomer.widget.TimePickerView.b;
import java.util.ArrayList;
import java.util.List;

public class l
  extends Dialog
{
  TimePickerView a;
  private Context b;
  private a c;
  private String[] d;
  private int e;
  private String f = "";
  private TextView g;
  private int h;
  
  public l(Context paramContext, a parama, String[] paramArrayOfString, int paramInt)
  {
    super(paramContext, 2131427692);
    this.b = paramContext;
    this.c = parama;
    this.d = paramArrayOfString;
    this.h = paramInt;
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.b).inflate(2130903850, null);
    a(localView);
    setListener(localView);
    setContentView(localView);
  }
  
  private void a(View paramView)
  {
    this.a = ((TimePickerView)paramView.findViewById(2131693854));
    this.g = ((TextView)paramView.findViewById(2131693706));
    paramView = new ArrayList();
    a(paramView);
    this.a.setData(paramView);
    this.a.setOnSelectListener(new TimePickerView.b()
    {
      public void onSelect(String paramAnonymousString, int paramAnonymousInt)
      {
        l.a(l.this, paramAnonymousString);
        l.a(l.this, paramAnonymousInt);
      }
    });
  }
  
  private void a(List<String> paramList)
  {
    try
    {
      if (this.d != null)
      {
        String[] arrayOfString = this.d;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          paramList.add(arrayOfString[i]);
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      g.textToast(this.b, "请检查网络连接", 0);
      paramList.add("");
      paramList.add("");
      paramList.add("");
      paramList.add("");
      this.f = ((String)paramList.get(0));
    }
  }
  
  public TextView getTv_choose()
  {
    return this.g;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public void setListener(View paramView)
  {
    Button localButton = (Button)paramView.findViewById(2131691363);
    paramView = (Button)paramView.findViewById(2131690460);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (TextUtils.isEmpty(l.a(l.this)))
        {
          g.textToast(l.b(l.this), "您还未选择", 0);
          l.this.dismiss();
          return;
        }
        l.e(l.this).showHour(l.a(l.this), l.c(l.this), l.d(l.this));
        l.this.dismiss();
      }
    });
    paramView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        l.this.dismiss();
      }
    });
  }
  
  public static abstract interface a
  {
    public abstract void showHour(String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */