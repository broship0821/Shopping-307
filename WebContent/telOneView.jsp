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

<h1>Tel Info 수정/삭제</h1>
<form action="TelUpdateInfo.do">
<table border="1">
  <tr>
    <td>사번</td>
    <td>${item.id}<input name="id" type="hidden" value="${item.id}"></td>
  </tr>
  <tr>
    <td>이름</td>
    <td>${item.name}</td>
  </tr>
  <tr>
    <td>전화</td>
    <td>${item.tel}</td>
  </tr>
  <tr>
    <td>입사일</td>
    <td><input name="date" type="date" value="${item.date}"></td>
  </tr>
  <tr>
    <td colspan="2" align="center">
      <input type="submit" value="수정">
    </td>
  </tr>
</table>
</form>

<a href="${pageContext.request.contextPath}/TelAllInfo.do">[모두보기]</a>
<a href="TelAllInfo.do">[모두보기]</a>
<a href="TelDelInfo.do?id=${item.id}">[삭제]</a>

</body>
</html>