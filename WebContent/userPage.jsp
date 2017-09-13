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
	
	<div data-role="content" style="font-size:20px;" align="center">
		<ul data-role="listview">
			<%
				List<Item> userItems = (List<Item>)request.getAttribute("userItems");
				for (Item item : userItems)
				{ %>
				<li>						
					<table>
						<tr>
							<td>
							<%
								out.println(item.getContent());
							%>
							</td>
							
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
		
		<div data-role="popup" id="purchase" data-theme="a" data-overlay-theme="b" class="ui-content" style="max-width:340px; padding-bottom:2em;">
   		<h3>Purchase Album?</h3>
		<p>Your download will begin immediately on your mobile device when you purchase.</p>
    	<a href="index.html" data-rel="back" class="ui-shadow ui-btn ui-corner-all ui-btn-b ui-icon-check ui-btn-icon-left ui-btn-inline ui-mini">Buy: $10.99</a>
   		<a href="index.html" data-rel="back" class="ui-shadow ui-btn ui-corner-all ui-btn-inline ui-mini">Cancel</a>
		</div>
		
		</br>
		<a href="/ToDoList/controller/addItem" class="ui-btn ui-btn-inline ui-corner-all ui-icon-check ui-btn-icon-right">Add Item</a>
		<a href="/ToDoList/controller/index" class="ui-btn ui-btn-inline ui-corner-all ui-icon-delete ui-btn-icon-right">Log out</a>
		
	</div>
	</div>
	
	<a href="#purchase" data-rel="popup" data-position-to="window" data-transition="pop" data-icon="edit" data-inline="true"></a>
	<td><a href="/ToDoList/controller/deleteItem" class="ui-icon ui-btn-inline ui-icon-plusthick ui-icon-delete ui-btn-icon-right"></a></td>
</body>
</html>