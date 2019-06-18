/**
 * 2019.06.18
 */
function myShowFunction() {
	var test1 = document.getElementById("panel").style.display;	
	if (test1 == 'none'|| test1=='') {
		document.getElementById("panel").style.display = "block";
	} else {
		document.getElementById("panel").style.display = "none";
	}

}
