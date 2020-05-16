<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/12/22
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="client_check.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>主页左侧导航</title>
    <style type="text/css">
        .menu{
            display:none;
            margin-left:10px;
        }
    </style>
    <script type="text/javascript">
        function test(e){
//  		$(e).style.display = $(e).style.display == 'block'? 'none':'block';
            var element = document.getElementById(e);
            element.style.display = element.style.display == 'block'? 'none':'block';
        }
    </script>
</head>
<body>
<h2>欢迎您：${user}</h2>
<ul>
    <li>
        <a href="client_right.jsp" target="right">书店首页</a><br/>
    </li>
    <br/><br/>
    <li>
        <a href="Book?meth=list&identity=C" target="right">图书列表</a><br/>
    </li>
    <br/><br/>
    <li>
        <a href="User?meth=find&identity=C&userID=${user}" target="right">个人资料</a><br/>
    </li>
    <br/><br/>
    <li>
        <a href="findbook.jsp" target="right">查找图书</a><br/>
    </li>
    <br/><br/>
    <li>
        <a href="#" onclick="test('menu')">我的订单
            <div id="menu" class="menu">
                <a href="Order?meth=find&orderState=未付款&identity=${identity}&userID=${user}" target="right">待付款</a><br/>
                <a href="Order?meth=find&orderState=未收款&identity=${identity}&userID=${user}" target="right">待收款</a><br/>
                <a href="Order?meth=find&orderState=未发货&identity=${identity}&userID=${user}" target="right">待发货</a><br/>
                <a href="Order?meth=find&orderState=未收货&identity=${identity}&userID=${user}" target="right">待收货</a>
            </div>
        </a>
    </li>
    <br/><br/>
    <li>
        <a href="Order?meth=find&orderState=已完成&identity=${identity}&userID=${user}" target="right">历史订单</a>
    </li>
    <br/><br/>
    <li>
        <a href="client_contact.jsp" target="right">联系我们</a>
    </li>
    <br/><br/>
</ul>

</body>
</html>