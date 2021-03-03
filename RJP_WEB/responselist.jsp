<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" errorPage="/error.jsp"%>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<meta charset="Windows-31J">
	<!--<script>
		function anker(id_name){
			obj = document.getElementByID(id_name);
			y= obj.offsetTop;
			scrollTo(0.y);
		}
	</script>-->
	<!-- CSS -->
	<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
	<link href="css/style.css" rel="stylesheet">

<title>
	<c:forEach var="_responses" items="${r_list}">
		${_responses.threadTitle}�X���b�h
	</c:forEach>
</title>
</head>

<body>
	<h2>     </h2>
	<h1 id="��ɖ߂遪">TADANO�f����</h1>
	<h2>
		<c:forEach var="_responses" items="${r_list}">
			${_responses.threadTitle}�X���b�h
		</c:forEach>
	</h2>
	<form method="POST" action="ResponseServlet?id=${t_id}">
	<table border="1">
		<tr><th>�X���b�hID</th><th>�X����</th><th>�쐬��</th></th></tr>
		<c:forEach var="_responses" items="${r_list}">
		<tr>
			<td>${_responses.threadID}</td>
			<td>${_responses.threadUser}</td>
			<td>${_responses.threadDate}</td>
		</tr>
	</c:forEach>
	</table>
	<h3>�����݂̋֎~�p��y"����","���܂˂�","�ʂ˂�","������","�e","rabbit"�z</h3>
	<br>
	<table>
		<!--<tr><th>���XID</th><th>���t</th><th>���O</th><th>�R�����g</th></tr>-->
		<c:forEach var="responses" items="${responses}">
			<tr>
				<td><a id="anker1" >${responses.resID}:</a>[${responses.resUser}]�E�E�E${responses.resDate}�E�E�E</td>
			</tr>
			<tr>
				<td>${responses.resComment}</td>
			</tr>
			<tr></tr><tr></tr><tr></tr>
		</c:forEach>
	</table>
	<br>
	<a href="#��ɖ߂遪">��ɖ߂遪</a>
	<br>
	<br><br>
	<table border="1">
		<tr>
		<th>���[�U�[��</th>
			<td><input type="text" size="20" maxlength="20" value="�����Ȃ���" name="Res_User" required></td></tr>
		
		<tr><th>�R�����g</th>
			<td><textarea name='Res_comment' cols="100" rows="10"  wrap="hard" required></textarea></td>
		</tr>
		
	</table>
	<input class="submit-button" type='submit' value='���e'><br>
	</form>
	<a href="http://localhost:8080/RJP_WEB/ThreadServlet">���X���b�h�ꗗ�ɖ߂�</a>

</body>
</html>