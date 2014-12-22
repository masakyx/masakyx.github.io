//Player Object--------------------------------------------------------------------------
function Player(){
  this.point=0,this.win=0,this.side=0,this.back=0,this.net=0,this.serviceace=0,this.fault=0,this.doublefault=0,this.returnace=0,this.returnmiss=0,this.spoint=0,this.bpoint=0,this.swin=0,this.bwin=0,this.sback=0,this.bback=0,this.sside=0,this.bside=0,this.snet=0,this.bnet=0;
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
//-----POINT----------------------------------------------------------------
  $(serviceace,win1,side2,back2,net2).click(function(){
    //p1f.move(p1f.point);
    if(foreback == 0){
      p1f.point++;
    }else{
      p1b.point++;
    }
  });
  $(returnace,win2,side1,back1,net1).click(function(){
    if(foreback == 0){
      p2f.point++;
    }else{
      p2b.point++;
    }
  });

//-----MISS POINT-----------------------------------------------------------
  $(net1).click(function(){
  });

});


