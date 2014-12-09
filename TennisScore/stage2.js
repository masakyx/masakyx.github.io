jQuery(function ($){
  var i=0;
    $("#change1").click(function (){
      i++;
      console.log(i);
      if(i%2 == 1){
        $(this).css("background","url(bolay.jpg) left top no-repeat");
      }else{
        $(this).css("background","url(stroke.jpg) left top no-repeat");
      }
    });

    $("#returnin").click(function(){
      $(this).slideUp();
      });
    $("#service").click(function (){
      $(this).css("background-color","green");
      });
    });  
