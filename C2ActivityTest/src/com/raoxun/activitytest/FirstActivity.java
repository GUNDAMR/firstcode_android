package com.raoxun.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		// hidden title bar
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.first_layout);
		
		Button btn1 = (Button)findViewById(R.id.button1);
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(FirstActivity.this, "You clicked Button 1", Toast.LENGTH_SHORT).show();
			}
		});
		
		Button btnExit = (Button)findViewById(R.id.button_exit);
		btnExit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		Button btnSecondExplict = (Button)findViewById(R.id.btn_second_explicit);
		btnSecondExplict.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String data = "hello, second activity explicit";
				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				intent.putExtra("extra_data", data);
				startActivityForResult(intent, 1);
			}
		});
		
		Button btnSecondImplicit = (Button)findViewById(R.id.btn_second_implicit);
		btnSecondImplicit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String data = "hello, second activity implicit";
				Intent intent = new Intent("android.intent.activitytest.ACTION_START");
				intent.addCategory("android.intent.category.MY_CATEGORY");
				intent.putExtra("extra_data", data);
				startActivity(intent);
			}
		});
		
		Button webButton = (Button)findViewById(R.id.btn_web);
		webButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("http://www.baidu.com"));
				startActivity(intent);
			}
		});
		
		Button firstButton = (Button)findViewById(R.id.btn_first);
		firstButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(FirstActivity.this, FirstActivity.class);
				startActivity(intent);
			}
		});
		
		Button thirdButton = (Button)findViewById(R.id.btn_third);
		thirdButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(FirstActivity.this, ThirdActivity.class);
				startActivity(intent);
			}
		});
		
		Button exitAllButton = (Button)findViewById(R.id.btn_exit_all);
		exitAllButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ActivityCollector.finishAll();
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.add_item:
			Toast.makeText(this, "click add", Toast.LENGTH_SHORT).show();
			break;
		case R.id.remove_item:
			Toast.makeText(this, "click remove", Toast.LENGTH_LONG).show();
			break;
		default:
			break;
		}
		
		return true;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case 1:
			if(resultCode == RESULT_OK){
				String returnString = data.getStringExtra("data_return");
				Toast.makeText(FirstActivity.this, returnString, Toast.LENGTH_LONG).show();
			}
			break;

		default:
			break;
		}
	}
}
