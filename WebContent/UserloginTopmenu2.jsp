<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
   <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script  src="http://code.jquery.com/jquery-latest.min.js">
회원가입시 메인 화면상단에 나올 jsp
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
가입에 성공 하셨습니다 환영 합니다. 하지만 로그인이 필요합니다 로그인 해주세요
<button type="button" onclick="location.href='UserLogin.jsp'">로그인</button>
<button type="button" onclick="location.href='UserLogout.do' ">로그아웃</button>
</div>

<hr>
</body>
</html>