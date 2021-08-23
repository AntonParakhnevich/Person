<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form method="post" action='<c:url value="language?language=ru_RU"/>' style="display:inline;">
    <input type="submit" value="Русский">
</form>

<form method="post" action='<c:url value="language?language=en_US"/>' style="display:inline;">
    <input type="submit" value="English">
</form>

</body>
</html>
