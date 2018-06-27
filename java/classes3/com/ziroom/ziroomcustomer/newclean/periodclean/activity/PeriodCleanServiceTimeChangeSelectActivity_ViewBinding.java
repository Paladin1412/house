package com.ziroom.ziroomcustomer.newclean.periodclean.activity;

import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;

public class PeriodCleanServiceTimeChangeSelectActivity_ViewBinding<T extends PeriodCleanServiceTimeChangeSelectActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public PeriodCleanServiceTimeChangeSelectActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689492, "field 'ivBack' and method 'onViewClicked'");
    paramT.ivBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'ivBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.rlTitle = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131689808, "field 'rlTitle'", RelativeLayout.class));
    paramT.viewgroup = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690094, "field 'viewgroup'", LinearLayout.class));
    paramT.hScrollView = ((HorizontalScrollView)Utils.findRequiredViewAsType(paramView, 2131690093, "field 'hScrollView'", HorizontalScrollView.class));
    paramT.ivBall = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690376, "field 'ivBall'", ImageView.class));
    paramT.gvHome = ((MyGridView)Utils.findRequiredViewAsType(paramView, 2131689973, "field 'gvHome'", MyGridView.class));
    paramT.llNoData = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690377, "field 'llNoData'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131692073, "field 'llOtherCleanTime' and method 'onViewClicked'");
    paramT.llOtherCleanTime = ((LinearLayout)Utils.castView(localView, 2131692073, "field 'llOtherCleanTime'", LinearLayout.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690043, "field 'btn' and method 'onViewClicked'");
    paramT.btn = ((Button)Utils.castView(localView, 2131690043, "field 'btn'", Button.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvNoticeMessage = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690365, "field 'tvNoticeMessage'", TextView.class));
  }
  
  public void unbind()
  {
    PeriodCleanServiceTimeChangeSelectActivity localPeriodCleanServiceTimeChangeSelectActivity = this.a;
    if (localPeriodCleanServiceTimeChangeSelectActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localPeriodCleanServiceTimeChangeSelectActivity.ivBack = null;
    localPeriodCleanServiceTimeChangeSelectActivity.tvTitle = null;
    localPeriodCleanServiceTimeChangeSelectActivity.rlTitle = null;
    localPeriodCleanServiceTimeChangeSelectActivity.viewgroup = null;
    localPeriodCleanServiceTimeChangeSelectActivity.hScrollView = null;
    localPeriodCleanServiceTimeChangeSelectActivity.ivBall = null;
    localPeriodCleanServiceTimeChangeSelectActivity.gvHome = null;
    localPeriodCleanServiceTimeChangeSelectActivity.llNoData = null;
    localPeriodCleanServiceTimeChangeSelectActivity.llOtherCleanTime = null;
    localPeriodCleanServiceTimeChangeSelectActivity.btn = null;
    localPeriodCleanServiceTimeChangeSelectActivity.tvNoticeMessage = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/activity/PeriodCleanServiceTimeChangeSelectActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */