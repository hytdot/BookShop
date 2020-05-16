package com.javaweb.BookShop.servlet;

import com.javaweb.BookShop.dao.BookDao;
import com.javaweb.BookShop.dao.OrderDao;
import com.javaweb.BookShop.dao.impl.BookDaoImpl;
import com.javaweb.BookShop.dao.impl.OrderDaoImpl;
import com.javaweb.BookShop.entity.Book;
import com.javaweb.BookShop.entity.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class OrderServlet extends HttpServlet { //需要继承HttpServlet  并重写doGet  doPost方法

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
        if(method.equalsIgnoreCase("getbook")){
            getbook(request, response);
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String state = request.getParameter("orderstate");
        OrderDao od = new OrderDaoImpl();
        List<Order> orderList = od.getOrderState(state);
        request.setAttribute("orderList", orderList);
        request.getRequestDispatcher("/admin_listorder.jsp").forward(request, response);
    }

    private void find(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String identity = request.getParameter("identity");
        String userid = request.getParameter("userID");
        String state = request.getParameter("orderState");
        OrderDao od = new OrderDaoImpl();
        List<Order> orderList = od.getOrderUserID(userid, state);
        request.setAttribute("orderList", orderList);
        if (identity.equals("C")) {
            if (state.equals("未付款")) {
                request.getRequestDispatcher("/client_unpayorder.jsp").forward(request, response);
            }
            else if (state.equals("未收货")) {
                request.getRequestDispatcher("/client_ungetorder.jsp").forward(request, response);
            }
            else {
                request.getRequestDispatcher("/client_listorder.jsp").forward(request, response);
            }
        }
        else {
            request.getRequestDispatcher("/admin_listorder.jsp").forward(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userid = request.getParameter("userID"); //获取jsp页面传过来的参数
        String bookid = request.getParameter("bookID");
        int bookID = Integer.parseInt(bookid);
        String bookname = request.getParameter("bookName");
        int count = Integer.parseInt(request.getParameter("count"));

        BookDao bd = new BookDaoImpl();
        List<Book> bookList = bd.find("bookID", bookid);
        Book book = bookList.get(0);
        double price = book.getPrice() * count;
        if (book.getInventory() < count) {
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('本书库存量不足！');window.location.href='client_listbook.jsp';</script>");
            return;
        }

        Order order = new Order();
        order.setOrderState("未付款");
        order.setUserID(userid);
        order.setBookID(bookID);
        order.setBookName(bookname);
        order.setCount(count);
        order.setPrice(price);
        order.setLogistics(null);

        OrderDao od = new OrderDaoImpl();

        if (od.add(order)) {
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('下单成功');window.location.href='client_listbook.jsp';</script>");
        }
        else {
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('下单失败');window.location.href='client_listbook.jsp';</script>");
        }
    }

    private void dele(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String identity = request.getParameter("identity");
        int id = Integer.parseInt(request.getParameter("id"));
        OrderDao od = new OrderDaoImpl();
        if (od.delete(id)) {
            PrintWriter out = response.getWriter();
            if (identity.equals("C")) {
                out.print("<script language='javascript'>alert('删除成功');window.location.href='client_unpayorder.jsp';</script>");
            }
            else {
                out.print("<script language='javascript'>alert('删除成功');window.location.href='admin_listorder.jsp';</script>");
            }
        }
        else {
            PrintWriter out = response.getWriter();
            if (identity.equals("C")) {
                out.print("<script language='javascript'>alert('删除失败');window.location.href='client_unpayorder.jsp';</script>");
            }
            else {
                out.print("<script language='javascript'>alert('删除失败');window.location.href='admin_listorder.jsp';</script>");
            }
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String identity = request.getParameter("identity");
        int id = Integer.parseInt(request.getParameter("orderID"));
        String state = request.getParameter("orderState"); //获取jsp页面传过来的参数
        String user = request.getParameter("userID");
        String bookid = request.getParameter("bookID");
        int bookID = Integer.parseInt(bookid);
        String bookname = request.getParameter("bookName");
        int count = Integer.parseInt(request.getParameter("count"));
        String log = request.getParameter("logistics");

        BookDao bd = new BookDaoImpl();
        List<Book> bookList = bd.find("bookID", bookid);
        Book book = bookList.get(0);
        double price = book.getPrice() * count;

        OrderDao od = new OrderDaoImpl();

        if (od.update(id, state, user, bookID, bookname, count, price, log)) {
            PrintWriter out = response.getWriter();
            if (identity.equals("C")) {
                out.print("<script language='javascript'>alert('修改成功');window.location.href='client_updateorder.jsp';</script>");
            }
            else {
                out.print("<script language='javascript'>alert('修改成功');window.location.href='admin_listorder.jsp';</script>");
            }
        }
        else {
            PrintWriter out = response.getWriter();
            if (identity.equals("C")) {
                out.print("<script language='javascript'>alert('修改失败');window.location.href='client_updateorder.jsp';</script>");
            }
            else {
                out.print("<script language='javascript'>alert('修改失败');window.location.href='admin_listorder.jsp';</script>");
            }
        }
    }

    private void getbook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("orderID"));
        String state = "已完成"; //获取jsp页面传过来的参数
        String user = request.getParameter("userID");
        String bookid = request.getParameter("bookID");
        int bookID = Integer.parseInt(bookid);
        String bookname = request.getParameter("bookName");
        int count = Integer.parseInt(request.getParameter("count"));
        Double price = Double.parseDouble(request.getParameter("price"));
        String log = request.getParameter("logistics");

        BookDao bd = new BookDaoImpl();
        List<Book> bookList = bd.find("bookID", bookid);
        Book book = bookList.get(0);
        book.setSales(book.getSales()+count);
        book.setInventory(book.getInventory()-count);

        OrderDao od = new OrderDaoImpl();

        if (bd.updateSales(bookID, bookname, book.getWriter(), book.getPublisher(), book.getType(), book.getPrice(), book.getSales(), book.getInventory(), book.getIntroduction())  && od.update(id, state, user, bookID, bookname, count, price, log)) {
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('确认成功');window.location.href='client_ungetorder.jsp';</script>");
        }
        else {
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('确认失败');window.location.href='client_ungetorder.jsp';</script>");
        }
    }
}
