package com.example.tennisscore2;

import java.math.BigDecimal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

	public class tennis5 extends Activity {
		Resultvalue Rv;
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.tennis5);
			Rv = (Resultvalue)this.getApplication();
			
			
			
			
			/* (Rv.nnn == 1){
				
			}else if(Rv.nnn == 2){
				us2 = it1.getStringExtra("username1");
				us1 = it1.getStringExtra("username2");
			}
			*/
			
			
			//player1
			TextView username1 =(TextView)findViewById(R.id.textView2);
			TextView fFirst1 =(TextView)findViewById(R.id.textView8);
			TextView bFirst1 =(TextView)findViewById(R.id.textView9);
			TextView fSecond1 =(TextView)findViewById(R.id.textView11);
			TextView bSecond1 =(TextView)findViewById(R.id.textView12);
			TextView fSerAce1 =(TextView)findViewById(R.id.textView14);
			TextView bSerAce1 =(TextView)findViewById(R.id.textView15);
			TextView fDf1 =(TextView)findViewById(R.id.textView17);
			TextView bDf1 =(TextView)findViewById(R.id.textView18);
			TextView pointall1 =(TextView)findViewById(R.id.textView20);
			TextView fpoint1 =(TextView)findViewById(R.id.textView23);
			TextView bpoint1 =(TextView)findViewById(R.id.textView24);
			TextView fRace1 =(TextView)findViewById(R.id.textView26);
			TextView bRace1=(TextView)findViewById(R.id.textView27);
			TextView fRmiss1 =(TextView)findViewById(R.id.textView29);
			TextView bRmiss1 =(TextView)findViewById(R.id.textView30);
			TextView fout1 =(TextView)findViewById(R.id.textView32);
			TextView bout1 =(TextView)findViewById(R.id.textView33);
			TextView fnet1 =(TextView)findViewById(R.id.textView35);
			TextView bnet1 =(TextView)findViewById(R.id.textView36);
			
			//player2
			TextView username2 =(TextView)findViewById(R.id.textView37);
			TextView fFirst2 =(TextView)findViewById(R.id.textView42);
			TextView bFirst2 =(TextView)findViewById(R.id.textView43);
			TextView fSecond2 =(TextView)findViewById(R.id.textView45);
			TextView bSecond2 =(TextView)findViewById(R.id.textView46);
			TextView fSerAce2 =(TextView)findViewById(R.id.textView48);
			TextView bSerAce2 =(TextView)findViewById(R.id.textView49);
			TextView fDf2 =(TextView)findViewById(R.id.textView51);
			TextView bDf2 =(TextView)findViewById(R.id.textView52);
			TextView pointall2 =(TextView)findViewById(R.id.textView54);
			TextView fpoint2 =(TextView)findViewById(R.id.textView56);
			TextView bpoint2 =(TextView)findViewById(R.id.textView57);
			TextView fRace2 =(TextView)findViewById(R.id.textView59);
			TextView bRace2=(TextView)findViewById(R.id.textView60);
			TextView fRmiss2 =(TextView)findViewById(R.id.textView62);
			TextView bRmiss2 =(TextView)findViewById(R.id.textView63);
			TextView fout2 =(TextView)findViewById(R.id.textView65);
			TextView bout2 =(TextView)findViewById(R.id.textView66);
			TextView fnet2 =(TextView)findViewById(R.id.textView68);
			TextView bnet2 =(TextView)findViewById(R.id.textView69);
			
			
			String us1 = null,us2 = null;
			
			Intent intent1 = getIntent();
			us1 = intent1.getStringExtra("username1");
			us2 = intent1.getStringExtra("username2");
			/*Intent it2 = getIntent();
			String gametype = it2.getStringExtra("gametype");
			String Server = it2.getStringExtra("server");
			if(gametype.equals("Singles")){
				us1 = it2.getStringExtra("username1");
				us2 = it2.getStringExtra("username2");
				
			}else if(gametype.equals("Doubles")){
				us1 = it2.getStringExtra("username3");
				us2 = it2.getStringExtra("username4");
			}
			
			if(gametype.equals("Singles")){
				if(Server.equals(us1)){
					username1.setText(us1);
					username2.setText(us2);
				}else if(Server.equals(us2)){
					username1.setText(us2);
					username2.setText(us1);
				}
			}else if(gametype.equals("Doubles")){
				if(Server.equals(us1)){
					username1.setText(us1);
					username2.setText(us2);
				}else if(Server.equals(us2)){
					username1.setText(us2);
					username2.setText(us1);
				}
			}*/
			
		/*	float ffirst1 = (float)Rv.ffSerAll1/(Rv.ffSerAll1 + Rv.fFfault1);
			float bfirst1 = (float)Rv.bfSerAll1/(Rv.bfSerAll1 + Rv.bFfault1);
			float fsecond1 = (float)Rv.fdSerAll1/(Rv.fdSerAll1 + Rv.fDfault1);
			float bsecond1 = (float)Rv.bdSerAll1/(Rv.bdSerAll1 + Rv.bDbault1);
			float fserace1 = (float)Rv.fSerAce1/Rv.fSerAll1;
			float bserace1 = (float)Rv.bSerAce1/Rv.bSerAll1;
			float frace1 = (float)Rv.fRace1/Rv.fnReturn1;
			float brace1 = (float)Rv.bRace1/Rv.bnReturn1;
			float frmiss1 = (float)Rv.fRmiss1/Rv.fnReturn1;
			float brmiss1 = (float)Rv.bRmiss1/Rv.bnReturn1;
			
			String sffirst1 = Float.toString(ffirst1);
			String sbfirst1 = Float.toString(bfirst1);
			String sfsecond1 = Float.toString(fsecond1);
			String sbsecond1 = Float.toString(bsecond1);
			String sfserace1 = Float.toString(fserace1);
			String sbserace1 = Float.toString(bserace1);
			String sfrace1 = Float.toString(frace1);
			String sbrace1 = Float.toString(brace1);
			String sfrmiss1 = Float.toString(frmiss1);
			String sbrmiss1 = Float.toString(brmiss1);
			
			
			
			
			
			float ffirst2 = (float)Rv.ffSerAll2/(Rv.ffSerAll2 + Rv.fFfault2);
			float bfirst2 = (float)Rv.bfSerAll2/(Rv.bfSerAll2 + Rv.bFfault2);
			float fsecond2 = (float)Rv.fdSerAll2/(Rv.fdSerAll2 + Rv.fDfault2);
			float bsecond2 = (float)Rv.bdSerAll2/(Rv.bdSerAll2 + Rv.bDbault2);
			float fserace2 = (float)Rv.fSerAce2/Rv.fSerAll2;
			float bserace2 = (float)Rv.bSerAce2/Rv.bSerAll2;
			float frace2 = (float)Rv.fRace2/Rv.fnReturn2;
			float brace2 = (float)Rv.bRace2/Rv.bnReturn2;
			float frmiss2 = (float)Rv.fRmiss2/Rv.fnReturn2;
			float brmiss2 = (float)Rv.bRmiss2/Rv.bnReturn2;
			
			String sffirst2 = Float.toString(ffirst2);
			String sbfirst2 = Float.toString(bfirst2);
			String sfsecond2 = Float.toString(fsecond2);
			String sbsecond2 = Float.toString(bsecond2);
			String sfserace2 = Float.toString(fserace2);
			String sbserace2 = Float.toString(bserace2);
			String sfrace2 = Float.toString(frace2);
			String sbrace2 = Float.toString(brace2);
			String sfrmiss2 = Float.toString(frmiss2);
			String sbrmiss2 = Float.toString(brmiss2);
			
			

			float ffirst2 = (float)Rv.ffSerAll2/(Rv.ffSerAll2 + Rv.fFfault2);
			float bfirst2 = (float)Rv.bfSerAll2/(Rv.bfSerAll2 + Rv.bFfault2);
			float fsecond2 = (float)Rv.fdSerAll2/(Rv.fdSerAll2 + Rv.fDfault2);
			float bsecond2 = (float)Rv.bdSerAll2/(Rv.bdSerAll2 + Rv.bDbault2);
			float fserace2 = (float)Rv.fSerAce2/Rv.fSerAll2;
			float bserace2 = (float)Rv.bSerAce2/Rv.bSerAll2;
			float frace2 = (float)Rv.fRace2/Rv.fnReturn2;
			float brace2 = (float)Rv.bRace2/Rv.bnReturn2;
			float frmiss2 = (float)Rv.fRmiss2/Rv.fnReturn2;
			float brmiss2 = (float)Rv.bRmiss2/Rv.bnReturn2;   */
			

			
			
			username1.setText(us1);
			fFirst1.setText(String.valueOf(Rv.ffserin1 + "/ " + Rv.ffSerAll1));
			bFirst1.setText(String.valueOf(Rv.bfserin1 + "/" +Rv.bfSerAll1));
			fSecond1.setText(String.valueOf(Rv.fdserin1 + "/" + Rv.fdSerAll1));
			bSecond1.setText(String.valueOf(Rv.bdserin1 + "/" + Rv.bdSerAll1));
			fSerAce1.setText(String.valueOf(Rv.fSerAce1 + "/" + (Rv.ffSerAll1 + Rv.fdSerAll1)));
			bSerAce1.setText(String.valueOf(Rv.bSerAce1 + "/" + (Rv.bdSerAll1 + Rv.bfSerAll1)));
			fDf1.setText(String.valueOf(Rv.fDfault1) + "/" + String.valueOf(Rv.ffSerAll1));
			bDf1.setText(String.valueOf(Rv.bDbault1) + "/" + String.valueOf(Rv.bfSerAll1));
			pointall1.setText(String.valueOf(Rv.nPoint1));
			fpoint1.setText(String.valueOf(Rv.fnPoint1));
			bpoint1.setText(String.valueOf(Rv.bnPoint1));
			fRace1.setText(String.valueOf(Rv.fRace1 + "/" + Rv.fnReturn1));
			bRace1.setText(String.valueOf(Rv.bRace1 + "/"+ Rv.bnReturn1));
			fRmiss1.setText(String.valueOf(Rv.fRmiss1 + "/" + Rv.fnReturn1));
			bRmiss1.setText(String.valueOf(Rv.bRmiss1 + "/" + Rv.bnReturn1));
			fout1.setText(String.valueOf(Rv.fnOut1));
			bout1.setText(String.valueOf(Rv.bnOut1));
			fnet1.setText(String.valueOf(Rv.fnNet1));
			bnet1.setText(String.valueOf(Rv.bnNet1));
			
			
			
			
			username2.setText(us2);
			fFirst2.setText(String.valueOf(Rv.ffserin2 + "/ " + Rv.ffSerAll2));
			bFirst2.setText(String.valueOf(Rv.bfserin2 + "/" +Rv.bfSerAll2));
			fSecond2.setText(String.valueOf(Rv.fdserin2 + "/" + Rv.fdSerAll2));
			bSecond2.setText(String.valueOf(Rv.bdserin2 + "/" + Rv.bdSerAll2));
			fSerAce2.setText(String.valueOf(Rv.fSerAce2 + "/" + (Rv.ffSerAll2 + Rv.fdSerAll2)));
			bSerAce2.setText(String.valueOf(Rv.bSerAce2 + "/" + (Rv.bdSerAll2 + Rv.bfSerAll2)));
			fDf2.setText(String.valueOf(Rv.fDfault2) + "/" + String.valueOf(Rv.ffSerAll2));
			bDf2.setText(String.valueOf(Rv.bDbault2) + "/" + String.valueOf(Rv.bfSerAll2));
			pointall2.setText(String.valueOf(Rv.nPoint2));
			fpoint2.setText(String.valueOf(Rv.fnPoint2));
			bpoint2.setText(String.valueOf(Rv.bnPoint2));
			fRace2.setText(String.valueOf(Rv.fRace2 + "/" + Rv.fnReturn2));
			bRace2.setText(String.valueOf(Rv.bRace2 + "/"+ Rv.bnReturn2));
			fRmiss2.setText(String.valueOf(Rv.fRmiss2 + "/" + Rv.fnReturn2));
			bRmiss2.setText(String.valueOf(Rv.bRmiss2 + "/" + Rv.bnReturn2));
			fout2.setText(String.valueOf(Rv.fnOut2));
			bout2.setText(String.valueOf(Rv.bnOut2));
			fnet2.setText(String.valueOf(Rv.fnNet2));
			bnet2.setText(String.valueOf(Rv.bnNet2));
			/*fFirst2.setText(String.valueOf(Rv.ffSerAll2 + "/ " +(Rv.ffSerAll2 + Rv.fFfault2)));
			bFirst2.setText(String.valueOf(Rv.bfSerAll2 + "/" +(Rv.bfSerAll2 + Rv.bFfault2)));
			fSecond2.setText(String.valueOf(Rv.fdSerAll2 + "/" + (Rv.fdSerAll2 + Rv.fDfault2)));
			bSecond2.setText(String.valueOf(Rv.bdSerAll2 + "/" + (Rv.bdSerAll2 + Rv.bDbault2)));
			fSerAce2.setText(String.valueOf(Rv.bSerAce2 + "/" + Rv.fSerAll2));
			bSerAce2.setText(String.valueOf(Rv.bSerAce2 + "/" + Rv.bSerAll2));
			fDf2.setText(String.valueOf(Rv.fDfault2) + "/" + String.valueOf(Rv.fdSerAll2));
			bDf2.setText(String.valueOf(Rv.bDbault2) + "/" + String.valueOf(Rv.bdSerAll2));
			pointall2.setText(String.valueOf(Rv.fnPoint2 + Rv.bnPoint2));
			fpoint2.setText(String.valueOf(Rv.fnPoint2));
			bpoint2.setText(String.valueOf(Rv.bnPoint2));
			fRace2.setText(String.valueOf(Rv.fRace2 + "/" + Rv.fnReturn2));
			bRace2.setText(String.valueOf(Rv.bRace2 + "/"+ Rv.bnReturn2));
			fRmiss2.setText(String.valueOf(Rv.fRmiss2 + "/" + Rv.fnReturn2));
			bRmiss2.setText(String.valueOf(Rv.bRmiss2 + "/" + Rv.bnReturn2));
			fout2.setText(String.valueOf(Rv.fnOut2));
			bout2.setText(String.valueOf(Rv.bnOut2));
			fnet2.setText(String.valueOf(Rv.fnNet2));
			bnet2.setText(String.valueOf(Rv.bnNet2));*/
			
		/*	username2.setText(us2);
			fFirst2.setText(sffirst2);
			bFirst2.setText(sbfirst2);
			fSecond2.setText(sfsecond2);
			bSecond2.setText(sbsecond2);
			fSerAce2.setText(sfserace2);
			bSerAce2.setText(sbserace2);
			fDf2.setText(String.valueOf(Rv.fDfault2) + "/" + String.valueOf(Rv.fdSerAll2));
			bDf2.setText(String.valueOf(Rv.bDbault2) + "/" + String.valueOf(Rv.bdSerAll2));
			pointall2.setText(String.valueOf(Rv.fnPoint2 + Rv.bnPoint2));
			fpoint2.setText(String.valueOf(Rv.fnPoint2));
			bpoint2.setText(String.valueOf(Rv.bnPoint2));
			fRace2.setText(sfrace2);
			bRace2.setText(sbrace2);
			fRmiss2.setText(sfrmiss2);
			bRmiss2.setText(sbrmiss2);
			fout2.setText(String.valueOf(Rv.fnOut2));
			bout2.setText(String.valueOf(Rv.bnOut2));
			fnet2.setText(String.valueOf(Rv.fnNet2));
			bnet2.setText(String.valueOf(Rv.bnNet2));  */
			
			
			
			
			
	}	
		@Override
	    protected void onDestroy() {
	    	super.onDestroy();
	    	Rv.Reset();
	    }
}
