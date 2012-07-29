package com.yoarabia.heriotwatt;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.yoarabia.moreclasses.swipeAdapter;


public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    

    InternetChecker internet = new InternetChecker();
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewer);
        
        swipeAdapter swipe = new swipeAdapter(R.layout.main,R.layout.yoarabiaswipe);
        ViewPager pager = (ViewPager)findViewById(R.id.viewpager);
        pager.setAdapter(swipe);
        pager.setCurrentItem(0);
        
    }
    public void people(View v){
  	   //Toast.makeText(v.getContext(), "people", Toast.LENGTH_SHORT).show();
  	   Intent intent =new Intent(MainActivity.this,PeopleActivity.class);
  	 
  	   startActivity(intent);
     }
    public void website(View v){
  	   //Toast.makeText(v.getContext(), "people", Toast.LENGTH_SHORT).show();
    	
    	if(internet.isOnline(this)){
	  	   Intent intent =new Intent(MainActivity.this,WebsiteActivity.class);
	  	   startActivity(intent);
        }
     }
    public void news(View v){
  	   //Toast.makeText(v.getContext(), "people", Toast.LENGTH_SHORT).show();
  	   Intent intent =new Intent(MainActivity.this,EventparseActivity.class);
  	   intent.putExtra("url", "1");
  	   startActivity(intent);
     }
    public void route(View v){
  	   //Toast.makeText(v.getContext(), "people", Toast.LENGTH_SHORT).show();
    	if(internet.isOnline(this)){
	  	    Intent intent =new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?daddr=25.138136,55.415726"));
	  	    startActivity(intent);
        }
     }
	@TargetApi(5)
	public void schools(View v){
  	   //Toast.makeText(v.getContext(), "people", Toast.LENGTH_SHORT).show();
  	   Intent intent =new Intent(MainActivity.this,SchoolsActivity.class);
  	   overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
  	   startActivity(intent);
     }
    public void living(View v){
  	   //Toast.makeText(v.getContext(), "people", Toast.LENGTH_SHORT).show();
  	   Intent intent =new Intent(MainActivity.this,AccomodationActivity.class);
  	   startActivity(intent);
     }
    public void activities(View v){
  	   //Toast.makeText(v.getContext(), "people", Toast.LENGTH_SHORT).show();
    	 Intent intent =new Intent(MainActivity.this,EventparseActivity.class);
    	 intent.putExtra("url", "0");
  	     startActivity(intent);
     }
    public void location(View v){
  	   //Toast.makeText(v.getContext(), "people", Toast.LENGTH_SHORT).show();
  	   Intent intent =new Intent(MainActivity.this,LocationsMapsActivity.class);
  	   startActivity(intent);
     }
    public void callus(View v){
  	   //Toast.makeText(v.getContext(), "people", Toast.LENGTH_SHORT).show();
  	   Intent intent =new Intent(Intent.ACTION_CALL,Uri.parse("tel:12321312"));
  	   startActivity(intent);
     }
    
    public void email(View v){
  	   //Toast.makeText(v.getContext(), "people", Toast.LENGTH_SHORT).show();
    	Intent intent = new Intent(android.content.Intent.ACTION_SEND);

        //String aEmailList[] = { "dubaienquiries@hw.ac.uk"};  
        String aEmailCCList[] = { "dubaienquiries@hw.ac.uk"};  
       // String aEmailBCCList[] = { "user5@fakehost.com" };  */
          
        //intent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);  
        intent.putExtra(android.content.Intent.EXTRA_CC, aEmailCCList);  
        //intent.putExtra(android.content.Intent.EXTRA_BCC, aEmailBCCList);  
          
        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");  
          
        intent.setType("plain/text");  
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "Your Message.");  
          
        startActivity(Intent.createChooser(intent, "Send your email using:"));
     }
    
    public void social(View v){
  	   //Toast.makeText(v.getContext(), "people", Toast.LENGTH_SHORT).show();
  	   Intent intent =new Intent(MainActivity.this,SocialActivity.class);
  	   if(v.getId()==R.id.maintw){
  		   intent.putExtra("url", "1");
  	   }else{
  		   intent.putExtra("url", "0");
  	   }
  	   startActivity(intent);
     }
    
    
    
}
