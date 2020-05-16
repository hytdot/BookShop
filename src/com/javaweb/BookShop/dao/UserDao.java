package com.javaweb.BookShop.dao;

import com.javaweb.BookShop.entity.User;

import java.util.List;

public interface UserDao {
    public int login(String id, String pwd);//登录

    public boolean register(User user);//用户注册

    public List<User> getUserAll();//返回用户信息集合

    public boolean delete(String id);//根据id删除用户

    public boolean update(String id, String pwd, String iden, String addr, String pho);//更新用户信息

    public User find(String id);//根据id查找用户
}
