<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/12/22
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("identity") != "S") {
        System.out.println("转发请求到login.jsp");
        response.sendRedirect("login.jsp");
    }
%>
