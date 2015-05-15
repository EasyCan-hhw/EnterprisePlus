package com.jianneng.moduleapp.task.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

public abstract class BaseFragmentActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		OnActivityCreate(savedInstanceState);
	}
	
	public abstract void OnActivityCreate(Bundle saveInstanceState);
	
	public BaseFragmentActivity getActivity(){
		return BaseFragmentActivity.this;
	}
	
	
}
