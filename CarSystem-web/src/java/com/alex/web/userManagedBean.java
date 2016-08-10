/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.web;

import com.alex.carsystem.entity.Users;
import com.alex.carsystem.repository.UserRepository;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author Alex
 */
@Named(value = "registerManagedBean")
@SessionScoped
public class userManagedBean  implements Serializable{

    private int id;
    private String lastName;
    private String firstName;
    @Email(message = "The format of you email is not right!")
    private String emailString;
    private String password;
    private int userType;
    private  String address;
    private long phoneNumber;
    private String messageString = null;
    private Users user;
    

    @EJB
    private  UserRepository userRepository; 
    
     public String addUser(){
         Users user = new Users(lastName, firstName, emailString, password, userType, address, phoneNumber);
//         System.out.println("##############" + user.toString());
    
         userRepository.addUser(user);
         return "Register successfully!";
    }

     public String logOut() {
        String outCome = "login";
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession Session = (HttpSession) fc.getExternalContext()
                .getSession(false);
        Session.invalidate();
        return outCome;
    }
    public String login(){
        user = userRepository.queryUser(emailString, password);
        if (null != user) {
            if (user.getUserType()==1) {
                return "salesman-info";
            }
            return "customer-info";
        }else
            return messageString = "Login failed, please check your name or password!";
        
    }
    
    public String customerQuery(){
        Users result = userRepository.queryUserBySalesman(id, lastName, firstName, userType, emailString);
        if (null != result) {
            return "customer-info";
            
        }else{
            return messageString = "The customer does not exit!";
        }
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    
    public String getMessageString() {
        return messageString;
    }

    public void setMessageString(String messageString) {
        this.messageString = messageString;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmailString() {
        return emailString;
    }

    public void setEmailString(String emailString) {
        this.emailString = emailString;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Creates a new instance of registerManagedBean
     */
    
    
    public userManagedBean() {
    }
    
}
