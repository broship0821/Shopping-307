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

<h1>Tel Info 모두 보기</h1>
<table border="2">
<!--   <tr>
    <td colspan="4">
      <form action="TelAllInfo.do">
        <input type="submit" value="확인">
      </form>
    </td>
  </tr>
 -->
   <tr>
    <td>사번</td>
    <td>이름</td>
    <td>전화</td>
    <td>입사일</td>
  </tr>
  <%--<c:forEach var="item" items="${lstItems}"> --%>    
  <c:forEach var="i" items="${requestScope.lstAll}">
  <c:set var="param1" value="TelOneInfo.do?id=${i.id}" />
  <tr>
    <td><a href="${param1}">${i.id}</a></td>
    <td><a href="${param1}">${i.name}</a></td>
    <td><a href="${param1}">${i.tel}</a></td>
    <td><a href="${param1}">${i.date}</a></td>
  </tr>
  </c:forEach>
</table>

<a href="telInsertView.jsp">[입력]</a>

</body>
</html>