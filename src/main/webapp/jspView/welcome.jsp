<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Welcome</title>
</head>

<body>
<h2>Welcome to Tuli Recipes house</h2>
Today is <fmt:formatDate value="${today}" pattern="yyyy-MM-dd" />.
<br>
Wecome Message from Tuli: ${WelcomeMessage}.
<br>
<br>

    <h2>Hello Spring Social</h2>

    <h3>Connections</h3>
    Click <a href="<spring:url value='/connect'/>">here</a> to see your Social Network Connections.
</body>
</html>
