package org.apache.http.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Deprecated
public class BasicHttpEntity
  extends AbstractHttpEntity
{
  public BasicHttpEntity()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void consumeContent()
    throws IOException
  {
    throw new RuntimeException("Stub!");
  }
  
  public InputStream getContent()
    throws IllegalStateException
  {
    throw new RuntimeException("Stub!");
  }
  
  public long getContentLength()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isRepeatable()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isStreaming()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setContent(InputStream paramInputStream)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setContentLength(long paramLong)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/org/apache/http/entity/BasicHttpEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */