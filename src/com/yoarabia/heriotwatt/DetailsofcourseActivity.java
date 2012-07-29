package com.yoarabia.heriotwatt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;



public class DetailsofcourseActivity extends Activity {

	private MyDatabase db;
	String coursedetails;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		String id = getIntent().getStringExtra("id");
		db = new MyDatabase(this);
		//Toast.makeText(getApplicationContext(), id, Toast.LENGTH_SHORT).show();*/
		setContentView(R.layout.detailsofcourse);
		
		Button courseapplynow = (Button)findViewById(R.id.courseapplynow);
		courseapplynow.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DetailsofcourseActivity.this,MenuActivity.class);
				startActivity(intent);
			}
		});
		
		//coursedetailsdb = db.getdetails(id);
		//Log.d("details", coursedetails);
		TextView title = (TextView)findViewById(R.id.title);
		TextView coursedetails = (TextView)findViewById(R.id.coursedetails);
		//coursedetails.setText((CharSequence) coursedetails);
		title.setText(db.getdetails(id).getString(1));
		coursedetails.setText(db.getdetails(id).getString(2));
	}
		
}
