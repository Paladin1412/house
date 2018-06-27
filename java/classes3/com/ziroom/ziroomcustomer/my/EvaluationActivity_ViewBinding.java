package com.ziroom.ziroomcustomer.my;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.widget.OrderItemView;

public class EvaluationActivity_ViewBinding<T extends EvaluationActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  
  public EvaluationActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mBztb = ((BasicZiroomToolBar)Utils.findRequiredViewAsType(paramView, 2131689787, "field 'mBztb'", BasicZiroomToolBar.class));
    View localView = Utils.findRequiredView(paramView, 2131689933, "field 'order_minsu' and method 'onClick'");
    paramT.order_minsu = ((OrderItemView)Utils.castView(localView, 2131689933, "field 'order_minsu'", OrderItemView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690580, "method 'onClick'");
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131689932, "method 'onClick'");
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690578, "method 'onClick'");
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690581, "method 'onClick'");
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690579, "method 'onClick'");
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131689930, "method 'onClick'");
    this.h = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    EvaluationActivity localEvaluationActivity = this.a;
    if (localEvaluationActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localEvaluationActivity.mBztb = null;
    localEvaluationActivity.order_minsu = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
    this.f.setOnClickListener(null);
    this.f = null;
    this.g.setOnClickListener(null);
    this.g = null;
    this.h.setOnClickListener(null);
    this.h = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/EvaluationActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */