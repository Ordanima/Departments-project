<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dante
  Date: 25.01.2019
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Департаменты</title>
</head>
<body>
    <h1>Список департаментов:</h1>
<table border="2px">
    <tr>
        <td>Департамент</td>
        <td colspan="4">Действия</td>
    </tr>
    <c:set var="isEmptyList" value="${depList}"/>
    <c:if test="${empty isEmptyList}">
        <form method="get" action="DepartmentActionServlet">
            <tr><td colspan="2"><input style="width: 100%" type="submit" name="button" value="Добавить"/></td></tr>
        </form>
    </c:if>
    <c:forEach items="${depList}" var="department">
        <tr>
            <td><c:out value="${department.name}" /></td>
            <form method="get" action="DepartmentActionServlet">
                <td><input type="submit" name="button" value="Добавить" /></td>
                <td><input type="submit" name="button" value="Редактировать" /></td>
                <td><input type="submit" name="button" value="Удалить" /></td>
                <td><input type="submit" name="button" value="Список сотрудников" /></td>
                <input type="hidden" name="curDepartment_id" value="${department.id}">
                <input type="hidden" name="curDepartment_name" value="${department.name}">
            </form>
        </tr>
    </c:forEach>
</table>
</body>
</html>
