<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp" %>  
<%@ include file="sub_img2.jsp"%> 
<%@ include file="sub_menu.jsp" %>

 <c:set var="contextPath" value="${pageContext.request.contextPath}" />  
<script type="text/javascript">

	function go_order_delete(contextPath) { // 주문 목록 삭제
	  var count = 0;

	  if (document.formm.oseq.length == undefined) {
	    if (document.formm.oseq.checked == true) {
	      count++;
	    }
	  }

	  for ( var i = 0; i < document.formm.oseq.length; i++) {
	    if (document.formm.oseq[i].checked == true) {
	      count++;
	    }
	  }
	  if (count == 0) {
	    alert("삭제할 항목을 선택해 주세요.");
	    
	  } else {
	    document.formm.action = contextPath + "/userpages/orderDelete";
	    document.formm.submit();
	  }
	}




</script>   
       
  <article>
    <h2> My Page(${title}) </h2>
    <form name="formm" method="post">
      <table id="cartList">
      <tr>
        <th>주문일자</th> <th>주문번호</th> <th>상품명</th> <th>결제 금액</th> <th>주문 상세</th>
      </tr>
      <c:forEach items="${orderList}"  var="orderVO">
      <tr>  
        <td> <fmt:formatDate value="${orderVO.indate}" type="date"/></td>
        <td> ${orderVO.oseq} </td>    
        <td> ${orderVO.pname} </td>
        <td> <fmt:formatNumber value="${orderVO.price2}" type="currency"/> </td>
        <td> <a href="${contextPath}/userpages/orderDetail?oseq=${orderVO.oseq}"> 조회 </a></td>
      </tr>
      </c:forEach>    
      </table>   
          
      <div class="clear"></div>
      <div id="buttons" style="float: right">
       <input type="button"    value="쇼핑 계속하기"  class="cancel"  onclick="location.href='${contextPath}/mall'"> 
      </div>
    </form>  
  </article>
<%@ include file="../footer.jsp" %>    