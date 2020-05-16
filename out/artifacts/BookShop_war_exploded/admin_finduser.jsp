<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/12/20
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin_check.jsp" %>

<html>
<head>
    <title>查找用户</title>
</head>
<body>
<form action="User?identity=S"  method="post"  style="padding-top:-700px;">
    用户名：<input type="text" name="userID" value=""><br><br>
    <input type="submit" name="meth" value="find">
    <input type="reset" value="reset"><br>
</form>
</body>
</html>
