<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/12/22
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="client_check.jsp" %>

<html>
<head>
    <title>修改订单信息</title>
</head>
<body>
<form action="Order?orderID=<%=request.getParameter("orderID")%>&orderState=<%=request.getParameter("orderState")%>&userID=<%=request.getParameter("userID")%>&bookID=<%=request.getParameter("bookID")%>&bookName=<%=request.getParameter("bookName")%>&logistics=<%=request.getParameter("logiatics")%>&identity=C" method="post">
    书    名：<%=request.getParameter("bookName")%><br/>
    数    量：<input type="text" name="count" value="<%=request.getParameter("count")%>"><br/>
    <input type="submit" name="meth" value="update">
    <input type="reset" value="reset"><br>
</form>
</body>
</html>
