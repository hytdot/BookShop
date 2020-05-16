<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/12/22
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="client_check.jsp" %>

<html>
<head>
    <title>付款界面</title>
</head>
<body>
<h2>请扫描支付宝或者微信二维码付款：</h2>
<img src="Images/zhifubao.jpg" width="200" height="250"/>
<img src="Images/weixin.png" width="200" height="250"/>
<form action="Order?orderID=<%=request.getParameter("orderID")%>&orderState=未收款&userID=<%=request.getParameter("userID")%>&bookID=<%=request.getParameter("bookID")%>&bookName=<%=request.getParameter("bookName")%>&count=<%=request.getParameter("count")%>&price=<%=request.getParameter("price")%>&logistics=<%=request.getParameter("logiatics")%>&identity=C" method="post">
    价格：<%=request.getParameter("price")%><br/>
    确认付款后请update：
    <input type="submit" name="meth" value="update">
</form>
</body>
</html>
