<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
	function go_search(contextPath) { // 상품 목록에서 keyword 검색
		document.frm.action = contextPath
				+ "/mall/member/AdminMemberListAction.do";
		document.frm.submit();
	}
	
	function go_ban(contextPath) { // 유저 탈퇴
		document.getElementsByName("key")[0].value = Array.from(document.querySelectorAll("input[name='useyn']:checked")).map(function(checkbox) {
		    return checkbox.value;
		}).join(",");	
		document.frm.action = contextPath + "/mall/member/AdminMemberBanAction.do";
		document.frm.submit();
	}

</script>

<article>
	<h1>회원리스트</h1>
	<form name="frm" method="post">
		<table style="float: right;">
			<tr>
				<td>회원 이름 <input type="text" name="key"> <input
					class="btn" type="button" value="검색" onclick="go_search('${contextPath}')">
				</td>
			</tr>
		</table>
		<br>
		<table id="orderList">
			<tr>
				<th>아이디(탈퇴여부)</th>
				<th>이름</th>
				<th>이메일</th>
				<th>우편번호</th>
				<th>주소</th>
				<th>전화</th>
				<th>가입일</th>
			</tr>
			<c:forEach items="${memberList}" var="memberVO">
				<c:set var="memberId" value="${memberVO.id}" />
				<tr>
					<td>${memberVO.id}
					<c:choose>
							<c:when test='${memberVO.useyn=="y"}'>
								<input type="checkbox" name="useyn" value="${memberId}">
							</c:when>
							<c:otherwise>
								<input type="checkbox" name="useyn" value="${memberId}" checked="checked"
									disabled="disabled">
							</c:otherwise>
						</c:choose></td>
					<td>${memberVO.name}</td>
					<td>${memberVO.email}</td>
					<td>${memberVO.zipNum}</td>
					<td>${memberVO.address}</td>
					<td>${memberVO.phone}</td>
					<td><fmt:formatDate value="${memberVO.indate}" /></td>
				</tr>
			</c:forEach>
		</table>
		<input type="button" class="btn" style="width: 200px"
		value="강퇴 처리 (확인)" onClick="go_ban('${contextPath}')">
	</form>
</article>
<%@ include file="/admin/footer.jsp"%>
</body>
</html>