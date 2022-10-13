<%@ page import="ru.javawebinar.topjava.util.MealsUtil" %>
<%@ page import="ru.javawebinar.topjava.model.Meal" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 11.10.2022
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ru">
<head>
    <title>Meals</title>
    <style>
        .normal {
        color: green;
        }

        .excess {
        color: red;
        }
        </style>
</head>
<body>

<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<br/><br/>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
    </tr>
    </thead>

    <c:forEach var="meal" items="${requestScope.mealList}">
        <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.Meal"/>
        <tr class="${'normal'}">
    <tr>
        <td>${meal.date}</td>
        <td>${meal.description}</td>
        <td>${meal.calories}</td>
    </tr>
    </c:forEach>

</table>
</body>
</html>
