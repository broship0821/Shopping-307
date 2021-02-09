<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>쇼핑307</title>
<style>
hr {
display:block;
width:100%;
}

span {

}

.container {
width:480px;
text-align:center;
margin:0 auto;
}

.revuSeach {
width:200px;
text-align:left;
}

.revuSearch>h2 {
text-align:left;
font-weight:normal;
}
.revuSearch img{
width:200px;
text-align:left;
}

.revuResult {
width:480px;
text-align : center;
}

.revuResult p {
width:200px;
text-align: left;
}


p.imgSr {
text-align: left;
}

#star3 {
width:480px;
}

input[type="button"] {
width:200px;
height:43px;
color:white;
background-color:#14A1EE;
border-radius:5px;
border:none;
}

#revuTble {
width:480px;
padding:2px;
text-align:center;
}

p#imgSr, p#sangname {
width:160px;
display:inline-block;
text-align:left;
float:left;
}

#revu {
width:150px;
display:inline-block;
float:left;

}

#revu .star {
width:150px;
height:100%;
padding-bottom:20px;
display:inline-block;
text-align:left;
float:left;
}


</style>
</head>
<body>

<div class="container">
	<header>
		<h1>쇼핑 307</h1>
	</header>
	<section>
		<div class="revuSearch">
			<h2>구매후기</h2>
			<hr>
			<p id="imgSr"><img src="" alt="이미지없음"></p>
			<p id="sangname">상품명</p><br>
		</div>
		<div class="revuResult">
			<table id="revuTble">
			<tr>
				<td colspan="2"><hr><p id="star1">별점</p><hr></td>
			</tr>
			<tr id="revu">
				<td><span class="star">구매후기</span><br></td>
				<td><span class="star">나랏말싸미 어쩌구</span></td>
			</tr>
			<tr>
				<td><span><input type="button" value="삭제"></span></td>
				<td><span><input type="button" value="수정"></span></td>
			</tr>
			</table>
		</div>
	</section>
</div>



</body>
</html>