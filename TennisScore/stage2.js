  var i=0;//change1 number
  var k=0;//change2 number
  var j=0;//fault button    
jQuery(function ($){
  $('input[name="usn2"],input[name="usn4"]').slideUp();


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
    });
    $("#side1").click(function (){
      openbutton();
    }); 
    $("#back1").click(function (){
      openbutton();
    }); 
    $("#net1").click(function (){
      openbutton();
    }); 

//Player 2
    $("#returnin").click(function (){
      $(this).slideUp();
      $("#returnace").slideUp();
      $("#rm").slideUp();
      $("#fault").val("Fault");
      j=0;
    }); 
    $("#returnace").click(function (){
      openbutton();
    }); 
    $("#rm").click(function (){
      openbutton();
    }); 
    $("#win2").click(function (){
      openbutton();
    }); 
    $("#side2").click(function (){
      openbutton();
    }); 
    $("#back2").click(function (){
      openbutton();
    }); 
    $("#net2").click(function (){
      openbutton();
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
  

