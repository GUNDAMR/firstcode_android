package com.raoxun.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends BaseActivity {
	String dataString;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_layout);
		Intent intent = getIntent();
		dataString = intent.getStringExtra("extra_data");
		Button toastButton = (Button)findViewById(R.id.btn_exit_all);
		toastButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(SecondActivity.this, dataString, Toast.LENGTH_SHORT).show();
			}
		});
		
		Button returnButton = (Button)findViewById(R.id.btn2_return);
		returnButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("data_return", "echo: " + dataString);
				setResult(RESULT_OK, intent);
				finish();
			}
		});
		
		Button firstButton = (Button)findViewById(R.id.btn_first);
		firstButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
				startActivity(intent);
			}
		});

		Button secondButton = (Button)findViewById(R.id.btn_second);
		secondButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SecondActivity.this, SecondActivity.class);
				startActivity(intent);
			}
		});
		
		Button thirdButton = (Button)findViewById(R.id.btn_third);
		thirdButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
				startActivity(intent);
			}
		});
	}
	
	@Override
	public void onBackPressed() {
		Intent intent = new Intent();
		intent.putExtra("data_return", "from back press: " + dataString);
		setResult(RESULT_OK, intent);
		finish();
	}
}
