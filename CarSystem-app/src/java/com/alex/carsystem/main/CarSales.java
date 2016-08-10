package com.alex.carsystem.main;


import com.alex.carsystem.entity.Car;
import com.alex.carsystem.gui.CarSaleGUI;
import com.alex.carsystem.gui.CarSaleGUIImpl;
import com.alex.carsystem.repository.CarRepository;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author hp
 */
public class CarSales implements ActionListener, ListSelectionListener{

    @EJB
    private static CarRepository carRepository;
    
    public CarSaleGUI gui;
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private CarSales(String name) {
         this.name = name;
            
    }
    
    public void initView(){
        this.gui = new CarSaleGUIImpl(this, this);
//        this.displayAllCars();
    }
            
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == gui.getViewButton()) {
            this.displayAllCars();
        }
        else if (ae.getSource() == gui.getSearchButton()) {
            this.searchCar();
        }
        else if (ae.getSource() == gui.getCloseButton()) {
            System.exit(0);
        }
      
    }

   

    private void displayAllCars() {
        try {
            List<Car> cars;
            cars = carRepository.queryAll();
            if (cars != null) {
                this.gui.displayCarDetails(cars);
            }
          
        } catch (Exception ex) {
            this.gui.dispalyMessageInDialog("Failed to retrive cars: " + ex.getMessage());
        }
    }

    private void searchCar() {
        Car car = this.gui.getCar();
        
        
        List<Car> cars = carRepository.queryCar(car.getManufacturer(), car.getModelName(), car.getModelNo(), car.getCarType());
        if(!cars.isEmpty()){
            gui.displayCarDetails(cars);
        }
      
    }
    
    public static void main(String[] args) {
        
        
        final CarSales carSales = new CarSales("Car Sales System");
        carSales.initView();
        
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource() == gui.getCarTable().getSelectionModel()) {
            if (gui.isCarSelected()) {
                try {
                    String carId = gui.getSelectedCarId();
                    if (null != carId) {
                        Car selectedCar = carRepository.QueryCar(carId);
                        if (null != selectedCar) {
                            gui.setInputContent(selectedCar);
                        }
                    }
                } catch (Exception ex) {
                    Logger.getLogger(CarSales.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
