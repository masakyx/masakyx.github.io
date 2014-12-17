//変数定義
var point1 = 0;
var point2 = 0;
var gamepoint1 = 0;
var gamepoint2 = 0;
var setpoint1 = 0;
var setpoint2 = 0;
var setcount = 1;

//ID取得
var score1 = $("#score1");
var score2 = $("#score2");
var gamest1 = $("#gamest1");
var gamest2 = $("#gamest2");
var setst1 = $("#setst1");
var setst2 = $("#setst2");
var service = $("#service");
var retrunin = $("#returnin");
var serviceace = $("#serviceace");
var returnace = $("#returnace");
var fault = $("#fault");
var rm = $("#rm");
var win1 = $("#win1");
var win2 = $("#win2");
var side1 = $("#side1");
var side2 = $("#side2");
var back1 = $("#back1");
var back2 = $("#back2");
var net1 = $("#net1");
var net2 = $("#net2");
var set1 = $("#set1");
var set3 = $("#set3");
var set5 = $("#set5");

jQuery(function($){

   $("#serviceace,#win1,#side2,#back2,#net2").click(function(){
     point1++;
     ScorePoint(score1,point1);
     console.log("point1="+point1);
   });
   $("#returnace,#win2,#side1,#back1,#net1").click(function(){
     point2++;
     ScorePoint(score2,point2);
     console.log("point2="+point2);
   });
   fault.click(function(){   
     if(fault.val() == "Fault" ){
      point2++;
      ScorePoint(score2,point2);
     }
   });
});

//スコアーメソッド  
function ScorePoint(score,point){
     if(point == 1){
       score.text("15");
     }else if(point == 2){
       score.text("30");
     }else if(point == 3 && point1 < 3 || point == 3 && point2 < 3){
       score.text("40"); 
     }else if(point1 == 3 && point2 == 3){
       score1.text("DEUCE");
       score2.text("DEUCE");
     }else if(point1 == 3 && point2 == 4 || point1 == 4 && point2 == 3){
       if(point1 > point2){
         score1.text("Ad");
       }else if(point2 > point1){
         score2.text("Ad");
       }
     }else if(point1 == 4 && point2 == 4){
       point1 = 3; point2 = 3;
       score1.text("DEUCE"); score2.text("DEUCE");
     }else if(point1 == 3 && point2 == 5 || point1 == 5 && point2 == 3){
       if(point1 > point2){
         gamepoint1++;
         GamePoint(gamest1,gamepoint1);
       }else if(point2 > point1){
         gamepoint2++;
         GamePoint(gamest2,gamepoint2);
       }
     }else if(point1 == 4 && point2 < 3){
       gamepoint1++;
       GamePoint(gamest1,gamepoint1);
     }else if(point2 == 4 && point1 < 3){
       gamepoint2++;
       GamePoint(gamest2,gamepoint2);
     }                        
     return 0;
}

//ゲームカウントメソッド
function GamePoint(gamest,gamepoint){
  if(gamepoint < 6 || gamepoint1 == 6 && gamepoint2 == 5 || gamepoint1 == 5 && gamepoint2 == 6 ){
    point1 = 0;
    point2 = 0;
    score1.text("0");
    score2.text("0");
    gamest.text(gamepoint);                  
  }else if(gamepoint == 6 && gamepoint1 < 5 || gamepoint == 6 && gamepoint2 <5 || gamepoint1 == 7 && gamepoint2 == 5 || gamepoint1 == 5 && gamepoint2 == 7){
    if(gamepoint1 > gamepoint2){
      setpoint1++;
      SetPoint(setst1,setpoint1);
    }else if(gamepoint1 < gamepoint2){
      setpoint2++;
      SetPoint(setst2,setpoint2);
    }
  }else if(gamepoint1 == 6 && gamepoint2 == 6){
    gamest1.text("TIE BREAK");
    gamest2.text("TIE BREAK");
    score1.text("0");
    score2.text("0");
  }
  return 0;
}

//セットカウントメソッド
function SetPoint(setst,setpoint){
//セットカウントの取得
  if(set1.is(":checked")){
    setcount = 1;
  }else if(set3.is(":checked")){
    setcount = 3;
  }else if(set5.is(":checked")){
    setcount = 5;
  }
//セットポイントのカウント
  point1=0;
  point2=0;
  score1.text("0");
  score2.text("0");
  gamepoint1=0;
  gamepoint2=0;
  gamest1.text("0");
  gamest2.text("0");
  setst.text(setpoint);
  if(setcount == 1){

  }else if(setcount = 3){

  }else if(setcount = 3){

  }

}

//タイブレイクメソッド
function TieBreak(){

}
