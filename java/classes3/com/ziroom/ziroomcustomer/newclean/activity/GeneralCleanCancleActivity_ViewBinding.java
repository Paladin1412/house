package com.ziroom.ziroomcustomer.newclean.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class GeneralCleanCancleActivity_ViewBinding<T extends GeneralCleanCancleActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public GeneralCleanCancleActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.lv_item = ((ListView)Utils.findRequiredViewAsType(paramView, 2131691811, "field 'lv_item'", ListView.class));
    paramT.et_remark = ((EditText)Utils.findRequiredViewAsType(paramView, 2131690002, "field 'et_remark'", EditText.class));
    paramT.tv_num = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690003, "field 'tv_num'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131689956, "field 'tv_commit' and method 'onClick'");
    paramT.tv_commit = ((TextView)Utils.castView(localView, 2131689956, "field 'tv_commit'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.fl_mark = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131691812, "field 'fl_mark'", FrameLayout.class));
  }
  
  public void unbind()
  {
    GeneralCleanCancleActivity localGeneralCleanCancleActivity = this.a;
    if (localGeneralCleanCancleActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localGeneralCleanCancleActivity.lv_item = null;
    localGeneralCleanCancleActivity.et_remark = null;
    localGeneralCleanCancleActivity.tv_num = null;
    localGeneralCleanCancleActivity.tv_commit = null;
    localGeneralCleanCancleActivity.fl_mark = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/GeneralCleanCancleActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */