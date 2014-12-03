package com.example.tennisscore2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;
public class tennis1 extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tennis1);
		
		Button bt1 = (Button)findViewById(R.id.button1);
		bt1.setOnClickListener(new OnClickListener(){
			
			@Override
			 public void onClick(View v) {
	               Intent intent = new Intent();
	               EditText player[] = new EditText[2];
	               player[0] = (EditText)findViewById(R.id.editText1);
	               player[1] = (EditText)findViewById(R.id.editText2);
	               intent.setClass(tennis1.this, tennis3.class);
	               Intent intent2 = new Intent();
	               intent2.setClass(tennis1.this, tennis5.class);
	               intent.putExtra("gametype","Singles");
	               for(int i=0;i<2;i++){
	            	   intent.putExtra("player"+i,player[i].getText().toString());
	               }
	               intent.putExtra("gametype", "Singles");
	               startActivity(intent);
			}
		});
		Button bt2 = (Button)findViewById(R.id.button2);
		bt2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(tennis1.this,MainActivity.class);
				startActivity(intent);
				// TODO 自動生成されたメソッド・スタブ
				
			}
			
		});
	}
	

}
