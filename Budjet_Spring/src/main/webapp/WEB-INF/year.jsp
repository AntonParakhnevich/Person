<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${sessionScope.language}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="translations"/>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<table>
    <tr>
        <th><fmt:message key="month"/></th>
        <th><fmt:message key="incomes"/></th>
        <th><fmt:message key="costs"/></th>
        <th><fmt:message key="accumulations"/></th>
    </tr>

    <c:forEach items="${months}" var="month">
    <tr>
        <th>
<%--            <a href="${pageContext.request.contextPath}/month?idMonth=${month.id}&year=${requestScope.year}">${month.name}</a>--%>
            <a href="${pageContext.request.contextPath}/month?idMonth=${month.id}&year=${year}"><fmt:message key="${month.name}"/></a>
        </th>
        <th>${month.income.calculationTotalIncome()}</th>
        <th>${month.expenses.calculationTotalExpenses()}</th>
        <th>${month.calculationAccumulationInMonth()}</th>
        <td>
            <form method="post" action='<c:url value="/deleteMonth?idMonth=${month.id}&year=${year}" />'
                  style="display:inline;">
                <input type="hidden" name="id" value="${month.id}">
                <input type="submit" value="<fmt:message key="delete"/>">
            </form>
        </td>
        </c:forEach>
    </tr>
</table>
<a href="createMonth?year=${year}"><fmt:message key="create"/></a>

<form method="post" action='<c:url value="/backIndex"/>' style="display:inline;">
    <input type="submit" value="<fmt:message key="back"/>">
</form>
</body>
</html>