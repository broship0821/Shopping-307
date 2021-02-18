<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
 <script type="text/javascript">
    
        // 필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수
        function checkValue()
        {
            if(!document.form1.Id.value){
                alert("아이디를 입력하세요.");
                return false;
            }
            
            else if(document.form1.idclick.value !="iduncheck"){
            	alert("아이디 중복체크를 해주세요")
            	return false;
            }
            
            else if(!document.form1.pw.value){
                alert("비밀번호를 입력하세요.");
                return false;
            }
            else if(!document.form1.name.value){
                alert("이름을 입력하세요.");
                return false;
            }
            else if(!document.form1.phone.value){
                alert("전화 번호를 입력하세요");
                return false;
            }
            else if(!document.form1.zip.value){
                alert("우편번호를 입력하세요.");
                return false;
            }
            else if(!document.form1.address.value){
                alert("주소를 입력하세요.");
                return false;
            }
             else if(document.form1.check1.checked != true){
            	alert("14세 이상만 가입가능합니다.")
            	return false;
            }
             else if(document.form1.check2.checked != true){
             	alert("개인 정보 동의에 체크해주세요")
             	return false;
             }
            else{
            	document.form1.action = "Join.do";
            	document.form1.submit();
            }
        }
        
        
        // 취소 버튼 클릭시 로그인 화면으로 이동
        function goLoginForm() {
            location.href="UserLogin.jsp";
        }
        
        
        //중복 검사 클릭시 확인 후 중복 검사 창 띄움
        function Idcheck(){
        	if(!document.form1.Id.value){
        		alert("아이디를 입력 해주세요")
        	}
        	else{
        	var id = document.getElementById('Id').value;
        	url = "userJoinidcheck.jsp?Id="+id;
        	window.open(url,"get","width=500,height=600");
        	}
        }
        
    </script>
<style>

#Logo{
font-size: 50px
}
</style>
</head>
<body>
<h1 align="center" id="Logo">쇼핑 307</h1>
<h3 align="center">회원정보를 입력해주세요</h3>

<form name="form1" method="get">
<table border="0" width="400px" align="center">
<tr>
<td>아이디</td>
<td><input type= "text" name="Id" id="Id">
<input type="button" value="중복확인" onclick="Idcheck()">
<input type="hidden" name="idclick" value="iduncheck">
</td>
<% %>
</tr>
<tr>
	<td>비밀번호</td>
	<td><input type="password" name="pw" ></td>
</tr>
<tr>
<td>이름</td>
<td><input type="text" name="name"></td>
</tr>
<tr>
<td>핸드폰번호</td>
<td><input type="text" name="phone"></td>
</tr>
<tr>
<td>우편번호</td>
<td><input type="text" name="zip"></td>
</tr>
<tr>
<td> 주소</td>
<td><input type="text" name="address"></td>
</tr>
</table>
<br>
<div align="center">
서비스 약관에 동의해 주세요
</div>      <!-- 체크박스 만들기 -->
<div  class= "checkbox_group" align="center">
<input type="checkbox" name="check1" class=nomal>
만 14세 이상입니다.
<br>
<input type="checkbox" name="check2" class=nomal>
개인정보 제공 동의
<br><br>
<button  align="center" type="button" name="btnjoin" onclick="checkValue()"> 동의하고 가입하기</button>
<button align="center" type="button" name="btnreset" onclick="goLoginForm()">취소</button>
</div>
</form>
</body>
</html>