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

<h1>Tel Info 입력</h1>
<form action="TelInsertInfo.do">
<table border="1">
  <tr>
    <td>사번</td>
    <td><input name="id" type="text" required></td>
  </tr>
  <tr>
    <td>이름</td>
    <td><input name="name" type="text" required></td>
  </tr>
  <tr>
    <td>전화</td>
    <td><input name="tel" type="text" required></td>
  </tr>
  <tr>
    <td>입사일</td>
    <td><input name="date" type="date" required></td>
  </tr>
  <tr>
    <td colspan="2" align="center">
      <input type="submit" value="등록">
    </td>
  </tr>
</table>
</form>

<a href="TelAllInfo.do">[모두보기]</a>

</body>
</html>