<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!--スレッド投稿用-->
    
<html id="top background-brack" lang="ja">
    <head>
        <meta charset="Windows-31J">
        <title>TADANO掲示板</title>
    <!-- CSS -->
    <link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
    <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        
    <h1>TADANO掲示板</h1>
    <h2 id="th">投稿スペース</h2>
        <form action="ThreadServlet" method="POST">
        <table border="1">
            <tr>
                <th>タイトル</th><td><textarea name="Thread_Title" rows="5" cols="50" maxlength="100" required></textarea></td></tr>
            <tr><th>スレ主</th><td><input type="text" size="20" maxlength="20" value="名もなき民" name="Thread_User" required></td>
            </tr>
        </table>
        <input class="submit-button"type="submit" VALUE="投稿">
        </form>
        <br>
        <h2>これまでのスレッド</h2>
        <table border="1">
            <tr></th><th>スレッドID</th><th>タイトル</th><th>日付</th><th>スレ主</th></tr>
            <c:forEach var="_threads" items="${threads}">
                <tr>
                <td><a href="ResponseServlet?id=${_threads.threadID}">>>${_threads.threadID}</a></td>
                <td>${_threads.threadTitle}</td>
                <td>${_threads.threadDate}</td>
                <td>${_threads.threadUser}</td>
                </tr>
            </c:forEach>
        </table>
        <h3>最新の10件</h3>
<table border="1">
            <tr></th><th>スレッドID</th><th>レス民</th><th>レス内容</th><th>日付</th></tr>
            <c:forEach var="_new" items="${newlist}">
                <tr>
                <td><a href="ResponseServlet?id=${_new.threadID}">>>${_new.threadID}</a></td>
		<td>${_new.resUser}</td>
		<td>${_new.resComment}</td>
		<td>${_new.resDate}</td>
                </tr>
            </c:forEach>
</table>
        <a href="#th">投稿場所へ↑</a>
        <br>
	<a href="http://localhost:8080/RJP_WEB/searchlist">→スレッド検索ページへ</a>
    </form>
    </body>
</html>