<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<script>
		function anker(id_name){
			obj = document.getElementByID(id_name);
			y= obj.offsetTop;
			scrollTo(0.y);
		}
	</script>
<style type="text/css">
<!--
textarea {
  resize: none;}
</style>
<title><c:forEach var="_responses" items="${r_list}">
	${_responses.threadTitle}スレッド
</c:forEach></title>
</head>
<body>
	<a href="http://localhost:8080/RJP_WEB/ThreadServlet">←スレッド一覧へ</a>
	<h1 id="上に戻る↑">TADANO掲示板</h1>
	<h2>
		<c:forEach var="_responses" items="${r_list}">
			${_responses.threadTitle}スレッド
		</c:forEach>
	</h2>
	<form method="POST" action="ResponseServlet?id=${t_id}">
	<br>
	<table border="1">
		<tr><th>スレッドID</th><th>スレ主</th><th>作成日</th></th></tr>
		<c:forEach var="_responses" items="${r_list}">
		<tr>
			<td>${_responses.threadID}</td>
			<td>${_responses.threadUser}</td>
			<td>${_responses.threadDate}</td>
		</tr>
	</c:forEach>
	</table>
	<br>
	<table>
		<!--<tr><th>レスID</th><th>日付</th><th>名前</th><th>コメント</th></tr>-->
		<c:forEach var="responses" items="${responses}">
			<tr>
				<td><a id="anker1" >${responses.resID}:</a>[${responses.resUser}]</td></tr>
			<tr>
				<td>${responses.resComment}</td>
				<td>・・・${responses.resDate}・・・</td>
			</tr>
			<tr></tr><tr></tr><tr></tr>
		</c:forEach>
	</table>
	<br>
	<a href="#上に戻る↑">上に戻る↑</a>
	<br>
	<br><br>
	<table border="1">
		<tr>
		<th>ユーザー名</th>
			<td><input type="text" size="20" maxlength="20" value="名もなき民" name="Res_User" required></td></tr>
		
		<tr><th>コメント</th>
			<td><textarea name='Res_comment' cols="100" rows="10"  wrap="hard" required></textarea></td></tr>
		<input type='submit' value='投稿'><br>
	</table>
	</form>
	<a href="http://localhost:8080/RJP_WEB/ThreadServlet">スレッド一覧に戻る</a>

</body>
</html>