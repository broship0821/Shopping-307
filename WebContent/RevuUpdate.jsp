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
			<tr><td colspan="2"><b>구매후기 수정</b></td></tr>
			<tr>
				<td>상품명</td>
				<td>${r.productName}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" value="${r.title}" name="title" required></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${r.userId}</td>
			</tr>
			<tr>
				<td>구매후기</td>
				<td><textarea required name="content">${r.content}</textarea></td>
			</tr>
			<tr>
				<td>별점</td>
				<td><input type="number" name="star" size="20" min="1" max="5" length="20" value="${r.star}" required /></td>
			</tr>
			<tr>
				<td><a href="RevuSelectAll.do"><input type="button" value="후기 페이지로"></a></td>
				<td>
					<input type="hidden" name="reviewID" value="${reviewID}">
					<input type="submit" value="수정하기" formaction="RevuUpdateResult.do">
				</td>
			</tr>
		</table>
	</form></body>
</html>