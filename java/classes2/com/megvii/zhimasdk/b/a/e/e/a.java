package com.megvii.zhimasdk.b.a.e.e;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
{
  private static final Pattern a = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
  private static final Pattern b = Pattern.compile("^::[fF]{4}:(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
  private static final Pattern c = Pattern.compile("^[0-9a-fA-F]{1,4}(:[0-9a-fA-F]{1,4}){7}$");
  private static final Pattern d = Pattern.compile("^(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){0,5})?)::(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){0,5})?)$");
  
  public static boolean a(String paramString)
  {
    return a.matcher(paramString).matches();
  }
  
  public static boolean b(String paramString)
  {
    return c.matcher(paramString).matches();
  }
  
  public static boolean c(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    int k;
    for (int j = 0; i < paramString.length(); j = k)
    {
      k = j;
      if (paramString.charAt(i) == ':') {
        k = j + 1;
      }
      i += 1;
    }
    boolean bool1 = bool2;
    if (j <= 7)
    {
      bool1 = bool2;
      if (d.matcher(paramString).matches()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean d(String paramString)
  {
    return (b(paramString)) || (c(paramString));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/e/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */