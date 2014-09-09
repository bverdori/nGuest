// 방명록 입력에 대한 클라이언트 측 입력값 체크
$(document).ready(function() {
	// 입력시 E-mail, 비밀번호, 내용 입력 확인 (공백일 경우 경고창 생성)
	$("#addGuestbookForm").bind("submit", function () {
		var email_regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
		
		if ($(".addEmail").val().trim() == "") {
			alert("이메일주소를 입력해 주세요.");
			$(".addEmail").focus();
			return false;
		} else if ($(".addPasswd").val().trim() == "") {
			alert("비밀번호를 입력해 주세요.");
			$(".addPasswd").focus();
			return false;
		} else if ($(".addText").val().trim() == "") {
			alert("내용을 입력해 주세요.");
			$(".addText").focus();
			return false;
		} 
		// E-mail 형식 체크 (형식 불일치의 경우 경고창 생성)
		else if(!email_regex.test($(".addEmail").val().trim())){
			alert("이메일 형식을 맞춰 주세요.");
			$(".addEmail").focus();
			return false;
		}
		return true;
	});
	
	// 수정시 비밀번호, 내용 입력 확인 (공백일 경우 경고창 생성)
	$("#modifyGuestbookForm").bind("submit", function () {
		if ($(".modifyPasswd").val().trim() == "") {
			alert("비밀번호를 입력해 주세요.");
			$(".modifyPasswd").focus();
			return false;
		} else if ($(".modifyText").val().trim() == "") {
			alert("내용을 입력해 주세요.");
			$(".modifyText").focus();
			return false;
		}
		return true;
	});
	
	// 방명록 삭제 시 비밀번호 입력 확인 (공백일 경우 경고창 생성)
	$("#removeGuestbookForm").bind("submit", function () {
		if ($(".removePasswd").val().trim() == "") {
			alert("비밀번호를 입력해 주세요.");
			$(".removePasswd").focus();
			return false;
		}
		return true;
	});
});