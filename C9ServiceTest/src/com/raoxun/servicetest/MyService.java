package com.raoxun.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

	public static final String TAG = "MyService";
	
	private DownloadBinder mBinder = new DownloadBinder();
	
	class DownloadBinder extends Binder{
		public void startDownload(){
			Log.d(TAG, "start Download");
		}
		
		public void getProgress(){
			Log.d(TAG, "get progress");
		}
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d(TAG, "onCreate");
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(TAG, "onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "onDestroy");
	}
}
