<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/12/22
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="client_check.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>订单列表</title>
</head>

<body>
<table  width="600" border="1" cellpadding="0" >
    <tr>
        <th>订单号</th>
        <th>订单状态</th>
        <th>用户名</th>
        <th>书号</th>
        <th>书名</th>
        <th>数量</th>
        <th>价格</th>
        <th>物流单号</th>
    </tr>

    <c:forEach var="O" items = "${orderList}"  >
        <tr>
            <td>${O.orderID}</td>
            <td>${O.orderState}</td>
            <td>${O.userID}</td>
            <td>${O.bookID}</td>
            <td>${O.bookName}</td>
            <td>${O.count}</td>
            <td>${O.price}</td>
            <td>${O.logistics}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

