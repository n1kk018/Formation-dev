<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Index</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
</head>
<body>
	<a href="${baseURL}/pages/identificationClient.jsf">identificationClient</a><br />
</body>
</html>