$(function(){
	$("form").on("submit", function(){
	if($("input").val().length < 1){
	        $("div.control-group").addClass("error");
	    $("div.alert").show("slow").delay(4000).hide("slow");
	        return false;
	    }
	    });
  });
