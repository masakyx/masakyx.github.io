  var i=0;//change1 number
  var k=0;//change2 number
  var j=0;//fault button 
  var c=0;//change cort button


jQuery(function ($){
//初期設定
  $('input[name="usn2"],input[name="usn4"]').slideUp();
  strclosebutton();   
  $(".leftbt").css("background-color","#b3b3b3");
  $(".rightbt").css("background-color","#7fff00");  

 

  $('input[name="gametype"]').click(function (){
    var gametypecheck = $('#single').is(":checked");


    if(gametypecheck){
      $('input[name="usn2"],input[name="usn4"]').slideUp();
    }else{
      $('input[name="usn2"],input[name="usn4"]').slideDown();
    }
    console.log(gametypecheck);
  });

 
  
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

//CHANGE CORT
    $("#chanco").click(function (){
      c++;
      var posi1 = $("#returnin").offset();
      var posi2 = $("#service").offset();
      if(c%2 == 1){
        changecort(posi1.left - 10);
      }else{
        changecort(posi2.left - 10);
      }
    });

//Player1
    $("#service").click(function (){
      $(this).slideUp();
      $("#serviceace").slideUp();
      $("#fault").slideUp();
    });
    $("#serviceace").click(function (){
      $("#fault").val("Fault");
      j=0;
    });
    $("#fault").click(function (){
      j++;
      if(j%2 == 1){
        $("#fault").val("Double Fault");
      }else{
        $("#fault").val("Fault");
      }
    }); 
    $("#win1").click(function (){
      openbutton();
      strclosebutton();
    });
    $("#side1").click(function (){
      openbutton();
      strclosebutton();
    }); 
    $("#back1").click(function (){
      openbutton();
      strclosebutton();
    }); 
    $("#net1").click(function (){
      openbutton();
      strclosebutton();
    }); 

//Player 2
    $("#returnin").click(function (){
      $(this).slideUp();
      $("#returnace").slideUp();
      $("#rm").slideUp();
      $("#fault").val("Fault");
      j=0;
      stropenbutton();
    }); 
    $("#returnace").click(function (){
      openbutton();
    }); 
    $("#rm").click(function (){
      openbutton();
    }); 
    $("#win2").click(function (){
      openbutton();
      strclosebutton();
    }); 
    $("#side2").click(function (){
      openbutton();
      strclosebutton();
    }); 
    $("#back2").click(function (){
      openbutton();
      strclosebutton();
    }); 
    $("#net2").click(function (){
      openbutton();
      strclosebutton();
    }); 
});

function openbutton(){
  $("#service").slideDown();
  $("#serviceace").slideDown();
  $("#fault").slideDown();
  $("#returnin").slideDown();
  $("#returnace").slideDown();
  $("#rm").slideDown();
  $("#fault").val("Fault");
  j=0;
  return 0;
}
function strclosebutton(){
  $("#win1,#win2,#side1,#side2,#back1,#back2,#net1,#net2").slideUp();
  return 0;
}
function stropenbutton(){
  $("#win1,#win2,#side1,#side2,#back1,#back2,#net1,#net2").slideDown();
  return 0;
}
  
function changecort(po1){
  console.log(c); 
  console.log(po1);
  if(c%2 == 1){
    $(".leftbt").animate({"left":+=po1},"slow");
    $(".rightbt").animate({"left":'-=po1'},"slow");
  }else{
    $(".leftbt").animate({"left":'+=po1'},"slow");
    $(".rightbt").animate({"left":'-=po1'},"slow");  
  } 
  return 0;
}
