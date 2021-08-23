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
<h3><fmt:message key="newCategoryCost"/></h3>
<form method="post">
    <label><fmt:message key="name"/></label><br>
    <input required placeholder="<fmt:message key="name"/>" name="name"/><br>
    <label><fmt:message key="amount"/></label><br>
    <input required placeholder="<fmt:message key="amount"/>" name="amount" type="number" min="1"/><br>
    <label><fmt:message key="binding"/></label><br>
    <input required placeholder="<fmt:message key="binding"/>" name="binding" type="number" min="1" max="5"/><br>
    <input type="submit" value="<fmt:message key="create"/>"/>
</form>
</body>
</html>

