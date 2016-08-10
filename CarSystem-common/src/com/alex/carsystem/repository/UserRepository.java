/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.carsystem.repository;

import com.alex.carsystem.entity.Users;
import javax.ejb.Remote;

/**
 *
 * @author Alex
 */
@Remote
public interface UserRepository {
    public void addUser(Users user);

    public Users queryUser(String email, String password);
    
    public Users finduserIdByuserName(String salesmanNameString);
    
    public Users queryUserBySalesman(int id, String lastName, String firstName, int type, String emailString);
    
}
