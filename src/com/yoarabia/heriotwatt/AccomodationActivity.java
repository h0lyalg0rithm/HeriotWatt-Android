package com.yoarabia.heriotwatt;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class AccomodationActivity extends Activity {
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accomodation);
        Gallery gallery = (Gallery)findViewById(R.id.gallery1);
        Imageadapter adapter = new Imageadapter(this);
        gallery.setAdapter(adapter);
        gallery.setSelection(1);
     
    }
    class Imageadapter extends BaseAdapter{
    	 int mGalleryItemBackground;
    	    private Context mContext;

    	    private Integer[] mImageIds = {
    	    		R.drawable.live1,R.drawable.live2,R.drawable.live3,R.drawable.live6
    	    };

    	    public Imageadapter(Context c) {
    	        mContext = c;
    	        TypedArray attr = mContext.obtainStyledAttributes(R.styleable.HelloGallery);
    	        mGalleryItemBackground = attr.getResourceId(
    	                R.styleable.HelloGallery_android_galleryItemBackground, 0);
    	        attr.recycle();
    	    }

    	    public int getCount() {
    	        return mImageIds.length;
    	    }

    	    public Object getItem(int position) {
    	        return position;
    	    }

    	    public long getItemId(int position) {
    	        return position;
    	    }

    	    public View getView(int position, View convertView, ViewGroup parent) {
    	        ImageView imageView = new ImageView(mContext);

    	        imageView.setImageResource(mImageIds[position]);
    	        imageView.setLayoutParams(new Gallery.LayoutParams(260, 225));
    	        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
    	        imageView.setBackgroundResource(mGalleryItemBackground);
    	        return imageView;
    	    }
    	}
}