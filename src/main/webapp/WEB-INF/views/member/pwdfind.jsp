<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호  찾기</title>
<link href="CSS/subpage.css" rel="stylesheet">
<style type="text/css">
body{   
  background-color:#B96DB5;
  font-family: Verdana;
}
#wrap{     
  margin: 0 20px;
}
h1 {
  font-family: "Times New Roman", Times, serif;
  font-size: 45px;
  color: #CCC;
  font-weight: normal;
}
input[type=button], input[type=submit] {
  float: right;
}
</style>
<script type="text/javascript">
function finduserpwd(){
  window.close();
}
</script>
</head>
<body>
<div id="wrap">
  <h1>비밀번호 찾기</h1>
  		<c:choose>
			<c:when test="${pwd eq null}">
	  			등록된  계정이 없습니다.
	  		</c:when>
			<c:otherwise>
	         	비밀번호는 ${pwd}입니다.
	        </c:otherwise>
		</c:choose>
        <input type="button" value="확인" class="cancel" onclick="finduserpwd()">
    </div>
</body>
</html>