package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;

public interface UserDao {

    void addUserToDataBase(User user);
    List<User> showAllUsersInDataBase();
    User showUserByIdFromDataBase(Long id);
    void updateUserInDataBase(User updatedUser);
    void deleteUserByIdInDataBase(Long id);
}
