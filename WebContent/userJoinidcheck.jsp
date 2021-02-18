<%@page import="com.team1.shopping307.DAO.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
String id = request.getParameter("Id");
UserDAO dao = new UserDAO();
boolean idcheck = dao.idcheck(id);
%>
<title>Insert title here</title>
<style>
*{
margin: 0px;
padding: 0px;
list-style: none;
text-decoration: none;
border-collapse: collapse;
}
h1{
text-align: center;
padding-top: 25%;
}
p{
text-align: center;
font-size: 20px;
}
#na{
color: green;
text-align: center;
font-size: 40px;
}
div{
text-align: center;
}
</style>
</head>
<body>
<h1>쇼핑 307</h1>
<br />
<p>아이디</p>
<p id="na"><%=id%></p>
<div>
<%
if(idcheck){
	out.println(" 는 이미 사용 중입니다.");}
else{
		out.println(" 는 사용 할수 있습니다");
	}
%>
<br />
<input type="button" value="닫기" onclick="self.close()">
</div>
</body>
</html>