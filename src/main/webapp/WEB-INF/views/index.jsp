<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp" flush="false" />
<div class="container">
<h1>
	방명록 페이지
</h1>
<form action="add" method="post">
	<label>ID</label><input type="text" name="id" placeholder="아이디"><br>
	<label>Password</label><input type="password" name="passwd" placeholder="패스워드"><br>
	<label>Content</label><input type="text" placeholder="방명록에 글 남기기">
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
		<tr>
			<td>김준태</td>
			<td>하하</td>
			<td>오늘</td>
			<td>
				<button type="button" class="btn btn-default">수정</button>
				<button type="button" class="btn btn-default">삭제</button>
			</td>
		</tr>
		<tr>
			<td>
				<form action="modify" method="post">
					<input type="hidden" name="id" value="">
					<label>Content</label><input type="text" placeholder="방명록에 글 남기기">
					<label>Password</label><input type="password" name="passwd" placeholder="패스워드"><br>
					<button type="submit">수정</button>
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<form action="remove" method="post">
					<input type="hidden" name="id" value="">
					<label>Password</label><input type="password" name="passwd" placeholder="패스워드"><br>
					<button type="submit">삭제</button>
				</form>
			</td>
		</tr>
	</tbody>
</table>
</div>
</body>
</html>
