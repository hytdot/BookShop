<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/12/22
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="client_check.jsp" %>

<html>
<head>
    <title>用户信息</title>
</head>
<body>
<form action="User?identity=C&userID=${U.userID}" method="post">
    用户名：${U.userID}<br/>
    密码：<input type="text" name="password" value="${U.password}"><br/>
    住址：<input type="text" name="address" value="${U.address}"><br/>
    电话：<input type="text" name="phone" value="${U.phone}"><br/>
    <input type="submit" name="meth" value="update">
    <input type="reset" value="reset"><br>
</form>
</body>
</html>
