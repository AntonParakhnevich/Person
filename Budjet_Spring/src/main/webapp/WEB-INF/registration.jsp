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
<h3><fmt:message key="registration"/></h3>
<form method="post">
    <label><fmt:message key="login"/></label><br>
    <input type="text" required placeholder="<fmt:message key="login"/>" name="login"><br>

    <label><fmt:message key="password"/></label><br>
    <input type="text" required placeholder="<fmt:message key="password"/>" name="password"><br>

    <input type="submit" value="<fmt:message key="registration"/>"/>

    <a href="start" style="display: inline"><fmt:message key="back"/></a>
</form>
</body>
</html>
