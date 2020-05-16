package com.javaweb.BookShop.servlet;

import com.javaweb.BookShop.dao.UserDao;
import com.javaweb.BookShop.dao.impl.UserDaoImpl;
import com.javaweb.BookShop.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String id = request.getParameter("userID"); //获取jsp页面传过来的参数
        String pwd = request.getParameter("password");
        String client = new String("C");
        String addr = request.getParameter("address");
        String pho = request.getParameter("phone");

        User user = new User(); //实例化一个对象，组装属性
        user.setUserID(id);
        user.setPassword(pwd);
        user.setIdentity(client);
        user.setAddress(addr);
        user.setPhone(pho);

        UserDao ud = new UserDaoImpl();

        if (ud.register(user)) {
            session.setAttribute("identity", "C");
            session.setAttribute("user", id);
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('注册成功');window.location.href='login.jsp';</script>");
        }
        else {
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('注册失败');window.location.href='register.jsp';</script>");
        }
    }
}
