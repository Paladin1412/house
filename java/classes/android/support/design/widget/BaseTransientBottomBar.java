package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.design.R.anim;
import android.support.design.R.layout;
import android.support.design.R.styleable;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>>
{
  static final int ANIMATION_DURATION = 250;
  static final int ANIMATION_FADE_DURATION = 180;
  public static final int LENGTH_INDEFINITE = -2;
  public static final int LENGTH_LONG = 0;
  public static final int LENGTH_SHORT = -1;
  static final int MSG_DISMISS = 1;
  static final int MSG_SHOW = 0;
  private static final boolean USE_OFFSET_API;
  static final Handler sHandler;
  private final AccessibilityManager mAccessibilityManager;
  private List<BaseCallback<B>> mCallbacks;
  private final ContentViewCallback mContentViewCallback;
  private final Context mContext;
  private int mDuration;
  final SnackbarManager.Callback mManagerCallback = new SnackbarManager.Callback()
  {
    public void dismiss(int paramAnonymousInt)
    {
      BaseTransientBottomBar.sHandler.sendMessage(BaseTransientBottomBar.sHandler.obtainMessage(1, paramAnonymousInt, 0, BaseTransientBottomBar.this));
    }
    
    public void show()
    {
      BaseTransientBottomBar.sHandler.sendMessage(BaseTransientBottomBar.sHandler.obtainMessage(0, BaseTransientBottomBar.this));
    }
  };
  private final ViewGroup mTargetParent;
  final SnackbarBaseLayout mView;
  
  static
  {
    if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT <= 19)) {}
    for (boolean bool = true;; bool = false)
    {
      USE_OFFSET_API = bool;
      sHandler = new Handler(Looper.getMainLooper(), new Handler.Callback()
      {
        public boolean handleMessage(Message paramAnonymousMessage)
        {
          switch (paramAnonymousMessage.what)
          {
          default: 
            return false;
          case 0: 
            ((BaseTransientBottomBar)paramAnonymousMessage.obj).showView();
            return true;
          }
          ((BaseTransientBottomBar)paramAnonymousMessage.obj).hideView(paramAnonymousMessage.arg1);
          return true;
        }
      });
      return;
    }
  }
  
  protected BaseTransientBottomBar(ViewGroup paramViewGroup, View paramView, ContentViewCallback paramContentViewCallback)
  {
    if (paramViewGroup == null) {
      throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
    }
    if (paramView == null) {
      throw new IllegalArgumentException("Transient bottom bar must have non-null content");
    }
    if (paramContentViewCallback == null) {
      throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
    }
    this.mTargetParent = paramViewGroup;
    this.mContentViewCallback = paramContentViewCallback;
    this.mContext = paramViewGroup.getContext();
    ThemeUtils.checkAppCompatTheme(this.mContext);
    this.mView = ((SnackbarBaseLayout)LayoutInflater.from(this.mContext).inflate(R.layout.design_layout_snackbar, this.mTargetParent, false));
    this.mView.addView(paramView);
    ViewCompat.setAccessibilityLiveRegion(this.mView, 1);
    ViewCompat.setImportantForAccessibility(this.mView, 1);
    ViewCompat.setFitsSystemWindows(this.mView, true);
    ViewCompat.setOnApplyWindowInsetsListener(this.mView, new OnApplyWindowInsetsListener()
    {
      public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
      {
        paramAnonymousView.setPadding(paramAnonymousView.getPaddingLeft(), paramAnonymousView.getPaddingTop(), paramAnonymousView.getPaddingRight(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetBottom());
        return paramAnonymousWindowInsetsCompat;
      }
    });
    this.mAccessibilityManager = ((AccessibilityManager)this.mContext.getSystemService("accessibility"));
  }
  
  private void animateViewOut(final int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 12)
    {
      localObject = new ValueAnimator();
      ((ValueAnimator)localObject).setIntValues(new int[] { 0, this.mView.getHeight() });
      ((ValueAnimator)localObject).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
      ((ValueAnimator)localObject).setDuration(250L);
      ((ValueAnimator)localObject).addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          BaseTransientBottomBar.this.onViewHidden(paramInt);
        }
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          BaseTransientBottomBar.this.mContentViewCallback.animateContentOut(0, 180);
        }
      });
      ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        private int mPreviousAnimatedIntValue = 0;
        
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          if (BaseTransientBottomBar.USE_OFFSET_API) {
            ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.mView, i - this.mPreviousAnimatedIntValue);
          }
          for (;;)
          {
            this.mPreviousAnimatedIntValue = i;
            return;
            BaseTransientBottomBar.this.mView.setTranslationY(i);
          }
        }
      });
      ((ValueAnimator)localObject).start();
      return;
    }
    Object localObject = android.view.animation.AnimationUtils.loadAnimation(this.mView.getContext(), R.anim.design_snackbar_out);
    ((Animation)localObject).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    ((Animation)localObject).setDuration(250L);
    ((Animation)localObject).setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        BaseTransientBottomBar.this.onViewHidden(paramInt);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.mView.startAnimation((Animation)localObject);
  }
  
  public B addCallback(BaseCallback<B> paramBaseCallback)
  {
    if (paramBaseCallback == null) {
      return this;
    }
    if (this.mCallbacks == null) {
      this.mCallbacks = new ArrayList();
    }
    this.mCallbacks.add(paramBaseCallback);
    return this;
  }
  
  void animateViewIn()
  {
    if (Build.VERSION.SDK_INT >= 12)
    {
      final int i = this.mView.getHeight();
      if (USE_OFFSET_API) {
        ViewCompat.offsetTopAndBottom(this.mView, i);
      }
      for (;;)
      {
        localObject = new ValueAnimator();
        ((ValueAnimator)localObject).setIntValues(new int[] { i, 0 });
        ((ValueAnimator)localObject).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        ((ValueAnimator)localObject).setDuration(250L);
        ((ValueAnimator)localObject).addListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            BaseTransientBottomBar.this.onViewShown();
          }
          
          public void onAnimationStart(Animator paramAnonymousAnimator)
          {
            BaseTransientBottomBar.this.mContentViewCallback.animateContentIn(70, 180);
          }
        });
        ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          private int mPreviousAnimatedIntValue = i;
          
          public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.USE_OFFSET_API) {
              ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.mView, i - this.mPreviousAnimatedIntValue);
            }
            for (;;)
            {
              this.mPreviousAnimatedIntValue = i;
              return;
              BaseTransientBottomBar.this.mView.setTranslationY(i);
            }
          }
        });
        ((ValueAnimator)localObject).start();
        return;
        this.mView.setTranslationY(i);
      }
    }
    Object localObject = android.view.animation.AnimationUtils.loadAnimation(this.mView.getContext(), R.anim.design_snackbar_in);
    ((Animation)localObject).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    ((Animation)localObject).setDuration(250L);
    ((Animation)localObject).setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        BaseTransientBottomBar.this.onViewShown();
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.mView.startAnimation((Animation)localObject);
  }
  
  public void dismiss()
  {
    dispatchDismiss(3);
  }
  
  void dispatchDismiss(int paramInt)
  {
    SnackbarManager.getInstance().dismiss(this.mManagerCallback, paramInt);
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public int getDuration()
  {
    return this.mDuration;
  }
  
  public View getView()
  {
    return this.mView;
  }
  
  final void hideView(int paramInt)
  {
    if ((shouldAnimate()) && (this.mView.getVisibility() == 0))
    {
      animateViewOut(paramInt);
      return;
    }
    onViewHidden(paramInt);
  }
  
  public boolean isShown()
  {
    return SnackbarManager.getInstance().isCurrent(this.mManagerCallback);
  }
  
  public boolean isShownOrQueued()
  {
    return SnackbarManager.getInstance().isCurrentOrNext(this.mManagerCallback);
  }
  
  void onViewHidden(int paramInt)
  {
    SnackbarManager.getInstance().onDismissed(this.mManagerCallback);
    if (this.mCallbacks != null)
    {
      int i = this.mCallbacks.size() - 1;
      while (i >= 0)
      {
        ((BaseCallback)this.mCallbacks.get(i)).onDismissed(this, paramInt);
        i -= 1;
      }
    }
    if (Build.VERSION.SDK_INT < 11) {
      this.mView.setVisibility(8);
    }
    ViewParent localViewParent = this.mView.getParent();
    if ((localViewParent instanceof ViewGroup)) {
      ((ViewGroup)localViewParent).removeView(this.mView);
    }
  }
  
  void onViewShown()
  {
    SnackbarManager.getInstance().onShown(this.mManagerCallback);
    if (this.mCallbacks != null)
    {
      int i = this.mCallbacks.size() - 1;
      while (i >= 0)
      {
        ((BaseCallback)this.mCallbacks.get(i)).onShown(this);
        i -= 1;
      }
    }
  }
  
  public B removeCallback(BaseCallback<B> paramBaseCallback)
  {
    if (paramBaseCallback == null) {}
    while (this.mCallbacks == null) {
      return this;
    }
    this.mCallbacks.remove(paramBaseCallback);
    return this;
  }
  
  public B setDuration(int paramInt)
  {
    this.mDuration = paramInt;
    return this;
  }
  
  boolean shouldAnimate()
  {
    return !this.mAccessibilityManager.isEnabled();
  }
  
  public void show()
  {
    SnackbarManager.getInstance().show(this.mDuration, this.mManagerCallback);
  }
  
  final void showView()
  {
    if (this.mView.getParent() == null)
    {
      Object localObject = this.mView.getLayoutParams();
      if ((localObject instanceof CoordinatorLayout.LayoutParams))
      {
        localObject = (CoordinatorLayout.LayoutParams)localObject;
        Behavior localBehavior = new Behavior();
        localBehavior.setStartAlphaSwipeDistance(0.1F);
        localBehavior.setEndAlphaSwipeDistance(0.6F);
        localBehavior.setSwipeDirection(0);
        localBehavior.setListener(new SwipeDismissBehavior.OnDismissListener()
        {
          public void onDismiss(View paramAnonymousView)
          {
            paramAnonymousView.setVisibility(8);
            BaseTransientBottomBar.this.dispatchDismiss(0);
          }
          
          public void onDragStateChanged(int paramAnonymousInt)
          {
            switch (paramAnonymousInt)
            {
            default: 
              return;
            case 1: 
            case 2: 
              SnackbarManager.getInstance().pauseTimeout(BaseTransientBottomBar.this.mManagerCallback);
              return;
            }
            SnackbarManager.getInstance().restoreTimeoutIfPaused(BaseTransientBottomBar.this.mManagerCallback);
          }
        });
        ((CoordinatorLayout.LayoutParams)localObject).setBehavior(localBehavior);
        ((CoordinatorLayout.LayoutParams)localObject).insetEdge = 80;
      }
      this.mTargetParent.addView(this.mView);
    }
    this.mView.setOnAttachStateChangeListener(new OnAttachStateChangeListener()
    {
      public void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public void onViewDetachedFromWindow(View paramAnonymousView)
      {
        if (BaseTransientBottomBar.this.isShownOrQueued()) {
          BaseTransientBottomBar.sHandler.post(new Runnable()
          {
            public void run()
            {
              BaseTransientBottomBar.this.onViewHidden(3);
            }
          });
        }
      }
    });
    if (ViewCompat.isLaidOut(this.mView))
    {
      if (shouldAnimate())
      {
        animateViewIn();
        return;
      }
      onViewShown();
      return;
    }
    this.mView.setOnLayoutChangeListener(new OnLayoutChangeListener()
    {
      public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        BaseTransientBottomBar.this.mView.setOnLayoutChangeListener(null);
        if (BaseTransientBottomBar.this.shouldAnimate())
        {
          BaseTransientBottomBar.this.animateViewIn();
          return;
        }
        BaseTransientBottomBar.this.onViewShown();
      }
    });
  }
  
  public static abstract class BaseCallback<B>
  {
    public static final int DISMISS_EVENT_ACTION = 1;
    public static final int DISMISS_EVENT_CONSECUTIVE = 4;
    public static final int DISMISS_EVENT_MANUAL = 3;
    public static final int DISMISS_EVENT_SWIPE = 0;
    public static final int DISMISS_EVENT_TIMEOUT = 2;
    
    public void onDismissed(B paramB, int paramInt) {}
    
    public void onShown(B paramB) {}
    
    @Retention(RetentionPolicy.SOURCE)
    public static @interface DismissEvent {}
  }
  
  final class Behavior
    extends SwipeDismissBehavior<BaseTransientBottomBar.SnackbarBaseLayout>
  {
    Behavior() {}
    
    public boolean canSwipeDismissView(View paramView)
    {
      return paramView instanceof BaseTransientBottomBar.SnackbarBaseLayout;
    }
    
    public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, BaseTransientBottomBar.SnackbarBaseLayout paramSnackbarBaseLayout, MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        return super.onInterceptTouchEvent(paramCoordinatorLayout, paramSnackbarBaseLayout, paramMotionEvent);
        if (paramCoordinatorLayout.isPointInChildBounds(paramSnackbarBaseLayout, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
        {
          SnackbarManager.getInstance().pauseTimeout(BaseTransientBottomBar.this.mManagerCallback);
          continue;
          SnackbarManager.getInstance().restoreTimeoutIfPaused(BaseTransientBottomBar.this.mManagerCallback);
        }
      }
    }
  }
  
  public static abstract interface ContentViewCallback
  {
    public abstract void animateContentIn(int paramInt1, int paramInt2);
    
    public abstract void animateContentOut(int paramInt1, int paramInt2);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Duration {}
  
  static abstract interface OnAttachStateChangeListener
  {
    public abstract void onViewAttachedToWindow(View paramView);
    
    public abstract void onViewDetachedFromWindow(View paramView);
  }
  
  static abstract interface OnLayoutChangeListener
  {
    public abstract void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  static class SnackbarBaseLayout
    extends FrameLayout
  {
    private BaseTransientBottomBar.OnAttachStateChangeListener mOnAttachStateChangeListener;
    private BaseTransientBottomBar.OnLayoutChangeListener mOnLayoutChangeListener;
    
    SnackbarBaseLayout(Context paramContext)
    {
      this(paramContext, null);
    }
    
    SnackbarBaseLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SnackbarLayout);
      if (paramContext.hasValue(R.styleable.SnackbarLayout_elevation)) {
        ViewCompat.setElevation(this, paramContext.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
      }
      paramContext.recycle();
      setClickable(true);
    }
    
    protected void onAttachedToWindow()
    {
      super.onAttachedToWindow();
      if (this.mOnAttachStateChangeListener != null) {
        this.mOnAttachStateChangeListener.onViewAttachedToWindow(this);
      }
      ViewCompat.requestApplyInsets(this);
    }
    
    protected void onDetachedFromWindow()
    {
      super.onDetachedFromWindow();
      if (this.mOnAttachStateChangeListener != null) {
        this.mOnAttachStateChangeListener.onViewDetachedFromWindow(this);
      }
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (this.mOnLayoutChangeListener != null) {
        this.mOnLayoutChangeListener.onLayoutChange(this, paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    
    void setOnAttachStateChangeListener(BaseTransientBottomBar.OnAttachStateChangeListener paramOnAttachStateChangeListener)
    {
      this.mOnAttachStateChangeListener = paramOnAttachStateChangeListener;
    }
    
    void setOnLayoutChangeListener(BaseTransientBottomBar.OnLayoutChangeListener paramOnLayoutChangeListener)
    {
      this.mOnLayoutChangeListener = paramOnLayoutChangeListener;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/design/widget/BaseTransientBottomBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */