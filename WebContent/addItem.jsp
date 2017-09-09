<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Add Item</title>
<link rel="stylesheet" href="//code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
	<div data-role="page" id="addItem">
	<div data-role="header">
		<div align="center" style="font-size:15px;"><br><h1>What are you going to do?</h1></div>
	<div data-role="content" align="center">
		<form method="post" action="/">
  			<label for="userName" class="ui-hidden-accessible">User name:</label>
  			<textarea name="addinfo" id="info"></textarea>
  			<input type="submit" value="Post It!" data-icon="check" data-iconpos="right">
  			<a href="index.jsp" class="ui-btn ui-btn-inline ui-corner-all ui-icon-delete ui-btn-icon-right">Cancel</a>
		</form>
	</div></div></div>
</body>
</html>