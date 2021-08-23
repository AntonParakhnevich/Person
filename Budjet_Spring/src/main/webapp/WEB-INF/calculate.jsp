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
<form method="post">
    <label><fmt:message key="totalYears"/> </label><br>
    <input type="number" required placeholder="<fmt:message key="totalYears"/> " name="years" min="1"><br>

    <label><fmt:message key="incomes"/> </label><br>
    <input type="number" required placeholder="<fmt:message key="incomes"/> " name="income" min="1"><br>

    <label><fmt:message key="costs"/> </label><br>
    <input type="number" required placeholder="<fmt:message key="costs"/> " name="cost" min="1"><br>

    <input type="submit" value="<fmt:message key="calculation"/> "/>

    <a href="index" style="display: inline"><fmt:message key="back"/> </a>
</form>
</body>
</html>
