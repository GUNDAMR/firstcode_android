package com.raoxun.servicetest;

import android.app.Activity;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	public static final String TAG = "MyService";
	private ServiceConnection connection = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.d(TAG, name.toShortString() + " onServiceDisconnected");
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.d(TAG, name.toShortString() + " onServiceConnected");
			MyService.DownloadBinder binder = (MyService.DownloadBinder)service;
			binder.startDownload();
			binder.getProgress();
		}
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startService = (Button)findViewById(R.id.btn_start_service);
        startService.setOnClickListener(this);
        
        Button stopService = (Button)findViewById(R.id.btn_stop_service);
        stopService.setOnClickListener(this);
        
        Button bindService = (Button)findViewById(R.id.btn_bind_service);
        bindService.setOnClickListener(this);
        
        Button unBindService = (Button)findViewById(R.id.btn_unbind_service);
        unBindService.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {
    	switch(v.getId()){
    	case R.id.btn_start_service:
    		Intent startIntent = new Intent(this, MyService.class);
    		startService(startIntent);
    		break;
    	case R.id.btn_stop_service:
    		Intent stopIntent = new Intent(this, MyService.class);
    		stopService(stopIntent);
    		break;
    	case R.id.btn_bind_service:
    		Intent bindIntent = new Intent(this, MyService.class);
    		bindService(bindIntent, connection, BIND_AUTO_CREATE);
    		break;
    	case R.id.btn_unbind_service:
    		unbindService(connection);
    		break;
    	default:
    			break;
    	}
    }
}
