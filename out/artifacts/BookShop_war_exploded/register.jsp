<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/12/12
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <style type="text/css">
        *{margin: 0;padding: 0}
        html,body{height: 100%}     /*这里很关键*/

        .outer-wrap{
            /*只有同时为html和body设置height: 100%时，这里的height才生效，
            并且随浏览器窗口变化始终保持和浏览器视窗等高*/
            height: 100%;
            position: relative;
            background-color: lightseagreen;
        }
        .login-panel{
            width: 300px;
            height: 210px;
            background-color: honeydew;
            position: absolute;
            top: 50%;
            left: 50%;
            margin-top: -150px;
            margin-left: -200px;
        }
        .login-form{
            width: 300px;
            height: 120px;
            position: center;
        }
    </style>
</head>
<body>
<div class="outer-wrap">
    <div class="login-panel" style="text-align:center;">
        <h2>注册</h2>
        -----------------------------------------
        <form class="login-form" action="Register" method="post">
            账号：<input type="text" name="userID"><br/>
            密码：<input type="password" name="password"><br/>
            住址：<input type="text" name="address"><br/>
            电话：<input type="text" name="phone"><br/><br/>
            <input type="submit" value="注册">
            <input type="reset" value="reset"><br>
        </form>
    </div>
</div>
</body>
</html>
