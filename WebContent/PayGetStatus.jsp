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

  var changeCurStatus = function() {
    var curStatus = $("#status option:selected").val();
    var loc = "<%=Common.strPayGetStatusDo%>?status=" + curStatus;

    console.log("loc=" + loc);
    location.replace(loc);
  };
  
  var doPayUpdateStatus = function(payId) {
    var curStatus = $("#status option:selected").val();
    var newStatus = $("#newStatus option:selected").val();

    if(curStatus != newStatus) {
      var loc = "<%=Common.strPayUpdateStatusDo%>?payId="
              + payId + "&curStatus=" + curStatus + "&newStatus=" + newStatus;

      console.log("loc=" + loc);
      location.replace(loc);
    }
  };

</script>

</head>
<body>
  <%request.setCharacterEncoding("UTF-8");%>
  <%response.setCharacterEncoding("UTF-8");%>
<a href="mainMenu.html">[메인페이지로]</a>
<%-- <% pageContext.setAttribute("cmd", Common.strPayUpdateStatusDo); %> --%>
<%-- <% pageContext.setAttribute("curStatus", Common.strPayStatusPayed); %> --%>

  <script>
      $(function() { // = $(document).ready(function() {
	    var curStatus = "${curStatus}";
	    console.log("curStatus=" + curStatus); 
	    sp307.setComboItemText("status", curStatus);
	  });
  
  </script>  

<%--  status = ${curStatus}<br /> --%>
<%--  status = ${requestScope.curStatus}<br /> --%>
<%--  status = <%=request.getAttribute("curStatus") %><br /> --%>
 
  <div>
       현재 상태: 
    <select name="status" id="status" onchange="changeCurStatus();">
      <option value="입금완료" name="입금완료">입금완료</option>
      <option value="결제승인" name="결제승인">결제승인</option>
      <option value="출고"    name="출고"   >출고</option>
      <option value="교환"    name="교환"   >교환</option>
      <option value="환불"    name="환불"   >환불</option>
      <option value="구매완료" name="구매완료">구매완료</option>
    </select>
  </div> 
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
        <th align="center">상태 변경</td>
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
        <td><input type="button" value="상태 변경" onClick="doPayUpdateStatus('${i.payId}');"></td>
      </tr>
      </c:forEach>
      </c:if>
    </table>
  </div>
</body>
</html>