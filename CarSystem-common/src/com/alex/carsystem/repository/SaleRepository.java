/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.carsystem.repository;

import com.alex.carsystem.entity.Sales;
import com.alex.carsystem.entity.Users;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Alex
 */
@Remote
public interface SaleRepository {
    public List<Sales> queryAll();
    
    public void createOrder(Sales sales);
    
    public void deleteOrder(Sales sales);
    
    public void updateOrder(Sales sales);
    
    public List<Sales> customerOrderQuery(int customerId);
    
    public List<Sales> salesmanQuery(int id, String carID);
    
    
}
