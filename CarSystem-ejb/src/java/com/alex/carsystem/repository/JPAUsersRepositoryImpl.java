/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.carsystem.repository;

import com.alex.carsystem.entity.Users;
//import com.sun.org.apache.bcel.internal.generic.Select;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alex
 */
@PermitAll
@Stateless
public class JPAUsersRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(Users user) {
        entityManager.persist(user);

    }

    @Override
    public Users queryUser(String email, String password) {
//        System.out.println("hellllll");
        Query query = entityManager.createQuery("select u from Users u where u.emailString = :email and u.password = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        List<Users> users = query.getResultList();
        if (users.isEmpty()) {
            return null;
        } else {
            return (Users) query.getResultList().get(0);
        }

    }

    @Override
    public Users queryUserBySalesman(int id, String lastName, String firstName, int type, String emailString) {
     Query query = entityManager.createQuery("select u from Users u where u.id = :id and u.lastName = :lastName and u.firstName = :firstName and u.userType = :userType and u.emailString = :emailString");
     query.setParameter("id", id);
     query.setParameter("lastName", lastName);
     query.setParameter("firstName", firstName);
     query.setParameter("userType", type);
     query.setParameter("emailString", emailString);
     List<Users> users = query.getResultList();
        if (users.isEmpty()) {
            return null;
            
        }else{
            return (Users) query.getResultList().get(0);
        }
     
    
    }

    @Override
    public Users finduserIdByuserName(String salesmanNameString) {
        Query query = entityManager.createQuery("SELECT u FROM Users u WHERE u.firstName = :firstName");
        query.setParameter("firstName", salesmanNameString);
        List<Users> users = query.getResultList();
        if (users.isEmpty()) {
            return null;

        } else {
            return (Users) query.getResultList().get(0);
        }
    }

}
