<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% request.setCharacterEncoding("UTF-8"); %> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}" /> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sero Footwear</title>

<link href="${contextPath}/resources/css/shopping.css" rel="stylesheet">
<script type="text/javascript" src="${contextPath}/resources/js/member.js"></script>
<script type="text/javascript" src="${contextPath}/mypage/mypage.js"></script>
</head>


<body>
	<div id="wrap">
		<!--헤더파일 들어가는 곳 시작 -->
		<header>
			<!--로고 들어가는 곳 시작--->
			<form name="" method="post"></form>
			<div id="mall">
				<a href="${contextPath}/mall/mainPage"> <img src="${contextPath}/resources/images/logo.png" width="180" height="100" alt="nonageshop">

				</a>
			</div>
			<!--로고 들어가는 곳 끝-->
			<nav id="catagory_menu">
				<ul>
					<c:choose>
						<c:when test="${empty sessionScope.loginUser}">
							<li><a href="${contextPath}/members/loginForm"
								style="width: 110px;">LOGIN(CUSTOMER</a> <a
								href="${contextPath}/mall/main?admin_login_form"
								style="width: 100px;">| ADMIN)</a></li>
							<li>/</li>
							<li><a href="${contextPath}/members/contract">JOIN</a></li>
						</c:when>
						<c:otherwise>
							<li style="color: black">
								${sessionScope.loginUser.name}(${sessionScope.loginUser.id})</li>
							<li><a href="${contextPath}/userpages/logout">LOGOUT</a></li>
						</c:otherwise>
					</c:choose>
					<li>/</li>
					<li><a href="${contextPath}/userpages/cartList">CART</a></li>
					<li>/</li>
					<li><a href="${contextPath}/userpages/mypage">MY PAGE</a></li>
					<li>/</li>
					<li><a href="${contextPath}/qnas/qnaList">Q&amp;A(1:1)</a>
					</li>
				</ul>
			</nav>

			<nav id="top_menu">
				<ul>
					<li><a href="${contextPath}/mall/ProductKind?kind=1">Heels</a>
					</li>
					<li><a href="${contextPath}/mall/ProductKind?kind=2">Boots</a>
					</li>
					<li><a href="${contextPath}/mall/ProductKind?kind=3">Sandals</a>
					</li>
					<li><a href="${contextPath}/mall/ProductKind?kind=4">Sneakers</a>
					</li>
					<li><a href="${contextPath}/mall/ProductKind?kind=5">On Sale</a></li>
				</ul>
			</nav>
			<div class="clear"></div>
			<hr>
		</header>
		<!--헤더파일 들어가는 곳 끝 -->