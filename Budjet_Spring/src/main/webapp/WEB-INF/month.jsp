<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${sessionScope.language}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="translations"/>

<html>
<body>
<h1><fmt:message key="incomes"/></h1>
<table>
    <tr>
        <th><fmt:message key="category"/></th>
        <th><fmt:message key="amount"/></th>
    </tr>
    <c:forEach items="${categoriesIncome}" var="category">
    <tr>
        <th>${category.name}</th>
        <th>${category.value}</th>
        <td>
            <form method="post"
                  action='<c:url value="/deleteIncome?idMonth=${idMonth}&year=${year}" />'
                  style="display:inline;">
                <input type="hidden" name="idIncome" value="${category.id}">
                <input type="submit" value="<fmt:message key="delete"/>">
            </form>
        </td>
        </c:forEach>
    </tr>

    <a href="createIncome?idMonth=${idMonth}&year=${year}"><fmt:message key="create"/></a>
<%--    <form method="get"--%>
<%--          action='<c:url value="/createIncome?idMonth=${idMonth}&year=${year}" />'--%>
<%--          style="display:inline;">--%>
<%--        <input type="submit" value="<fmt:message key="create"/>">--%>
<%--    </form>--%>
</table>
<h1><fmt:message key="costs"/></h1>
<table>
    <tr>
        <th><fmt:message key="category"/></th>
        <th><fmt:message key="amount"/></th>
        <th><fmt:message key="binding"/></th>
    </tr>
    <c:forEach items="${categoriesCost}" var="category">
    <tr>
        <th>${category.name}</th>
        <th>${category.price}</th>
        <th>${category.binding}</th>
        <td>
            <form method="post"
                  action='<c:url value="/deleteCost?idMonth=${idMonth}&year=${year}" />'
                  style="display:inline;">
                <input type="hidden" name="idCost" value="${category.id}">
                <input type="submit" value="<fmt:message key="delete"/>">
            </form>
        </td>
        </c:forEach>
    </tr>

    <a href="createCost?idMonth=${idMonth}&year=${year}"><fmt:message key="create"/></a>
<%--    <form method="get" action='<c:url value="/createCost?idMonth=${idMonth}&year=${year}" />'--%>
<%--          style="display:inline;">--%>
<%--        <input type="submit" value="<fmt:message key="create"/>">--%>
<%--    </form>--%>

</table>
</body>
<form method="post" action='<c:url value="/backYear?year=${year}"/>' style="display:inline;">
    <input type="submit" value="<fmt:message key="back"/>">
</form>
</html>
