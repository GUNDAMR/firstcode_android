package com.raoxun.activitylifecycletest;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	public static final String TAG = "MainActivity";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "OnCreate");
        setContentView(R.layout.activity_main);
        Button normalButton = (Button)findViewById(R.id.btn_normal);
        normalButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, NormalActivity.class);
				startActivity(intent);
			}
		});
        
        Button dialogButton = (Button)findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, DialogActivity.class);
				startActivity(intent);
			}
		});
        
        if(savedInstanceState!=null){
        	String tmpData = savedInstanceState.getString("data_key");
        	Toast.makeText(MainActivity.this, tmpData, Toast.LENGTH_SHORT).show();
        } else{
        	Toast.makeText(MainActivity.this, "on saved instance state", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    protected void onStart() {
    	super.onStart();
    	Log.d(TAG, "OnStart");
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	Log.d(TAG, "OnPause");
    }
    
    @Override
    protected void onStop() {
    	super.onStop();
    	Log.d(TAG, "OnStop");
    }
    
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	Log.d(TAG, "OnDestroy");
    }
    
    @Override
    protected void onRestart() {
    	super.onRestart();
    	Log.d(TAG, "OnRestart");
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	Log.d(TAG, "OnResume");
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	// TODO Auto-generated method stub
    	super.onSaveInstanceState(outState);
    	String dataString = "Save Instance State";
    	outState.putString("data_key", dataString);
    }
}
