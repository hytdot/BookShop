<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/12/12
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
  <title>网上书店</title>
  <link type="text/css" rel="stylesheet" href="Css/reset.css" />
  <link type="text/css" rel="stylesheet" href="Css/1024_768.css" />
  <link type="text/css" rel="stylesheet" media="screen and (min-width:861px) and (max-width:960px)" href="Css/pad_heng.css" />
  <link type="text/css" rel="stylesheet" media="screen and (min-width:601px) and (max-width:860px)" href="Css/pad.css" />
  <link type="text/css" rel="stylesheet" media="screen and (min-width:481px) and (max-width:600px)" href="Css/tel_heng.css" />
  <link type="text/css" rel="stylesheet" media="screen and (max-width:480px)" href="Css/tel.css" />
</head>
<body>

<div class="w_100_l">
  <div class="main">
    <div class="top_banner">
      <div class="top_logo"><img src="Images/top_logo.jpg" alt="A BOOK APART LOGO" /></div>
      <div class="top_menu">
        <ul>
          <li class="sel"><a href="index.jsp">主页</a></li>
          <li><a href="login.jsp">登录</a></li>
          <li><a href="register.jsp">注册</a></li>
          <li><a href="#contact">联系我们</a></li>
        </ul>
      </div>
      <div class="top_shop_cur"><img src="Images/top_shop_cur.jpg" alt="shopping car" /></div>
    </div>
    <span class="index_img"><img src="Images/banner_img.jpg" alt="Dan Cederholm" border="0" usemap="#Map" />
        <map name="Map" id="Map">
          <area shape="rect" coords="857,230,930,269" href="login.jsp" alt="buy now" />
        </map>
        </span>
    <p class="index_hr"></p>
    <div class="content">
      <h1 class="h1_book_title">Also from A Book Apart</h1>
      <ul>
        <li>
          <dl>
            <dd><img src="Images/book_01.jpg" alt="book" /></dd>
            <dt>
              <p class="book_title"><a href="login.jsp" target="_blank">Gift cards</a></p>
              <p class="book_inline">$25, $50, and $100</p>
              <a class="book_buy" href="login.jsp" target="_blank">BUY</a>
            </dt>
          </dl>
        </li>
        <li>
          <dl>
            <dd><img src="Images/book_02.jpg" alt="book" /></dd>
            <dt>
              <p class="book_title"><a href="login.jsp" target="_blank">Just Enough Research</a></p>
              <p class="book_inline">by Erika Hall</p>
              <a class="book_buy" href="login.jsp" target="_blank">BUY</a>
            </dt>
          </dl>
        </li>
        <li>
          <dl>
            <dd><img src="Images/book_03.jpg" alt="book" /></dd>
            <dt>
              <p class="book_title"><a href="login.jsp" target="_blank">Content Strategy for Mobile</a></p>
              <p class="book_inline">by Karen McGrane</p>
              <a class="book_buy" href="login.jsp" target="_blank">BUY</a>
            </dt>
          </dl>
        </li>
        <li>
          <dl>
            <dd><img src="Images/book_04.jpg" alt="book" /></dd>
            <dt>
              <p class="book_title"><a href="login.jsp" target="_blank">Design Is a Job</a></p>
              <p class="book_inline">by Mike Monteiro</p>
              <a class="book_buy" href="login.jsp" target="_blank">BUY</a>
            </dt>
          </dl>
        </li>
        <li>
          <dl>
            <dd><img src="Images/book_05.jpg" alt="book" /></dd>
            <dt>
              <p class="book_title"><a href="login.jsp" target="_blank">Mobile First</a></p>
              <p class="book_inline">by Luke Wroblewski</p>
              <a class="book_buy" href="login.jsp" target="_blank">BUY</a>
            </dt>
          </dl>
        </li>
        <li>
          <dl>
            <dd><img src="Images/book_06.jpg" alt="book" /></dd>
            <dt>
              <p class="book_title"><a href="login.jsp" target="_blank">Designing for Emotion</a></p>
              <p class="book_inline">by Aarron Walter</p>
              <a class="book_buy" href="login.jsp" target="_blank">BUY</a>
            </dt>
          </dl>
        </li>
        <li>
          <dl>
            <dd><img src="Images/book_07.jpg" alt="book" /></dd>
            <dt>
              <p class="book_title"><a href="login.jsp" target="_blank">Responsive Web Design</a></p>
              <p class="book_inline">by Ethan Marcotte</p>
              <a class="book_buy" href="login.jsp" target="_blank">BUY</a>
            </dt>
          </dl>
        </li>
        <li>
          <dl>
            <dd><img src="Images/book_08.jpg" alt="book" /></dd>
            <dt>
              <p class="book_title"><a href="login.jsp" target="_blank">CSS3 for Web Designers</a></p>
              <p class="book_inline">by Dan Cederholm</p>
              <a class="book_buy" href="login.jsp" target="_blank">BUY</a>
            </dt>
          </dl>
        </li>
        <li>
          <dl>
            <dd><img src="Images/book_09.jpg" alt="book" /></dd>
            <dt>
              <p class="book_title"><a href="login.jsp" target="_blank">HTML5 for Web Designers</a></p>
              <p class="book_inline">by Jeremy Keith</p>
              <a class="book_buy" href="login.jsp" target="_blank">BUY</a>
            </dt>
          </dl>
        </li>
        <li>
          <dl>
            <dd><img src="Images/book_10.jpg" alt="book" /></dd>
            <dt>
              <p class="book_title"><a href="login.jsp" target="_blank">On Web Typography</a></p>
              <p class="book_inline">by Jason Santa Maria</p>
              <a class="book_buy" href="login.jsp" target="_blank">BUY</a>
            </dt>
          </dl>
        </li>
        <li>
          <dl>
            <dd><img src="Images/book_11.jpg" alt="book" /></dd>
            <dt>
              <p class="book_title"><a href="login.jsp" target="_blank">Responsible Responsive Design</a></p>
              <p class="book_inline">by Scott Jehl</p>
              <a class="book_buy" href="login.jsp" target="_blank">BUY</a>
            </dt>
          </dl>
        </li>
        <li>
          <dl>
            <dd><img src="Images/book_12.jpg" alt="book" /></dd>
            <dt>
              <p class="book_title"><a href="login.jsp" target="_blank">On Web Typography</a></p>
              <p class="book_inline">by Jason Santa Maria</p>
              <a class="book_buy" href="login.jsp" target="_blank">BUY</a>
            </dt>
          </dl>
        </li>
      </ul>
    </div>
    <p class="index_hr"></p>
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
    <p class="index_hr"></p>
    <p class="index_hr" style="margin-top:20px;"></p>
  </div>
</div>
</body>
</html>