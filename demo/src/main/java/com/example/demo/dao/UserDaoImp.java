package com.example.demo.dao;

import com.example.demo.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addUserToDataBase(User user) {

        entityManager.persist(user);
    }

    @Override
    public List<User> showAllUsersInDataBase() {

        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User showUserByIdFromDataBase(Long id) {

        return entityManager.find(User.class, id);
    }


    @Override
    public void updateUserInDataBase(User updatedUser) {

        entityManager.merge(updatedUser);
    }

    @Override
    public void deleteUserByIdInDataBase(Long id) {

        entityManager.remove(showUserByIdFromDataBase(id));
    }
}
