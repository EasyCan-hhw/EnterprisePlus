package com.jianneng.moduleapp.task.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		FragmentCreateView(inflater, container, savedInstanceState);
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	public abstract View FragmentCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState);
	
	@Override
	public void setMenuVisibility(boolean menuVisible) {
		super.setMenuVisibility(menuVisible);
		if (this.getView()!=null) {
			if (menuVisible) {
				this.getView().setVisibility(View.VISIBLE);
			}else {
				this.getView().setVisibility(View.GONE);
			}
			
		}
		
	}
	
}
