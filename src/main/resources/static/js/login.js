
const urlParams = new URL(location.href).searchParams;
const message = urlParams.get('errorMessage');

if( !message ){
}else{
    if(message == "0"){
        alert("로그아웃되었습니다.")
    }else{
        if(message == "1"){
            alert("아이디 또는 비밀번호가 맞지 않습니다. 다시 확인해 주세요.")
        }else if(message == "2"){
            alert("내부적으로 발생한 시스템 문제...")
        }else if(message == "3"){
            alert("계정이 존재하지 않습니다. 회원가입 진행 후 로그인 해주세요.")
        }else if(message == "4"){
            alert("인증 요청이 거부되었습니다.")
        }else{
            alert("관리자에게 문의 주세요.")
        }
    }
}