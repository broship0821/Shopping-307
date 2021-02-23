<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String error = (String) request.getAttribute("error");
pageContext.setAttribute("error", error);

%>
<!-- 로그인 화면을 구성 한 jsp파일입니다. -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
function loginClick() {
	if (!document.form1.userId.value) {
		alert("아이디를 입력 하세요.");
		$("#userId").focus(); //이렇게 하면 입력 포커스로 이동함
		return;
	}
	if (!document.form1.userPw.value) {
		alert("비밀번호를 입력 하세요");
		$("#userPw").focus();
		return;

	}
	document.form1.action = "UserLogin.do";
	document.form1.submit();
};

function Search() {
	location.href= "UserId_Pwfind.jsp";
	
};

function Join() {
	location.href= "JoinMembership.jsp";
}


</script>
<style>
h1{
margin-top: 10%;
}

#button{
padding-top:  20px;
}
</style>
</head>
<body>
<a href="mainMenu.html">[메인페이지로]</a>
	<h1 align="center">쇼핑 307</h1>
	<form name="form1" method="get">
		<table border="0" width="400px" align="center">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userId" id="userId"></td>
				
				
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="userPw" id="userPw"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center" id="button">
					<button type="button" id="btnSearch" onclick="Search()">ID/암호 찾기</button>
					<button type="button" id="btnLogin" onclick="loginClick()">로그인</button>
					<button type="button" id="btnJoin" onclick="Join()">회원가입</button>
					
				</td>
				
			</tr>
			
		</table>
		<c:if test="${error  eq '아이디 없거나 비밀번호가 맞지 않습니다.'}">
			<p style="color: red; text-align: center;" >
			<%=error %>
			</p>
			</c:if>
	</form>
	
</body>
</html>