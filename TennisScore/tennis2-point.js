//変数定義
var point1 = 0;
var point2 = 0;

jQuery(function($){
   //ID変数　取得
   var score1 = $("#score1");
   var score2 = $("#score2");

   $("#serviceace,#rm,#win1,#side2,#back2,#net2").click(function(){
     point1++;
     ScorePoint(score1,point1);
   });
   $("#returnace,#win2,#side1,#back1,#net1").click(function(){
     point2++;
     ScorePoint(score2,point2);
   });
});

//スコアーメソッド
function ScorePoint(score,point){
     if(point == 1){
       score.text("15");
     }else if(point == 2){
       score.text("30");
     }else if(point == 3){
       score.text("40");
     }
     return 0;
}
