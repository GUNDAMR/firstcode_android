package com.raoxun.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ThirdActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.third_layout);
		
		Button firstButton = (Button)findViewById(R.id.btn_first);
		firstButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ThirdActivity.this, FirstActivity.class);
				startActivity(intent);
			}
		});

		Button secondButton = (Button)findViewById(R.id.btn_second);
		secondButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
				startActivity(intent);
			}
		});
		
		Button thirdButton = (Button)findViewById(R.id.btn_third);
		thirdButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ThirdActivity.this, ThirdActivity.class);
				startActivity(intent);
			}
		});
	}
}
