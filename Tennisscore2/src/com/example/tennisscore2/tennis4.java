package com.example.tennisscore2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class tennis4 extends Activity implements OnClickListener{
//array 取得変数
	int button_id[];
	
//変数の初期設定
	//player1スコア
	int score1 = 0;
	int count1 = 0;
	int setcount1 = 0;
	String sScore1 = String.valueOf(score1);
	String scount1 = String.valueOf(count1);
	String sSetcount1 = String.valueOf(setcount1);
	
	
    //player2スコア
	
	int score2 = 0;
	int count2 = 0;
	int setcount2 = 0;
	//int tibreak2 = 0;
	String sScore2 = String.valueOf(score2);
	String scount2 = String.valueOf(count2);
	String sSetcount2 = String.valueOf(setcount2);
	
	//設定値
	int cot = 0;
	int change = 0;
	String inOut = "in";
	int s1 = 0;
	int gs1 = 0;
	int sc1 = 0;
	boolean isTibreak = false;	
	int cb = 0; //changebuttonnumber
	int ChangeServer = 0;
	int ChangeCort = 0;
	int sidechange  = 0;
	boolean isFore = true;
	
//Gloabals変数の取得
	Resultvalue Rv;

	
//SQLite 
	private static SQLiteDatabase db;
	private MyDBTennisScore myhelper;
	private String str;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tennis4);
		Rv = (Resultvalue) this.getApplication();
/*//Databace helperの取得
		myhelper = new MyDBTennisScore(this);
		db = myhelper.getReadableDatabase();
//database delete
		db.delete("tennisDB", null , null);
//database show
		Cursor c = db.query("tennisDB" , new String[] {"_id" ,"comment"} ,null,null,null,null,null);
		startManagingCursor(c);
		str = "データベース一覧/n";
		while(c.moveToNext()){
			str += c;
		}*/
		
//array 取得
		Resources btres = getResources();
		String[] btlist = btres.getStringArray(R.array.btar);
		button_id = new int[btlist.length];
		for (int i = 0; i < btlist.length; i++) {
            button_id[i] = btres.getIdentifier(btlist[i], "id", getPackageName());
        }
		
//テキスト取得

		final TextView username1 = (TextView)findViewById(R.id.textView16);
		final TextView username2 = (TextView)findViewById(R.id.textView17);
		final TextView sorr1 = (TextView)findViewById(R.id.textView18);
		final TextView sorr2 = (TextView)findViewById(R.id.textView19);

//ボタン取得
		final Button bt[] = new Button[btlist.length];
		for(int i=0; i<btlist.length;i++){
			bt[i] = (Button)findViewById(button_id[i]);
		}
		
		
//tennis3 テキスト取得
		Intent intent = getIntent();
		String us1 = intent.getStringExtra("username1");
		String us2 = intent.getStringExtra("username2");
		String us3 = intent.getStringExtra("username3");
		String us4 = intent.getStringExtra("username4");
		String gametype = intent.getStringExtra("gametype");
		String server = intent.getStringExtra("server");

//ボタン初期設定
		changeButtonVisible("in");
		
		
		
//テキスト適用変換
		if(gametype.equals("Singles")){
				sorr1.setText("Server");
				sorr2.setText("Recever");
				
				if(server.equals(us1)){
					username1.setText(us1);
					username2.setText(us2);
					Rv.nnn = 1;
				}else if(server.equals(us2)){
					username1.setText(us2);
					username2.setText(us1);
					Rv.nnn = 2;
				}
			}else if(gametype.equals("Doubles")){
				sorr1.setText("Server");
				sorr2.setText("Recever");
				
				
				if(server.equals(us3)){
					username1.setText(us3);
					username2.setText(us4);
					Rv.nnn = 1;
				}else if(server.equals(us4)){
					username1.setText(us3);
					username2.setText(us4);
					Rv.nnn = 2;
				}
			}
		/*Intent it1 = new Intent();
		it1.setClass(tennis4.this, tennis5.class);
		if(gametype.equals("Singles")){
			it1.putExtra("username1",username1.getText());
			it1.putExtra("username2",username2.getText());
			
		}else if(gametype.equals("Doubles")){
			it1.putExtra("username1",username1.getText());
			it1.putExtra("username2",username2.getText());
		}
		int iiii = 0;
		iiii++;
		Log.v("miro", String.valueOf(iiii));*/
		
		
//ボタン処理

//player1 スコアー
		
	//button Return MIss 
		bt[3].setOnClickListener(this);
		bt[13].setOnClickListener(this);
	//button Service Ace	
		bt[6].setOnClickListener(this);
		bt[16].setOnClickListener(this);
	//button out
		bt[9].setOnClickListener(this);
		bt[19].setOnClickListener(this);
	//button Net
		bt[1].setOnClickListener(this);
		bt[11].setOnClickListener(this);
	//button service in
		bt[4].setOnClickListener(this);
		bt[14].setOnClickListener(this);
		
		
//player2 スコアー
	//button Return Ace
		bt[5].setOnClickListener(this);
		bt[15].setOnClickListener(this);
	//button out
		bt[8].setOnClickListener(this);
		bt[18].setOnClickListener(this);
	//button Net
		bt[0].setOnClickListener(this);	
		bt[10].setOnClickListener(this);
	//player1.fault and Double fault button
		bt[2].setOnClickListener(this);
		bt[12].setOnClickListener(this);
		
    //change court
		bt[7].setOnClickListener(this);
		
	}
	
	
//player score method
			
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub		
//array make
		Resources btres = getResources();
		String[] btlist = btres.getStringArray(R.array.btar);
		button_id = new int[btlist.length];
		for (int i = 0; i < btlist.length; i++) {
            button_id[i] = btres.getIdentifier(btlist[i], "id", getPackageName());
        }
		
		
		final TextView username1 = (TextView)findViewById(R.id.textView16);
		final TextView username2 = (TextView)findViewById(R.id.textView17);
//ボタン取得
		final Button bt[] = new Button[btlist.length];
		for(int i=0; i<btlist.length;i++){
			bt[i] = (Button)findViewById(button_id[i]);
		}
		bt[17].setVisibility(View.INVISIBLE);
//tennis3 テキスト取得
		Intent intent = getIntent();
		String us1 = intent.getStringExtra("username1");
		String us2 = intent.getStringExtra("username2");
		String us3 = intent.getStringExtra("username3");
		String us4 = intent.getStringExtra("username4");
		String gametype = intent.getStringExtra("gametype");
		String server = intent.getStringExtra("server");
		String setnumber = intent.getStringExtra("setnumber");
		String gamenumber = intent.getStringExtra("gamenumber");
		String deucenumber = intent.getStringExtra("deusenumber");
		String tibreaknumber = intent.getStringExtra("tibreaknumber");

//設定値
		int stn = Integer.valueOf(setnumber).intValue();
		
		/*if(v.getId() == button_id[2] && cot == 0 || v.getId() == button_id[12] && cot == 0 || v.getId() == button_id[7]){
			
		}else{
			sidechange++;
		}
		*/
		/*if((score1 + score2)%2 == 0){
			sidechange = 1;
		}else if((score1 + score2 )%2 == 1){
			sidechange = 0;
		}*/
		//method 振り分け
		//Result 振り分け
		Sidechange();
		if(isFore){
			Log.v("side","fore");
		}else if(!isFore){
			Log.v("side","back");
		}
	if(gametype.equals("Singles")){
			if(inOut == "in" && us1.equals(username1.getText())){
				if(v.getId() == button_id[4]){  //Server = us1
					Log.v(inOut,"in us1 servein");
					Resultpoint(0);
				}else if(v.getId() == button_id[2]){
					Log.v(inOut,"in us1 fault");
					Resultpoint(1);
				}
			}else if(inOut == "in" && us1.equals(username2.getText())){ //Server = username2
				if(v.getId() == button_id[4]){
					Log.v(inOut,"in us2 servein");
					Resultpoint(2);
				}else if(v.getId() == button_id[2]){
					Log.v(inOut,"in us2 fault");
					Resultpoint(3);
				}
			}else if(inOut == "in1" && us1.equals(username1.getText())){// Server = usrname2
				if(v.getId() == button_id[14]){
					Log.v(inOut,"in1 us2 servein");
					Resultpoint(2);
				}else if(v.getId() == button_id[12]){
					Log.v(inOut,"in1 us1 fault");
					Resultpoint(3);
				}
			}else if(inOut == "in1" && us1.equals(username2.getText())){  //Server = username1
				Log.v(inOut,"in1 us1 servein");
				if(v.getId() == button_id[14]){
					Resultpoint(0);
				}else if(v.getId() == button_id[12]){
					Log.v(inOut,"in1 us2 fault");
					Resultpoint(1);
				}
			}else if(inOut == "out" && us1.equals(username1.getText())){ //Server = username1
				Log.v(inOut,"out us1");
				if(v.getId() == button_id[8]){
					Resultpoint(5);
				}else if(v.getId() == button_id[0]){
					Resultpoint(6);
				}else if(v.getId() == button_id[5]){
					Resultpoint(7);
				}else if(v.getId() == button_id[3]){
					Resultpoint(8);
				}else if(v.getId() == button_id[9]){
					Resultpoint(9);
				}else if(v.getId() == button_id[1]){
					Resultpoint(10);
				}else if(v.getId() == button_id[6]){
					Resultpoint(4);
				}
			}else if(inOut == "out" && us1.equals(username2.getText())){ //Server = username2
				Log.v(inOut,"out us2");
				if(v.getId() == button_id[8]){
					Resultpoint(12);
				}else if(v.getId() == button_id[0]){
					Resultpoint(13);
				}else if(v.getId() == button_id[5]){
					Resultpoint(14);
				}else if(v.getId() == button_id[3]){
					Resultpoint(15);
				}else if(v.getId() == button_id[9]){
					Resultpoint(16);
				}else if(v.getId() == button_id[1]){
					Resultpoint(17);
				}else if(v.getId() == button_id[6]){
					Resultpoint(11);
				}
				
			}else if(inOut == "out1" && us1.equals(username1.getText())){ //Server = username2
				Log.v(inOut,"out1 us2");
				if(v.getId() == button_id[18]){
					Resultpoint(12);
				}else if(v.getId() == button_id[10]){
					Resultpoint(13);
				}else if(v.getId() == button_id[15]){
					Resultpoint(14);
				}else if(v.getId() == button_id[13]){
					Resultpoint(15);
				}else if(v.getId() == button_id[19]){
					Resultpoint(16);
				}else if(v.getId() == button_id[11]){
					Resultpoint(17);
				}else if(v.getId() == button_id[16]){
					Resultpoint(11);
				}
			}else if(inOut == "out1" && us1.equals(username2.getText())){ //Server = username1
				Log.v(inOut,"out1 us1");
				if(v.getId() == button_id[18]){
					Resultpoint(5);
				}else if(v.getId() == button_id[10]){
					Resultpoint(6);
				}else if(v.getId() == button_id[15]){
					Resultpoint(7);
				}else if(v.getId() == button_id[13]){
					Resultpoint(8);
				}else if(v.getId() == button_id[19]){
					Resultpoint(9);
				}else if(v.getId() == button_id[11]){
					Resultpoint(10);
				}else if(v.getId() == button_id[16]){
					Resultpoint(4);
				}
			}
		}else if(gametype.equals("Doubles")){
			if(inOut == "in" && us3.equals(username1.getText())){
				if(v.getId() == button_id[4]){  //Server = us3
					Log.v(inOut,"in us3 servein");
					Resultpoint(0);
				}else if(v.getId() == button_id[2]){
					Log.v(inOut,"in us3 fault");
					Resultpoint(1);
				}
			}else if(inOut == "in" && us3.equals(username2.getText())){ //Server = username2
				if(v.getId() == button_id[4]){
					Log.v(inOut,"in us2 servein");
					Resultpoint(2);
				}else if(v.getId() == button_id[2]){
					Log.v(inOut,"in us2 fault");
					Resultpoint(3);
				}
			}else if(inOut == "in1" && us3.equals(username1.getText())){// Server = usrname2
				if(v.getId() == button_id[14]){
					Log.v(inOut,"in1 us3 servein");
					Resultpoint(2);
				}else if(v.getId() == button_id[12]){
					Log.v(inOut,"in1 us3 fault");
					Resultpoint(3);
				}
			}else if(inOut == "in1" && us3.equals(username2.getText())){  //Server = username1
				Log.v(inOut,"in1 us2 servein");
				if(v.getId() == button_id[14]){
					Resultpoint(0);
				}else if(v.getId() == button_id[12]){
					Log.v(inOut,"in1 us2 fault");
					Resultpoint(1);
				}
			}else if(inOut == "out" && us3.equals(username1.getText())){ //Server = username1
				Log.v(inOut,"out us1");
				if(v.getId() == button_id[8]){
					Resultpoint(5);
				}else if(v.getId() == button_id[0]){
					Resultpoint(6);
				}else if(v.getId() == button_id[5]){
					Resultpoint(7);
				}else if(v.getId() == button_id[3]){
					Resultpoint(8);
				}else if(v.getId() == button_id[9]){
					Resultpoint(9);
				}else if(v.getId() == button_id[1]){
					Resultpoint(10);
				}else if(v.getId() == button_id[6]){
					Resultpoint(4);
				}
			}else if(inOut == "out" && us3.equals(username2.getText())){ //Server = username2
				Log.v(inOut,"out us2 ");
				if(v.getId() == button_id[8]){
					Resultpoint(12);
				}else if(v.getId() == button_id[0]){
					Resultpoint(13);
				}else if(v.getId() == button_id[5]){
					Resultpoint(14);
				}else if(v.getId() == button_id[3]){
					Resultpoint(15);
				}else if(v.getId() == button_id[9]){
					Resultpoint(16);
				}else if(v.getId() == button_id[1]){
					Resultpoint(17);
				}else if(v.getId() == button_id[6]){
					Resultpoint(11);
				}
				
			}else if(inOut == "out1" && us3.equals(username1.getText())){ //Server = username2
				Log.v(inOut,"out1 us2");
				if(v.getId() == button_id[18]){
					Resultpoint(12);
				}else if(v.getId() == button_id[10]){
					Resultpoint(13);
				}else if(v.getId() == button_id[15]){
					Resultpoint(14);
				}else if(v.getId() == button_id[13]){
					Resultpoint(15);
				}else if(v.getId() == button_id[19]){
					Resultpoint(16);
				}else if(v.getId() == button_id[11]){
					Resultpoint(17);
				}else if(v.getId() == button_id[16]){
					Resultpoint(11);
				}
			}else if(inOut == "out1" && us3.equals(username2.getText())){ //Server = username1
				Log.v(inOut,"out1 us1");
				if(v.getId() == button_id[18]){
					Resultpoint(5);
				}else if(v.getId() == button_id[10]){
					Resultpoint(6);
				}else if(v.getId() == button_id[15]){
					Resultpoint(7);
				}else if(v.getId() == button_id[13]){
					Resultpoint(8);
				}else if(v.getId() == button_id[19]){
					Resultpoint(9);
				}else if(v.getId() == button_id[11]){
					Resultpoint(10);
				}else if(v.getId() == button_id[16]){
					Resultpoint(4);
				}
			}
		
			
		}
	
//player2 score
		if(v.getId() == button_id[8] || v.getId() == button_id[0] || v.getId() == button_id[5] ){
			changeButtonVisible("in");
			inOut = "in";
			pointMethod(1);
			if(setcount2 >= stn){
				showAlert(username2.getText().toString());
			}
//player1 score
		}else if (v.getId()==button_id[3] || v.getId()==button_id[9] || v.getId()==button_id[1] || v.getId()==button_id[6]){
			changeButtonVisible("in");
			pointMethod(2);
			inOut = "in";
			if(setcount1 >= stn){
				this.showAlert(username1.getText().toString());
			}
			
			
		}else if(v.getId() == button_id[4]){
			clickMethod(3);
			changeButtonVisible("out");
			inOut = "out";
		}else if(v.getId() == button_id[2] ){
			clickMethod(4);
//fault
			
//終了method
			if(setcount2 == stn){
				this.showAlert(username2.getText().toString());
			}

			
	//After change button 
		}else if(v.getId()==button_id[13] || v.getId()==button_id[19] ||  v.getId()==button_id[11] || v.getId()==button_id[16] ){
			changeButtonVisible("in1");
			inOut = "in1";
			pointMethod(1);
			if(setcount2 >= stn){
				showAlert(username2.getText().toString());
			}
			
		}else if( v.getId()==button_id[18] ||  v.getId()==button_id[10] ||  v.getId()==button_id[15]  ){
			changeButtonVisible("in1");
			inOut = "in1";
			pointMethod(2);
			if(setcount1 >= stn){
				this.showAlert(username1.getText().toString());
			}
			
		}else if(v.getId()==button_id[14]){
			clickMethod(3);
			changeButtonVisible("out1");
			inOut = "out1";
			
		}else if(v.getId()==button_id[12]){
			clickMethod(7);
			//fault
						
			//終了method
						if(setcount1 >= stn){
							this.showAlert(username1.getText().toString());
						}
			
		}
		
	//change button
		else if(v.getId() == button_id[7]){
			change++;
			String ace = (String)String.valueOf(Rv.SerAce1);
			String net = (String)String.valueOf(Rv.nNet1);
			
    //値の交換
			clickMethod(5);	
	//player score 入力
			clickMethod(6);
	//Button change
			if(inOut == "in"){
				changeButtonVisible("in1");
				ChangeCort = 1;
				ChangeServer = 1;
				inOut = "in1";
			}else if(inOut == "in1"){
				changeButtonVisible("in");
				ChangeCort = 0;
				ChangeServer = 0;
				inOut = "in";
			}
			
		}
	}
	
//終了method make
	public void showAlert(String winner){
		final TextView username1 = (TextView)findViewById(R.id.textView16);
		final TextView username2 = (TextView)findViewById(R.id.textView17);
		AlertDialog.Builder ResultAlert =new AlertDialog.Builder(this);
		ResultAlert.setTitle("Winner");
		ResultAlert.setMessage(winner);
		ResultAlert.setPositiveButton("Result",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Intent intent = getIntent();
				String us1 = intent.getStringExtra("username1");
				String us2 = intent.getStringExtra("username2");
				String us3 = intent.getStringExtra("username3");
				String us4 = intent.getStringExtra("username4");
				String gametype = intent.getStringExtra("gametype");
				
				if(gametype.equals("Singles")){
					
					Intent intent1 = new Intent();
					intent1.putExtra("username1",us1);
					intent1.putExtra("username2",us2);
					intent1.setClass(tennis4.this, tennis5.class);
					startActivity(intent1);
				}else if(gametype.equals("Doubles")){
					Intent intent1 = new Intent();
					intent1.putExtra("username1",us3);
					intent1.putExtra("username2",us4);
					intent1.setClass(tennis4.this, tennis5.class);
					startActivity(intent1);
				}
				
			}
		} );
		ResultAlert.setCancelable(true);
		AlertDialog AlertResult = ResultAlert.create();
		AlertResult.show();
		}
	public void Sidechange(){
		//array make
				Resources btres = getResources();
				String[] btlist = btres.getStringArray(R.array.btar);
				button_id = new int[btlist.length];
				for (int i = 0; i < btlist.length; i++) {
		            button_id[i] = btres.getIdentifier(btlist[i], "id", getPackageName());
		        }
				
				final TextView gamescore1 =(TextView)findViewById(R.id.textView4);
				final TextView gamescore2 =(TextView)findViewById(R.id.textView3);
				final TextView gamecount1 =(TextView)findViewById(R.id.textView2);
				final TextView gamecount2 =(TextView)findViewById(R.id.textView1);
				final TextView setcounts1 =(TextView)findViewById(R.id.textView12);
				final TextView setcounts2 =(TextView)findViewById(R.id.textView11);
				final TextView username1 = (TextView)findViewById(R.id.textView16);
				final TextView username2 = (TextView)findViewById(R.id.textView17);
				final TextView sorr1 = (TextView)findViewById(R.id.textView18);
				final TextView sorr2 = (TextView)findViewById(R.id.textView19);
				final TextView point1 = (TextView)findViewById(R.id.textView7);
				final TextView point2 = (TextView)findViewById(R.id.textView8);
		//ボタン取得
				final Button bt[] = new Button[btlist.length];
				for(int i=0; i<btlist.length;i++){
					bt[i] = (Button)findViewById(button_id[i]);
				}
				
		//tennis3 テキスト取得
				Intent intent = getIntent();
				String us1 = intent.getStringExtra("username1");
				String us2 = intent.getStringExtra("username2");
				String us3 = intent.getStringExtra("username3");
				String us4 = intent.getStringExtra("username4");
				String gametype = intent.getStringExtra("gametype");
				String server = intent.getStringExtra("server");
				String setnumber = intent.getStringExtra("setnumber");
				String gamenumber = intent.getStringExtra("gamenumber");
				String deucenumber = intent.getStringExtra("deusenumber");
				String tibreaknumber = intent.getStringExtra("tibreaknumber");

		/*if(!isTibreak){
			if(gamescore1.getText() ==  gamescore2.getText() || gamescore1.getText() == "0" && gamescore2.getText() == "30"
					|| gamescore1.getText() == "30" && gamescore2.getText() == "0"
					|| gamescore1.getText() == "15" && gamescore2.getText() == "40"
					|| gamescore1.getText() == "40" && gamescore2.getText() == "15"
					){
				Log.v("sidchange", "fore");
				isFore = true;
			}else if(gamescore1.getText() == "15" && gamescore2.getText() == "0"
					|| gamescore1.getText() == "0" && gamescore2.getText() == "15"
					|| gamescore1.getText() == "15" && gamescore2.getText() == "30"
					|| gamescore1.getText() == "30" && gamescore2.getText() == "15"
					|| gamescore1.getText() == "40" && gamescore2.getText() == "30"
					|| gamescore1.getText() == "30" && gamescore2.getText() == "40"
					|| gamescore1.getText() == "Ad" && gamescore2.getText() == "Deuce"
					|| gamescore1.getText() == "Deuce" && gamescore2.getText() == "Ad"){
				isFore = false;
				Log.v("sidechange","back");
			}*/
		if(!isTibreak){
			if(gamescore1.getText().equals(gamescore2.getText()) || gamescore1.getText().equals("0") && gamescore2.getText().equals("30")
					|| gamescore1.getText().equals("30") && gamescore2.getText().equals("0")
					|| gamescore1.getText().equals("15") && gamescore2.getText().equals("40")
					|| gamescore1.getText().equals("40") && gamescore2.getText().equals("15")
					){
				Log.v("sidchange", "fore");
				isFore = true;
			}else /*if(gamescore1.getText() == "15" && gamescore2.getText() == "0"
					|| gamescore1.getText() == "0" && gamescore2.getText() == "15"
					|| gamescore1.getText() == "15" && gamescore2.getText() == "30"
					|| gamescore1.getText() == "30" && gamescore2.getText() == "15"
					|| gamescore1.getText() == "40" && gamescore2.getText() == "30"
					|| gamescore1.getText() == "30" && gamescore2.getText() == "40"
					|| gamescore1.getText() == "Ad" && gamescore2.getText() == "Deuce"
					|| gamescore1.getText() == "Deuce" && gamescore2.getText() == "Ad")*/{
				isFore = false;
				Log.v("sidechange","back");
			}
		}else if(isTibreak){
			String s1 = (String)gamescore1.getText();
			String s2 = (String)gamescore2.getText();
			int s11 = (int)Integer.valueOf(s1);
			int s22 = (int)Integer.valueOf(s2);
			if((s11 + s22)%2 == 0){
				isFore = true;
			}else{
				isFore = false;
			}
		}
				
	}
//click method
	public void clickMethod(int changenumber){
		//array make
				Resources btres = getResources();
				String[] btlist = btres.getStringArray(R.array.btar);
				button_id = new int[btlist.length];
				for (int i = 0; i < btlist.length; i++) {
		            button_id[i] = btres.getIdentifier(btlist[i], "id", getPackageName());
		        }
				
				final TextView gamescore1 =(TextView)findViewById(R.id.textView4);
				final TextView gamescore2 =(TextView)findViewById(R.id.textView3);
				final TextView gamecount1 =(TextView)findViewById(R.id.textView2);
				final TextView gamecount2 =(TextView)findViewById(R.id.textView1);
				final TextView setcounts1 =(TextView)findViewById(R.id.textView12);
				final TextView setcounts2 =(TextView)findViewById(R.id.textView11);
				final TextView username1 = (TextView)findViewById(R.id.textView16);
				final TextView username2 = (TextView)findViewById(R.id.textView17);
				final TextView sorr1 = (TextView)findViewById(R.id.textView18);
				final TextView sorr2 = (TextView)findViewById(R.id.textView19);
				final TextView point1 = (TextView)findViewById(R.id.textView7);
				final TextView point2 = (TextView)findViewById(R.id.textView8);
		//ボタン取得
				final Button bt[] = new Button[btlist.length];
				for(int i=0; i<btlist.length;i++){
					bt[i] = (Button)findViewById(button_id[i]);
				}
				
		//tennis3 テキスト取得
				Intent intent = getIntent();
				String us1 = intent.getStringExtra("username1");
				String us2 = intent.getStringExtra("username2");
				String us3 = intent.getStringExtra("username3");
				String us4 = intent.getStringExtra("username4");
				String gametype = intent.getStringExtra("gametype");
				String server = intent.getStringExtra("server");
				String setnumber = intent.getStringExtra("setnumber");
				String gamenumber = intent.getStringExtra("gamenumber");
				String deucenumber = intent.getStringExtra("deusenumber");
				String tibreaknumber = intent.getStringExtra("tibreaknumber");

		//設定値
				int gn = Integer.valueOf(gamenumber).intValue();
				int stn = Integer.valueOf(setnumber).intValue();
//method 振り分け
				
				
				
				//player2 score
				if(changenumber == 1){
					
//player1 score
				}else if(changenumber == 2){
					
				}else if(changenumber == 3){
					//service in
					
					cot = 0;
					
				}else if(changenumber == 4){
					//fault
					cot = cot + 1;
					if(cot == 1){
						
						bt[2].setText("Doublefault");
					}else if(cot == 2){
						bt[2].setText("fault");
						pointMethod(1);
						cot = 0;
					}
				}else if(changenumber == 7){
					//fault
					cot = cot + 1;
					if(cot == 1){
						
						bt[12].setText("Doublefault");
					}else if(cot == 2){
						bt[12].setText("fault");
						pointMethod(2);
						cot = 0;
					}
				}
				else if(changenumber == 5){
					
					//値の交換
					//score change
					s1 = score1;
					score1 = score2;
					score2 = s1;
					//gamecount change
					gs1 = count1;
					count1 = count2;
					count2 = gs1;
					//setcount change
					sc1 = setcount1;
					setcount1 = setcount2;
					setcount2 = sc1;
					String user1 = (String)username1.getText();
					String user2 = (String)username2.getText();
					
					if(gametype.equals("Singles")){
						if(us1.equals(user1)){
								username1.setText(us2);
								username2.setText(us1);
						}else if(us1.equals(user2)){
								username1.setText(us1);
								username2.setText(us2);
						}
					}else if(gametype.equals("Doubles")){
						if(us3.equals(user1)){
								username1.setText(us4);
								username2.setText(us3);
						}else if(us3.equals(user2)){
								username1.setText(us3);
								username2.setText(us4);	
						}
					}
					if(sorr1.getText() == "Server"){
						sorr1.setText("Recever");
						sorr2.setText("Server");
					}else if(sorr1.getText() == "Recever"){
						sorr1.setText("Server");
						sorr2.setText("Recever");
						
						
					}
					
				}else if(changenumber == 6){
			//player score 入力
					//player1
					sScore1 = String.valueOf(score1);
					scount1 = String.valueOf(count1);
					sSetcount1 = String.valueOf(setcount1);
					sScore2 = String.valueOf(score2);
					scount2 = String.valueOf(count2);
					sSetcount2 = String.valueOf(setcount2);
			//player1
					if(!isTibreak){
						
						if(score1 == 1){
							gamescore1.setText("15");
						}else if(score1 == 0){
							gamescore1.setText("0");
						}else if(score1 == 2){
							gamescore1.setText("30");
						}else if(score1 == 3 && score2 <3){
							gamescore1.setText("40");
						}
						else if(score1 == 3 && score2 == 3 && deucenumber.equals("有")){
							gamescore1.setText("Deuce");
							gamescore2.setText("Deuce");
						}else if(score1 == 4 && score2 == 3 && deucenumber.equals("有")){
							gamescore1.setText("Ad");
							gamescore2.setText("Deuce");
				//player2
						}
						if(score2 == 1){
							gamescore2.setText("15");
						}else if(score2 == 0){
							gamescore2.setText("0");
						}else if(score2 == 2){
							gamescore2.setText("30");
						}else if(score2 == 4 && score1 == 3 && deucenumber.equals("有")){
							gamescore2.setText("Ad");
							gamescore1.setText("Deuce");
						}else if(score2 == 3 && score1 <3){
							gamescore2.setText("40");
						}else if(score1 == 3 && score2 == 3&& deucenumber.equals("無")){
							gamescore1.setText("40");
							gamescore2.setText("40");
						}
					}
					if(isTibreak){
						gamescore1.setText(sScore1);
						gamescore2.setText(sScore2);
					}
					
					gamecount1.setText(scount1);
					gamecount2.setText(scount2);
					setcounts1.setText(sSetcount1);
					setcounts2.setText(sSetcount2);
				
				}
	}
	public void changeButtonVisible(String inOut){

		//array 取得
				Resources btres = getResources();
				String[] btlist = btres.getStringArray(R.array.btar);
				button_id = new int[btlist.length];
				for (int i = 0; i < btlist.length; i++) {
		            button_id[i] = btres.getIdentifier(btlist[i], "id", getPackageName());
		        }
				
		//ボタン取得
				final Button bt[] = new Button[btlist.length];
				for(int i=0; i<btlist.length;i++){
					bt[i] = (Button)findViewById(button_id[i]);
				}
				
				if(inOut == "in"){//left server service
					bt[0].setVisibility(View.INVISIBLE);
					bt[1].setVisibility(View.INVISIBLE);
					bt[2].setVisibility(View.VISIBLE);
					bt[3].setVisibility(View.INVISIBLE);
					bt[4].setVisibility(View.VISIBLE);
					bt[5].setVisibility(View.INVISIBLE);
					bt[6].setVisibility(View.INVISIBLE);
					bt[7].setVisibility(View.VISIBLE);
					bt[8].setVisibility(View.INVISIBLE);
					bt[9].setVisibility(View.INVISIBLE);
					for(int i = 10;i<17;i++){
						bt[i].setVisibility(View.INVISIBLE);
					}
					bt[18].setVisibility(View.INVISIBLE);
					bt[19].setVisibility(View.INVISIBLE);
					bt[17].setVisibility(View.INVISIBLE);
				}else if(inOut == "out"){ //left server service in
					bt[2].setText("fault");
					bt[7].setVisibility(View.INVISIBLE);
					bt[4].setVisibility(View.INVISIBLE);
					bt[2].setVisibility(View.INVISIBLE);
					bt[0].setVisibility(View.VISIBLE);
					bt[1].setVisibility(View.VISIBLE);
					bt[3].setVisibility(View.VISIBLE);
					bt[5].setVisibility(View.VISIBLE);
					bt[6].setVisibility(View.VISIBLE);
					bt[8].setVisibility(View.VISIBLE);
					bt[9].setVisibility(View.VISIBLE);	
					for(int i = 10;i<17;i++){
						bt[i].setVisibility(View.INVISIBLE);
					}
					bt[18].setVisibility(View.INVISIBLE);
					bt[19].setVisibility(View.INVISIBLE);
				}else if(inOut == "in1"){//Right server service
					for(int i=0;i<10;i++){
						bt[i].setVisibility(View.INVISIBLE);
					}
					bt[7].setVisibility(View.VISIBLE);
					bt[10].setVisibility(View.INVISIBLE);
					bt[11].setVisibility(View.INVISIBLE);
					bt[12].setVisibility(View.VISIBLE);
					bt[13].setVisibility(View.INVISIBLE);
					bt[14].setVisibility(View.VISIBLE);
					bt[15].setVisibility(View.INVISIBLE);
					bt[16].setVisibility(View.INVISIBLE);
					bt[18].setVisibility(View.INVISIBLE);
					bt[19].setVisibility(View.INVISIBLE);	
				}else if(inOut == "out1"){//Right server service in
					for(int i=0;i<10;i++){
						bt[i].setVisibility(View.INVISIBLE);
					}
					bt[12].setText("fault");
					bt[14].setVisibility(View.INVISIBLE);
					bt[12].setVisibility(View.INVISIBLE);
					bt[10].setVisibility(View.VISIBLE);
					bt[11].setVisibility(View.VISIBLE);
					bt[13].setVisibility(View.VISIBLE);
					bt[15].setVisibility(View.VISIBLE);
					bt[16].setVisibility(View.VISIBLE);
					bt[18].setVisibility(View.VISIBLE);
					bt[19].setVisibility(View.VISIBLE);	
				}
		
	}
	public void pointMethod(int playernumber){
		//array make
		Resources btres = getResources();
		String[] btlist = btres.getStringArray(R.array.btar);
		button_id = new int[btlist.length];
		for (int i = 0; i < btlist.length; i++) {
            button_id[i] = btres.getIdentifier(btlist[i], "id", getPackageName());
        }
		
		final TextView gamescore1 =(TextView)findViewById(R.id.textView4);
		final TextView gamescore2 =(TextView)findViewById(R.id.textView3);
		final TextView gamecount1 =(TextView)findViewById(R.id.textView2);
		final TextView gamecount2 =(TextView)findViewById(R.id.textView1);
		final TextView setcounts1 =(TextView)findViewById(R.id.textView12);
		final TextView setcounts2 =(TextView)findViewById(R.id.textView11);
		final TextView username1 = (TextView)findViewById(R.id.textView16);
		final TextView username2 = (TextView)findViewById(R.id.textView17);
		final TextView sorr1 = (TextView)findViewById(R.id.textView18);
		final TextView sorr2 = (TextView)findViewById(R.id.textView19);
		final TextView point1 = (TextView)findViewById(R.id.textView7);
		final TextView point2 = (TextView)findViewById(R.id.textView8);
//ボタン取得
		final Button bt[] = new Button[btlist.length];
		for(int i=0; i<btlist.length;i++){
			bt[i] = (Button)findViewById(button_id[i]);
		}
		
//tennis3 テキスト取得
		Intent intent = getIntent();
		String us1 = intent.getStringExtra("username1");
		String us2 = intent.getStringExtra("username2");
		String us3 = intent.getStringExtra("username3");
		String us4 = intent.getStringExtra("username4");
		String gametype = intent.getStringExtra("gametype");
		String server = intent.getStringExtra("server");
		String setnumber = intent.getStringExtra("setnumber");
		String gamenumber = intent.getStringExtra("gamenumber");
		String deucenumber = intent.getStringExtra("deusenumber");
		String tibreaknumber = intent.getStringExtra("tibreaknumber");

//設定値
		int gn = Integer.valueOf(gamenumber).intValue();
		int stn = Integer.valueOf(setnumber).intValue();
//右側の入力
		if(playernumber == 1){
			if(!isTibreak){
				score2++;
				if(score2 == 1){
					gamescore2.setText("15");
				}else if(score2 == 2){
					gamescore2.setText("30");
				}else if(score2 == 3 && score1 <3){
					gamescore2.setText("40");
//Deuce処理					
				}else if(score1 == 3 && score2 ==3 && deucenumber.equals("有")){
						gamescore1.setText("Deuce");
						gamescore2.setText("Deuce");
				}else if(score2 == 4 && score1 == 3 && deucenumber.equals("有")){
						gamescore2.setText("Ad");
				}else if(score1 == 4 && score2 == 4 && deucenumber.equals("有")){
						gamescore1.setText("Deuce");
						gamescore2.setText("Deuce");
						score1 = 3;
						score2 = 3;
					
				}else if(score2 == 3 && score1 == 3 && deucenumber.equals("無")){
						gamescore1.setText("40");
						gamescore2.setText("40");
//gamecount処理					
				}else if(score2 == 5 && score1 == 3 && deucenumber.equals("有") ||
						score2 == 4 && score1 < 3 ||
						score2 == 4 && deucenumber.equals("無")){
					count2 ++;
					score1 = 0;
					score2 = 0;
					gamescore1.setText("0");
					gamescore2.setText("0");	
			//change Server		
					if(ChangeServer == 0){
						changeButtonVisible("in1");
						ChangeServer = 1;
						ChangeCort = 1;
						sorr1.setText("Recever");
						sorr2.setText("Server");
						inOut = "in1";
					}else if(ChangeServer == 1){
						changeButtonVisible("in");
						ChangeServer = 0;
						ChangeCort = 0;
						sorr1.setText("Server");
						sorr2.setText("Recever");
						inOut = "in";
					}
					String s = String.valueOf(ChangeServer);
//tiebreak　無
					if(tibreaknumber.equals("無")){
						if(count2 < gn){
							scount2 = String.valueOf(count2);
							gamecount2.setText(scount2);
						}else if(count2 == gn){
							count1 = 0;
							count2 = 0;
							setcount2 = setcount2 + 1;
							sSetcount2 = String.valueOf(setcount2);
							scount1 = String.valueOf(count1);
							scount2 = String.valueOf(count2);
							setcounts2.setText(sSetcount2);
							gamecount1.setText(scount1);
							gamecount2.setText(scount2);
						}
//tiebreak 有
					}else{
						if(count2 == gn && count1 <(gn-1) || count2 == (gn+1) && count1 == (gn-1)){
							count1 = 0;
							count2 = 0;
							setcount2 ++;
							sSetcount2 = String.valueOf(setcount2);
							scount1 = String.valueOf(count1);
							scount2 = String.valueOf(count2);
							setcounts2.setText(sSetcount2);
							gamecount1.setText(scount1);
							gamecount2.setText(scount2);
						}else if(count1 == gn && count2 == gn){
//tiebreak on
							isTibreak = true;
							point1.setText("Tiebreak");
							point2.setText("Tiebreak");
							gamecount1.setText(gamenumber);
							gamecount2.setText(gamenumber);
							
						}else if(count2 <= gn){
							
							scount2 = String.valueOf(count2);
							gamecount2.setText(scount2);
						}
					}
				}
			
//tiebreak count
			}else if(isTibreak){
				score2 ++;
				int tbn = Integer.valueOf(tibreaknumber).intValue();
				sScore2 = String.valueOf(score2);
				gamescore2.setText(sScore2);
				
				if(sorr1.getText().equals("Server")){
					if((score1 + score2)%2 == 1){
						changeButtonVisible("in1");
						sorr1.setText("Recever");
						sorr2.setText("Server");
							
					}
				}else if(sorr2.getText().equals("Recever")){
					if((score1 + score2)%2 == 1){
						changeButtonVisible("in");
						sorr1.setText("Server");
						sorr2.setText("Recever");
					}
				}
				if(score2 >= tbn && (score2 - score1) >= 2){
					
					count1 = 0;
					count2 = 0;
					setcount2++;
					scount1 = String.valueOf(count1);
					scount2 = String.valueOf(count2);
					sSetcount2 = String.valueOf(setcount2);
					setcounts1.setText(sSetcount2);
					gamecount1.setText(scount1);
					gamecount2.setText(scount2);
					gamescore1.setText("0");
					gamescore2.setText("0");
					score1 = 0;
					score2 = 0;
					isTibreak = false;
				}
			}
		}else if(playernumber == 2){
//左側の入力
				if(!isTibreak){
					score1 = score1 + 1;
					if(score1 == 1){
						gamescore1.setText("15");
					}else if(score1 == 2){
						gamescore1.setText("30");
					}else if(score1 == 3 && score2 <3){
						gamescore1.setText("40");
	//Deuce処理		
					}else if(score1 == 3 && score2 == 3 && deucenumber.equals("有")){
							gamescore1.setText("Deuce");
							gamescore2.setText("Deuce");
					}else if(score1 == 4 && score2 == 3 && deucenumber.equals("有")){
							gamescore1.setText("Ad");
					}else if(score1 == 4 && score2 == 4 && deucenumber.equals("有")){
							gamescore1.setText("Deuce");
							gamescore2.setText("Deuce");
							score1 = 3;
							score2 = 3;
					}else if(score2 == 3 && score1 == 3 && deucenumber.equals("無")){
							gamescore1.setText("40");
							gamescore2.setText("40");
	//gamecount処理		
					}else if(score1 == 5 && score2 == 3 && deucenumber.equals("有") ||
							score1 == 4 && score2 < 3 ||
							score1 == 4 && deucenumber.equals("無")){
						count1 = count1 + 1;
						score1 = 0;
						score2 = 0;
						gamescore1.setText("0");
						gamescore2.setText("0");
			//change Server
						if(ChangeServer == 0/* && ChangeCort == 0 || ChangeServer == 1 && ChangeCort == 1*/){
							changeButtonVisible("in1");
							ChangeServer = 1;
							ChangeCort = 1;
							sorr1.setText("Recever");
							sorr2.setText("Server");
							inOut = "in1";
							
						}else if(ChangeServer == 1/* && ChangeCort == 0 || ChangeServer == 0 && ChangeCort == 1*/){
							changeButtonVisible("in");
							ChangeServer = 0;
							ChangeCort = 0;
							sorr1.setText("Server");
							sorr2.setText("Recever");
							inOut = "in";
						}
	//tiebreak 無
						if(tibreaknumber.equals("無")){
							if(count1 < gn){
								scount1 = String.valueOf(count1);
								gamecount1.setText(scount1);
							}else if(count1 == gn){
								count1 = 0;
								count2 = 0;
								setcount1 = setcount1 + 1;
								sSetcount1 = String.valueOf(setcount1);
								scount1 = String.valueOf(count1);
								scount2 = String.valueOf(count2);
								setcounts1.setText(sSetcount1);
								gamecount1.setText(scount1);
								gamecount2.setText(scount2);
							}
							
						}else{
							
							if(count1 == gn && count2 <(gn-1) || count1 == (gn+1) && count2 ==(gn-1)){
								count1 = 0;
								count2 = 0;
								setcount1 = setcount1 + 1;
								scount1 = String.valueOf(count1);
								scount2 = String.valueOf(count2);
								sSetcount1 = String.valueOf(setcount1);
								setcounts1.setText(sSetcount1);
								gamecount1.setText(scount1);
								gamecount2.setText(scount2);
							}else if(count1 == gn && count2 == gn){
								
	//tiebreak on
								isTibreak = true;
								point1.setText("Tiebreak");
								point2.setText("Tiebreak");
								gamecount1.setText(gamenumber);
								gamecount2.setText(gamenumber);
								
							}else if(count1 <= gn){
								scount1 = String.valueOf(count1);
								gamecount1.setText(scount1);
							}
						}
					}
	//tiebrak count
				}else if(isTibreak){
					score1 = score1 + 1;
					if(sorr1.getText().equals("Server")){
						if((score1 + score2)%2 == 1){
							changeButtonVisible("in1");
							sorr1.setText("Recever");
							sorr2.setText("Server");
						}
					}else if(sorr2.getText().equals("Recever")){
						if((score1 + score2)%2 == 1){
							changeButtonVisible("in");
							sorr1.setText("Server");
							sorr2.setText("Recever");
						}
					}
					
					int tbn = Integer.valueOf(tibreaknumber).intValue();
					if(score1 >= tbn && (score1 - score2) >= 2){
						count1 = 0;
						count2 = 0;
						setcount1 = setcount1 + 1;
						scount1 = String.valueOf(count1);
						scount2 = String.valueOf(count2);
						sSetcount1 = String.valueOf(setcount1);
						setcounts1.setText(sSetcount1);
						gamecount1.setText(scount1);
						gamecount2.setText(scount2);
						gamescore1.setText("0");
						gamescore2.setText("0");
						score1 = 0;
						score2 = 0;
						isTibreak = false;
					}
					sScore1 = String.valueOf(score1);
					gamescore1.setText(sScore1);
					//return;
				}
	//終了method
		}
	}
	public void Resultpoint(int us){
		
		//array make
				Resources btres = getResources();
				String[] btlist = btres.getStringArray(R.array.btar);
				button_id = new int[btlist.length];
				for (int i = 0; i < btlist.length; i++) {
		            button_id[i] = btres.getIdentifier(btlist[i], "id", getPackageName());
		        }
				
				
				final TextView username1 = (TextView)findViewById(R.id.textView16);
				final TextView username2 = (TextView)findViewById(R.id.textView17);
		//ボタン取得
				final Button bt[] = new Button[btlist.length];
				for(int i=0; i<btlist.length;i++){
					bt[i] = (Button)findViewById(button_id[i]);
				}
				bt[17].setVisibility(View.INVISIBLE);
		//tennis3 テキスト取得
				Intent intent = getIntent();
				String us1 = intent.getStringExtra("username1");
				String us2 = intent.getStringExtra("username2");
				String us3 = intent.getStringExtra("username3");
				String us4 = intent.getStringExtra("username4");
				String gametype = intent.getStringExtra("gametype");
				String server = intent.getStringExtra("server");
				String setnumber = intent.getStringExtra("setnumber");
				String gamenumber = intent.getStringExtra("gamenumber");
				String deucenumber = intent.getStringExtra("deusenumber");
				String tibreaknumber = intent.getStringExtra("tibreaknumber");
				
		if(us == 0){    //server == us1 and serve in
			Rv.SerAll1++; 
			Rv.serin1++;
			if(isFore){  //foreside
				Rv.Fserin1++;
				Rv.fSerAll1++;
				Rv.fnReturn2++;
				Rv.nReturn2++;
				if(cot == 0){
					Rv.fserin1++;
					Rv.ffserin1++;
					Rv.ffSerAll1++;
				}else if(cot == 1){
					Rv.dserin1++;
					Rv.fdserin1++;
					Rv.fdSerAll1++;
				}
			}else if(!isFore){
				Rv.Bserin1++;
				Rv.bSerAll1++;
				Rv.bnReturn2++;
				Rv.nReturn2++;
				if(cot == 0){
					Rv.fserin1++;
					Rv.bfserin1++;
					Rv.bfSerAll1++;
				}else if(cot == 1){
					Rv.dserin1++;
					Rv.bdserin1++;
					Rv.bdSerAll1++;
				}
			}
		}else if(us == 1){   //server == us1 and fault
			Rv.SerAll1++;
			if(isFore){//forside
				Rv.fSerAll1++;
				if(cot == 0){
					Rv.ffSerAll1++;
					Rv.fFfault1++;
				}else if(cot == 1){
					Rv.fdSerAll1++;
					Rv.fDfault1++;
					Rv.fnPoint2++;
					Rv.nPoint2++;
				}
			}else if(!isFore){                 //backside 
				Rv.bSerAll1++;
				if(cot == 0){
					Rv.bfSerAll1++;
					Rv.bFfault1++;
				}else if(cot == 1){
					Rv.bdSerAll1++;
					Rv.nPoint2++;
					Rv.bDbault1++;
					Rv.bnPoint2++;
				}
			}
			}else if(us == 2){ //server == us2 and serve in
				Rv.SerAll2++; 
				Rv.serin2++;
				if(isFore){  //foreside
					Rv.Fserin2++;
					Rv.fSerAll2++;
					Rv.fnReturn1++;
					Rv.nReturn1++;
					if(cot == 0){
						Rv.fserin2++;
						Rv.ffserin2++;
						Rv.ffSerAll2++;
					}else if(cot == 1){
						Rv.dserin2++;
						Rv.fdserin2++;
						Rv.fdSerAll2++;
					}
				}else if(!isFore){
					Rv.Bserin2++;
					Rv.bSerAll2++;
					Rv.bnReturn1++;
					Rv.nReturn1++;
					if(cot == 0){
						Rv.fserin2++;
						Rv.bfserin2++;
						Rv.bfSerAll2++;
					}else if(cot == 1){
						Rv.dserin2++;
						Rv.bdserin2++;
						Rv.bdSerAll2++;
					}
				}
			}else if(us == 3){   //serve == us2 and fault
				Rv.SerAll2++;
				if(isFore){//forside
					Rv.fSerAll2++;
					if(cot == 0){
						Rv.ffSerAll2++;
						Rv.fFfault2++;
					}else if(cot == 1){
						Rv.fdSerAll2++;
						Rv.fDfault2++;
						Rv.fnPoint1++;
						Rv.nPoint1++;
					}
				}else if(!isFore){                 //backside 
					Rv.bSerAll2++;
					if(cot == 0){
						Rv.bfSerAll2++;
						Rv.bFfault2++;
					}else if(cot == 1){
						Rv.bdSerAll2++;
						Rv.nPoint1++;
						Rv.bDbault2++;
						Rv.bnPoint1++;
					}
				}
				
			}else if(us == 4){   //serve == us1 and service ace
				Rv.SerAce1++;
				Rv.nPoint1++;
				if(isFore){
					Rv.fnPoint1++;
					Rv.fSerAce1++;
				}else if(!isFore){
					Rv.bnPoint1++;
					Rv.bSerAce1++;
				}
			}else if(us ==  5){ //serve = us1 and out
				Rv.nPoint2++;
				Rv.nOut1++;
				if(isFore){
					Rv.fnPoint2++;
					Rv.fnOut1++;
				}else if(!isFore){
					Rv.bnPoint2++;
					Rv.bnOut1++;
				}
			}else if(us == 6){    //serve = us1 and net
				Rv.nNet1++;
				Rv.nPoint2++;
				if(isFore){
					Rv.fnPoint2++;
					Rv.fnNet1++;
				}else if(!isFore){
					Rv.bnPoint2++;
					Rv.bnNet1++;
				}
			}else if(us == 7 ){   //return = us2 and return ace
				Rv.Race2++;
				Rv.nPoint2++;
				if(isFore){
					Rv.fnPoint2++;
					Rv.fRace2++;
				}else if(!isFore){
					Rv.bnPoint2++;
					Rv.bRace2++;
				}
			}else if(us == 8){    //return = us2 and return miss
				Rv.Rmiss2++;
				Rv.nPoint1++;
				if(isFore){
					Rv.fnPoint1++;
					Rv.fRmiss2++;
				}else if(!isFore){
					Rv.bnPoint1++;
					Rv.bRmiss2++;
				}
			}else if(us == 9){    //return = us2 and out
				Rv.nOut2++;
				Rv.nPoint1++;
				if(isFore){
					Rv.fnPoint1++;
					Rv.fnOut2++;
				}else if(!isFore){
					Rv.bnPoint1++;
					Rv.bnOut2++;
				}
			}else if(us == 10){   //return = us2 and net
				Rv.nNet2++;
				Rv.nPoint1++;
				if(isFore){
					Rv.fnPoint1++;
					Rv.fnNet2++;
				}else if(!isFore){
					Rv.bnPoint1++;
					Rv.bnNet2++;
				}
			}else if(us == 11){   //serve == us2 and service ace
				Rv.SerAce2++;
				Rv.nPoint2++;
				if(isFore){
					Rv.fnPoint2++;
					Rv.fSerAce2++;
				}else if(!isFore){
					Rv.bnPoint2++;
					Rv.bSerAce2++;
				}
			}else if(us ==  12){   //serve = us2 and out
				Rv.nOut2++;
				Rv.nPoint1++;
				if(isFore){
					Rv.fnPoint1++;
					Rv.fnOut2++;
				}else if(!isFore){
					Rv.bnPoint1++;
					Rv.bnOut2++;
				}
			}else if(us == 13){    //serve = us2 and net
				Rv.nNet2++;
				Rv.nPoint1++;
				if(isFore){
					Rv.fnPoint1++;
					Rv.fnNet2++;
				}else if(!isFore){
					Rv.bnPoint1++;
					Rv.bnNet2++;
				}
				
			}else if(us == 14){   //return = us1 and return ace
				Rv.Race1++;
				Rv.nPoint1++;
				if(isFore){
					Rv.fnPoint1++;
					Rv.fRace1++;
				}else if(!isFore){
					Rv.bnPoint1++;
					Rv.bRace1++;
				}
			}else if(us == 15){    //return = us1 and return miss
				Rv.Rmiss1++;
				Rv.nPoint2++;
				if(isFore){
					Rv.fnPoint2++;
					Rv.fRmiss1++;
				}else if(!isFore){
					Rv.bnPoint2++;
					Rv.bRmiss1++;
				}
			}else if(us == 16){    //return = us1 and out
				Rv.nOut1++;
				Rv.nPoint2++;
				if(isFore){
					Rv.fnPoint2++;
					Rv.fnOut1++;
				}else if(!isFore){
					Rv.bnPoint2++;
					Rv.bnOut1++;
				}
			}else if(us == 17){   //return = us1 and net
				Rv.nNet1++;
				Rv.nPoint2++;
				if(isFore){
					Rv.fnPoint2++;
					Rv.fnNet1++;
				}else if(!isFore){
					Rv.bnPoint2++;
					Rv.bnNet1++;
				}
			}
	}
}











