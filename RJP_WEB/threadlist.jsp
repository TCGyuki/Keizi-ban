<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!--�X���b�h���e�p-->
    <html>
    <head>
        <title>TADANO�f����</title>
    </head>
    <body>
    <h1>TADANO�f����</h1>
    <h2 id="th">���e</h2>
        <form action="ThreadServlet" method="POST">
        <table border="1">
            <tr>
                <th>�^�C�g��</th><td><textarea name="Thread_Title" rows="5" cols="50" maxlength="100" required></textarea></td></tr>
            <tr><th>�X����</th><td><input type="text" size="20" maxlength="20" value="�����Ȃ���" name="Thread_User" required></td>
            </tr>
        </table>
        <br>
        <input type="submit" VALUE="���M">
        </form>
        <br>
        <br>
        <h2>�쐬���ꂽ�X���b�h�ꗗ</h2>
        <table border="1">
            <tr></th><th>�X���b�hID</th><th>�^�C�g��</th><th>���t</th><th>�X����</th></tr>
            <c:forEach var="_threads" items="${threads}">
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
        <br>
        <a href="#th">���e�ꏊ�ց�</a>
    </form>
    </body>
    </html>