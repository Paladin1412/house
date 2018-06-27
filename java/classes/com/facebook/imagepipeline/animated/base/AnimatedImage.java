package com.facebook.imagepipeline.animated.base;

public abstract interface AnimatedImage
{
  public static final int LOOP_COUNT_INFINITE = 0;
  
  public abstract void dispose();
  
  public abstract boolean doesRenderSupportScaling();
  
  public abstract int getDuration();
  
  public abstract AnimatedImageFrame getFrame(int paramInt);
  
  public abstract int getFrameCount();
  
  public abstract int[] getFrameDurations();
  
  public abstract AnimatedDrawableFrameInfo getFrameInfo(int paramInt);
  
  public abstract int getHeight();
  
  public abstract int getLoopCount();
  
  public abstract int getSizeInBytes();
  
  public abstract int getWidth();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/animated/base/AnimatedImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */