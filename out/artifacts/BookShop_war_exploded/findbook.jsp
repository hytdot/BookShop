<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/12/21
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>查找图书</title>
</head>
<body>
<form action="Book?identity=${identity}"  method="post"  style="padding-top:-700px;">
    书号：<input type="text" name="bookID" value=""><br><br>
    书名：<input type="text" name="bookName" value=""><br><br>
    作者：<input type="text" name="writer" value=""><br><br>
    出版社：<input type="text" name="publisher" value=""><br><br>
    类型：<input type="text" name="type" value=""><br><br>
    查询方式：<input type="radio" name="sort" value="sales"checked>按销量降序
              <input type="radio" name="sort" value="price">按价格升序<br><br>
    <input type="submit" name="meth" value="find">
    <input type="reset" value="reset"><br>
</form>
</body>
</html>
