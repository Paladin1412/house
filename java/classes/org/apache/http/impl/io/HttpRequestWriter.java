package org.apache.http.impl.io;

import java.io.IOException;
import org.apache.http.HttpMessage;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.LineFormatter;
import org.apache.http.params.HttpParams;

@Deprecated
public class HttpRequestWriter
  extends AbstractMessageWriter
{
  public HttpRequestWriter(SessionOutputBuffer paramSessionOutputBuffer, LineFormatter paramLineFormatter, HttpParams paramHttpParams)
  {
    super((SessionOutputBuffer)null, (LineFormatter)null, (HttpParams)null);
    throw new RuntimeException("Stub!");
  }
  
  protected void writeHeadLine(HttpMessage paramHttpMessage)
    throws IOException
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/org/apache/http/impl/io/HttpRequestWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */