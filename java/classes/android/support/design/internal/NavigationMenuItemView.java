package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.design.R.dimen;
import android.support.design.R.drawable;
import android.support.design.R.id;
import android.support.design.R.layout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o.a;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.support.v7.widget.av;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView
  extends ForegroundLinearLayout
  implements o.a
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private final AccessibilityDelegateCompat mAccessibilityDelegate = new AccessibilityDelegateCompat()
  {
    public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfoCompat);
      paramAnonymousAccessibilityNodeInfoCompat.setCheckable(NavigationMenuItemView.this.mCheckable);
    }
  };
  private FrameLayout mActionArea;
  boolean mCheckable;
  private Drawable mEmptyDrawable;
  private boolean mHasIconTintList;
  private final int mIconSize;
  private ColorStateList mIconTintList;
  private j mItemData;
  private boolean mNeedsEmptyIcon;
  private final CheckedTextView mTextView;
  
  public NavigationMenuItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    LayoutInflater.from(paramContext).inflate(R.layout.design_navigation_menu_item, this, true);
    this.mIconSize = paramContext.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size);
    this.mTextView = ((CheckedTextView)findViewById(R.id.design_menu_item_text));
    this.mTextView.setDuplicateParentStateEnabled(true);
    ViewCompat.setAccessibilityDelegate(this.mTextView, this.mAccessibilityDelegate);
  }
  
  private void adjustAppearance()
  {
    if (shouldExpandActionArea())
    {
      this.mTextView.setVisibility(8);
      if (this.mActionArea != null)
      {
        localLayoutParams = (LinearLayoutCompat.LayoutParams)this.mActionArea.getLayoutParams();
        localLayoutParams.width = -1;
        this.mActionArea.setLayoutParams(localLayoutParams);
      }
    }
    do
    {
      return;
      this.mTextView.setVisibility(0);
    } while (this.mActionArea == null);
    LinearLayoutCompat.LayoutParams localLayoutParams = (LinearLayoutCompat.LayoutParams)this.mActionArea.getLayoutParams();
    localLayoutParams.width = -2;
    this.mActionArea.setLayoutParams(localLayoutParams);
  }
  
  private StateListDrawable createDefaultBackground()
  {
    TypedValue localTypedValue = new TypedValue();
    if (getContext().getTheme().resolveAttribute(R.attr.colorControlHighlight, localTypedValue, true))
    {
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(CHECKED_STATE_SET, new ColorDrawable(localTypedValue.data));
      localStateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
      return localStateListDrawable;
    }
    return null;
  }
  
  private void setActionView(View paramView)
  {
    if (paramView != null)
    {
      if (this.mActionArea == null) {
        this.mActionArea = ((FrameLayout)((ViewStub)findViewById(R.id.design_menu_item_action_area_stub)).inflate());
      }
      this.mActionArea.removeAllViews();
      this.mActionArea.addView(paramView);
    }
  }
  
  private boolean shouldExpandActionArea()
  {
    return (this.mItemData.getTitle() == null) && (this.mItemData.getIcon() == null) && (this.mItemData.getActionView() != null);
  }
  
  public j getItemData()
  {
    return this.mItemData;
  }
  
  public void initialize(j paramj, int paramInt)
  {
    this.mItemData = paramj;
    if (paramj.isVisible()) {}
    for (paramInt = 0;; paramInt = 8)
    {
      setVisibility(paramInt);
      if (getBackground() == null) {
        ViewCompat.setBackground(this, createDefaultBackground());
      }
      setCheckable(paramj.isCheckable());
      setChecked(paramj.isChecked());
      setEnabled(paramj.isEnabled());
      setTitle(paramj.getTitle());
      setIcon(paramj.getIcon());
      setActionView(paramj.getActionView());
      setContentDescription(paramj.getContentDescription());
      av.setTooltipText(this, paramj.getTooltipText());
      adjustAppearance();
      return;
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((this.mItemData != null) && (this.mItemData.isCheckable()) && (this.mItemData.isChecked())) {
      mergeDrawableStates(arrayOfInt, CHECKED_STATE_SET);
    }
    return arrayOfInt;
  }
  
  public boolean prefersCondensedTitle()
  {
    return false;
  }
  
  public void recycle()
  {
    if (this.mActionArea != null) {
      this.mActionArea.removeAllViews();
    }
    this.mTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
    if (this.mCheckable != paramBoolean)
    {
      this.mCheckable = paramBoolean;
      this.mAccessibilityDelegate.sendAccessibilityEvent(this.mTextView, 2048);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    refreshDrawableState();
    this.mTextView.setChecked(paramBoolean);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    Object localObject;
    if (paramDrawable != null)
    {
      localObject = paramDrawable;
      if (this.mHasIconTintList)
      {
        localObject = paramDrawable.getConstantState();
        if (localObject == null)
        {
          localObject = DrawableCompat.wrap(paramDrawable).mutate();
          DrawableCompat.setTintList((Drawable)localObject, this.mIconTintList);
        }
      }
      else
      {
        ((Drawable)localObject).setBounds(0, 0, this.mIconSize, this.mIconSize);
        paramDrawable = (Drawable)localObject;
      }
    }
    for (;;)
    {
      TextViewCompat.setCompoundDrawablesRelative(this.mTextView, paramDrawable, null, null, null);
      return;
      paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
      break;
      if (this.mNeedsEmptyIcon)
      {
        if (this.mEmptyDrawable == null)
        {
          this.mEmptyDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.navigation_empty_icon, getContext().getTheme());
          if (this.mEmptyDrawable != null) {
            this.mEmptyDrawable.setBounds(0, 0, this.mIconSize, this.mIconSize);
          }
        }
        paramDrawable = this.mEmptyDrawable;
      }
    }
  }
  
  void setIconTintList(ColorStateList paramColorStateList)
  {
    this.mIconTintList = paramColorStateList;
    if (this.mIconTintList != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.mHasIconTintList = bool;
      if (this.mItemData != null) {
        setIcon(this.mItemData.getIcon());
      }
      return;
    }
  }
  
  public void setNeedsEmptyIcon(boolean paramBoolean)
  {
    this.mNeedsEmptyIcon = paramBoolean;
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar) {}
  
  public void setTextAppearance(int paramInt)
  {
    TextViewCompat.setTextAppearance(this.mTextView, paramInt);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.mTextView.setTextColor(paramColorStateList);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mTextView.setText(paramCharSequence);
  }
  
  public boolean showsIcon()
  {
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/design/internal/NavigationMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */