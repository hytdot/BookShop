<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/12/22
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="client_check.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>书店首页</title>
</head>
<frameset rows="15%,*">
    <frame src="client_head.jsp" name="head">
    <frameset cols="15%,*">
        <frame src="client_left.jsp" name="left">
        <frame src="client_right.jsp" name="right">
    </frameset>
</frameset>
</html>
