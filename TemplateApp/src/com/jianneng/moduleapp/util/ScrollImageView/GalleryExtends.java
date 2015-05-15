package com.jianneng.moduleapp.util.ScrollImageView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Gallery;

public class GalleryExtends extends Gallery {
	
	
	public GalleryExtends(Context context){
		super(context);
	}
	
	public GalleryExtends(Context context,AttributeSet attrs){
		super(context, attrs);
	}
	

	public GalleryExtends(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	private Boolean isScrollingLeft(MotionEvent e1,MotionEvent e2) {
		return e2.getX() > e1.getX();
	}
	
	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		
		int KeEvent;
		
		if (isScrollingLeft(e1, e2)) {
			
			KeEvent = KeyEvent.KEYCODE_DPAD_LEFT;
			
		}else {
			
			KeEvent = KeyEvent.KEYCODE_DPAD_RIGHT;
			
		}
		
		onKeyDown(KeEvent, null);
		
		return true;
		
	}
	

}
