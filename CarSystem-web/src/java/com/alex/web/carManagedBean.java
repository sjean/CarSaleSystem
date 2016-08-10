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
@Named(value = "indexManagedBean")
@RequestScoped
public class carManagedBean {

    private String VIN;
    private String modelNo;
    private String modelName;
    private int type;
    private String manufacture;
    private String previewURL;
    private String thumnail;
    private String description;
    private boolean carState;
    private String messageString = null;
    
    private  List<Car> cars;
    private  Car car;
    
    
    @EJB
    private CarRepository carRepository;

    
    public carManagedBean(String modelNo, String modelName, int type, String manufacture) {
        this.modelNo = modelNo;
        this.modelName = modelName;
        this.type = type;
        this.manufacture = manufacture;
    }
    
    public String removeCar(){
        VIN =car.getVIN();
        if (null != this.VIN) {
            carRepository.removeCar(this.VIN);
            return messageString = "delete successfully!";
        }else{
          return messageString = "delete failed!";
        }
    }
    
    public  String updateCar(){
        if (this.car != null) {
            carRepository.updateCar(this.car);
            return messageString = "update successfully!";
        }else{
          return messageString = "update failed!";
        }
        
    }
    
    public List<Car> searchCar(){
        cars = carRepository.queryCar(manufacture, modelName, modelNo, type);
        if (!cars.isEmpty()) {
            return cars;
        }else
            return null;
    }
    
    public String searchCarBySalesman(){
        car = carRepository.QueryCar(VIN);
        if (null != car) {
            return "car-management";
        }else{
            return messageString = "Can not find the car!";
        }
    }
    
    public void createCar(){
        Car newcar = new Car(VIN, type, thumnail, description, previewURL, carState, modelNo, modelName, manufacture);
        carRepository.createCar(newcar);
    }
    
    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public String getMessageString() {
        return messageString;
    }

    public void setMessageString(String messageString) {
        this.messageString = messageString;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    public String getThumnail() {
        return thumnail;
    }

    public void setThumnail(String thumnail) {
        this.thumnail = thumnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getCarState() {
        return carState;
    }

    public void setCarState(boolean carState) {
        this.carState = carState;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    
    
    
    /**
     * Creates a new instance of indexManagedBean
     */
    
    
    public carManagedBean() {
      this.car = new Car();
    }

    
    
}
