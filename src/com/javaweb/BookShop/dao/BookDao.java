package com.javaweb.BookShop.dao;

import com.javaweb.BookShop.entity.Book;

import java.util.List;

public interface BookDao {
    public List<Book> getBookAll();//返回图书信息集合

    public List<Book> sortBookSales(List<Book> list);//返回图书信息集合

    public List<Book> sortBookPrice(List<Book> list);//返回图书信息集合

    public List<Book> find(String meth, String id);//查找图书

    public boolean add(Book book);//增加图书

    public boolean delete(int id);//根据id删除图书

    public boolean update(int id, String name, String writ, String publish, String ty, double pri, int inven, String intro);//更新图书信息

    public boolean updateSales(int id, String name, String writ, String publish, String ty, double pri, int sales, int inven, String intro);//更新图书信息
}
