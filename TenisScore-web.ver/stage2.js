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
      $('input[name="usn3"]').val("player2");
    }else{
      $('input[name="usn2"],input[name="usn4"]').slideDown();
      $('input[name="usn3"]').val("player3");
    }
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
    //stroke button
      var posi1 = $("#returnin").offset();
      var posi2 = $("#service").offset();
    //player text button   
      var posi3 = $("#usn3").offset();
      var posi4 = $("#usn1").offset();
    //change button
      var posi5 = $("#change2").offset();
      var posi6 = $("#change1").offset();
    //score text
      var posi7 = $("#setst2").offset();
      var posi8 = $("#setst1").offset();

      if(c%2 == 1){
        changecort(posi1.left - 10,posi3.left - 10,posi5.left - posi6.left,posi7.left - 10);
      }else{
        changecort(posi2.left - 10,posi4.left - 10,posi6.left - posi5.left,posi8.left - 10);
      }
    });                                

//Player1
    $("#service").click(function (){
      $(this).slideUp();
      $("#serviceace").slideUp();
      $("#fault").slideUp();
      chanco(1);
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
      chanco(2);
    });
    $("#side1").click(function (){
      openbutton();
      strclosebutton();
      chanco(2);
    }); 
    $("#back1").click(function (){
      openbutton();
      strclosebutton();
      chanco(2);
    }); 
    $("#net1").click(function (){
      openbutton();
      strclosebutton();
      chanco(2);
    }); 

//Player 2
    $("#returnin").click(function (){
      $(this).slideUp();
      $("#returnace").slideUp();
      $("#rm").slideUp();
      $("#fault").val("Fault");
      j=0;
      stropenbutton();
      chanco(1);
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
      chanco(2);
    }); 
    $("#side2").click(function (){
      openbutton();
      strclosebutton();
      chanco(2);
    }); 
    $("#back2").click(function (){
      openbutton();
      strclosebutton();
      chanco(2);
    }); 
    $("#net2").click(function (){
      openbutton();
      strclosebutton();
      chanco(2);
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
function chanco(a){
  if(a == 1){
    $("#chanco").slideUp();
  }else if(a == 2){
    $("#chanco").slideDown();
  }
}
  
function changecort(po1,po2,po3,po4){
  if(c%2 == 1){
    $(".leftbt").animate({"left":'+=' + po1},"slow");
    $(".rightbt").animate({"right":'+=' + po1},"slow");
    $("#usn1,#usn2").animate({"left":'+=' + po2},'slow');
    $("#usn3,#usn4").animate({"right":'+=' + po2},'slow');
    $("#change1").animate({"left":'+=' + po3},'slow');
    $("#change2").animate({"right":'+=' + po3},'slow');
    $(".pl1").animate({"left":'+=' + po4},'slow');
    $(".pl2").animate({"right":'+=' + po4},'slow');
  }else{
    $(".leftbt").animate({"left":'-=' + po1},"slow");
    $(".rightbt").animate({"right":'-=' + po1},"slow");
    $("#usn1,#usn2").animate({"left":'-=' + po2},'slow');
    $("#usn3,#usn4").animate({"right":'-=' + po2},'slow');
    $("#change1").animate({"left":'-=' + po3},'slow');
    $("#change2").animate({"right":'-=' + po3},'slow');
    $(".pl1").animate({"left":'-=' + po4},'slow');
    $(".pl2").animate({"right":'-=' + po4},'slow');
  } 
  return 0;
}

function reposition(){
  if(c%2 == 1){
    $(".leftbt").css({"right":'10px'});
    $(".rightbt").css({"left":'10px'});
    $("#usn1,#usn2").css({"right":'10px'});
    $("#usn3,#usn4").css({"left":'10px'});
    $("#change1").css({"right":'32%'});
    $("#change2").css({"left":'32%'}); 
  }else{
    $(".leftbt").css({"left":'10px'});
    $(".rightbt").css({"right":'10px'});
    $("#usn1,#usn2").css({"left":'10px'});
    $("#usn3,#usn4").css({"right":'10px'});
    $("#change1").css({"left":'32%'});
    $("#change2").css({"right":'32%'});   
  }
  return 0;
}
