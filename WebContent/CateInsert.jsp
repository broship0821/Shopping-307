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

<h1>Category 입력</h1>
<form action="<%=Common.strCateInsertDo%>">
<table border="1">
  <tr>
    <td align="center">카테고리명</td>
    <td><input type="text" name="name" size="20" length="20" required /></td>
  </tr>
  <tr>
    <td align="center">설명</td>
    <td><textarea rows="4" cols="50" name="bigo" required></textarea></td>
  </tr>
    <td colspan="2">
      <input type="submit" value="등록" /> 
    </td>
  <tr>
  </tr>
</table>
</form>

<a href="CateSelectAll.do">[모두보기]</a>

</body>
</html>
