<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/12/20
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ include file="admin_check.jsp" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>用户列表</title>
</head>

<body>
<table  width="600" border="1" cellpadding="0" >
    <tr>
        <th>用户名</th>
        <th>密码</th>
        <th>权限</th>
        <th>地址</th>
        <th>联系电话</th>
        <th>操作</th>
    </tr>

    <c:forEach var="U" items = "${userList}"  >
        <tr>
            <td>${U.userID}</td>
            <td>${U.password}</td>
            <td>${U.identity}</td>
            <td>${U.address}</td>
            <td>${U.phone}</td>
            <td><a href="User?meth=dele&id=${U.userID}">删除</a>
                <a href="admin_updateuser.jsp?userID=${U.userID}&password=${U.password}&identity=${U.identity}&address=${U.address}&phone=${U.phone}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
