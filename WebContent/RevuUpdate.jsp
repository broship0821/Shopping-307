<%@page import="com.team1.shopping307.VO.RevuVO"%>
<%@page import="com.team1.shopping307.DAO.RevuDAO"%>
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
<%
   RevuDAO RO = new RevuDAO();
   RevuVO VO = null;
   int reviewId = Integer.parseInt(request.getParameter("reviewId"));
   RO.update(VO, reviewId);

%>


<h1>쇼핑 307</h1>
<p>리뷰 수정</p>
<form action="<%=Common.strRevuUpdateDo %>" encType="multipart/form-data" method="post">
   <table border="2">
      <tr>
         <td>구매번호</td>
         <td><input type="text"  value="<%=VO.getPatId()%>"name="pay_id" size="20" length="20" required /></td>
      </tr>
      <tr>
         <td>작성자 아이디</td>
         <td><input type="text"  value="<%=VO.getUserId()  %>" name="user_id" size="20" length="20" required /></td>
      </tr>
      <tr>
         <td>작성자 이름</td>
         <td><input type="text"  value="<%=VO.getUserName()  %>" name="user_name" size="20" length="20" required /></td>
      </tr>
      <tr>
         <td>상품 아이디</td>
         <td><input type="text"  value="<%=VO.getProduct()  %>" name="product_id" size="20" length="20" required /></td>
      </tr>
      <tr>
         <td>별점 수</td>
         <td><input type="number"  value="<%=VO.getStar()  %>" name="star" size="20" min="1" max="5" length="20" required /></td>
      </tr>
      <tr>
         <td>후기 제목</td>
         <td><input type="text"  value="<%=VO.getTitle()  %>" name="title" size="20" length="20" required /></td>
      </tr>
      <tr>
         <td>후기 내용</td>
         <td><textarea rows="4"  value="<%=VO.getContent()  %>" cols="50" name="bigo" required></textarea></td>
      </tr>
      <tr>
         <td>생성일</td>
         <td><input type="date"  value="<%=VO.getcDate()  %>" name="c_date" size="20" length="20" required /></td>
      </tr>
      <tr>
         <td>갱신일</td>
         <td><input type="date"  value="<%=VO.getuDate()  %>" name="u_date" size="20" length="20" required /></td>
      </tr>
      <tr>
         <td colspan=2><input type="submit" value="[수정]" /></td>
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