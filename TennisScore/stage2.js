jQuery(function ($){
  var i=0;//change1 number
  var k=0;//change2 number
    $("#change1").click(function (){
      i++;
      console.log(i);
      if(i%2 == 1){
        $(this).css("background-image","url(bolay.jpg)");
      }else{
        $(this).css("background-image","url(stroke.jpg)");
      }
    });
    $("#change2").click(function (){
      k++;
      if(k%2 == 1){
        $(this).css("background-image","url(bolay.jpg)");
      }else{
        $(this).css("background-image","url(stroke.jpg)");
      }
    });
});
