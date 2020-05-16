package com.javaweb.BookShop.servlet;

import com.javaweb.BookShop.dao.UserDao;
import com.javaweb.BookShop.dao.impl.UserDaoImpl;
import com.javaweb.BookShop.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UserServlet extends HttpServlet { //需要继承HttpServlet  并重写doGet  doPost方法

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getParameter("meth");
        if(method.equalsIgnoreCase("list")){
            list(request, response);
        }
        if(method.equalsIgnoreCase("find")){
            find(request, response);
        }
        if(method.equalsIgnoreCase("add")){
            add(request, response);
        }
        if(method.equalsIgnoreCase("dele")){
            dele(request, response);
        }
        if(method.equalsIgnoreCase("update")){
            update(request, response);
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao ud = new UserDaoImpl();
        List<User> userList = ud.getUserAll();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/admin_listuser.jsp").forward(request, response);
    }

    private void find(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String identity = request.getParameter("identity");
        String id = request.getParameter("userID");
        UserDao ud = new UserDaoImpl();
        User user = ud.find(id);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        if (identity.equals("C")) {
            request.setAttribute("U", userList.get(0));
            request.getRequestDispatcher("/client_listuser.jsp").forward(request, response);
        }
        else {
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("/admin_listuser.jsp").forward(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("userID"); //获取jsp页面传过来的参数
        String pwd = request.getParameter("password");
        String admin = new String("S");
        String addr = request.getParameter("address");
        String pho = request.getParameter("phone");

        User user = new User(); //实例化一个对象，组装属性
        user.setUserID(id);
        user.setPassword(pwd);
        user.setIdentity(admin);
        user.setAddress(addr);
        user.setPhone(pho);

        UserDao ud = new UserDaoImpl();

        if (ud.register(user)) {
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('添加成功');window.location.href='admin_addadmin.jsp';</script>");
        }
        else {
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('添加失败');window.location.href='admin_addadmin.jsp';</script>");
        }
    }

    private void dele(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        UserDao ud = new UserDaoImpl();
        if (ud.delete(id)) {
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('删除成功');window.location.href='admin_listuser.jsp';</script>");
        }
        else {
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('删除失败');window.location.href='admin_listuser.jsp';</script>");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("userID"); //获取jsp页面传过来的参数
        String pwd = request.getParameter("password");
        String iden = request.getParameter("identity");
        String addr = request.getParameter("address");
        String pho = request.getParameter("phone");

        UserDao ud = new UserDaoImpl();

        if (ud.update(id, pwd, iden, addr, pho)) {
            PrintWriter out = response.getWriter();
            if (iden.equals("C")) {
                out.print("<script language='javascript'>alert('修改成功');window.location.href='client_listuser.jsp';</script>");
            }
            else {
                out.print("<script language='javascript'>alert('修改成功');window.location.href='admin_listuser.jsp';</script>");
            }
        }
        else {
            PrintWriter out = response.getWriter();
            if (iden.equals("C")) {
                out.print("<script language='javascript'>alert('修改失败');window.location.href='client_listuser.jsp';</script>");
            }
            else {
                out.print("<script language='javascript'>alert('修改失败');window.location.href='admin_listuser.jsp';</script>");
            }
        }
    }
}
