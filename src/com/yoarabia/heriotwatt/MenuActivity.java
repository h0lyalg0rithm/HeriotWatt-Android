package com.yoarabia.heriotwatt;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;

public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND, WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
		setContentView(R.layout.menucourse);
		Button callus = (Button)findViewById(R.id.menucallus);
		callus.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:0123456779"));
				startActivity(intent);
			}
		});
		Button applyonline = (Button)findViewById(R.id.menuapplynow);
		applyonline.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://myhwu.hw.ac.uk/"));
				startActivity(intent);
			}
		});
		Button visareq = (Button)findViewById(R.id.menuvisareq);
		visareq.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MenuActivity.this,VisareqActivity.class);
				startActivity(intent);
			}
		});
	}
	

}
