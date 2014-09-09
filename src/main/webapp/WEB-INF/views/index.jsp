<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title>nGuest</title>

	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0-wip/css/bootstrap.min.css">
</head>

<body>
	<div class="container">
		<h1>
			방명록 페이지
		</h1>
		
		<form action="add" method="post" id="addGuestbookForm">
			<label>E-mail</label>
			<input type="text" name="email" class="addEmail" placeholder="E-mail"><br>
			<label>Password</label>
			<input type="password" name="passwd" class="addPasswd" placeholder="패스워드"><br>
			<label>Content</label>
			<input type="text" name="text" class="addText" placeholder="방명록에 글 남기기">
			<button type="submit">작성</button>
		</form>

		<hr>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th>아이디</th>
					<th>내용</th>
					<th>작성일</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="guestbook" items="${guestbooks}" varStatus="status">
				<tr>
					<td>${guestbook.email}</td>
					<td>${guestbook.text}</td>
					<td>${guestbook.update}</td>
					<td>
						<button type="button" class="btn btn-default">수정</button>
						<button type="button" class="btn btn-default">삭제</button>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<form action="modify" method="post" id="modifyGuestbookForm">
							<input type="hidden" name="email" value="${guestbook.email}">
							<label>수정할 내용</label><input type="text" name="text" class="modifyText" value="${guestbook.text}">
							<label>Password</label><input type="password" name="passwd" class="modifyPasswd" placeholder="패스워드">
							<button type="submit">수정</button>
						</form>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<form action="remove" method="post" id="removeGuestbookForm">
							<label>삭제</label>
							<input type="hidden" name="email" value="${guestbook.email}">
							<label>Password</label><input type="password" name="passwd"  class="removePasswd" placeholder="패스워드">
							<button type="submit">삭제</button>
						</form>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0-wip/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="resources/js/validation.js"></script>
</body>
</html>
