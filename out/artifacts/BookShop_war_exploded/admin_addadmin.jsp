<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/12/20
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin_check.jsp" %>

<html>
<head>
    <title>添加管理员页面</title>
</head>
<body>
<form action="User" method="post">
    用户名：<input type="text" name="userID"><br/>
    密码：<input type="password" name="password"><br/>
    住址：<input type="text" name="address"><br/>
    电话：<input type="text" name="phone"><br/>
    <input type="submit"  name="meth" value="add">
    <input type="reset" value="reset"><br>
</form>
</body>
</html>
