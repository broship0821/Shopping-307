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

<h3>${result}</h3>
<br /><br />

<h1>Category 리스트</h1>
<table border="2">
   <tr>
    <td>카테고리명</td>
    <td>설명</td>
  </tr>
  <c:forEach var="i" items="${requestScope.lstAll}">
  <c:set var="param1" value="CateSelectOne.do?id=${i.name}" />
  <tr>
    <td><a href="${param1}">${i.name}</a></td>
    <td><a href="${param1}">${i.bigo}</a></td>
  </tr>
  </c:forEach>
</table>

<input type="button" value="입력" 
       onClick="location.href='<%=Common.strCateInsert%><%=Common.strJsp%>'" />

</body>
</html>