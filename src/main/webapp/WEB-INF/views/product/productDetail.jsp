<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>  
<%@ include file="sub_img.jsp"%> 
<%@ include file="sub_menu.jsp" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  /> 
    
<meta charset="UTF-8">
<script type="text/javascript">
function go_cart(contextPath) {
	  if (document.formm.quantity.value == "" && document.formm.quantity.value=="0") {
	    alert("수량을 입력하여 주세요.");	    
	    document.formm.quantity.focus();	
	    
	  } else {
	            document.formm.action = contextPath + "/userpages/cartInsert";
	            document.formm.submit();
	            
	        }
	    }

function go_order(contextPath) {
	 document.formm.action = contextPath + "/userpages/orderInsert";
	  document.formm.submit();
	  alert("최종 구매완료");
	
	}

</script>



<c:set var="contextPath"  value="${pageContext.request.contextPath}"  /> 
    
 <article>
    <h1> Item </h1>
    <div id="itemdetail" >
      <form  method="post" name="formm" >    
        <fieldset>
          <legend> Item detail Info</legend>  
          <a href="${contextPath}/mall/productDetail?pseq=${productVO.pseq}">         
            <span style="float: left;">
              <img  src="../resources/product_images/${productVO.image}"  />
            </span>              
            <h2> ${productVO.name} </h2>  
          </a>    
          <label> 가 격 :  </label>  
          <p> ${productVO.price2} 원</p>  
          <label> 수 량 : </label>
          <input  type="text"      name="quantity"  size="2"      value="1"><br>
          <input  type="hidden"    name="pseq"       value="${productVO.pseq}"><br>
        </fieldset>
        <div class="clear"></div>
        <div id="buttons">
          <input type="button" value="장바구니에 담기"   class="submit"    onclick="go_cart('${contextPath}')"> 
          <input type="button" value="즉시 구매"       class="submit"    onclick="go_order('${contextPath}')"> 
          <input type="reset"  value="취소"           class="cancel">
        </div>
      </form>  
    </div>
  </article>
<%@ include file="../footer.jsp" %>      