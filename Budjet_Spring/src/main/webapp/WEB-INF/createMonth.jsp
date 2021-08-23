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
<h3><fmt:message key="newMonth"/></h3>
<form method="post">
    <label><fmt:message key="month"/></label><br>
    <input name="month" required placeholder="<fmt:message key="month"/>" type="month" max="${maxMonth}"/><br>
    <input type="submit" value="<fmt:message key="create"/>" style="display: inline"/>
    <a href="year?year=${year}" style="display: inline"><fmt:message key="back"/></a>
</form>
</body>
</html>
