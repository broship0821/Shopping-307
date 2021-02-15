<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
margin:0;
padding:0;
box-sizing:0;
}
ul {
list-style : none;
}
a {
text-decoration:none;
color:inherit;}


hr {
width:480px;
margin:0 auto;
text-align:center;
}
/*/////////////////////////////////////////////////*/

.container {
width:480px;
margin:0 auto;
margin-top:20px;
}

h1 {
margin-bottom:20px;
}

section {
width:480px;
padding-bottom:20px;
}

section ul {

}

section ul li {


}


.left {
width:160px;
height:20px;
display:inline-block;
float:left;
padding-top:10px;
padding-bottom:10px;
}

.right {
width:320px;
height:20px;
display:inline-block;
float:right;
padding-top:10px;
padding-bottom:10px;
}

.rightee {
width:160px;
height:20px;
display:inline-block;
float:right;
padding-top:10px;
padding-bottom:10px;

}

 a { 
margin-top:30px;
width:200px;
height:28px;
color:white;
background-color:#14A1EE;
border-radius:5px;
border:none;
float:left;
display:inline-block;
text-align:center;
padding:15px;
padding-top:15px;
}


.starR{
  background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat right 0;
  background-size: auto 100%;
  width: 20px;
  height: 20px;
  display: inline-block;
  text-indent: -9999px;
  cursor: pointer;
}
.starR.on{background-position:0 0;}

a.righta {
float:right;
}

</style>
</head>
<body>

<div class="container">
   <header>
      <h1>쇼핑 307</h1>
   </header>
   <section>
      <ul>
         <li>
            <h2>구매후기</h2>
            <hr>
         </li>
      </ul>
      <ul>
         <li class="left">제목</li>
         <li class="rightee">작성자 아이디</li>
         <li class="rightee">작성일</li>
         <hr>
      </ul>
      <ul>
         <li class="left"><img src="" alt="이미지없음"></li>
         <li class="right">상품명</li>
         <hr>
      </ul>
      <ul>
         <li class="left">별점</li>
         <li class="right">
            <div class="starRev">
                 <span class="starR on">별1</span>
                 <span class="starR">별2</span>
                 <span class="starR">별3</span>
                 <span class="starR">별4</span>
                 <span class="starR">별5</span>
            </div>
      </li>
         <hr>
      </ul>
      <ul>
         <li class="left">구매후기</li>
         <li class="right">내용어쩌구~</li>
         <hr>
      </ul>
      <ul>
         <li><a href="#">삭제</a></li>
         <li><a href="#" class="righta">수정</a></li>
      </ul>
      
      
   </section>
</div>

<script src="js/jquery-1.12.3.js"></script>
<script>
$('.starRev span').click(function(){
     $(this).parent().children('span').removeClass('on');
     $(this).addClass('on').prevAll('span').addClass('on');
     return false;
   });
   
</script>



</body>
</html>