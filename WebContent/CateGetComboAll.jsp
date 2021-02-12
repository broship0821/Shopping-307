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
    <select name="<%=Common.strCateComboName%>">
      <c:forEach var="item" items="${requestScope.lstAll}">
        <c:set var="param1" value="TelOneInfo.do?id=${i.id}" />    
        <option value="${item.name}">${item.name}</option>
      </c:forEach>
    </select>
   </div>

</body>
</html>
