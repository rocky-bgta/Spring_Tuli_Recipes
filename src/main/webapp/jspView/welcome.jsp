<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Welcome</title>
</head>

<body>
<h2>Welcome to Tuli Recipes house</h2>
Today is <fmt:formatDate value="${today}" pattern="yyyy-MM-dd" />.
<br>
Wecome Message from Tuli: ${WelcomeMessage}.
</body>
</html>
