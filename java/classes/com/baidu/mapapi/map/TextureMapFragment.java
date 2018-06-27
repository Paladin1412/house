package com.baidu.mapapi.map;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

@Instrumented
public class TextureMapFragment
  extends Fragment
{
  private static final String a = TextureMapFragment.class.getSimpleName();
  private TextureMapView b;
  private BaiduMapOptions c;
  
  public TextureMapFragment() {}
  
  private TextureMapFragment(BaiduMapOptions paramBaiduMapOptions)
  {
    this.c = paramBaiduMapOptions;
  }
  
  public static TextureMapFragment newInstance()
  {
    return new TextureMapFragment();
  }
  
  public static TextureMapFragment newInstance(BaiduMapOptions paramBaiduMapOptions)
  {
    return new TextureMapFragment(paramBaiduMapOptions);
  }
  
  public BaiduMap getBaiduMap()
  {
    if (this.b == null) {
      return null;
    }
    return this.b.getMap();
  }
  
  public TextureMapView getMapView()
  {
    return this.b;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.b = new TextureMapView(getActivity(), this.c);
    return this.b;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.b.onDestroy();
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    VdsAgent.onFragmentHiddenChanged(this, paramBoolean);
  }
  
  public void onPause()
  {
    VdsAgent.onFragmentPause(this);
    super.onPause();
    this.b.onPause();
  }
  
  public void onResume()
  {
    VdsAgent.onFragmentResume(this);
    super.onResume();
    this.b.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    VdsAgent.setFragmentUserVisibleHint(this, paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/TextureMapFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */