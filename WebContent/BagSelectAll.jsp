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
    
    
    <table id="bagTable">
        <tr>
            <td><input type="checkbox" name="" id="selectAllBox"></td>
            <td>이미지</td>
            <td>상품명</td>
            <td>수량</td>
            <td>상품금액</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="" class="box"></td>
            <td><img src="" alt="상품사진들어갈곳"></td>
            <td>라이크 울 셔츠 (멜란지 오프화이트)[옵션: M(100~105)]</td>
            <td>1</td>
            <td>75,000원</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="" class="box"></td>
            <td><img src="" alt="상품사진들어갈곳"></td>
            <td>라이크 울 셔츠 (멜란지 오프화이트)[옵션: M(100~105)]</td>
            <td>1</td>
            <td>75,000원</td>
        </tr>
        <c:forEach var="bagVO" items="${bagList}">
        	<tr>
	            <td><input type="checkbox" name="" class="box"></td>
	            <td><img src="" alt="상품사진들어갈곳"></td>
	            <td>${bagVO.getProdName()}, 사이즈:${bagVO.getProdSize()}</td>
	            <td>${bagVO.getProdCnt()}개</td>
	            <td>${bagVO.getProdPrice()}원</td>
        	</tr>
        </c:forEach>
    </table>
    <div id="btns">
        <input type="button" value="계속 쇼핑하기" class="btn">
        <input type="button" value="선택상품삭제" class="btn">
        <input type="button" value="장바구니비우기" class="btn">
    </div>
    <div id="allPrice">
        총 주문 금액: 150,000원
    </div>
    
    <div id="btns">
        <input type="button" value="선택상품주문" class="btn">
        <input type="button" value="전체상품주문" class="btn">
    </div>
</body>
<script src="js/selectAllBox.js"></script>
</html>