<%@page import="com.team1.shopping307.controller.Common"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>장바구니</title>
    <link rel="stylesheet" href="css/BagSelectAll.css" />
    <style>
    #title{
    text-align: center;
}



#bagTable{
    text-align: center;
    width: 100%;
    border-collapse:collapse;
    
}

#bagTable td{
    border-top: 1px solid black;
    border-bottom: 1px solid black;
    height: 50px;
}

#allPrice{
    text-align: center;
    height: 50px;
}

#btns{
    text-align: center;
    
}

.btn{
    margin: 30px;
    width: 150px;
    height: 40px;
    border: 1px solid skyblue;
    background-color: skyblue;
    color: white;
}
    </style>
</head>
<body>
    <h1 id="title">쇼핑 307 장바구니</h1>
    <div id="bagImg"><img src="image/shopping-cart.png" alt="쇼핑카트"></div>
    
    <form method="post">
	    <table id="bagTable">
	        <tr>
	            <td><input type="checkbox" name="" id="selectAllBox"></td>
	            <td>이미지</td>
	            <td>상품명</td>
	            <td>수량</td>
	            <td>상품금액</td>
	        </tr>
	        <c:forEach var="bagVO" items="${bagList}">
	        	<tr>
		            <td><input type="checkbox" name="prodNo" class="box" value="${bagVO.getBagNo()}"></td>
		            <td><img src="<%=Common.strUpload%>/${bagVO.getImage1()}" alt="상품사진들어갈곳" height="100"></td>
		            <td>${bagVO.getProdName()}</td>
		            <td>${bagVO.getProdCnt()}</td>
		            <td>
		            	<span class="price">
				            ${bagVO.getProdCnt()*bagVO.getProdPrice()}
		            	</span>
		            	원
		            </td>
	        	</tr>
	        </c:forEach>
	    </table>
	    <div id="btns">
	        <a href="ProdUserSelectAll.do"><input type="button" value="계속 쇼핑하기" class="btn"></a>
	        <input type="submit" value="선택상품삭제" class="btn" formaction="BagDelete.do">
	        <a href="BagDeleteAll.do"><input type="button" value="장바구니비우기" class="btn"></a>
	    </div>
	    <div id="allPrice">
	        총 주문 금액: 0원
	    </div>
	    
	    <div id="btns">
	    	<input type="hidden" name="productId" value="${bagVO.getProductID()}"><!-- 상품아이디는 적어놓진 않지만 구매때 보내야됨 -->
	        <input type="submit" value="선택상품주문" class="btn" formaction="">
	        <input type="submit" value="전체상품주문" class="btn" formaction="">
	    </div>
    </form>
</body>
<script src="js/selectAllBox.js"></script>
<script src="js/getAllPrice.js"></script>
</html>