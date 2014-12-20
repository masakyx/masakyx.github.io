//Player Object--------------------------------------------------------------------------
function Player(){
  var point=0,win=0,side=0,back=0,net=0,serviceace=0,fault=0,doublefault=0,returnace=0,returnmiss=0;
}
//add method
Player.prototype.move = function(a){
  a++;
}

//Player1-------------------------------------------------------------------
var p1f = new Player();  //左上   
var p1b = new Player();
var p2f = new Player();  //左下
var p2b = new Player();
var p3f = new Player();  //右上
var p3b = new Player();
var p4f = new Player();  //右下
var p4b = new Player();
//--------------------------------------------------------------------------
jQuery(function($){
  $(serviceace,sin1,rm,side2,back2,net2).click(function(){
    p1f.move(p.point);
  });


});
