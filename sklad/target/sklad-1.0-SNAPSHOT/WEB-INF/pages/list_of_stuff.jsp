<%--
  Created by IntelliJ IDEA.
  User: polzovatel
  Date: 27.10.2019
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Stuff</title>
</head>
<body>
<c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
    <c:url value="/" var="url">
        <c:param name="page" value="${i.index}"/>
    </c:url>
    <a href="${url}">${i.index}</a>
</c:forEach>

<h2>Stuff_s</h2>
<table>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>year</th>
        <th>genre</th>
        <th>watched</th>
     <%--   <th>image</th>--%>
        <th>action</th>
    </tr>
    <c:forEach var="stuff" items="${stuffList}">
        <tr>
            <td>${stuff.id}</td>
            <td>${stuff.title}</td>
            <td>${stuff.year}</td>
            <td>${stuff.genre}</td>
            <td>${stuff.watched}</td>
         <%--   <td>${stuff.image}</td>--%>
            <td>
                <a href="/edit/${stuff.id}">edit</a>
                <a href="/delete/${stuff.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value = "/add" var = "add"/>
<a href="${add}">Add new stuff</a>
</body>
</html>
