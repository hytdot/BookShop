 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%
	 String path = request.getContextPath();
	 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
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
  	<ul>
		<li>
			<a href="#" onclick="test('menu1')">用户管理
				<div id="menu1" class="menu">
					<a href="User?method=list" target="right">查看用户列表</a><br/>
					<a href="${pageContext.request.contextPath }/manager/CategoryServlet?method=listall" target="right">查找用户</a><br/>
					<a href="${pageContext.request.contextPath }/manager/addcategory.jsp" target="right">添加管理员用户</a><br/>
					<a href="${pageContext.request.contextPath }/manager/addcategory.jsp" target="right">删除用户</a><br/>
					<a href="${pageContext.request.contextPath }/manager/addcategory.jsp" target="right">修改用户信息</a><br/>
				</div>
			</a>
		</li>
		<br/><br/>
  		<li>
		  	<a href="#" onclick="test('menu2')">分类管理
		  		<div id="menu2" class="menu">
		  			<a href="${pageContext.request.contextPath }/manager/addcategory.jsp" target="right">添加分类</a><br/>
				  	<a href="${pageContext.request.contextPath }/manager/CategoryServlet?method=listall" target="right">查看分类</a>
		  		</div>
  			</a> 
  		</li>
  		<br/><br/>
  		<li>
		  	<a href="#" onclick="test('menu3')">图书管理
		  		<div id="menu3" class="menu">
				  	 <a href="${pageContext.request.contextPath }/manager/BookServlet?method=addUI" target="right">添加图书</a><br/>
				  	 <a href="${pageContext.request.contextPath }/manager/BookServlet?method=list" target="right">查看图书</a>
			  	</div>
  			</a> 
  		</li>
  		<br/><br/>
  		<li>
		  	<a href="#" onclick="test('menu4')">订单管理
		  		<div id="menu4" class="menu">
				  	 <a href="${pageContext.request.contextPath }/manager/ListOrderServlet?state=false" target="right">未发货订单</a><br/>
				  	 <a href="${pageContext.request.contextPath }/manager/ListOrderServlet?state=true" target="right">已发货订单</a>
				</div>
  			</a> 
  		</li>
  		<br/><br/>
  	</ul>
 
  </body>
</html>