package com.example.tennisscore2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button bt = (Button)findViewById(R.id.button1);
		
		bt.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent it = new Intent(MainActivity.this,tennis1.class);
				startActivity(it);
				
			}
		});
		Button bt1 = (Button)findViewById(R.id.button2);
		
		bt1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent it = new Intent(MainActivity.this,tennis2.class);
				startActivity(it);
				
			}
		});
	}
}
