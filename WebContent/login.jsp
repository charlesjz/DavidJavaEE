<!DOCTYPE html>
<%@ taglib prefix="lo" uri="WEB-INF/logos.tld" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vic 2018-Feb Web App</title>
<% boolean hasError = request.getParameter( "err" ) != null; %>
<style>
.error {
    color: red;
    margin-left: 40px;
} 
</style>

</head>
<body>
<lo:Logo/>
<lo:Logo2>(implemented in Feb, 2018)</lo:Logo2><p>
<lo:Logo3 date="Feb, 2008" bold="true">- implemented in </lo:Logo3>
<h2>Please enter your username and password to login the app.</h2>
<%if ( hasError ) { %>
	<h2 class="error">Invalid username or password!</h2>
<%} else {%>
	... ...
<%} %>
<form action="Login" method="get">
	Username: <input type="text" name="username"><p>
	Password: <input type="password" name="password"><p>
	<input type="submit" value="Login">
	<input type="reset" value="Clear">
</form>
</body>
</html>