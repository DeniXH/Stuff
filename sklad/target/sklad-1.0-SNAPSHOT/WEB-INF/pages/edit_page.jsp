<%--
  Created by IntelliJ IDEA.
  User: polzovatel
  Date: 27.10.2019
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <c:if test="${empty stuff.title}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty stuff.title}">
        <title>Edit</title>
    </c:if>
</head>

<body>

<c:if test="${empty stuff.title}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty stuff.title}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty stuff.title}">
        <input type="hidden" name="id" value="${stuff.id}">
    </c:if>
    <%--<input type="hidden" name="id" value="${stuff.id}">--%>
    <label for = "title">Title</label>
    <input type="text" name="title" id="title">
    <label for="year">Year</label>
    <input type="text" name="year" id="year">
    <label for="genre">Genre</label>
    <input type="text" name="genre" id="genre">
    <label for="watched">Watched</label>
    <input type="text" name="watched" id="watched">
    <%--<input type="submit" value="Edit stuff">--%>

    <%--<c:if test="${empty stuff.title}">
        <input type="hidden" name="id" value=0>
    </c:if>--%>

    <c:if test="${empty stuff.title}">
        <input type="submit" value="Add new stuff">
    </c:if>
    <c:if test="${!empty stuff.title}">
        <input type="submit" value="Edit stuff">
    </c:if>

   <%-- <c:url value="/edit" var="var"/>
    <form action="${var}" method="POST">
        <input type="submit" value="Edit stuff">
    </form>--%>


</form>
</body>
</html>
