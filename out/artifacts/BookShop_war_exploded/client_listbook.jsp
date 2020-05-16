<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/12/22
  Time: 16:59
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
    <title>图书列表</title>
</head>

<body>
<table  width="600" border="1" cellpadding="0" >
    <tr>
        <th>书号</th>
        <th>书名</th>
        <th>作者</th>
        <th>出版社</th>
        <th>类型</th>
        <th>价格</th>
        <th>库存量</th>
        <th>销量</th>
        <th>简介</th>
        <th>操作</th>
    </tr>

    <c:forEach var="B" items = "${bookList}"  >
        <tr>
            <td>${B.bookID}</td>
            <td>${B.bookName}</td>
            <td>${B.writer}</td>
            <td>${B.publisher}</td>
            <td>${B.type}</td>
            <td>${B.price}</td>
            <td>${B.inventory}</td>
            <td>${B.sales}</td>
            <td>${B.introduction}</td>
            <td><a href="client_buybook.jsp?bookid=${B.bookID}&bookName=${B.bookName}">购买</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
