<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!--スレッド投稿用-->
    <html>
    <head>
        <title>TADANO掲示板</title>
    </head>
    <body>
    <h1>TADANO掲示板</h1>
    <h2 id="th">投稿</h2>
        <form action="ThreadServlet" method="POST">
        <table border="1">
            <tr>
                <th>タイトル</th><td><textarea name="Thread_Title" rows="5" cols="50" maxlength="100" required></textarea></td></tr>
            <tr><th>スレ主</th><td><input type="text" size="20" maxlength="20" value="名もなき民" name="Thread_User" required></td>
            </tr>
        </table>
        <br>
        <input type="submit" VALUE="送信">
        </form>
        <br>
        <br>
        <h2>作成されたスレッド一覧</h2>
        <table border="1">
            <tr></th><th>スレッドID</th><th>タイトル</th><th>日付</th><th>スレ主</th></tr>
            <c:forEach var="_threads" items="${threads}">
                <tr>
                <td><a href="ResponseServlet?id=${_threads.threadID}">>>${_threads.threadID}</a></td>
                <!--<td>${_threads.threadID}</td>-->
                <td>${_threads.threadTitle}</td>
                <td>${_threads.threadDate}</td>
                <td>${_threads.threadUser}</td>
                </tr>
            </c:forEach>
        <!--<p>投稿</p>
            タイトル：<input type="text" name="Thread_Title" size="40"><br>
            作成者名：<input type="text" name="Thread_User" size="10">-->
        </table>
        <br>
        <a href="#th">投稿場所へ↑</a>
    </form>
    </body>
    </html>