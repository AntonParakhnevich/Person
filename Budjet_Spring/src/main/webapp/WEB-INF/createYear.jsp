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
<h3><fmt:message key="newYear"/></h3>
<form method="post">
    <label><fmt:message key="year"/></label><br>
    <input name="year" required placeholder="<fmt:message key="year"/>" type="number" min="2000" max="${maxYear}"/><br>
    <input type="submit" value="<fmt:message key="create"/>" style="display: inline"/>
    <a href="index" style="display: inline"><fmt:message key="back"/></a>
</form>
</body>
</html>
