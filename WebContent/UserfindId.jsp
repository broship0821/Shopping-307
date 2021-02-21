<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
 <%//비밀번호 및 아이디 성공 jsp
 request.setCharacterEncoding("utf-8");
 response.setCharacterEncoding("utf-8");
 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
text-align: center;
}
div{
margin-top: 15%;
}
h1{
font-size: 30px;
}
p{
font-size: 15px;
}
</style>
</head>
<body>
<div>
<h1>쇼핑 307</h1>
<c:choose>
<c:when test="${id ne null}">
<p>회원님의 아이디는 ${id} 입니다.</p>
</c:when>
<c:when test="${pw ne null }">
<p>회원님의 비밀번호는 ${pw} 입니다.</p>
</c:when>
</c:choose>
<button type="button" onclick="location.href='UserLogin.jsp'">로그인</button>
</div>
</body>
</html>