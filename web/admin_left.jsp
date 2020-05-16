 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%
	 String path = request.getContextPath();
	 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
 <%@ include file="admin_check.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>后台左侧导航</title>
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
  <br/>
  	<ul>
		<li>
			<a href="#" onclick="test('menu1')">用户管理
				<div id="menu1" class="menu">
					<a href="User?meth=list" target="right">查看用户列表</a><br/>
					<a href="admin_finduser.jsp" target="right">查找用户</a><br/>
					<a href="admin_addadmin.jsp" target="right">添加管理员用户</a><br/>
				</div>
			</a>
		</li>
		<br/><br/><br/>
  		<li>
		  	<a href="#" onclick="test('menu2')">图书管理
		  		<div id="menu2" class="menu">
		  			<a href="Book?meth=list&identity=S" target="right">查看图书列表</a><br/>
                    <a href="findbook.jsp" target="right">查找图书</a><br/>
                    <a href="admin_addbook.jsp" target="right">添加图书</a><br/>
		  		</div>
  			</a>
  		</li>
  		<br/><br/><br/>
		<li>
		  	<a href="#" onclick="test('menu3')">订单管理
		  		<div id="menu3" class="menu">
					<a href="Order?meth=list&orderstate=未付款" target="right">未支付订单</a><br/>
					<a href="Order?meth=list&orderstate=未收款" target="right">未收款订单</a><br/>
					<a href="Order?meth=list&orderstate=未发货" target="right">未发货订单</a><br/>
					<a href="Order?meth=list&orderstate=未收货" target="right">未收货订单</a><br/>
					<a href="Order?meth=list&orderstate=已完成" target="right">已完成订单</a><br/>
					<a href="admin_findorder.jsp" target="right">查找订单</a><br/>
				</div>
  			</a> 
  		</li>
  		<br/><br/><br/>
  	</ul>
 
  </body>
</html>