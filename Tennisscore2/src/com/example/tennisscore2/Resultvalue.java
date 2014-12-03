package com.example.tennisscore2;

import android.app.Application;

public class Resultvalue extends Application {
	//Result number
		//player1 Result
		int nReturn1 = 0,fnReturn1 = 0,bnReturn1 = 0,fSerAll1 = 0,bSerAll1 = 0,ffSerAll1 = 0,fdSerAll1=0,bfSerAll1=0,bdSerAll1 = 0;
		int SerAll1 = 0,Dfault1= 0,SerIn1= 0,nPoint1= 0, Rmiss1= 0, Race1= 0, nOut1= 0, nNet1= 0,SerAce1= 0;
		int fDfault1= 0, fnPoint1= 0, fRmiss1= 0, fRace1= 0, fnOut1= 0, fnNet1= 0;
		int bDbault1= 0, bnPoint1= 0, bRmiss1= 0, bRace1= 0, bnOut1= 0, bnNet1= 0;
		int Ffault1 = 0,fFfault1 = 0,bFfault1,fSerAce1=0,bSerAce1 = 0;
		int ffserin1 = 0, fdserin1 = 0, fserin1 = 0, dserin1 = 0, serin1 = 0;
		int bfserin1 = 0, bdserin1 = 0, Fserin1 = 0, Bserin1 = 0;
		
		//player2 Result
		int nReturn2 = 0,fnReturn2 = 0,bnReturn2 = 0,fSerAll2 = 0,bSerAll2 = 0,ffSerAll2 = 0,bdSerAll2 = 0,fdSerAll2=0,bfSerAll2=0;
		int SerAll2 = 0,Dfault2= 0,SerIn2= 0,nPoint2= 0, Rmiss2= 0, Race2= 0, nOut2= 0, nNet2= 0,SerAce2= 0;
		int fDfault2= 0, fnPoint2= 0, fRmiss2= 0, fRace2= 0, fnOut2= 0, fnNet2= 0;
		int bDbault2= 0, bnPoint2= 0, bRmiss2= 0, bRace2= 0, bnOut2= 0, bnNet2= 0;
		int Ffault2 = 0,fFfault2 = 0,bFfault2,fSerAce2=0,bSerAce2 = 0;
		int ffserin2 = 0, fdserin2 = 0, fserin2 = 0, dserin2 = 0, serin2 = 0;
		int bfserin2 = 0, bdserin2 = 0, Fserin2 = 0, Bserin2 = 0;
		
		//playername
		String username1,username2,username3,username4;
		//ëÄçÏïœêî
		int nnn = 0;
		
		//player1 String
		String sSerAll1   = "0",sDfault1  = "0",sSerIn1  = "0",snPoint1  = "0", sRmiss1  = "0", sRace1  = "0", 
				snOut1  = "0", snNet1  = "0",sSerAce1 = "0" ;
		String sfDfault1  = "0", sfnPoint1  = "0", sfRmiss1  = "0", sfRace1  = "0", sfnOut1  = "0", sfnNet1 = "0";
		String sbDbault1  = "0", sbnPoint1  = "0", sbRmiss1  = "0", sbRace1  = "0", sbnOut1  = "0", sbnNet1 = "0";
       //player2 String
		String sSerAll2   = "0",sDfault2  = "0",sSerIn2  = "0",snPoint2  = "0", sRmiss2  = "0", sRace2  = "0", 
				snOut2  = "0", snNet2  = "0",sSerAce2 = "0";
		String sfDfault2  = "0", sfnPoint2  = "0", sfRmiss2  = "0", sfRace2  = "0", sfnOut2  = "0", sfnNet2 = "0";
		String sbDbault2  = "0", sbnPoint2  = "0", sbRmiss2  = "0", sbRace2  = "0", sbnOut2  = "0", sbnNet2 = "0";
		
	   
		public void Cout (String sScore){
			switch(sScore){
			case "SerAll1" :SerAll1++;break;
			case "Dfault1" :Dfault1++;break;
			case "SerIn1"  :SerIn1++;break;
			case "nPoint1" :nPoint1++;break;
			case "Rmiss1"  :Rmiss1++;break;
			case "Race1"   :Race1++;break;
			case "nOut1"   :nOut1++;break;
			case "nNet1"   :nNet1++;break;
			case "SerAce1" :SerAce1++;break;
			case "fDfault1":fDfault1++;break;
			case "fnPoint1":fnPoint1++;break;
			case "fRmiss1" :fRmiss1++;break;
			case "fRace1"  :fRace1++;break;
			case "fnOut1"  :fnOut1++;break;
			case "fnNet1"  :fnNet1++;break;
			case "bDbault1":bDbault1++;break;
			case "bnPoint1":bnPoint1++;break;
			case "bRmiss1" :bRmiss1++;break;
			case "bRace1"  :bRace1++;break;
			case "bnOut1"  :bnOut1++;break;
			case "bnNet1"  :bnNet1++;break;
			case "SerAll2" :SerAll2++;break;
			case "Dfault2" :Dfault2++;break;
			case "SerIn2"  :SerIn2++;break;
			case "nPoint2" :nPoint2++;break;
			case "Rmiss2"  :Rmiss2++;break;
			case "Race2"   :Race2++;break;
			case "nOut2"   :nOut2++;break;
			case "nNet2"   :nNet2++;break;
			case "SerAce2" :SerAce2++;break;
			case "fDfault2":fDfault2++;break;
			case "fnPoint2":fnPoint2++;break;
			case "fRmiss2" :fRmiss2++;break;
			case "fRace2"  :fRace2++;break;
			case "fnOut2"  :fnOut2++;break;
			case "fnNet2"  :fnNet2++;break;
			case "bDbault2":bDbault2++;break;
			case "bnPoint2":bnPoint2++;break;
			case "bRmiss2" :bRmiss2++;break;
			case "bRace2"  :bRace2++;break;
			case "bnOut2"  :bnOut2++;break;
			case "bnNet2"  :bnNet2++;break;
			default : break;
			}
			//player1 String
			sSerAll1 = String.valueOf(SerAll1);
			sDfault1  = String.valueOf(Dfault1);
			sSerIn1  = String.valueOf(SerIn1);
			snPoint1  = String.valueOf(nPoint1);
			sRmiss1  = String.valueOf(Rmiss1);
			sRace1  = String.valueOf(Race1);
			snOut1  = String.valueOf(nOut1);
			snNet1  = String.valueOf(nNet1);
			sSerAce1  = String.valueOf(SerAce1);
			 sfDfault1  = String.valueOf(fDfault1);
			 sfnPoint1  = String.valueOf(fnPoint1); 
			 sfRmiss1  = String.valueOf(fRmiss1);
			 sfRace1  = String.valueOf(fRace1); 
			 sfnOut1  = String.valueOf(fnOut1);
			 sfnNet1  = String.valueOf(fnNet1);
			 sbDbault1  = String.valueOf(bDbault1);
			 sbnPoint1  = String.valueOf(bnPoint1);
			 sbRmiss1  = String.valueOf(bRmiss1); 
			 sbRace1  = String.valueOf(bRace1); 
			 sbnOut1  = String.valueOf(bnOut1); 
			 sbnNet1  = String.valueOf(bnNet1);
	       //player2 String
			 sSerAll2 = String.valueOf(SerAll2);
				sDfault2  = String.valueOf(Dfault2);
				sSerIn2  = String.valueOf(SerIn2);
				snPoint2  = String.valueOf(nPoint2);
				sRmiss2  = String.valueOf(Rmiss2);
				sRace2  = String.valueOf(Race2);
				snOut2  = String.valueOf(nOut2);
				snNet2  = String.valueOf(nNet2);
				sSerAce2  = String.valueOf(SerAce2);
				 sfDfault2  = String.valueOf(fDfault2);
				 sfnPoint2  = String.valueOf(fnPoint2); 
				 sfRmiss2  = String.valueOf(fRmiss2);
				 sfRace2  = String.valueOf(fRace2); 
				 sfnOut2  = String.valueOf(fnOut2);
				 sfnNet2  = String.valueOf(fnNet2);
				 sbDbault2  = String.valueOf(bDbault2);
				 sbnPoint2  = String.valueOf(bnPoint2);
				 sbRmiss2  = String.valueOf(bRmiss2); 
				 sbRace2  = String.valueOf(bRace2); 
				 sbnOut2  = String.valueOf(bnOut2); 
				 sbnNet2  = String.valueOf(bnNet2);
		}
		public void Reset(){
			//player1 Result
			nReturn1 = 0;fnReturn1 = 0;bnReturn1 = 0;fSerAll1 = 0;bSerAll1 = 0;ffSerAll1 = 0;fdSerAll1=0;bfSerAll1=0;bdSerAll1 = 0;
			SerAll1 = 0;Dfault1= 0;SerIn1= 0;nPoint1= 0; Rmiss1= 0; Race1= 0; nOut1= 0; nNet1= 0;SerAce1= 0;
			fDfault1= 0; fnPoint1= 0; fRmiss1= 0; fRace1= 0; fnOut1= 0; fnNet1= 0;
			bDbault1= 0; bnPoint1= 0; bRmiss1= 0; bRace1= 0; bnOut1= 0; bnNet1= 0;
			Ffault1 = 0;fFfault1 = 0;bFfault1 = 0;fSerAce1=0;bSerAce1 = 0;
			ffserin1 = 0; fdserin1 = 0; fserin1 = 0; dserin1 = 0; serin1 = 0;
			bfserin1 = 0; bdserin1 = 0; Fserin1 = 0; Bserin1 = 0;
			
			//player2 Result
			nReturn2 = 0;fnReturn2 = 0;bnReturn2 = 0;fSerAll2 = 0;bSerAll2 = 0;ffSerAll2 = 0;bdSerAll2 = 0;fdSerAll2=0;bfSerAll2=0;
			SerAll2 = 0;Dfault2= 0;SerIn2= 0;nPoint2= 0; Rmiss2= 0; Race2= 0; nOut2= 0; nNet2= 0;SerAce2= 0;
			fDfault2= 0; fnPoint2= 0; fRmiss2= 0; fRace2= 0; fnOut2= 0; fnNet2= 0;
			bDbault2= 0; bnPoint2= 0; bRmiss2= 0; bRace2= 0; bnOut2= 0; bnNet2= 0;
			Ffault2 = 0;fFfault2 = 0;bFfault2 = 0;fSerAce2=0;bSerAce2 = 0;
			ffserin2 = 0; fdserin2 = 0; fserin2 = 0; dserin2 = 0; serin2 = 0;
			bfserin2 = 0; bdserin2 = 0; Fserin2 = 0; Bserin2 = 0;
		}
}

