99999<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
   

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
  request.setCharacterEncoding("UTF-8");

%> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  /> 
<%@ include file="../header.jsp" %>  
<%@ include file="sub_img.jsp"%> 
<%@ include file="sub_menu.jsp" %>
  <article>
    <h2> Item</h2>     
    <c:forEach items="${productVO }"  var="productVO">
      <div id="item">
        <a href="${contextPath}/mall/productDetail?pseq=${productVO.pseq}"> 
          <img src="../resources/product_images/${productVO.image}" />
          <h3>${productVO.name} </h3>        
          <p>${productVO.price2} </p>
        </a>  
      </div>
    </c:forEach>    
    <div class="clear"></div>
  </article>
<%@ include file="../footer.jsp" %> 