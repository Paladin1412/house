package com.tencent.mm.opensdk.openapi;

import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public abstract interface IWXAPIEventHandler
{
  public abstract void onReq(BaseReq paramBaseReq);
  
  public abstract void onResp(BaseResp paramBaseResp);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/mm/opensdk/openapi/IWXAPIEventHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */