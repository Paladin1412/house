package org.apache.http.client.protocol;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

@Deprecated
public class RequestProxyAuthentication
  implements HttpRequestInterceptor
{
  public RequestProxyAuthentication()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
    throws HttpException, IOException
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/org/apache/http/client/protocol/RequestProxyAuthentication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */