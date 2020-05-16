package com.javaweb.BookShop.dao.impl;

import com.javaweb.BookShop.dao.BookDao;
import com.javaweb.BookShop.entity.Book;
import com.javaweb.BookShop.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> getBookAll() {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book");
            while(rs.next()){
                Book book = new Book();
                book.setBookID(rs.getInt("bookID"));
                book.setBookName(rs.getString("bookName"));
                book.setWriter(rs.getString("writer"));
                book.setPublisher(rs.getString("publisher"));
                book.setType(rs.getString("type"));
                book.setPrice(rs.getDouble("price"));
                book.setInventory(rs.getInt("inventory"));
                book.setSales(rs.getInt("sales"));
                book.setIntroduction(rs.getString("introduction"));
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> sortBookSales(List<Book> list) {
        Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getSales()-b2.getSales();
            }
        });
        Collections.reverse(list);
        return list;
    }

    @Override
    public List<Book> sortBookPrice(List<Book> list) {
        Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return (int)(b1.getPrice()-b2.getPrice());
            }
        });
        return list;
    }

    @Override
    public List<Book> find(String meth, String id) {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            if (meth == "bookID") {
                int bookid = Integer.parseInt(id);
                ResultSet rs = DBconn.selectSql("select * from book where bookID = '"+bookid+"'");
                while(rs.next()){
                    Book book = new Book();
                    book.setBookID(rs.getInt("bookID"));
                    book.setBookName(rs.getString("bookName"));
                    book.setWriter(rs.getString("writer"));
                    book.setPublisher(rs.getString("publisher"));
                    book.setType(rs.getString("type"));
                    book.setPrice(rs.getDouble("price"));
                    book.setInventory(rs.getInt("inventory"));
                    book.setSales(rs.getInt("sales"));
                    book.setIntroduction(rs.getString("introduction"));
                    list.add(book);
                }
                DBconn.closeConn();
                return list;
            }
            if (meth == "bookID") {
                int bookid = Integer.parseInt(id);
                ResultSet rs = DBconn.selectSql("select * from book where bookID = '"+bookid+"'");
                while(rs.next()){
                    Book book = new Book();
                    book.setBookID(rs.getInt("bookID"));
                    book.setBookName(rs.getString("bookName"));
                    book.setWriter(rs.getString("writer"));
                    book.setPublisher(rs.getString("publisher"));
                    book.setType(rs.getString("type"));
                    book.setPrice(rs.getDouble("price"));
                    book.setInventory(rs.getInt("inventory"));
                    book.setSales(rs.getInt("sales"));
                    book.setIntroduction(rs.getString("introduction"));
                    list.add(book);
                }
                DBconn.closeConn();
                return list;
            }
            if (meth == "bookName") {
                ResultSet rs = DBconn.selectSql("select * from book where bookName = '"+id+"'");
                while(rs.next()){
                    Book book = new Book();
                    book.setBookID(rs.getInt("bookID"));
                    book.setBookName(rs.getString("bookName"));
                    book.setWriter(rs.getString("writer"));
                    book.setPublisher(rs.getString("publisher"));
                    book.setType(rs.getString("type"));
                    book.setPrice(rs.getDouble("price"));
                    book.setInventory(rs.getInt("inventory"));
                    book.setSales(rs.getInt("sales"));
                    book.setIntroduction(rs.getString("introduction"));
                    list.add(book);
                }
                DBconn.closeConn();
                return list;
            }
            if (meth == "writer") {
                ResultSet rs = DBconn.selectSql("select * from book where writer = '"+id+"'");
                while(rs.next()){
                    Book book = new Book();
                    book.setBookID(rs.getInt("bookID"));
                    book.setBookName(rs.getString("bookName"));
                    book.setWriter(rs.getString("writer"));
                    book.setPublisher(rs.getString("publisher"));
                    book.setType(rs.getString("type"));
                    book.setPrice(rs.getDouble("price"));
                    book.setInventory(rs.getInt("inventory"));
                    book.setSales(rs.getInt("sales"));
                    book.setIntroduction(rs.getString("introduction"));
                    list.add(book);
                }
                DBconn.closeConn();
                return list;
            }
            if (meth == "publisher") {
                ResultSet rs = DBconn.selectSql("select * from book where publisher = '"+id+"'");
                while(rs.next()){
                    Book book = new Book();
                    book.setBookID(rs.getInt("bookID"));
                    book.setBookName(rs.getString("bookName"));
                    book.setWriter(rs.getString("writer"));
                    book.setPublisher(rs.getString("publisher"));
                    book.setType(rs.getString("type"));
                    book.setPrice(rs.getDouble("price"));
                    book.setInventory(rs.getInt("inventory"));
                    book.setSales(rs.getInt("sales"));
                    book.setIntroduction(rs.getString("introduction"));
                    list.add(book);
                }
                DBconn.closeConn();
                return list;
            }
            if (meth == "type") {
                ResultSet rs = DBconn.selectSql("select * from book where type = '"+id+"'");
                while(rs.next()){
                    Book book = new Book();
                    book.setBookID(rs.getInt("bookID"));
                    book.setBookName(rs.getString("bookName"));
                    book.setWriter(rs.getString("writer"));
                    book.setPublisher(rs.getString("publisher"));
                    book.setType(rs.getString("type"));
                    book.setPrice(rs.getDouble("price"));
                    book.setInventory(rs.getInt("inventory"));
                    book.setSales(rs.getInt("sales"));
                    book.setIntroduction(rs.getString("introduction"));
                    list.add(book);
                }
                DBconn.closeConn();
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Book book) {
        boolean flag = false;
        DBconn.init();
        int i = DBconn.addUpdDel("insert into book (bookName, writer, publisher, type, price, inventory, sales, introduction)" +
                "values('"+book.getBookName()+"', '"+book.getWriter()+"', '"+book.getPublisher()+"', '"+book.getType()+"', '"+book.getPrice()+"', '"+book.getInventory()+"', '"+book.getSales()+"', '"+book.getIntroduction()+"')");
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        DBconn.init();
        int i = DBconn.addUpdDel("delete from book where bookID = '"+id+"'");
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public boolean update(int id, String name, String writ, String publish, String ty, double pri, int inven, String intro) {
        boolean flag = false;
        DBconn.init();
        String sql ="update book set bookName ='"+name+"', " +
                "writer ='"+writ+"' , " +
                "publisher ='"+publish+"' , " +
                "type ='"+ty+"' , " +
                "price ='"+pri+"' , " +
                "inventory ='"+inven+"' , " +
                "introduction ='"+intro+"' " +
                "where bookID = '"+id+"'";
        int i = DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public boolean updateSales(int id, String name, String writ, String publish, String ty, double pri, int sales, int inven, String intro) {
        boolean flag = false;
        DBconn.init();
        String sql ="update book set bookName ='"+name+"', " +
                "writer ='"+writ+"' , " +
                "publisher ='"+publish+"' , " +
                "type ='"+ty+"' , " +
                "price ='"+pri+"' , " +
                "sales ='"+sales+"' , " +
                "inventory ='"+inven+"' , " +
                "introduction ='"+intro+"' " +
                "where bookID = '"+id+"'";
        int i = DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }
}
