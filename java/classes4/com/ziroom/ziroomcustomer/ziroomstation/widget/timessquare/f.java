package com.ziroom.ziroomcustomer.ziroomstation.widget.timessquare;

import java.util.Date;

public class f
{
  private final int a;
  private final int b;
  private final Date c;
  private String d;
  
  public f(int paramInt1, int paramInt2, Date paramDate, String paramString)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramDate;
    this.d = paramString;
  }
  
  void a(String paramString)
  {
    this.d = paramString;
  }
  
  public Date getDate()
  {
    return this.c;
  }
  
  public String getLabel()
  {
    return this.d;
  }
  
  public int getMonth()
  {
    return this.a;
  }
  
  public int getYear()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "MonthDescriptor{label='" + this.d + '\'' + ", month=" + this.a + ", year=" + this.b + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/widget/timessquare/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */