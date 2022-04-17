<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户显示页面</title>
</head>
<body>
<table border="1" width="60%" align="center">
    <tr>
        <td>用户编号</td>
        <td>用户名称</td>
        <td>年龄</td>
    </tr>
    <c:forEach items="${list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.age}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

