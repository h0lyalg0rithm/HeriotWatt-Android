package com.yoarabia;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Button;
import android.widget.Button;


public class SocialActivity extends Activity {

	
	WebView view;
	int set;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.social);
		view = (WebView)findViewById(R.id.socialwebview);
		view.setWebViewClient(new client());
		view.getSettings().setDomStorageEnabled(true);
		view.getSettings().setUserAgentString("Mozilla/5.0 (Linux; U; Android 2.0; en-us; Droid Build/ESD20) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17");
		view.getSettings().setJavaScriptEnabled(true);
		String url = getIntent().getStringExtra("url");
		if(url=="1"){
		view.loadUrl("https://twitter.com/HeriotWattUni");}
		else {
			view.loadUrl("https://m.facebook.com/pages/Heriot-Watt-University-Dubai-Campus/350395710333");
		}
		
		//view.getSettings().
		//set=1;
		Button twitter = (Button)findViewById(R.id.twittersocialbtn);
		twitter.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				view.loadUrl("https://twitter.com/HeriotWattUni");
				//Toast.makeText(getApplicationContext(), view.getUrl().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		Button facebook = (Button)findViewById(R.id.facebooksocialbtn);
		facebook.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				view.loadUrl("https://m.facebook.com/pages/Heriot-Watt-University-Dubai-Campus/350395710333");
			}
		});
		Button youtube = (Button)findViewById(R.id.youtubesocialbtn);
		youtube.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				view.loadUrl("http://www.youtube.com/user/HeriotWattUni");
			}
		});
	}
    class client extends WebViewClient{
		
		
		

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			//return super.shouldOverrideUrlLoading(view, url);
			view.loadUrl(url);
			return true;
		}
    	
    }
    
}
