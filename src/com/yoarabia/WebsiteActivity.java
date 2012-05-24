package com.yoarabia;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebsiteActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.website);
        String url = "http://www.hw.ac.uk/";
        WebView websiteview;
        websiteview = (WebView)findViewById(R.id.websiteview);
        websiteview.loadUrl(url);
        websiteview.setWebViewClient(new webviewclient());
    }
    class webviewclient extends WebViewClient{

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
    	
    }
}