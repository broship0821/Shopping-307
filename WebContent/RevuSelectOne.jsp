<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쇼핑307</h1>
	<form method="post">
		<table border="1">
			<tr><td colspan="2"><b>구매후기</b></td></tr>
			<tr>
				<td>상품명</td>
				<td>${r.productName}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${r.title}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${r.userId}</td>
			</tr>
			<tr>
				<td>구매후기</td>
				<td>${r.content}</td>
			</tr>
			<tr>
				<td>별점</td>
				<td>${r.star}/5</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${r.cDate}</td>
			</tr>
			<tr>
				<td><a href="RevuSelectAll.do"><input type="button" value="후기 페이지로"></a></td>
				<td><input type="submit" value="삭제" formaction="RevuDelete.do?id=${r.reviewId}"></td>
			</tr>
		</table>
	</form>
</body>
</html>