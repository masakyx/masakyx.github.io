//Player Object--------------------------------------------------------------------------
function Player(){
  this.point=0,this.win=0,this.side=0,this.back=0,this.net=0,this.serviceace=0,this.fault=0,this.doublefault=0,this.returnace=0,this.returnmiss=0;
}
//add method
Player.prototype.move = function(a){
  var m = a;
  m++;
  console.log(m);
  return m;
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
  $(serviceace,win1,rm,side2,back2,net2).click(function(){
    //p1f.move(p1f.point);
    p1f.point++;
    console.log(p1f.point + "+" + p2f.point);
  });


});


