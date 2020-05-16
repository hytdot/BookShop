package com.javaweb.BookShop.dao.impl;

import com.javaweb.BookShop.dao.UserDao;
import com.javaweb.BookShop.entity.User;
import com.javaweb.BookShop.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public int login(String id, String pwd) {
        int flag = -1;
        String admin = new String("S");
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from user where userID = '"+id+"' and password = '"+pwd+"'");
            while(rs.next()){
                if(rs.getString("userID").equals(id) && rs.getString("password").equals(pwd)){
                    if (rs.getString("identity").equals(admin)) {
                        flag = 1;
                    }
                    else {
                        flag = 0;
                    }
                }
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean register(User user) {
        boolean flag = false;
        DBconn.init();
        int i = DBconn.addUpdDel("insert into user (userID, password, identity, address, phone)" +
                "values('"+user.getUserID()+"', '"+user.getPassword()+"', '"+user.getIdentity()+"', '"+user.getAddress()+"', '"+user.getPhone()+"')");
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public List<User> getUserAll() {
        List<User> list = new ArrayList<User>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from user");
            while(rs.next()){
                User user = new User();
                user.setUserID(rs.getString("userID"));
                user.setPassword(rs.getString("password"));
                user.setIdentity(rs.getString("identity"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                list.add(user);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        boolean flag = false;
        DBconn.init();
        int i = DBconn.addUpdDel("delete from user where userID = '"+id+"'");
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public boolean update(String id, String pwd, String iden, String addr, String pho) {
        boolean flag = false;
        DBconn.init();
        String sql ="update user set userID ='"+id+"', " +
                "password ='"+pwd+"' , " +
                "identity ='"+iden+"' , " +
                "address ='"+addr+"' , " +
                "phone ='"+pho+"' " +
                "where userID = '"+id+"'";
        int i = DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public User find(String id) {
        User user = new User();
        try {
            DBconn.init();
            ResultSet rs1 = DBconn.selectSql("select * from user where userID = '"+id+"'");
            while (rs1.next()){
                user.setUserID(rs1.getString("userID"));
                user.setPassword(rs1.getString("password"));
                user.setIdentity(rs1.getString("identity"));
                user.setAddress(rs1.getString("address"));
                user.setPhone(rs1.getString("phone"));
            }
            DBconn.closeConn();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
