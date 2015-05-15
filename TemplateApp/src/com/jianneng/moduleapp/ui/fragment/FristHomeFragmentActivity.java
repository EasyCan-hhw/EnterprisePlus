package com.jianneng.moduleapp.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jianneng.moduleapp.R;
import com.jianneng.moduleapp.task.base.BaseFragmentActivity;
import com.jianneng.moduleapp.ui.adapter.homeFragmentPager;

public class FristHomeFragmentActivity extends BaseFragmentActivity {

	
	private TextView first_mall_image,first_mall_text,first_activity_image,first_activity_text,first_about_image,first_about_text;
	private RelativeLayout forst_mall,forst_activity,forst_about;
	private LinearLayout container;
	private homeFragmentPager fragmentAdapter ;
	private OnClick mc = new OnClick();
	
	@Override
	public void OnActivityCreate(Bundle saveInstanceState) {
		setContentView(R.layout.first_home_fragment);
		fragmentAdapter = new homeFragmentPager(getSupportFragmentManager());
		findView();
		showFragment(0);
		first_mall_image.setSelected(true);
		first_mall_text.setTextColor(getResources().getColor(R.color.home_first_text_s));
		
	}
	
	private void findView() {
		
		container = (LinearLayout) findViewById(R.id.container);
		first_mall_image = (TextView) findViewById(R.id.first_mall_image);
		first_mall_text = (TextView) findViewById(R.id.first_mall_text);
		first_activity_image = (TextView) findViewById(R.id.first_activity_image);
		first_activity_text = (TextView) findViewById(R.id.first_activity_text);
		first_about_image = (TextView) findViewById(R.id.first_about_image);
		first_about_text = (TextView) findViewById(R.id.first_about_text);
		
		forst_mall = (RelativeLayout) findViewById(R.id.forst_mall);
		forst_activity = (RelativeLayout) findViewById(R.id.forst_activity);
		forst_about = (RelativeLayout) findViewById(R.id.forst_about);
		
		forst_mall.setOnClickListener(mc);
		forst_activity.setOnClickListener(mc);
		forst_about.setOnClickListener(mc);
		
		viewValue();
		
	}
	
	private void viewValue(){
		
		first_mall_image.setBackgroundResource(R.drawable.first_mall_selector);
		first_mall_text.setText(R.string.first_mall_text);
		first_mall_text.setTextColor(getResources().getColor(R.color.home_first_text));
		
		first_activity_image.setBackgroundResource(R.drawable.first_activity_selector);
		first_activity_text.setText(R.string.first_activity_text);
		first_activity_text.setTextColor(getResources().getColor(R.color.home_first_text));
		
		first_about_image.setBackgroundResource(R.drawable.first_about_selector);
		first_about_text.setText(R.string.first_about_text);
		first_about_text.setTextColor(getResources().getColor(R.color.home_first_text));
		
	}
	
	
	public void clearSelect(){
		
		first_mall_image.setSelected(false);
		first_mall_text.setTextColor(getResources().getColor(R.color.home_first_text));
		
		first_activity_image.setSelected(false);
		first_activity_text.setTextColor(getResources().getColor(R.color.home_first_text));
		
		first_about_image.setSelected(false);
		first_about_text.setTextColor(getResources().getColor(R.color.home_first_text));
		
		
	}
	
	class OnClick implements OnClickListener{

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.forst_mall:
				clearSelect();
				first_mall_image.setSelected(true);
				first_mall_text.setTextColor(getResources().getColor(R.color.home_first_text_s));
				showFragment(0);
				break;
				
			case R.id.forst_activity:
				clearSelect();
				first_activity_image.setSelected(true);
				first_activity_text.setTextColor(getResources().getColor(R.color.home_first_text_s));
				showFragment(1);
				break;
				
			case R.id.forst_about:
				clearSelect();
				first_about_image.setSelected(true);
				first_about_text.setTextColor(getResources().getColor(R.color.home_first_text_s));
				showFragment(2);
				break;
				
			default:
				break;
			}
		}
	}
	
	
	public void showFragment(int position){
		Fragment fragment = (Fragment) fragmentAdapter.instantiateItem(container, position);
		fragmentAdapter.setPrimaryItem(container, 0, fragment);
		fragmentAdapter.finishUpdate(container);
		fragmentAdapter.notifyDataSetChanged();
	}
	

	
}











