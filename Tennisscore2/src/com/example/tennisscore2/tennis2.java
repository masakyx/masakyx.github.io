package com.example.tennisscore2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class tennis2 extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tennis2);
		
		Button bt1 = (Button)findViewById(R.id.button1);
		bt1.setOnClickListener(new OnClickListener(){
			
			@Override
			 public void onClick(View v) {
				EditText player[] = new EditText[4];
				player[0] = (EditText)findViewById(R.id.editText1);
				player[1] = (EditText)findViewById(R.id.editText4);
				player[2] = (EditText)findViewById(R.id.editText2);
				player[3] = (EditText)findViewById(R.id.editText3);
	            Intent intent = new Intent();
	            intent.setClass(tennis2.this, tennis3.class);
	            intent.putExtra("gametype", "Doubles");
	            Intent intent2 = new Intent();
	            intent2.setClass(tennis2.this, tennis5.class);
	            intent2.putExtra("gametype" ,"Doubles");
	            for(int i=0;i<4;i++){
	            	intent.putExtra("player"+i,player[i].getText().toString());
	            }
	            startActivity(intent);
			}
		});
		Button bt2 = (Button)findViewById(R.id.button2);
		bt2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(tennis2.this,MainActivity.class);
				startActivity(intent);
				// TODO 自動生成されたメソッド・スタブ
				
			}
			
		});
	}
	

}
