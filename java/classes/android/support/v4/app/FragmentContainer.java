package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public abstract class FragmentContainer
{
  public Fragment instantiate(Context paramContext, String paramString, Bundle paramBundle)
  {
    return Fragment.instantiate(paramContext, paramString, paramBundle);
  }
  
  public abstract View onFindViewById(int paramInt);
  
  public abstract boolean onHasView();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v4/app/FragmentContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */