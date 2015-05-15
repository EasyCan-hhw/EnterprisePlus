package com.jianneng.moduleapp.ui.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.jianneng.moduleapp.R;
import com.jianneng.moduleapp.ui.adapter.ScrollGalleryAdapter;
import com.jianneng.moduleapp.util.Tool;
import com.jianneng.moduleapp.util.ScrollImageView.GalleryExtends;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class HomeMallFragment extends Fragment implements OnTouchListener,android.view.GestureDetector.OnGestureListener{

	
	//触摸事件监听start
	private static String TAG = "HomeMallFragment";
	private static GestureDetectorCompat detector ;
	//触摸事件监听 end 
	
	private Gallery myGallery;
	private RadioGroup gallery_points;
	private RadioButton[] gallery_point;
	private LinearLayout layout;
	private LayoutInflater inflater;
	private Context context;
//	private ScrollGalleryAdapter galleryAdapter = new ScrollGalleryAdapter();
	
	public static HomeMallFragment instance(){
		return new HomeMallFragment();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.home_mall_fragment, container, false);
		detector = new GestureDetectorCompat(getActivity(), HomeMallFragment.this);
		findView(view);
		context = view.getContext();
		inflater = LayoutInflater.from(context);
//		myGallery = new GalleryExtends(getActivity());
		
		//触摸事件监听 start
		view.setOnTouchListener(this);
		view.setFocusable(true);
		view.setClickable(true);
		view.setLongClickable(true);
		detector.setIsLongpressEnabled(true);
		//触摸事件监听 End 
		init(view);
		addEvn();
		return view;
	}
	
	
	private void findView(View view) {
		

	}
	
	//初始化
	public void init(View view){
		myGallery = (GalleryExtends) view.findViewById(R.id.myGallery);
		gallery_points = (RadioGroup) view.findViewById(R.id.galleryRaidoGroup);
		List<Integer> list = new ArrayList<Integer>();
		list.add(R.drawable.test_img1);
		list.add(R.drawable.test_img2);
		list.add(R.drawable.test_img3);
		ScrollGalleryAdapter galleryAdapter = new ScrollGalleryAdapter(list, context);
//		galleryAdapter.setListdate(list);
		System.out.println(list.size());
		System.out.println(galleryAdapter.getCount());
		myGallery.setAdapter(galleryAdapter);
		//设置小按钮
		gallery_point = new RadioButton[list.size()];
		for (int i = 0; i < gallery_point.length; i++) {
			layout = (LinearLayout) inflater.inflate(R.layout.scroll_gallery_redio_item, null);
			gallery_point[i] = (RadioButton) layout.findViewById(R.id.gallery_readiobutton);
			gallery_point[i].setId(i);//设置指示图ID
			int wh = Tool.dp2px(context, 15);
			RadioGroup.LayoutParams layoutparams = new RadioGroup.LayoutParams(wh, wh);//设置指示图大小
			gallery_point[i].setLayoutParams(layoutparams);
			layoutparams.setMargins(8, 0, 4, 3);// 设置指示图margin值
			gallery_point[i].setClickable(false);
			layout.removeView(gallery_point[i]);//一个子视图不能指定了多个父视图
			gallery_points.addView(gallery_point[i]);//把已经初始化的指示图动态添加到指示图的RadioGroup中 
		}
	}
	//添加事件
	public void addEvn(){
		myGallery.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				gallery_points.check(gallery_point[position % gallery_point.length].getId());
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
		});
	}
	
	private final Handler handler_gallery = new Handler() {
		public void handlerMessage(Message msg){
			//自定义屏幕按下的动作
			MotionEvent e1 = MotionEvent.obtain(SystemClock.uptimeMillis(),SystemClock.uptimeMillis(),MotionEvent.ACTION_DOWN,89.333336f,265.33334f,0);
			//自定义屏幕放开的动作
			MotionEvent e2 = MotionEvent.obtain(SystemClock.uptimeMillis(),SystemClock.uptimeMillis(),MotionEvent.ACTION_DOWN,300.0f,23800003f,0);
			myGallery.onFling(e2, e1, -800, 0);
			//给gallery添加按下和放开的动作，实现自动滑动
			super.handleMessage(msg);
		}
	};
	
	
	@Override
	public void onResume() {
		autogallery();
		super.onResume();
	}

	private void autogallery(){
		Timer time = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				Message m = new Message();
				handler_gallery.sendMessage(m);
			}
		};
		time.schedule(task, 8000, 5000);
	}
	
	@Override
	public void setMenuVisibility(boolean menuVisible) {
		// TODO Auto-generated method stub
		super.setMenuVisibility(menuVisible);
		if (this.getView() != null) {
			if (menuVisible) {
				this.getView().setVisibility(View.VISIBLE);
			}else { 
				this.getView().setVisibility(View.GONE);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	//触摸事件监听 startFind

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		detector.onTouchEvent(event);
		return false;
	}
	

	@Override
	public boolean onDown(MotionEvent e) {
		
		Log.e(TAG, "onDown()");
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		Log.e(TAG, "onShowPress()");
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		Log.e(TAG, "onSingleTapUp()");
		return false;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		Log.e(TAG, "onScroll()--->startdistanceX="+distanceX+"--->enddistanceY="+distanceY);
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		Log.e(TAG, "onLongPress()");
		
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		Log.e(TAG, "onFling()");
		Log.e(TAG, "onFling()--->startvelocityX="+velocityX+"--->endvelocityY="+velocityY);
		return false;
	}
//触摸事件监听 end Find
	
	
	
	
}
