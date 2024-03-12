$(".toggle-sidebar-btn").on("click", function() {
	if(!$("body").hasClass("toggle-sidebar")) {
		$("body").addClass("toggle-sidebar");
	} else {
		$("body").removeClass("toggle-sidebar");
	}
});