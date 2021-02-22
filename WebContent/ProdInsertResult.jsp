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
<a href="mainMenu.html">[메인페이지로]</a>
<h3>${result}</h3>
<br /><br />

<form action="<%=Common.strProdSelectAllDo %>">
  <input type="submit" value="리스트" />
</form>

</body>
</html>