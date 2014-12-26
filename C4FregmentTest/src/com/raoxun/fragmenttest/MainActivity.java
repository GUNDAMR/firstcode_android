package com.raoxun.fragmenttest;

import com.raoxun.fregmenttest.R;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Fragment curFragment;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Fragment fragment;
				if(curFragment == null || curFragment instanceof RightFragment){
					fragment = new AnotherRightFragment();
				} else {
					fragment = new RightFragment();
				}
				
				FragmentManager fragmentManager = MainActivity.this.getFragmentManager();
				FragmentTransaction transaction = fragmentManager.beginTransaction();
				transaction.replace(R.id.right_layout, fragment);
				transaction.addToBackStack(null);
				transaction.commit();
				curFragment = fragment;
			}
		});
    }
}
