<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/12/22
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="client_check.jsp" %>

<html>
<head>
    <title>购买图书</title>
</head>
<body>
<form action="Order" method="post">
    用户名：<input type="text" name="userID" value="${user}"><br/>
    书号：<input type="text" name="bookID" value="<%=request.getParameter("bookid")%>"><br/>
    书名：<input type="text" name="bookName" value="<%=request.getParameter("bookName")%>"><br/>
    购买数量：<input type="text" name="count" value=""><br/>
    <input type="submit" name="meth" value="add">
    <input type="reset" value="reset"><br>
</form>
</body>
</html>
