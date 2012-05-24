package com.yoarabia;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class PeopleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND, WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        setContentView(R.layout.people);
    }
    public void transport(View v){
    	call("044358621");
    }
    public void admiss(View v){
    	call("044358603");
    }public void support(View v){
    	call("043616996");
    }public void general(View v){
    	call("043616899");
    }
    void email(String email){
    	
    }
    void call(String num){
    	Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+num));
    	startActivity(intent);
    }
}