/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.carsystem.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Alex
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Users.FIND_ALL, query = "SELECT c FROM Users c")
})
public class Users implements Serializable {
    public static final String FIND_ALL = "Users.findAll";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String lastName;
    private String firstName;
    private String emailString;
    private String password;
    private int userType;
    private  String address;
    private long number;
    
    public Users(){}

    public Users(String lastName, String firstName, String password, int userType) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.userType = userType;
    }

    
    public Users(String lastName, String firstName, String emailString, String password, int userType, String address, long number) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.emailString = emailString;
        this.password = password;
        this.userType = userType;
        this.address = address;
        this.number = number;
    }

    public Users(int id, String lastName, String firstName, String emailString, String password, int userType, String address, long number) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.emailString = emailString;
        this.password = password;
        this.userType = userType;
        this.address = address;
        this.number = number;
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

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", emailString=" + emailString + ", password=" + password + ", userType=" + userType + ", address=" + address + ", number=" + number + '}';
    }

   
    
}
