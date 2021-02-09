<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>장바구니</title>
    <!-- <link rel="stylesheet" href="css/BagSelectAll.css" /> -->
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
    
    <!-- 나중에 jstl forEach로 구현하기 -->
    <table id="bagTable">
        <tr>
            <td><input type="checkbox" name="" id=""></td>
            <td>전체선택</td><!-- js로 구현 -->
            <td>상품명</td>
            <td>수량</td>
            <td>상품금액</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="" id=""></td>
            <td><img src="" alt="상품사진들어갈곳"></td>
            <td>라이크 울 셔츠 (멜란지 오프화이트)[옵션: M(100~105)]</td>
            <td>1</td>
            <td>75,000원</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="" id=""></td>
            <td><img src="" alt="상품사진들어갈곳"></td>
            <td>라이크 울 셔츠 (멜란지 오프화이트)[옵션: M(100~105)]</td>
            <td>1</td>
            <td>75,000원</td>
        </tr>
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
</html>
<!-- 
    기능 구현해야 할것들
    1. '장바구니담기' 버튼을 클릭하면 상품VO를 세션에 담음
    2. 장바구니 화면에 오면 세션에 저장된 상품VO들을 꺼내와서 jstl로 table에 출력
    3. 상품 VO들의 금액을 다 더해서 총 주문금액에 넣기
    4. 계속 쇼핑하기를 누르면 이전 상품 페이지로 이동시키기
    5. 주문하기를 누르면 결제 화면으로 이동(결제 화면도 만들어야겠네...)
    6. 장바구니 전체선택
    7. 장바구니 CRUD
    등....


    버리기 버튼, 결제 화면 만 더 만들면 되나?

 -->