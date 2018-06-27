package com.baidu.platform.comjni.tools;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;

public class BundleKeySet
{
  public String[] getBundleKeys(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    while (paramBundle.isEmpty()) {
      return null;
    }
    String[] arrayOfString = new String[paramBundle.size()];
    paramBundle = paramBundle.keySet().iterator();
    int i = 0;
    while (paramBundle.hasNext())
    {
      arrayOfString[i] = ((String)paramBundle.next()).toString();
      i += 1;
    }
    return arrayOfString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comjni/tools/BundleKeySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */