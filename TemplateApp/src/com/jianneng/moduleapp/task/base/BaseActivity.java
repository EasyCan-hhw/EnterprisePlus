package com.jianneng.moduleapp.task.base;
import com.jianneng.moduleapp.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

public abstract class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text_title);
	}
	
	
	public void baseSetContentView(int layoutResId){
		LinearLayout llContent = (LinearLayout) findViewById(R.id.content);  
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
        View v = inflater.inflate(layoutResId, null); 
        llContent.addView(v); 
        
	}
	
	
	
}