package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class ag
  extends AccessibilityDelegateCompat
{
  final RecyclerView a;
  final AccessibilityDelegateCompat b;
  
  public ag(RecyclerView paramRecyclerView)
  {
    this.a = paramRecyclerView;
    this.b = new a(this);
  }
  
  boolean a()
  {
    return this.a.hasPendingAdapterUpdates();
  }
  
  public AccessibilityDelegateCompat getItemDelegate()
  {
    return this.b;
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(RecyclerView.class.getName());
    if (((paramView instanceof RecyclerView)) && (!a()))
    {
      paramView = (RecyclerView)paramView;
      if (paramView.getLayoutManager() != null) {
        paramView.getLayoutManager().onInitializeAccessibilityEvent(paramAccessibilityEvent);
      }
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setClassName(RecyclerView.class.getName());
    if ((!a()) && (this.a.getLayoutManager() != null)) {
      this.a.getLayoutManager().a(paramAccessibilityNodeInfoCompat);
    }
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
      return true;
    }
    if ((!a()) && (this.a.getLayoutManager() != null)) {
      return this.a.getLayoutManager().a(paramInt, paramBundle);
    }
    return false;
  }
  
  public static class a
    extends AccessibilityDelegateCompat
  {
    final ag a;
    
    public a(ag paramag)
    {
      this.a = paramag;
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      if ((!this.a.a()) && (this.a.a.getLayoutManager() != null)) {
        this.a.a.getLayoutManager().a(paramView, paramAccessibilityNodeInfoCompat);
      }
    }
    
    public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
        return true;
      }
      if ((!this.a.a()) && (this.a.a.getLayoutManager() != null)) {
        return this.a.a.getLayoutManager().a(paramView, paramInt, paramBundle);
      }
      return false;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */