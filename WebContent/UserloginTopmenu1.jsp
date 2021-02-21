<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
   <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script  src="http://code.jquery.com/jquery-latest.min.js">
로그인을 하지 않았을경우 메인 상단에 표시 jsp
</script> -->

<style>
div{
text-align: right;
}
</style>
<script >
function logout(){
	document.btnlogout.action = "/LogOut.do";
}
</script>
</head>
<body>
<div>
<button type="button" onclick="location.href='UserLogin.jsp'">로그인</button>
<button type="button" onclick="location.href='UserLogout.do' ">로그아웃</button>
</div>

<hr>
</body>
</html>