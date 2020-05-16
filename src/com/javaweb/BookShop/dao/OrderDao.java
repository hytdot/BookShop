package com.javaweb.BookShop.dao;

import com.javaweb.BookShop.entity.Order;

import java.util.List;

public interface OrderDao {
    public List<Order> getOrderState(String state);//返回订单信息集合

    public List<Order> getOrderUserID(String id, String state);//根据用户id找到订单

    public boolean add(Order order);

    public boolean delete(int id);//根据id删除订单

    public boolean update(int id, String ordersta, String user, int bookid, String bookNa, int cou, double pri, String log);//更新订单信息

}
