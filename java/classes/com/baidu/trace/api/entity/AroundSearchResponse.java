package com.baidu.trace.api.entity;

import java.util.List;

public final class AroundSearchResponse
  extends CommonResponse
{
  public AroundSearchResponse() {}
  
  public AroundSearchResponse(int paramInt1, int paramInt2, String paramString)
  {
    super(paramInt1, paramInt2, paramString);
  }
  
  public AroundSearchResponse(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, List<EntityInfo> paramList)
  {
    super(paramInt1, paramInt2, paramString, paramInt3, paramInt4, paramList);
  }
  
  public final String toString()
  {
    return "AroundSearchResponse [tag=" + this.tag + ", status=" + this.status + ", message=" + this.message + ", total=" + this.a + ", size=" + this.b + ", entities=" + this.c + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/entity/AroundSearchResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */