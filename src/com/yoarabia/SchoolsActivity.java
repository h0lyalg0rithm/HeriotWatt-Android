package com.yoarabia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SchoolsActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school);
        //Typeface font = Typeface.createFromAsset(getAssets(), "roman.ttf");
        TextView eps = (TextView)findViewById(R.id.EPS);
        eps.setOnClickListener(this);
        TextView dep = (TextView)findViewById(R.id.DEP);
        dep.setOnClickListener(this); 
        TextView be = (TextView)findViewById(R.id.BE);
        be.setOnClickListener(this); 
        TextView sml = (TextView)findViewById(R.id.SML);
        sml.setOnClickListener(this); 
        TextView ls = (TextView)findViewById(R.id.LS);
        ls.setOnClickListener(this); 
        TextView td = (TextView)findViewById(R.id.TD);
        td.setOnClickListener(this); 
        TextView smcs = (TextView)findViewById(R.id.SMCS);
        smcs.setOnClickListener(this); 
        TextView pe = (TextView)findViewById(R.id.PE);
        pe.setOnClickListener(this); 
        TextView ebs = (TextView)findViewById(R.id.EBS);
        ebs.setOnClickListener(this); 
        
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(SchoolsActivity.this,CourseActivity.class);
		switch (v.getId()) {
		case R.id.EPS:
			intent.putExtra("course", "EPS");
			startActivity(intent);
			break;
		case R.id.DEP:
			intent.putExtra("course", "DEP");
			startActivity(intent);
			break;
		case R.id.BE:
			intent.putExtra("course", "SBE");
			startActivity(intent);
			break;
		case R.id.SML:
			intent.putExtra("course", "SML");
			startActivity(intent);
			break;
		case R.id.LS:
			intent.putExtra("course", "SLS");
			startActivity(intent);
			break;
		case R.id.TD:
			intent.putExtra("course", "STD");
			startActivity(intent);
			break;
		case R.id.SMCS:
			intent.putExtra("course", "SMCS");
			startActivity(intent);
			break;
		case R.id.PE:
			intent.putExtra("course", "IPE");
			startActivity(intent);
			break;
		case R.id.EBS:
			intent.putExtra("course", "EBS");
			startActivity(intent);
			break;
		default:
			break;
		}
	}
}