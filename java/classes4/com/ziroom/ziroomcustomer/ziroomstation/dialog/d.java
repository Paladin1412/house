package com.ziroom.ziroomcustomer.ziroomstation.dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import com.ziroom.ziroomcustomer.ziroomstation.a.a;
import com.ziroom.ziroomcustomer.ziroomstation.adapter.h;
import com.ziroom.ziroomcustomer.ziroomstation.model.DaysPrice;
import com.ziroom.ziroomcustomer.ziroomstation.model.TypePrice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
{
  private Context a;
  private List<DaysPrice> b;
  private ExpandableListView c;
  private PopupWindow d;
  private h e;
  private a f;
  private long g;
  private ObservableScrollView h;
  private View i;
  private ImageView j;
  private float k;
  private TextView l;
  
  public d(Context paramContext, List<DaysPrice> paramList, float paramFloat, a parama)
  {
    this.a = paramContext;
    this.b = a(paramList);
    this.f = parama;
    this.k = paramFloat;
  }
  
  private List<DaysPrice> a(List<DaysPrice> paramList)
  {
    this.b = new ArrayList();
    int m = 0;
    while (m < paramList.size())
    {
      DaysPrice localDaysPrice = new DaysPrice();
      localDaysPrice.dayDate = ((DaysPrice)paramList.get(m)).dayDate;
      localDaysPrice.typePriceList = new ArrayList();
      Iterator localIterator = ((DaysPrice)paramList.get(m)).typePriceList.iterator();
      while (localIterator.hasNext())
      {
        TypePrice localTypePrice = (TypePrice)localIterator.next();
        if (localTypePrice.num != 0) {
          localDaysPrice.typePriceList.add(localTypePrice);
        }
      }
      this.b.add(localDaysPrice);
      m += 1;
    }
    com.freelxl.baselibrary.f.d.i("PricesDetailsPop", this.b);
    return this.b;
  }
  
  private void a(View paramView)
  {
    this.c = ((ExpandableListView)paramView.findViewById(2131697604));
    this.c.setSelector(2130838956);
    this.h = ((ObservableScrollView)paramView.findViewById(2131690150));
    this.i = paramView.findViewById(2131689863);
    this.j = ((ImageView)paramView.findViewById(2131690549));
    this.l = ((TextView)paramView.findViewById(2131697605));
    this.l.setText("¥" + (int)this.k);
    this.h.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        d.c(d.this).setAlpha(f);
      }
    });
    this.e = new h(this.a, this.b);
    this.c.setGroupIndicator(null);
    this.c.setAdapter(this.e);
    int m = 0;
    while (m < this.e.getGroupCount())
    {
      this.c.expandGroup(m);
      m += 1;
    }
    this.j.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        d.this.dismissDialog();
      }
    });
  }
  
  public void dismissDialog()
  {
    if ((this.d != null) && (this.d.isShowing())) {
      this.d.dismiss();
    }
  }
  
  public void showPriceWindow()
  {
    View localView = ((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2130905153, null);
    a(localView);
    this.d = new PopupWindow(localView, -1, -1);
    this.d.setFocusable(true);
    Object localObject = new ColorDrawable(-167772161);
    this.d.setBackgroundDrawable((Drawable)localObject);
    localObject = this.d;
    if (!(localObject instanceof PopupWindow)) {
      ((PopupWindow)localObject).showAtLocation(localView, 0, 0, 0);
    }
    for (;;)
    {
      this.d.setOnDismissListener(new PopupWindow.OnDismissListener()
      {
        public void onDismiss()
        {
          int i = (int)((d.a(d.this) - System.currentTimeMillis()) / 1000L);
          if ((d.b(d.this) != null) && (i > 0)) {
            d.b(d.this).callback(i);
          }
        }
      });
      this.g = System.currentTimeMillis();
      return;
      VdsAgent.showAtLocation((PopupWindow)localObject, localView, 0, 0, 0);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/dialog/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */