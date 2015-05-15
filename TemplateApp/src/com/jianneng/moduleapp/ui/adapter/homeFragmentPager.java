package com.jianneng.moduleapp.ui.adapter;

import com.jianneng.moduleapp.ui.fragment.HomeAboutFragment;
import com.jianneng.moduleapp.ui.fragment.HomeActivityFragment;
import com.jianneng.moduleapp.ui.fragment.HomeMallFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class homeFragmentPager extends FragmentPagerAdapter {
	
	Fragment fragment = null;

	public homeFragmentPager(FragmentManager fm) {
		super(fm);
	}

	
	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			fragment = HomeMallFragment.instance();
			break;
		case 1:
			fragment = HomeActivityFragment.instance();
			break;
		case 2:
			fragment = HomeAboutFragment.instance();
			break;
		
		default:
			break;
		}
		
		return fragment;
	}

	
	@Override
	public int getCount() {
		
		return 3;
	}
	
	public Fragment getCurrentFragment(){
		
		return fragment;
	}

}
