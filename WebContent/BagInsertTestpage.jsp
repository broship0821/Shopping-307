<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>옷 상세보기</title>
    <link rel="stylesheet" href="css/ProdSelectOne.css" />
    <style>
    body {
	    text-align: center;
	}
	
	img{
	    border: 1px solid black;
	}
	
	table{
	    margin-left: auto;
	    margin-right: auto;
	}
    </style>
</head>
<body>
    <h1>쇼핑307 </h1>
    <img src="image/fashion-1623085_1920.jpg" alt="상품사진" width="300">
    <form action="BagInsert.do" method="POST">
        <table>
            <tr>
                <td colspan="2"><b>프리미엄 니트</b></td>
            </tr>
            <tr>
                <td>판매가</td>
                <td>87,000원</td>
            </tr>
            <tr>
            	<td>수량</td>
            	<td><input type="number" name="prodCnt" value="1"></td>
            </tr>
            <tr>
                <td>사이즈</td>
                <td>
                    <select name="prodSize" id="size" size="1">
                        <option value="S">S</option>
                        <option value="M">M</option>
                        <option value="L">L</option>
                        <option value="XL">XL</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="hidden" name="prodName" value="프리미엄 니트">
                    <input type="hidden" name="prodPrice" value="87000">
                    <input type="submit" value="장바구니 담기">
                </td>
            </tr>
            <tr>
            	<td colspan="2">
            		<br><br>
            		<a href="BagSelectAll.do"><input type="button" value="장바구니 보러가기"></a>
            	</td>
            </tr>
        </table>
    </form>
</body>
</html>