package com.ziroom.datacenter.remote.responsebody.financial.c;

public class d
{
  private String a;
  private String b;
  private String c;
  private a d;
  
  public a getData()
  {
    return this.d;
  }
  
  public String getError_code()
  {
    return this.a;
  }
  
  public String getError_message()
  {
    return this.b;
  }
  
  public String getStatus()
  {
    return this.c;
  }
  
  public boolean isSuccess()
  {
    return this.c.equals("success");
  }
  
  public void setData(a parama)
  {
    this.d = parama;
  }
  
  public void setError_code(String paramString)
  {
    this.a = paramString;
  }
  
  public void setError_message(String paramString)
  {
    this.b = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.c = paramString;
  }
  
  public class a
  {
    private int b;
    
    public a() {}
    
    public int getResult()
    {
      return this.b;
    }
    
    public void setResult(int paramInt)
    {
      this.b = paramInt;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */