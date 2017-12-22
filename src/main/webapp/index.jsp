<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="resources/bootstrap/js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.min.css" >
<title>登录</title>
</head>
<body>
    
	<form action="user/login" method="post" role="form"  class="bs-example bs-example-form">   
	     <div class="input-group">
            <span class="input-group-addon glyphicon glyphicon-user">User:</span>
            <input type="text" class="form-control" placeholder="username" name="username">
        </div>
        <div class="input-group">
            <span  class="input-group-addon glyphicon glyphicon-asterisk">Password:</span>
            <input type="password" class="form-control" placeholder="password" name="password">
        </div>
	    <div>
	        <input type="submit" value="确定" class="btn btn-defaults">
	    </div>    
	  
		
	</form>
</body>
</html>
