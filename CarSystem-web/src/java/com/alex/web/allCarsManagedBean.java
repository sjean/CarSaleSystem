/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.web;

import com.alex.carsystem.entity.Car;
import com.alex.carsystem.repository.CarRepository;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Alex
 */
@Named(value = "allCarsManagedBean")
@RequestScoped
public class allCarsManagedBean {

    private  List<Car> cars;
    @EJB
    private CarRepository carRepository;
    
    
    /**
     * Creates a new instance of allCarsManagedBean 
     */
    
   
    public allCarsManagedBean() {
        
    }

    public List<Car> getCars() {
        cars = carRepository.queryAll();
        System.out.println("#############"+cars);
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    
}
