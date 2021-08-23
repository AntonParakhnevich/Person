<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language"
       value="${sessionScope.languages}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="translations"/>
<!DOCTYPE html>
<html lang="${language}">
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<p><fmt:message key="login"/>: ${family.login}</p>
<p><fmt:message key="accumulations"/>: ${totalAccumulation}</p>
<p></p>
<p><fmt:message key="years"/>:</p>
<c:forEach items="${years}" var="year">
    <tr>
        <th>
            <a href="${pageContext.request.contextPath}/year?year=${year.id}">${year.year}</a>
        </th>
    </tr>
</c:forEach>

<p>
    <a href="createYear"><fmt:message key="create"/></a>
    <a href="calculate"><fmt:message key="calculation"/></a>
    <a href="logout"><fmt:message key="logout"/></a>
</p>
</body>
</html>