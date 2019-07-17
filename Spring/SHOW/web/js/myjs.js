/**
 * 2019.06.18
 */

$(document).ready(function (){
	$('.svgLi').mouseenter(function(){		
		$(this).children(':eq(0)').children(':eq(0)').css('fill','#87CEFA');
	});
	$('.svgLi').mouseleave(function(){
		$(this).children(':eq(0)').children(':eq(0)').css('fill','#0a95e9');
	});
	
	
});
function myShowFunction(id) {	
	$('#'+id+'ori').toggle('fast','swing');
	$('#'+id+'div').toggle('fast','swing');
}
function len_chk(){  
  var frm = document.insertFrm.text;
  if(frm.value.length > 200){  
       alert("글자수는 100자로 제한됩니다.!");  
       frm.value = frm.value.substring(0,200);  
       frm.focus();  
  }
}
function down_menu(id){
$('.'+id).toggle('fast','swing');
}
