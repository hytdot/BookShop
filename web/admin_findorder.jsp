<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/12/22
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin_check.jsp" %>

<html>
<head>
    <title>查找订单</title>
</head>
<body>
<form action="Order?identity=S"  method="post"  style="padding-top:-700px;">
    用户名：<input type="text" name="userID" value=""><br><br>
    订单状态：<input type="text" name="orderState" list="statelist">
        <datalist id="statelist">
            <option>未付款</option>
            <option>未收款</option>
            <option>未发货</option>
            <option>未收货</option>
            <option>已完成</option>
        </datalist>
    <br><br>
    <input type="submit" name="meth" value="find">
    <input type="reset" value="reset"><br>
</form>
</body>
</html>
