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
    <h2 id="th">スレッド検索ページ</h2>
        <form action="SearchServlet" method="POST">
        <table border="1">
            <tr>
                <th>タイトル</th><td><textarea name="Thread_Title" rows="5" cols="50" maxlength="100" required></textarea></td>
            </tr>
        </table>
        <input class="submit-button"type="submit" VALUE="検索">
        </form>
        <br>
        <h2>検索結果</h2>
        <table border="1">
            <tr></th><th>スレッドID</th><th>タイトル</th><th>日付</th><th>スレ主</th></tr>
            <c:forEach var="_threads" items="${search}">
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
        <a href="#th">検索欄へ↑</a>
    </form>
    <br>
	<a href="http://localhost:8080/RJP_WEB/ThreadServlet">←スレッド一覧に戻る</a>
    </body>
</html>