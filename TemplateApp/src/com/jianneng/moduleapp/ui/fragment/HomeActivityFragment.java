package com.jianneng.moduleapp.ui.fragment;

import com.jianneng.moduleapp.R;
import com.jianneng.moduleapp.task.base.BaseFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeActivityFragment extends Fragment {

	public static HomeActivityFragment instance(){
		return new HomeActivityFragment();
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.home_activity_fragment, container, false);
		return view;
	}
	
	public void findView(View view){
			
	}

	@Override
	public void setMenuVisibility(boolean menuVisible) {
		super.setMenuVisibility(menuVisible);
		if (this.getView() != null) {
			if (menuVisible) {
				this.getView().setVisibility(View.VISIBLE);
			}else {
				this.getView().setVisibility(View.GONE);
			}
		}
	}

	
}
