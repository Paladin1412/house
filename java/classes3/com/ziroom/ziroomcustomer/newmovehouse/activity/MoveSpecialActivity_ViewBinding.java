package com.ziroom.ziroomcustomer.newmovehouse.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;

public class MoveSpecialActivity_ViewBinding<T extends MoveSpecialActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public MoveSpecialActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
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
    paramT.fl_like = ((FlowLayout)Utils.findRequiredViewAsType(paramView, 2131690332, "field 'fl_like'", FlowLayout.class));
    paramT.et_remark = ((EditText)Utils.findRequiredViewAsType(paramView, 2131690002, "field 'et_remark'", EditText.class));
    paramT.tv_wordnum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691765, "field 'tv_wordnum'", TextView.class));
    paramView = Utils.findRequiredView(paramView, 2131689492, "method 'onClick'");
    this.c = paramView;
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
    MoveSpecialActivity localMoveSpecialActivity = this.a;
    if (localMoveSpecialActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMoveSpecialActivity.tv_commit = null;
    localMoveSpecialActivity.fl_like = null;
    localMoveSpecialActivity.et_remark = null;
    localMoveSpecialActivity.tv_wordnum = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/MoveSpecialActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */