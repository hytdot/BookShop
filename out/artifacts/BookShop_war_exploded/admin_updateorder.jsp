<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/12/22
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin_check.jsp" %>

<html>
<head>
    <title>修改订单信息</title>
</head>
<body>
<form action="Order?&identity=S&orderID=<%=request.getParameter("orderID")%>&userID=<%=request.getParameter("userID")%>&bookID=<%=request.getParameter("bookID")%>&bookName=<%=request.getParameter("bookName")%>" method="post">
    订 单 号：<%=request.getParameter("orderID")%><br/>
    订单状态：
    <select name = "orderState">
        <option value ="未付款" <%if(request.getParameter("orderState").equals("未付款")){%>selected="selected"<%}%>>未付款</option>
        <option value ="未收款" <%if(request.getParameter("orderState").equals("未收款")){%>selected="selected"<%}%>>未收款</option>
        <option value ="未发货" <%if(request.getParameter("orderState").equals("未发货")){%>selected="selected"<%}%>>未发货</option>
        <option value ="未收货" <%if(request.getParameter("orderState").equals("未收货")){%>selected="selected"<%}%>>未收货</option>
        <option value ="已完成" <%if(request.getParameter("orderState").equals("已完成")){%>selected="selected"<%}%>>已完成</option>
    </select>
    <br/>
    用 户 名：<%=request.getParameter("userID")%><br/>
    书    号：<%=request.getParameter("bookID")%><br/>
    书    名：<%=request.getParameter("bookName")%><br/>
    数    量：<input type="text" name="count" value="<%=request.getParameter("count")%>"><br/>
    价    格：<input type="text" name="price" value="<%=request.getParameter("price")%>"><br/>
    物流单号：<input type="text" name="logistics" value="<%=request.getParameter("logistics")%>"><br/>
    <input type="submit" name="meth" value="update">
    <input type="reset" value="reset"><br>
</form>
</body>
</html>
