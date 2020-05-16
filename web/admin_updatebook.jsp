<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/12/21
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin_check.jsp" %>
<html>
<head>
    <title>修改图书信息</title>
</head>
<body>
<form action="Book" method="post">
    书号：<input type="text" name="bookID" value="<%=request.getParameter("bookID")%>"><br/>
    书名：<input type="text" name="bookName" value="<%=request.getParameter("bookName")%>"><br/>
    作者：<input type="text" name="writer" value="<%=request.getParameter("writer")%>"><br/>
    出版社：<input type="text" name="publisher" value="<%=request.getParameter("publisher")%>"><br/>
    类型：<input type="text" name="type" value="<%=request.getParameter("type")%>"><br/>
    价格：<input type="text" name="price" value="<%=request.getParameter("price")%>"><br/>
    库存量：<input type="text" name="inventory" value="<%=request.getParameter("inventory")%>"><br/>
    简介：<input type="text" name="introduction" value="<%=request.getParameter("introduction")%>"><br/>
    <input type="submit" name="meth" value="update">
    <input type="reset" value="reset"><br>
</form>
</body>
</html>
