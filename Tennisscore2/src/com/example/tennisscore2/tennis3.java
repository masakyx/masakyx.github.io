package com.example.tennisscore2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class tennis3 extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tennis3);
		
		Resultvalue Rvv;
		Rvv = (Resultvalue) getApplication();
		
		final Spinner sp2 = (Spinner)findViewById(R.id.spinner2);
		final String[] items2 = new String[8];
		for(int i=0;i<8;i++){
			items2[i] = String.valueOf(i+1);
		}
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.list1,items2);
		sp2.setAdapter(adapter1);
		
		final Spinner sp3 = (Spinner)findViewById(R.id.spinner3);
		final String[] items3 = {"1","3","5"};
		ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, R.layout.list1, items3);
		sp3.setAdapter(adapter3);
		
		final Spinner sp4 = (Spinner)findViewById(R.id.spinner4);
		final String[] items4 = {"有","無"};
		ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,R.layout.list1, items4);
		sp4.setAdapter(adapter4);
		
		final Spinner sp5 = (Spinner)findViewById(R.id.spinner5);
		final String[] items5 = {"無","7","12"};
		ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this,R.layout.list1,items5);
		sp5.setAdapter(adapter5);
		
		Intent intent = getIntent();
		final String gametype = intent.getStringExtra("gametype");
		final String p[] = new String[4];
		for(int i=0;i<4;i++){
			p[i] = intent.getStringExtra("player"+i);
		}
		/*String p1 = intent.getStringExtra("p1");
		String p2 = intent.getStringExtra("p2");
		String p3 = intent.getStringExtra("p3");
		String p4 = intent.getStringExtra("p4");
		*/
		final String[] items = new String[2];
		final Spinner sp1 = (Spinner)findViewById(R.id.spinner1);
		if(gametype.equals("Singles")){
			for(int i = 0;i<2;i++){
				items[i] = p[i];
			}
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list1,items);
			sp1.setAdapter(adapter);
			/*intent.putExtra("username1", p[0]);
			intent.putExtra("username2", p[1]);*/
		}else if(gametype.equals("Doubles")){
			for(int i=0; i<2;i++){
				items[i] = p[i*2] + ","+p[i*2+1];
 			}
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list1,items);
			sp1.setAdapter(adapter);
			/*intent.putExtra("username1", p[0]+","+p[1]);
			intent.putExtra("username2", p[2]+","+p[3]);*/
		}/*else{
			items[1] = "nothing";
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list1,items);
			sp1.setAdapter(adapter);
		}*/
		
		Button bt1 = (Button)findViewById(R.id.button1);
		bt1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				String server = (String)sp1.getSelectedItem();		//sp1 スピーナーから値を取得
				String setnumber = (String)sp3.getSelectedItem();
				String gamenumber = (String)sp2.getSelectedItem();
				String deusenumber = (String)sp4.getSelectedItem();
				String tibreaknumber = (String)sp5.getSelectedItem();
				Intent it1 = new Intent();
				//Intent it2 = new Intent();
				it1.setClass(tennis3.this, tennis4.class);
				/*it2.setClass(tennis3.this,tennis5.class);
				it2.putExtra("gametype", gametype);
				it2.putExtra("server", server);
				it2.putExtra("username1", p[0]);
				it2.putExtra("username2", p[1]);
				it2.putExtra("username3", p[0]+","+p[1]);
				it2.putExtra("username4", p[2]+","+p[3]);*/
				
				it1.putExtra("gametype",gametype);
				it1.putExtra("username1", p[0]);
				it1.putExtra("username2", p[1]);
				it1.putExtra("username3", p[0]+","+p[1]);
				it1.putExtra("username4", p[2]+","+p[3]);
				it1.putExtra("server",server);
				it1.putExtra("gamenumber",gamenumber);
				it1.putExtra("setnumber", setnumber);
				it1.putExtra("deusenumber", deusenumber);
				it1.putExtra("tibreaknumber", tibreaknumber);
				startActivity(it1);
				// TODO 自動生成されたメソッド・スタブ
				
			}
			
		});
		
		Button bt2 = (Button)findViewById(R.id.button2);
		bt2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = getIntent();
				String gametype = intent.getStringExtra("gametype");
				Intent it1 = new Intent();
				if(gametype.equals("Singles")){
					it1.setClass(tennis3.this,tennis1.class);
					startActivity(it1);
				}else if(gametype.equals("Doubles")){
					it1.setClass(tennis3.this, tennis1.class);
					startActivity(it1);
				}
				// TODO 自動生成されたメソッド・スタブ
				
			}
			
		});
		
	}

}
