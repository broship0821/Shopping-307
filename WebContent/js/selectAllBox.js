//제일 위에 있는 체크박스
const selectAllBox = document.querySelector("#selectAllBox");
//나머지 모든 체크박스들
const boxs = document.querySelectorAll(".box");

//전체선택,전체선택해제 기능 구현
function selectAll(){
    if(selectAllBox.checked)
        boxs.forEach(box=>box.checked = true);
    else
        boxs.forEach(box=>box.checked = false);
}

selectAllBox.addEventListener('click',selectAll);