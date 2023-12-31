<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextPath"  value="${pageContext.request.contextPath}"  /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link rel="stylesheet" href="${contextPath}/resources/css/admin.css">
<script type="text/javascript" src="${contextPath}/resources/product/product.js"></script>
<%--
<c:choose>
  	<c:when test="${empty workerId}">
		<script type="text/javascript">
			location.href = "${contextPath}/mall";
		</script>
	</c:when> 	 
</c:choose>
 --%>
</head>
<body onload="go_ab()">
	<div id="wrap">
		<header>
			<div id="logo">
				<a href="${contextPath}/mall/mainPage"> <img
					style="width: 800px" src="${contextPath}/resources/admin/images/bar_01.gif"> <img
					src="${contextPath}/resources/admin/images/text.gif">
				</a>
			</div>
			<input class="btn" type="button" value="logout" style="float: right;"
				onClick="location.href='${contextPath}/admin/logout'">
		</header>
		<div class="clear"></div>