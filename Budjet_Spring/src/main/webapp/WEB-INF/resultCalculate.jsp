<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${sessionScope.language}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="translations"/>
<html>
<body>
<h3><fmt:message key="calculationAccumulation"/></h3>
<table>
    <tr>
        <th><fmt:message key="totalYears"/></th>
        <th><fmt:message key="incomes"/></th>
        <th><fmt:message key="costs"/></th>
        <th><fmt:message key="accumulations"/></th>
    </tr>
    <tr>
        <th>${years}</th>
        <th>${income}</th>
        <th>${cost}</th>
        <th>${accumulation}</th>
    </tr>
</table>
<%--<form method="post" action='<c:url value="/calculate"/>' style="display:inline;">--%>
<%--    <input type="submit" value="<fmt:message key="back"/> ">--%>
<%--</form>--%>
<a href="calculate" style="display: inline"><fmt:message key="back"/> </a>
</body>
</html>

