<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/12/23
  Time: 12:00
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
    <title>联系我们</title>
    <link type="text/css" rel="stylesheet" href="Css/reset.css" />
    <link type="text/css" rel="stylesheet" href="Css/1024_768.css" />
    <link type="text/css" rel="stylesheet" media="screen and (min-width:861px) and (max-width:960px)" href="Css/pad_heng.css" />
    <link type="text/css" rel="stylesheet" media="screen and (min-width:601px) and (max-width:860px)" href="Css/pad.css" />
    <link type="text/css" rel="stylesheet" media="screen and (min-width:481px) and (max-width:600px)" href="Css/tel_heng.css" />
    <link type="text/css" rel="stylesheet" media="screen and (max-width:480px)" href="Css/tel.css" />
</head>

<body>
<div id="contact" class="content_press">
    <div class="press_porsen_01">
        <dl>
            <dd><img src="Images/img_men.jpg" alt="person" /></dd>
            <dt>
                <p class="date">Dec 23, 2019</p>
                <p class="book_title">联系店长</p>
                <p class="book_intro">
                    如在购买过程中出现问题，请联系店长。联系电话：18551760163；QQ：1185805315；电子邮箱：1185805315@qq.com；微信：18551760163.
                </p>
            </dt>
        </dl>
    </div>
    <div class="press_porsen_02">
        <dl>
            <dd><img src="Images/img_lives.jpg" alt="book img" /></dd>
            <dt>
                <p class="date">Dec 23, 2019</p>
                <p class="book_title">书店地址</p>
                <p class="book_intro">
                    本书店位于江苏省南京市江宁区将军大道29号南京航空航天大学将军路校区。
                </p>
            </dt>
        </dl>
    </div>
</div>
</body>
</html>
