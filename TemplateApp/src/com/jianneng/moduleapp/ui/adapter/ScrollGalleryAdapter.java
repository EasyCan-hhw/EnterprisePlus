package com.jianneng.moduleapp.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ScrollGalleryAdapter extends BaseAdapter {

	private List<Integer> listdate = new ArrayList<Integer>();
	private Context context;
	
	public ScrollGalleryAdapter(){
		super();
	}
	
	public ScrollGalleryAdapter(List<Integer> listdate, Context context) {
		this.listdate = listdate;
		this.context = context;
	}

	public List<Integer> getListdate() {
		return listdate;
	}

	public void setListdate(List<Integer> listdate) {
		this.listdate = listdate;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listdate.size();
	}

	@Override
	public Integer getItem(int position) {
		// TODO Auto-generated method stub
		return listdate.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView = new ImageView(context);
		if (convertView == null) {
			imageView.setBackgroundResource(listdate.get(position%listdate.size()));
			imageView.setScaleType(ScaleType.FIT_XY);
			imageView.setLayoutParams(new Gallery.LayoutParams(Gallery.LayoutParams.FILL_PARENT, Gallery.LayoutParams.WRAP_CONTENT));
			convertView.setTag(imageView);
			
		}else {
			imageView = (ImageView) convertView.getTag();
		}
		
		return convertView;
	}

	
	
	
	
	
}
