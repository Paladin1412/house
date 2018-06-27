package com.ziroom.credit.view.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.credit.view.a.a.a;
import com.ziroom.credit.view.a.a.c;
import java.util.ArrayList;
import java.util.List;

public class b<T>
  extends RecyclerView.a<c>
{
  protected Context f;
  protected List<T> g;
  protected com.ziroom.credit.view.a.a.b h;
  protected a i;
  
  public b(Context paramContext, List<T> paramList)
  {
    this.f = paramContext;
    this.g = paramList;
    this.h = new com.ziroom.credit.view.a.a.b();
  }
  
  protected void a(ViewGroup paramViewGroup, final c paramc, int paramInt)
  {
    if (!a(paramInt)) {
      return;
    }
    paramc.getConvertView().setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (b.this.i != null)
        {
          int i = paramc.getAdapterPosition();
          b.this.i.onItemClick(paramAnonymousView, paramc, i);
        }
      }
    });
    paramc.getConvertView().setOnLongClickListener(new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        if (b.this.i != null)
        {
          int i = paramc.getAdapterPosition();
          return b.this.i.onItemLongClick(paramAnonymousView, paramc, i);
        }
        return false;
      }
    });
  }
  
  protected boolean a()
  {
    return this.h.getItemViewDelegateCount() > 0;
  }
  
  protected boolean a(int paramInt)
  {
    return true;
  }
  
  public void addDatas(List<T> paramList)
  {
    if (this.g != null) {
      this.g.addAll(paramList);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.g = new ArrayList();
      this.g.addAll(paramList);
    }
  }
  
  public b addItemViewDelegate(int paramInt, a<T> parama)
  {
    this.h.addDelegate(paramInt, parama);
    return this;
  }
  
  public b addItemViewDelegate(a<T> parama)
  {
    this.h.addDelegate(parama);
    return this;
  }
  
  public void convert(c paramc, T paramT)
  {
    this.h.convert(paramc, paramT, paramc.getAdapterPosition());
  }
  
  public List<T> getDatas()
  {
    return this.g;
  }
  
  public int getItemCount()
  {
    if (this.g == null) {
      return 0;
    }
    return this.g.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (!a()) {
      return super.getItemViewType(paramInt);
    }
    return this.h.getItemViewType(this.g.get(paramInt), paramInt);
  }
  
  public void onBindViewHolder(c paramc, int paramInt)
  {
    convert(paramc, this.g.get(paramInt));
  }
  
  public c onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    int j = this.h.getItemViewDelegate(paramInt).getItemViewLayoutId();
    c localc = c.get(this.f, paramViewGroup, j);
    onViewHolderCreated(localc, localc.getConvertView());
    a(paramViewGroup, localc, paramInt);
    return localc;
  }
  
  public void onViewHolderCreated(c paramc, View paramView) {}
  
  public void setDatas(List<T> paramList)
  {
    this.g = paramList;
  }
  
  public void setOnItemClickListener(a parama)
  {
    this.i = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onItemClick(View paramView, RecyclerView.u paramu, int paramInt);
    
    public abstract boolean onItemLongClick(View paramView, RecyclerView.u paramu, int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/view/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */