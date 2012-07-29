package com.yoarabia.heriotwatt;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.widget.Toast;

public class InternetChecker {

	public boolean isOnline(Context c){
		URL url = null;
		try {
			url = new URL("http://www.google.com/");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    ConnectivityManager cm = (ConnectivityManager)c.getSystemService(c.CONNECTIVITY_SERVICE);
	    NetworkInfo netInfo = cm.getActiveNetworkInfo();
	    if (netInfo != null && netInfo.isConnectedOrConnecting()) {
	    	
	    	HttpURLConnection conn;
			try {
				conn = (HttpURLConnection)url.openConnection();
				if(!url.getHost().equals(conn.getURL().getHost())){
		    		Toast.makeText(c, "Please sign on to the network", Toast.LENGTH_SHORT).show();
		    		Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(url.getHost().toString()));
		    		c.startActivity(intent);
		    	}else{
		    		return true;
		    	}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
	    }else{
	    Toast.makeText(c, "Please Connect to the internet", Toast.LENGTH_SHORT).show();
	    return false;
	    }
		return false;
	}

}
