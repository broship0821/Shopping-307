<%@page import="com.team1.shopping307.controller.Common"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%request.setCharacterEncoding("UTF-8");%>
  <%response.setCharacterEncoding("UTF-8");%>
  
  <div>
    <select name="status">
      <option value="입금완료" name="입금완료">입금완료</option>
      <option value="결제승인" name="결제승인">결제승인</option>
      <option value="출고"    name="출고"   >출고</option>
      <option value="교환"    name="교환"   >교환</option>
      <option value="환불"    name="환불"   >환불</option>
      <option value="구매완료" name="구매완료">구매완료</option>
    </select>
    <input type="button" value="조회" onClick="location.href='<%=Common.strPayGetStatusDo %>'" />
    
    <table>
      <tr>
        <th align="center">구매자 아이디</td>
        <th align="center">구매자 명</td>
        <th align="center">구매자 전화</td>
        <th align="center">구매품목</td>
        <th align="center">구매합계</td>
        <th align="center">결제장법</td>
        <th align="center">상태</td>
        <th align="center">다음상태</td>
      </tr>
      <c:set var="items" value="${requestScope.lstAll}" />
      ${items } <br />
      <c:if test="${!empty items}">
       items != null <br />
<%--       <c:forEach var="i" items="${items}"> --%>
<%--       <c:set var="param1" value="<%=Common.strPaySetStatusDo%>?payId=${i.payId}" /> --%>
<!--       <tr> -->
<%--         <td>${i.payId}</td> --%>
<%--         <td>${i.buyerId}</td> --%>
<%--         <td>${i.buyerName}/td> --%>
<%--         <td>${i.buyerPhone}</td> --%>
<%--         <td>${i.itemsInfo}</td> --%>
<%--         <td>${i.amount}</td> --%>
<%--         <td>${i.cashOrCard}</td> --%>
<%--         <td>${i.status}</td> --%>
<%--         <td><input type="button" value="다음상태로 변경" onClick="location='${param1}'"></td> --%>
<!--       </tr> -->
<%--       </c:forEach> --%>
      </c:if>
    </table>
  </div>
</body>
</html>