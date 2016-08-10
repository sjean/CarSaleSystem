/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.carsystem.gui;



import com.alex.carsystem.entity.Car;
import java.util.List;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author hp
 */
public interface CarSaleGUI {
    void clearInput();
    
    void clearTextField();
    
    void  displayAllCars();
    
    void clearComboBoxes();
    
    void dispalyMessageInDialog(String message);
    
    void displayCarDetails(Car car);
    
    void displaySelectedCarDetails(Car car);
    
    void displayCarDetails(List<Car> cars);
    
    void displayCarDetails(Set<Car> cars);
    
    String getSelectedCarId() throws Exception;
    
    JButton getCloseButton();
    
    JButton getSearchButton();
    
    JButton getViewButton();
    
    public JTable getCarTable();
    
    Car getCarDetails();
    
    int getCarID();
    
    Car getCar();
    
    public void clearCarTable();
    
    public boolean isCarSelected();

    public void setInputContent(Car selectedCar);
    
    
}
