<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/12/21
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin_check.jsp" %>

<html>
<head>
    <title>添加图书页面</title>
</head>
<body>
<form action="Book" method="post">
    书名：<input type="text" name="bookName"><br/>
    作者：<input type="text" name="writer"><br/>
    出版社：<input type="text" name="publisher"><br/>
    类型：<input type="text" name="type"><br/>
    价格：<input type="text" name="price"><br/>
    库存量：<input type="text" name="inventory"><br/>
    简介：<input type="text" name="introduction"><br/>
    <input type="submit"  name="meth" value="add">
    <input type="reset" value="reset"><br>
</form>
</body>
</html>