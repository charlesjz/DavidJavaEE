<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome - Vic 2018-02 Web App</title>
</head>
<body>
	
	<h1>Hello,  <c:out value="${CURRENT_USER_PROFILE.firstname}" /> <c:out value="${CURRENT_USER_PROFILE.lastname}" /><p></h1>
	
	 <h2>Welcome to VIC 2018-02 Web Application.<p>
	 Please verify your email address: <c:out value="${CURRENT_USER_PROFILE.email}" />. Should you have any further questions, please feel free to contact us.
	</h2>
	
	<form action="Search" method="get">
		What to search: <input type=text" name="searchText">
		<input type="submit" value="Search in Google">
	</form>
	<a href="Logout">Logout</a>
</body>
</html>