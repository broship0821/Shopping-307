<%@page import="com.team1.shopping307.controller.Common"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<%request.setCharacterEncoding("UTF-8");%>
<%response.setCharacterEncoding("UTF-8");%>

<h1>쇼핑 307</h1>
<p>리뷰 등록</p>
<form action="<%=Common.strRevuInsertDo %>" encType="multipart/form-data" method="post">
   <table border="2">
      <tr>
         <td>구매번호</td>
         <td><input type="text" name="pay_id" size="20" length="20" required /></td>
      </tr>
      <tr>
         <td>작성자 아이디</td>
         <td><input type="text" name="user_id" size="20" length="20" required /></td>
      </tr>
      <tr>
         <td>작성자 이름</td>
         <td><input type="text" name="user_name" size="20" length="20" required /></td>
      </tr>
      <tr>
         <td>상품 아이디</td>
         <td><input type="text" name="product_id" size="20" length="20" required /></td>
      </tr>
      <tr>
         <td>별점 수</td>
         <td><input type="number" name="star" size="20" min="1" max="5" length="20" required /></td>
      </tr>
      <tr>
         <td>후기 제목</td>
         <td><input type="text" name="title" size="20" length="20" required /></td>
      </tr>
      <tr>
         <td>후기 내용</td>
         <td><textarea rows="4" cols="50" name="bigo" required></textarea></td>
      </tr>
      <tr>
         <td>생성일</td>
         <td><input type="date" name="c_date" size="20" length="20" required /></td>
      </tr>
      <tr>
         <td>갱신일</td>
         <td><input type="date" name="u_date" size="20" length="20" required /></td>
      </tr>
      
   </table>
   
   <table border=0>
      <tr>
         <td><a href="RevuInsert.jsp">[입력]</a></td>
         <td><a href="RevuSelectAll.jsp">[모두보기]</a></td>
      </tr>
   </table>
   
</form>

</body>
</html>