package com.yoarabia;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class VisareqActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		TextView text =new TextView(this);
		String tex = "Students from outside the UAE will need to apply for a Student Residence Visa by completing the Student Visa Form.Visa application processing and renewal on a normal basis takes around 20-25 working days. An express service, which takes 7-10 working days, is available at an additional cost of AED 1,500.Visa fees are beyond the control of the University and are subject to change. For more details on the visa sponsorship fees, please refer to the notes in the Student Visa Form.";
		tex +="\nThere is an additional refundable deposit of AED 3,000 for all visa sponsorship applications. This is only paid once.To make a visa sponsorship application, you will need to provide:proof of your undergraduate degree (attested at UAE embassy) proof of funds in your bank account (AED 30,000) receipt of your tuition fees";
		tex +="\n\nVisa renewal \nYour Student Residence Visa must be renewed each year. This costs AED 3,000.";
		text.setText(tex);
		setContentView(text);
	}
		
}
