<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${sessionScope.language}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="translations"/>
<html>
<head>
    <title>Start</title>
</head>
<body>

<div class="form">
    <h1><fmt:message key="Authorization"/></h1><br>
    <form method="post" action="">

        <input type="text" required placeholder="<fmt:message key="login"/>" name="login"><br>
        <input type="password" required placeholder="<fmt:message key="password"/>" name="password"><br>
        <input class="button" type="submit" value="<fmt:message key="loginInSystem"/>">

    </form>

    <form method="get" action='<c:url value="registration"/>' style="display:inline;">
        <input type="submit" value="<fmt:message key="registration"/>">
    </form>
</div>

</body>
</html>
