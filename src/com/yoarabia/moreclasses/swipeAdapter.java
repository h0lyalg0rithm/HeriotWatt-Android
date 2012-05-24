package com.yoarabia.moreclasses;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

public class swipeAdapter extends PagerAdapter{

	
	int first,second,third,fourth,fifth,count;
	public swipeAdapter(int first){
		this.first = first;
		count = 1;
	}
	public swipeAdapter(int first, int second) {
		// TODO Auto-generated constructor stub
		this.first = first;
		this.second = second;
		count = 2;
	}
	public swipeAdapter(int first, int second,int third){
		this.first = first;
		this.second = second;
		this.third = third;
		count = 3;
	}
	public swipeAdapter(int first, int second,int third,int fourth){
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
		count = 4;
	}
	public swipeAdapter(int first, int second,int third,int fourth,int fifth){
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
		this.fifth = fifth;
		count = 5;
	}
	public void destroyItem(View arg0, int arg1, Object arg2) {
		// TODO Auto-generated method stub
		((ViewPager) arg0).removeView((View) arg2);
	}

	@Override
	public void finishUpdate(View arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public Object instantiateItem(View arg0, int arg1) {
		// TODO Auto-generated method stub
		int resid = 0;
		LayoutInflater inflator = (LayoutInflater)arg0.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		switch(arg1){
		case 0:
			resid = first;
			break;
		case 1:
			resid = second;
		case 2:
			resid = third;
		case 3:
			resid = fourth;
		case 4:
			resid = fifth;
			break;
		}
		View view = inflator.inflate(resid, null);
		((ViewPager)arg0).addView(view,0);
		return view;
		
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == ((View) arg1);
	}

	@Override
	public void restoreState(Parcelable arg0, ClassLoader arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Parcelable saveState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void startUpdate(View arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
