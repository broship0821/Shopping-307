<%@page import="com.team1.shopping307.controller.Common"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- <script src="jquery-3.1.1.js" /> <!-- import JQuery -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script> -->

<script src="js/shopping307.js?ver=1"></script>

<script>
  
  var payUpdateStatus = function(payId) {
	  console.log(payId);
    var curStatus = $("#status option:selected").val();
    var newStatus = $("#newStatus option:selected").val();
    var loc = "<%=Common.strPayUpdateStatusDo%>?payId="
        + payId + "&curStatus=" + curStatus + "&newStatus=" + newStatus;

    console.log("loc=" + loc);
    location.replace(loc);
  }

</script>

</head>
<body>
  <%request.setCharacterEncoding("UTF-8");%>
  <%response.setCharacterEncoding("UTF-8");%>

<%-- <% pageContext.setAttribute("cmd", Common.strPayUpdateStatusDo); %> --%>
<%-- <% pageContext.setAttribute("curStatus", Common.strPayStatusPayed); %> --%>

  <script>
      $(function() { // = $(document).ready(function() {
	    var status = "${requestScope.status}";
	    console.log("status=" + status); // 외 ''일까? 갸우뚱
	    sp307.setComboItemText("status", status);
	  });
  
  </script>  

  <form action="<%=Common.strPayGetStatusDo %>" method="get">
       현재 상태: 
    <select name="status" id="status">
      <option value="입금완료" name="입금완료">입금완료</option>
      <option value="결제승인" name="결제승인">결제승인</option>
      <option value="출고"    name="출고"   >출고</option>
      <option value="교환"    name="교환"   >교환</option>
      <option value="환불"    name="환불"   >환불</option>
      <option value="구매완료" name="구매완료">구매완료</option>
    </select>
    <input type="submit" value="조회 " />
  </form> 
    새 상태: 
    <select name="newStatus" id="newStatus">
      <option value="입금완료" name="입금완료">입금완료</option>
      <option value="결제승인" name="결제승인">결제승인</option>
      <option value="출고"    name="출고"   >출고</option>
      <option value="교환"    name="교환"   >교환</option>
      <option value="환불"    name="환불"   >환불</option>
      <option value="구매완료" name="구매완료">구매완료</option>
    </select>
    
  <div>
    <table border="1">
      <tr>
        <th align="center">구매자 아이디</td>
        <th align="center">구매자 명</td>
        <th align="center">구매자 전화</td>
        <th align="center">구매품목</td>
        <th align="center">구매번호</td>
        <th align="center">구매합계</td>
        <th align="center">결제장법</td>
        <th align="center">상태</td>
        <th align="center">다음상태</td>
      </tr>
      
      <c:set var="items" value="${requestScope.lstAll}" />
      <c:if test="${not empty items}">
      <c:forEach var="i" items="${items}">
      <tr>
        <td>${i.payId}</td>
        <td>${i.buyerId}</td>
        <td>${i.buyerName}</td>
        <td>${i.buyerPhone}</td>
        <td>${i.itemsInfo}</td>
        <td>${i.amount}</td>
        <td>${i.cashOrCard}</td>
        <td>${i.status}</td>
        <td><input type="button" value="새 상태 적용" onClick="payUpdateStatus('${i.payId}');"></td>
      </tr>
      </c:forEach>
      </c:if>
    </table>
  </div>
</body>
</html>