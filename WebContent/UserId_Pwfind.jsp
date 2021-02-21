<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%
     request.setCharacterEncoding("utf-8");
     response.setCharacterEncoding("utf-8");
     /* 비밀번호 찾기 jsp
    String error= (String) request.getAttribute("error");
     String error1 = (String) request.getAttribute("error1"); */
     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디,비밀번호 찾기</title>
<script>
	function buttonId(){
		if(!document.form1.name.value){
			alert("이름을 입력하세요.");
			$("#name").focus(); //이렇게 하면 입력 포커스로 이동함
			return;
		}
		if(!document.form1.phone.value){
			alert("핸드폰 번호를 입력 하세요.");
			$("#phone").focus(); //이렇게 하면 입력 포커스로 이동함
			return;
		}
		document.form1.action="UserfindId.do";
		document.form1.submit();
	};
	
	function buttonPw(){
		if(!document.form2.name1.value){
			alert("패스워드를 찾으실려면 이름을 입력 하세요.");
			$("#name1").focus(); //이렇게 하면 입력 포커스로 이동함
			return;
		}
		if(!document.form2.userID.value){
			alert("패스워드를 찾으실려면 이름을 입력 하세요.");
			$("#userID").focus(); //이렇게 하면 입력 포커스로 이동함
			return;
		}
		document.form2.action="UserfindPw.do";
		document.form2.submit();
	};


 </script>
<style >
#buttonid{
border: 1px solid blue;
border-top-left-radius: 5px;
border-top-right-radius: 5px;
border-bottom-left-radius: 5px;
border-bottom-right-radius: 5px;
margin-left: -4px;
margin-right: -3px;
background-color: rgba(0,0,0,0);
color: black;
padding: 5px;
}

#buttonpw{
border: 1px solid blue;
border-top-left-radius: 5px;
border-top-right-radius: 5px;
border-bottom-left-radius: 5px;
border-bottom-right-radius: 5px;
margin-left: -4px;
margin-right: -3px;
background-color: rgba(0,0,0,0);
color: black;
padding: 5px;
}
#buttonid:hover{
color: white;
background-color: gray;
}

#buttonpw:hover{
color: white;
background-color: gray;
}
</style>
</head>
<body>
<h1 align="center" style="font-size: 40px">쇼핑307</h1>
<table border="0" align= "center">
<tr>
<td style="text-align: center;">아이디 찾기/ 패스워드 찾기</td>
</tr>
</table>
<br>
<form  name="form1">
<table border="0" width="400" align="center">
<tr>
<td style="text-align:center; width: 100px; ">이름</td>
<td style="text-align: left;"><input type="text" name="name" id="name" required></td>
</tr>
<tr>
<td style="text-align: center;">휴대번호 </td>
<td style="text-align: left; "><input type="text" name="phone" id="phone" required></td>
</tr>
<tr>
<td colspan="2" align="center">
<button type="button" id=buttonid name="butionid" onclick="buttonId()">아이디 찾기</button>
</tr>
<c:if test="${error ne null}">
<p style="color: red; text-align: center;">${error}</p>
</c:if>
</table>
</form>
<br>
<form name="form2">
<table border="0" width="400" align="center">
<tr>
<td style="text-align: center; width: 100px;">이름</td>
<td style="text-align: left;"><input type="text" name="name1" id="name1" required></td>
</tr>
<tr>
<td style="text-align: center;">아이디 </td>
<td style="text-align: left;"><input type="text" name="userID" id="userID" required></td>
</tr>
<c:if test="${error1 ne null}">
<p style="color: red; text-align: center;">${error1}</p>
</c:if>
<tr>
<td colspan="2" align="center">
<button type="button" id=buttonpw onclick="buttonPw()">패스워드 찾기</button>
</tr>
</table>
</form>
</body>
</html>