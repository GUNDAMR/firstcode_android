package com.raoxun.uiwidgettest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	EditText editText;
	
	ImageView imageView;
	
	ProgressBar progressBar;
	
	Button alertButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String inputString = editText.getText().toString();
				Toast.makeText(MainActivity.this, inputString, Toast.LENGTH_SHORT).show();
				imageView.setImageResource(R.drawable.jelly_bean);
				if(progressBar.getVisibility() == View.GONE){
					progressBar.setVisibility(View.VISIBLE);
				} 
				
				progressBar.setProgress(progressBar.getProgress() + 10);
				if(progressBar.getProgress() == 100){
					progressBar.setProgress(0);
					progressBar.setVisibility(View.GONE);
				}
			}
		});
        
        editText = (EditText)findViewById(R.id.edit_text);
        imageView = (ImageView)findViewById(R.id.image_view);
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        progressBar.setMax(100);
        alertButton = (Button)findViewById(R.id.btn_alert);
        alertButton.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {
    	// TODO Auto-generated method stub
    	switch(v.getId()){
    	case R.id.btn_alert:
    		AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
    		dialog.setTitle("Alert Dialog");
    		dialog.setMessage("Message");
    		dialog.setCancelable(false);
    		dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Toast.makeText(MainActivity.this, "ok for alert dialog", Toast.LENGTH_SHORT).show();
				}
			});
    		dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Toast.makeText(MainActivity.this, "cancel for alert dialog", Toast.LENGTH_SHORT).show();
				}
			});
    		dialog.show();
    		break;
    	}
    }
}
