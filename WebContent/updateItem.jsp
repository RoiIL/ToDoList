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
	<div data-role="page" id="updateItem">
	<div data-role="header">
		<div align="center" style="font-size:15px;"><br><h1>Let's change the plan...</h1></div>
	<div data-role="content" align="center">
		<form action="/ToDoList/controller/updateItem" method="post">
		<%
			if (request.getAttribute("message") != null)
			{
				out.println((String)request.getAttribute("message"));
			}
			String itemId = (String)request.getAttribute("itemId");
		%>
		
  			<textarea name="updateContent" id="info" placeholder="<%=request.getAttribute("itemContent")%>"></textarea>
  			<input type="hidden" value="<%=itemId %>" name="itemId">
  			<input type="submit" value="Done!" data-icon="check" data-iconpos="right">
  			<input type="submit" formaction="/ToDoList/controller/userPage" name="cancel" value="Cancel" data-icon="delete" data-iconpos="right">
		</form>
	</div></div></div>
</body>
</html>