<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=utf-8" 
    pageEncoding="windows-1255" import="java.util.List,il.ac.hit.todolist.model.Item"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>UserPage</title>
<link rel="stylesheet" href="//code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
	<div data-role="page" id="userPage">
	<div data-role="header">
	<div align="center" style="font-size:15px;">
		<%
			String userFirstName = (String)request.getAttribute("userFirstName");
			out.println("<h1>Welcome " + userFirstName + "</h1>");
		%>
		</div>
	</div>
	
	<div data-role="content" align="center">
		<ul data-role="listview">
			<%
				List<Item> userItems = (List<Item>)request.getAttribute("userItems");
				for (Item item : userItems)
				{
					out.println("<li>" + item.getContent() + "</li>");
				}
			%>
		</ul>
	</div>
</body>
</html>