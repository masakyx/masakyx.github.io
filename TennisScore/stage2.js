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

//Player1
    $("#service").click(function (){
    });
    $("#serviceace").click(function (){
    });
    $("#fault").click(function (){
    }); 
    $("#win1").click(function (){
    });
    $("#side1").click(function (){
    }); 
    $("#back1").click(function (){
    }); 
    $("#net1").click(function (){
    }); 

//Player 2
    $("#returnin").click(function (){
    }); 
    $("#returnace").click(function (){
    }); 
    $("#rm").click(function (){
    }); 
    $("#win2").click(function (){
    }); 
    $("#side2").click(function (){
    }); 
    $("#back2").click(function (){
    }); 
    $("#net2").click(function (){
    }); 
});

