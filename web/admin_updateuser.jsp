<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/12/20
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin_check.jsp" %>

<html>
<head>
    <title>修改用户信息</title>
</head>
<body>
<form action="User?userID=<%=request.getParameter("userID")%>" method="post">
    用户名：<%=request.getParameter("userID")%><br/>
    密码：<input type="text" name="password" value="<%=request.getParameter("password")%>"><br/>
    权限：<input type="text" name="identity" value="<%=request.getParameter("identity")%>"><br/>
    住址：<input type="text" name="address" value="<%=request.getParameter("address")%>"><br/>
    电话：<input type="text" name="phone" value="<%=request.getParameter("phone")%>"><br/>
    <input type="submit" name="meth" value="update">
    <input type="reset" value="reset"><br>
</form>
</body>
</html>
