<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>장바구니</title>
    <link rel="stylesheet" href="css/PaySelectAll.css" />
</head>
<body>
    <h1 id="title">쇼핑 307 주문하기</h1>
    
    <!-- 나중에 jstl forEach로 구현하기 -->
    <table id="payTable">
        <tr>
            <td><input type="checkbox" name="" id=""></td>
            <td>전체선택</td>
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
        <input type="button" value="쇼핑페이지로" class="btn">
        <input type="button" value="선택상품삭제" class="btn">
    </div>

    <h2>배송 정보</h2>
    <table id="orderInfoTable">
        <tr>
            <td style="width: 10%;">받으시는 분</td>
            <td><input type="text" name="" id=""></td>
        </tr>
        <tr>
            <td style="width: 10%;">우편번호</td>
            <td><input type="text" name="" id=""></td>
        </tr>
        <tr>
            <td style="width: 10%;">주소</td>
            <td>
                <input type="text" name="" id="">기본주소<br>
                <input type="text" name="" id="">나머지주소
            </td>
        </tr>
        <tr>
            <td style="width: 10%;">휴대전화</td>
            <td><input type="tel" name="" id=""></td>
        </tr>
        <tr>
            <td style="width: 10%;">결제수단</td>
            <td>
                <input type="radio" name="cashOrCard" id="">카드&nbsp;&nbsp;&nbsp;
                <input type="radio" name="cashOrCard" id="">무통장입금
            </td>
        </tr>
    </table>
    <div id="allPrice">
        총 주문 금액: 150,000원
    </div>

    <div id="btns">
        <input type="button" value="선택상품주문" class="btn">
        <input type="button" value="전체상품주문" class="btn">
    </div>
</body>
</html>