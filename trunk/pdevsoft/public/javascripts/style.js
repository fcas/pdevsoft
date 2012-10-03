$(document).ready(function(){  
	$("#interno").hide();
	$("#interno2").hide();
	$("#interno3").hide();
	$("#interno4").hide();
	$("#interno5").hide();

	 $('#med').click(function () {
		$("#interno2").hide();
	$("#interno3").hide();
	$("#interno4").hide();
	$("#interno5").hide();	 
    $("#interno").slideToggle("fast");
    
    });
    $('#paciente').click(function () {
			$("#interno").hide();
	$("#interno3").hide();
	$("#interno4").hide();
	$("#interno5").hide();
    $("#interno2").slideToggle("fast");
    });
    $('#exame').click(function () {
			$("#interno2").hide();
	$("#interno").hide();
	$("#interno4").hide();
	$("#interno5").hide();
    $("#interno3").slideToggle("fast");
    });
    $('#laudo').click(function () {	$("#interno2").hide();
	$("#interno3").hide();
	$("#interno").hide();
	$("#interno5").hide();
    $("#interno4").slideToggle("fast");
    });
    $('#sobre').click(function () {	$("#interno2").hide();
	$("#interno3").hide();
	$("#interno4").hide();
	$("#interno").hide();
    $("#interno5").slideToggle("fast");
    });
  });      
