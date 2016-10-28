<%@ page language="java" contentType="text/html; charset=Utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome to response page!!!!</h3>
	<jsp:useBean id="message" class="com.formation.dto.Message" scope="request" />
	<p>Nom: <jsp:getProperty property="nom" name="message"/></p>
</body>
</html>