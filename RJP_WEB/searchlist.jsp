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
    <h2 id="th">�X���b�h�����y�[�W</h2>
        <form action="SearchServlet" method="POST">
        <table border="1">
            <tr>
                <th>�^�C�g��</th><td><textarea name="Thread_Title" rows="5" cols="50" maxlength="100" required></textarea></td>
            </tr>
        </table>
        <input class="submit-button"type="submit" VALUE="����">
        </form>
        <br>
        <h2>��������</h2>
        <table border="1">
            <tr></th><th>�X���b�hID</th><th>�^�C�g��</th><th>���t</th><th>�X����</th></tr>
            <c:forEach var="_threads" items="${search}">
                <tr>
                <td><a href="ResponseServlet?id=${_threads.threadID}">>>${_threads.threadID}</a></td>
                <!--<td>${_threads.threadID}</td>-->
                <td>${_threads.threadTitle}</td>
                <td>${_threads.threadDate}</td>
                <td>${_threads.threadUser}</td>
                </tr>
            </c:forEach>
        <!--<p>���e</p>
            �^�C�g���F<input type="text" name="Thread_Title" size="40"><br>
            �쐬�Җ��F<input type="text" name="Thread_User" size="10">-->
        </table>
        <a href="#th">�������ց�</a>
    </form>
    <br>
	<a href="http://localhost:8080/RJP_WEB/ThreadServlet">���X���b�h�ꗗ�ɖ߂�</a>
    </body>
</html>