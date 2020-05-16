package com.javaweb.BookShop.dao.impl;

import com.javaweb.BookShop.dao.OrderDao;
import com.javaweb.BookShop.entity.Order;
import com.javaweb.BookShop.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public List<Order> getOrderState(String state) {
        List<Order> list = new ArrayList<Order>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from `order` where orderState = '"+state+"'");
            while(rs.next()){
                Order order = new Order();
                order.setOrderID(rs.getInt("orderID"));
                order.setOrderState(rs.getString("orderState"));
                order.setUserID(rs.getString("userID"));
                order.setBookID(rs.getInt("bookID"));
                order.setBookName(rs.getString("bookName"));
                order.setCount(rs.getInt("count"));
                order.setPrice(rs.getDouble("price"));
                order.setLogistics(rs.getString("logistics"));
                list.add(order);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Order> getOrderUserID(String id, String state) {
        List<Order> list = new ArrayList<Order>();
        try {
            if (state.isEmpty()) {
                DBconn.init();
                ResultSet rs = DBconn.selectSql("select * from `order` where userID = '"+id+"' ");
                while(rs.next()){
                    Order order = new Order();
                    order.setOrderID(rs.getInt("orderID"));
                    order.setOrderState(rs.getString("orderState"));
                    order.setUserID(rs.getString("userID"));
                    order.setBookID(rs.getInt("bookID"));
                    order.setBookName(rs.getString("bookName"));
                    order.setCount(rs.getInt("count"));
                    order.setPrice(rs.getDouble("price"));
                    order.setLogistics(rs.getString("logistics"));
                    list.add(order);
                }
                DBconn.closeConn();
                return list;
            }
            else {
                DBconn.init();
                ResultSet rs = DBconn.selectSql("select * from `order` where userID = '"+id+"' and orderState = '"+state+"'");
                while(rs.next()){
                    Order order = new Order();
                    order.setOrderID(rs.getInt("orderID"));
                    order.setOrderState(rs.getString("orderState"));
                    order.setUserID(rs.getString("userID"));
                    order.setBookID(rs.getInt("bookID"));
                    order.setBookName(rs.getString("bookName"));
                    order.setCount(rs.getInt("count"));
                    order.setPrice(rs.getDouble("price"));
                    order.setLogistics(rs.getString("logistics"));
                    list.add(order);
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
    public boolean add(Order order) {
        boolean flag = false;
        DBconn.init();
        int i = DBconn.addUpdDel("insert into `order` (orderState, userID, bookID, bookName, count, price, logistics)" +
                "values('"+order.getOrderState()+"', '"+order.getUserID()+"', '"+order.getBookID()+"', '"+order.getBookName()+"', '"+order.getCount()+"', '"+order.getPrice()+"', '"+order.getLogistics()+"')");
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
        int i = DBconn.addUpdDel("delete from `order` where orderID = '"+id+"'");
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public boolean update(int id, String ordersta, String user, int bookid, String bookNa, int cou, double pri, String log) {
        boolean flag = false;
        DBconn.init();
        String sql ="update `order` set orderState ='"+ordersta+"', " +
                "userID ='"+user+"' , " +
                "bookID ='"+bookid+"' , " +
                "bookName ='"+bookNa+"' , " +
                "count ='"+cou+"' , " +
                "price ='"+pri+"' , " +
                "logistics ='"+log+"' " +
                "where orderID = '"+id+"'";
        int i = DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }
}
