package com.yoarabia.heriotwatt;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class CourseActivity extends Activity {

	private Cursor employees;
	private MyDatabase db;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.schoolsmain);
		String course = this.getIntent().getStringExtra("course").toString();
		db = new MyDatabase(this);
		employees = db.getCourses(course); // you would not typically call this on the main thread
		ListView courseview = (ListView)findViewById(R.id.listView1);
		courseview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				//int sss= employees.getColumnIndex("_id");
				//int sss=1;
				Log.d("dd", employees.getString(0));
				Intent intent = new Intent(CourseActivity.this,DetailsofcourseActivity.class);
				intent.putExtra("id", employees.getString(0));
				startActivity(intent);
				//Toast.makeText(getApplicationContext(), , Toast.LENGTH_SHORT).show();
			}
		});
		ListAdapter adapter = new SimpleCursorAdapter(this, 
				android.R.layout.simple_list_item_1, 
				employees, 
				new String[] {"name"}, 
				new int[] {android.R.id.text1});
		
		courseview.setAdapter(adapter);
	}
	

	@Override
	protected void onDestroy() {
		super.onDestroy();
		employees.close();
		db.close();
	}

}