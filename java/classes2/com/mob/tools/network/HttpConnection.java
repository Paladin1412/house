package com.mob.tools.network;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public abstract interface HttpConnection
{
  public abstract InputStream getErrorStream()
    throws IOException;
  
  public abstract Map<String, List<String>> getHeaderFields()
    throws IOException;
  
  public abstract InputStream getInputStream()
    throws IOException;
  
  public abstract int getResponseCode()
    throws IOException;
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/network/HttpConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */