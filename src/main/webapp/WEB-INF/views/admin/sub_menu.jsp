<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  /> 

<nav id="sub_menu">
	<h1>Admin Setting</h1>
	<ul>
		<li><a href='${contextPath}/admin/product/productList'> 상품리스트</a></li>
		<li><a href='${contextPath}/admin/order/orderList'> 주문리스트</a></li>
		<li><a href='${contextPath}/admin/member/memberList'> 회원리스트</a></li>
		<li><a href='${contextPath}/admin/qna/qnaList'>Q&amp;A리스트</a></li>
	</ul>
</nav>