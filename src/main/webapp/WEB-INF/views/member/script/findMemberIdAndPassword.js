function findMemberId(contextPath) {
	  if (document.findId.name.value == "") {
		    alert('아이디를 입력하여 주십시오.');
		    document.findId.name.focus();
		    return;
	  } else if (document.findId.email.value == "") {
		    alert('이메일을 입력하여 주십시오.');
		    document.findId.email.focus();
		    return;
	  }
	  var url = contextPath + "/members/findMemberId?name=" 
	  + document.findId.name.value
	  + "&email="
	  + document.findId.email.value;
	    window.open( url, "_blank",
	  "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=330, height=200");
}

function findPassword(contextPath) {
	  if (document.findPW.memberId.value == "") {
		    alert('아이디를 입력하여 주십시오.');
		    document.findPW.memberId.focus();
		    return;
	  } else if (document.findPW.name.value == "") {
		    alert('이름을 입력하여 주십시오.');
		    document.findPW.name.focus();
		    return;
	  } else if (document.findPW.email.value == "") {
		    alert('이메일을 입력하여 주십시오.');
		    document.findPW.email.focus();
		    return;
	  }
		    
		var url2 = contextPath + "/members/findPassword?id=" 
		+ document.findPW.memberId.value
		+ "&name="
		+ document.findPW.name.value
		+ "&email="
		+ document.findPW.email.value;
		window.open( url2, "_blank_1",
		"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=330, height=200");
}
