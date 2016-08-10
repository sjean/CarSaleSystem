/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.carsystem.repository;

import com.alex.carsystem.entity.Car;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface CarRepository {
    
    public void createCar(Car car);
    
    public void deleteCar(Car car);
    
    public void updateCar(Car car);
    
    public List<Car> queryCar(String manufacturer, String modelName, String modelNo, int carType);
    
    public Car queryCar(String carId);
    
    public List<Car> queryAll();
    
    public Car QueryCar(String carId);
    
    public void removeCar(String carId);
    
    public void close();
    
    public List<Car> combinedSearch(int type,String modelNo,String modeNameString,String make);

    public List<Car> queryCar(String VIN, String manufacture, String modelName, String modelNo, int type);
}
