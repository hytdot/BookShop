package com.javaweb.BookShop.servlet;

import com.javaweb.BookShop.dao.UserDao;
import com.javaweb.BookShop.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet { //需要继承HttpServlet  并重写doGet  doPost方法

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String id = request.getParameter("userID"); //得到jsp页面传过来的参数
        String pwd = request.getParameter("password");

        UserDao ud = new UserDaoImpl();

        if(ud.login(id, pwd) != -1){
            if (ud.login(id, pwd) == 1) {           //管理员成功登录
                session.setAttribute("identity", "S");
                session.setAttribute("user", id);
                PrintWriter out = response.getWriter();
                out.print("<script language='javascript'>alert('管理员登录成功');window.location.href='admin.jsp';</script>");
            }
            else {                                  //普通用户成功登录
                session.setAttribute("identity", "C");
                session.setAttribute("user", id);
                PrintWriter out = response.getWriter();
                out.print("<script language='javascript'>alert('登录成功');window.location.href='client.jsp';</script>");
            }
        }
        else {
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('登录失败');window.location.href='login.jsp';</script>");
        }
    }

}
