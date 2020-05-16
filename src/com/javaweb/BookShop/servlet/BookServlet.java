package com.javaweb.BookShop.servlet;

import com.javaweb.BookShop.dao.BookDao;
import com.javaweb.BookShop.dao.impl.BookDaoImpl;
import com.javaweb.BookShop.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BookServlet extends HttpServlet { //需要继承HttpServlet  并重写doGet  doPost方法

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
        String user = request.getParameter("identity");
        BookDao bd = new BookDaoImpl();
        List<Book> bookList = bd.getBookAll();
        if (user.equals("C")) {
            request.setAttribute("bookList", bookList);
            request.getRequestDispatcher("/client_listbook.jsp").forward(request, response);
        }
        else {
            request.setAttribute("bookList", bookList);
            request.getRequestDispatcher("/admin_listbook.jsp").forward(request, response);
        }
    }

    private void find(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String identity = request.getParameter("identity");
        String bookid = request.getParameter("bookID");
        String name = request.getParameter("bookName");
        String writ = request.getParameter("writer");
        String publish = request.getParameter("publisher");
        String ty = request.getParameter("type");
        String sort = request.getParameter("sort");
        List<Book> bookList1 = new ArrayList<Book>();
        List<Book> bookList2 = new ArrayList<Book>();
        BookDao bd = new BookDaoImpl();
        if (!bookid.isEmpty()) {
            String meth = "bookID";
            String id = bookid;
            List<Book> list = bd.find(meth, id);
            bookList1.addAll(list);
        }
        else {
            if (!name.isEmpty()) {
                String meth = "bookName";
                String id = name;
                List<Book> list = bd.find(meth, id);
                bookList2.addAll(list);
            }
            if (!writ.isEmpty()) {
                String meth = "writer";
                String id = writ;
                List<Book> list = bd.find(meth, id);
                bookList2.addAll(list);
            }
            if (!publish.isEmpty()) {
                String meth = "publisher";
                String id = publish;
                List<Book> list = bd.find(meth, id);
                bookList2.addAll(list);
            }
            if (!ty.isEmpty()) {
                String meth = "type";
                String id = ty;
                List<Book> list = bd.find(meth, id);
                bookList2.addAll(list);
            }
        }
        if (!bookid.isEmpty()) {
            request.setAttribute("bookList", bookList1);
            if (identity.equals("C")) {
                request.getRequestDispatcher("/client_listbook.jsp").forward(request, response);
            }
            else {
                request.getRequestDispatcher("/admin_listbook.jsp").forward(request, response);
            }
        }
        else {
            List<Book> bookList3 = new ArrayList<>(new HashSet<>(bookList2));
            List<Book> bookList4 = new ArrayList<Book>();
            if (sort.equals("sales")) {
                bookList4 = bd.sortBookSales(bookList3);
            }
            if (sort.equals("price")) {
                bookList4 = bd.sortBookPrice(bookList3);
            }
            request.setAttribute("bookList", bookList4);
            if (identity.equals("C")) {
                request.getRequestDispatcher("/client_listbook.jsp").forward(request, response);
            }
            else {
                request.getRequestDispatcher("/admin_listbook.jsp").forward(request, response);
            }
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("bookName"); //获取jsp页面传过来的参数
        String writ = request.getParameter("writer");
        String publish = request.getParameter("publisher");
        String ty = request.getParameter("type");
        double pri = Double.parseDouble(request.getParameter("price"));
        int inven = Integer.parseInt(request.getParameter("inventory"));
        int sale = 0;
        String intro = request.getParameter("introduction");

        Book book = new Book();
        book.setBookName(name);
        book.setWriter(writ);
        book.setPublisher(publish);
        book.setType(ty);
        book.setPrice(pri);
        book.setInventory(inven);
        book.setSales(sale);
        book.setIntroduction(intro);

        BookDao bd = new BookDaoImpl();

        if (bd.add(book)) {
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('添加成功');window.location.href='admin_listbook.jsp';</script>");
        }
        else {
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('添加失败');window.location.href='admin_addbook.jsp';</script>");
        }
    }

    private void dele(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        BookDao bd = new BookDaoImpl();
        if (bd.delete(id)) {
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

        int id = Integer.parseInt(request.getParameter("bookID"));
        String name = request.getParameter("bookName"); //获取jsp页面传过来的参数
        String writ = request.getParameter("writer");
        String publish = request.getParameter("publisher");
        String ty = request.getParameter("type");
        double pri = Double.parseDouble(request.getParameter("price"));
        int inven = Integer.parseInt(request.getParameter("inventory"));
        String intro = request.getParameter("introduction");

        BookDao bd = new BookDaoImpl();

        if (bd.update(id, name, writ, publish, ty, pri, inven, intro)) {
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('修改成功');window.location.href='admin_listbook.jsp';</script>");
        }
        else {
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('修改失败');window.location.href='admin_listbook.jsp';</script>");
        }
    }

    private void sortSales(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookDao bd = new BookDaoImpl();
        List<Book> bookList = bd.getBookAll();
        request.setAttribute("bookList", bookList);
        request.getRequestDispatcher("/admin_listbook.jsp").forward(request, response);
    }
}
