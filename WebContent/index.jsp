<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>To Do List</title>
<link rel="stylesheet" href="//code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
	<div data-role="page" id="index">
 		<div data-role="main" class="ui-content" align="center">
    		<h1>Welcome!</h1>
    		<a href="/ToDoList/controller/login" class="ui-btn ui-btn-inline ui-corner-all ui-icon-user ui-btn-icon-left">Log In</a>
    		<a href="/ToDoList/controller/signup" class="ui-btn ui-btn-inline ui-corner-all ui-icon-user ui-btn-icon-left">Sign Up</a>
    		<br>
    		<a href="#anylink" class="ui-btn ui-btn-inline ui-corner-all ui-icon-search ui-btn-icon-right">Search</a>
			<a href="#bing" data-rel="dialog" class="ui-btn ui-btn-inline ui-corner-all ui-icon-search ui-btn-icon-right">Bing</a>
			<a href="#video" data-rel="dialog" class="ui-btn ui-btn-inline ui-corner-all ui-icon-search ui-btn-icon-right">Video</a>
  		</div>
	</div>

	<div data-role="page" id="video">
	<div data-role="header">
	<h1>Testing the dialog</h1>
	
	<div data-role="content">
		<iframe width="100%" height="360"
			src="//www.youtube.com/embed/X-RsfO0uARI?rel=0" frameborder="0" allowfullscreen>
		</iframe> 
	</div></div></div>
	
	<div data-role="page" id="bing">
	<div data-role="header">
		<h1>Bing as dialog</h1>
	<div data-role="content">
		<iframe width="100%" height="750" src="//www.bing.com"></iframe> 
	</div></div></div>
	
</body>
</html>