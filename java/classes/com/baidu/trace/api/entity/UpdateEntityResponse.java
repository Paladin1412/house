package com.baidu.trace.api.entity;

import com.baidu.trace.model.BaseResponse;

public final class UpdateEntityResponse
  extends BaseResponse
{
  public UpdateEntityResponse(int paramInt1, int paramInt2, String paramString)
  {
    super(paramInt1, paramInt2, paramString);
  }
  
  public final String toString()
  {
    return "UpdateEntityResponse [tag=" + this.tag + ", status=" + this.status + ", message=" + this.message + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/entity/UpdateEntityResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */