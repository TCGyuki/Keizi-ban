<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!--�X���b�h���e�p-->
    
<html id="top background-brack" lang="ja">
    <head>
        <meta charset="Windows-31J">
        <title>TADANO�f����</title>
    <!-- CSS -->
    <link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
    <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        
    <h1>TADANO�f����</h1>
    <h2 id="th">���e�X�y�[�X</h2>
        <form action="ThreadServlet" method="POST">
        <table border="1">
            <tr>
                <th>�^�C�g��</th><td><textarea name="Thread_Title" rows="5" cols="50" maxlength="100" required></textarea></td></tr>
            <tr><th>�X����</th><td><input type="text" size="20" maxlength="20" value="�����Ȃ���" name="Thread_User" required></td>
            </tr>
        </table>
        <input class="submit-button"type="submit" VALUE="���e">
        </form>
        <br>
        <h2>����܂ł̃X���b�h</h2>
        <table border="1">
            <tr></th><th>�X���b�hID</th><th>�^�C�g��</th><th>���t</th><th>�X����</th></tr>
            <c:forEach var="_threads" items="${threads}">
                <tr>
                <td><a href="ResponseServlet?id=${_threads.threadID}">>>${_threads.threadID}</a></td>
                <td>${_threads.threadTitle}</td>
                <td>${_threads.threadDate}</td>
                <td>${_threads.threadUser}</td>
                </tr>
            </c:forEach>
        </table>
        <h3>�ŐV��10��</h3>
<table border="1">
            <tr></th><th>�X���b�hID</th><th>���X��</th><th>���X���e</th><th>���t</th></tr>
            <c:forEach var="_new" items="${newlist}">
                <tr>
                <td><a href="ResponseServlet?id=${_new.threadID}">>>${_new.threadID}</a></td>
		<td>${_new.resUser}</td>
		<td>${_new.resComment}</td>
		<td>${_new.resDate}</td>
                </tr>
            </c:forEach>
</table>
        <a href="#th">���e�ꏊ�ց�</a>
        <br>
	<a href="http://localhost:8080/RJP_WEB/searchlist">���X���b�h�����y�[�W��</a>
    </form>
    </body>
</html>