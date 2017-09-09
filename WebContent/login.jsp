<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login</title>
<link rel="stylesheet" href="//code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
	<div data-role="page" id="login">
	<div data-role="header">
		<div align="center" style="font-size:15px;"><br><h1>Hi you!</h1>
	</div>
	
	<div data-role="content" align="center">
		<form action="login" method="get">
		<%
			if (request.getAttribute("message") != null)
			{
				out.println((String)request.getAttribute("message"));
			}
		%>
  			<label for="userName" class="ui-hidden-accessible">User name:</label>
  			<input type="text" name="userName" id="userName" placeholder="User name..." data-clear-btn="true">
  			<label for="password" class="ui-hidden-accessible">Password:</label>
  			<input type="password" name="password" id="password" placeholder="Password..." data-clear-btn="true">
  			<input type="submit" value="Log in" data-icon="check" data-iconpos="right">
		</form>
	</div></div></div>
</body>
</html>

<!-- <div style="width:250px;"></div> -->