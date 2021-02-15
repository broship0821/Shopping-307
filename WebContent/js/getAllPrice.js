const priceArr = document.querySelectorAll(".price");

let allPrice = 0;

priceArr.forEach(e => allPrice += (e.innerText.trim()*1));

document.getElementById("allPrice").innerHTML="총 주문 금액: "+allPrice+"원";