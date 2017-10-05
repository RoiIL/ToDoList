<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=utf-8" 
    pageEncoding="windows-1255" import="java.util.List,il.ac.hit.todolist.model.Item"%> 
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1, user-scalable=no">
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
	
	<div data-role="content" style="font-size:20px;" align="center">
		<ul data-role="listview">
			<%
				List<Item> userItems = (List<Item>)request.getAttribute("userItems");
				for (Item item : userItems)
				{ %>
				<li>						
					<table>
						<tr>
							<td style="white-space: normal;">
							<%
								out.println(item.getContent());
								out.println("</br>");
							%>
							<div data-role="content" style="font-size:12px;" align="left"><%=item.getDate().toGMTString()%></div>
							</td>
						</tr>
						<tr data-role="controlgroup">
							<td>
								<form action="/ToDoList/controller/deleteItem" method="post">
								<fieldset data-role="controlgroup" data-type="horizontal" data-mini="true">
									<input type="hidden" value="<%=item.getItemId() %>" name="itemId">
									<input type="submit" value="Delete" data-icon="delete" data-iconpos="notext">
								</fieldset>
								</form>
							</td>
							<td>
								<form action="/ToDoList/controller/updateItem" method="post">
								<fieldset data-role="controlgroup" data-type="horizontal" data-mini="true">
									<input type="hidden" value="<%=item.getItemId() %>" name="itemId">
									<input type="submit" value="Edit" data-icon="edit" data-iconpos="notext">
								</fieldset>
								</form>
							</td>	
															
						</tr>					
					</table>
				</li>
				<%}
			%>
		</ul>
		
		<form action="/ToDoList/controller/addItem" method="post">
  			<input type="submit" value="Add Item" data-icon="check" data-iconpos="right">
  			<input type="submit" formaction="/ToDoList/controller/index" name="signout" value="Sign out" data-icon="power" data-iconpos="right">
  		</form>		
	</div>
	</div>
</body>
</html>