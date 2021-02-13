/**
 * 
 */

var sp307 = {
  "getCategory": function(loc, target) {
	  // window.open(loc); 
	  // window.location.href = loc;
	  console.log("loc=" + loc + ", target=" + target);
	  
	  $.ajax({
	    type: "GET",
	    dataType: "html",
	    url: loc,
	    success: function(msg) {
	      console.log(msg);
	      $("#" + target).html(msg);      
	    } 
	  });
	}
};