<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑 307</title>
<style>
* {
margin:0;
padding:0;
}

h1 {
text-align:center;
margin-top:20px;
}

 .tbl {
   width:100%;
   width:800px;
   margin:0 auto;
   margin-top:20px;
   border-collapse:collapse;
}
.tbl td{
    border-bottom: 1px solid gray;
    height: 30px;
}

input[type=text ]{
border : 0px solid #ededed;
padding:5px;
}

</style>
</head>
<body>

<a href="mainMenu.html">[메인페이지로]</a>
<div class="container">
   <form action="" method="get">
   <div class="row">
      <div class="header"><h1>쇼핑 307</h1></div>
      <table class="tbl" style="text-align:center; border:1px solid #ededed; ">
         <tr style="background-color:#ededed;">
            <th style=" text-align:center;">상품명</th>
            <th style="text-align:center; ">제목</th>
            <th style=" text-align:center;">작성자</th>
            <th style=" text-align:center;">별점</th>
            <th style=" text-align:center;">작성날짜</th>
         </tr>
         <c:forEach var="i" items="${list}">
         <tr>
            <td>${i.productName }</td>
            <td><a href="RevuSelectOne.do?id=${i.reviewId }">${i.title }</a></td>
            <td>${i.userId }</td>
            <td>${i.star }/5</td>
            <td>${i.cDate }</td>
         </tr>
         </c:forEach>
      </table>
   </div>
   </form>
</div>
</body>
</html>