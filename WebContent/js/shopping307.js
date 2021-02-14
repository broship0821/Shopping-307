/**
 * 
 */

var sp307 = {
  // 기능: server의 loc로 부터 ComboBox(=select) 항목듷을 읽어 
  //      target의 ComboBox 대입하고, 선택 항목을 selValue Text로 한다.
  "getCategory": function(loc, target, selValue) {
	  // window.open(loc); 
	  // window.location.href = loc;
	  console.log("loc=" + loc + ", target=" + target);
	  
	  $.ajax({
	    type: "GET",
	    dataType: "html",
	    url: loc,
	    success: function(msg) {
	      console.log(">>>1. " + msg);
	      $("#" + target).html(msg);
	      console.log(">>>2. " + $("#" + target).html());
	      console.log(">>>3. " + $("#" + target + ">select").length);
	      console.log(">>>4. " + $("#" + target + ">select").html());
	      $("#" + target + ">select").val(selValue);
	    } 
	  });
	},
	
	// 기능: ComboBox(=select)의 선택 항목을  selValue text 항목으로 설정한다.
	"setComboItemText": function(target, selValue) {
		$("#" + target).val(selValue);
	},
			
	// 기능: ComboBox(=select)의 선택된 항목의 text룰 응답한다.
	"getComboItemText": function(target) {
		return $("#" + target).val();
	}
};