/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.carsystem.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Alex
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Car.FIND_ALL, query = "SELECT c FROM Car c")
})
public class Car implements Serializable {
    public static final String FIND_ALL = "Car.findAll";
    public static final String QUERY_BY_MODEL_AND_TYPE = "Car.queryByModelAndType";
    
    private String VIN;
    private int carType;
    private String thumbNail;
    private String description;
    private String previewUrl;
    
    private String produceTime;
    private boolean state;
    private String modelNo;
    private String modelName;
    private String manufacturer;
    public Car(){}

    public Car(String VIN, int carType, String thumbNail, String description, String previewUrl, boolean state, String modelNo, String modelName, String manufacturer) {
        this.VIN = VIN;
        this.carType = carType;
        this.thumbNail = thumbNail;
        this.description = description;
        this.previewUrl = previewUrl;
        this.state = state;
        this.modelNo = modelNo;
        this.modelName = modelName;
        this.manufacturer = manufacturer;
    }

    

    public Car(int carType, String modelNo, String modelName, String manufacturer) {
        this.carType = carType;
        this.modelNo = modelNo;
        this.modelName = modelName;
        this.manufacturer = manufacturer;
    }
    
    public Car(String make, String modelName) {
        this.manufacturer = make;
        this.modelName = modelName;
        
     }
    
    @Id
    @Column(name = "vin")
    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    @Column(name = "car_type")
    public int getCarType() {
        return carType;
    }

    public void setCarType(int carType) {
        this.carType = carType;
    }
    
    @Column(name = "thumb_nail")
    public String getThumbNail() {
        return thumbNail;
    }

    public void setThumbNail(String thumbNail) {
        this.thumbNail = thumbNail;
    }
    
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    @Column(name = "preview_url")
    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }
    
    @Column(name = "produce_time")
    public String getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(String produceTime) {
        this.produceTime = produceTime;
    }
    
    
    @Column(name = "state")
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    
    @Column(name = "model_no")
    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }
    
    @Column(name = "model_name")
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    
    @Column(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Car{" + "carId=" + VIN + ", carType=" + carType + ", thumbNail=" + thumbNail + ", description=" + description + ", previewUrl=" + previewUrl + ", produceTime=" + produceTime + ", state=" + state + ", modelNo=" + modelNo + ", modelName=" + modelName + ", manufacturer=" + manufacturer + '}';
    }
    
    
    
}
