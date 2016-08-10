/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.web;

import com.alex.carsystem.entity.Sales;
import com.alex.carsystem.entity.Users;
import com.alex.carsystem.repository.SaleRepository;
import com.alex.carsystem.repository.UserRepository;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Alex
 */
@Named(value = "salesManagedBean")
@SessionScoped
public class SalesManagedBean  implements Serializable{
    
    @EJB
    private SaleRepository saleRepository;
    @EJB
    private UserRepository userRepository;
    
    private int saleId;
    private int customerId =0;
    private int salesPersonId;
    private String carId;
    private String saleTimeString;
    private String salesPersonNameString;
    private boolean saleState;
    private String messageString = null;
    private Sales sale; 
    private List<Sales> sales;
    private List<Sales> salesByCustomer;  
    private List<Sales> newSales = null;

    /**
     * Creates a new instance of SalesManagedBean
     * @return 
     */
    public List<Sales> salesQuery(){
        newSales = saleRepository.salesmanQuery(saleId, carId);
        if (newSales.isEmpty()) {
            return null;
        }else{
         return newSales;
        }
    }
    
    public String buyCar() {
//        boolean b = false;
//        for (Sales sales1 : salesByCustomer) {
//            System.out.println(sales1);
//            while (sales1.isOrderState()) {                
//                b = true;
//            }
//        }
        
        if (getOrderedCustomerId() != null) {
                Sales newSale = new Sales(getOrderedCustomerId(), getCurrentTime(), getOrderedCarId(), getSalesPersonIdSelected(), salesPersonNameString, true);
                if (null != newSale) {
                    saleRepository.createOrder(newSale);
                    messageString = "";
                    return "customer-info";
                } else {
                    return messageString = "Failed";
                }
        } else {
            return "login";
        }
    }
    
    
    public String paymoney(){
        for (Sales sale1 : salesByCustomer) {
            if (sale1.isOrderState()) {
                if (sale1 != null) {
                    sale1.setOrderState(false);
                    saleRepository.updateOrder(sale1);
                    return messageString = "payment succeed!";
                } 
            }
        }
        return messageString = "update failed!";
    }
            
    public SalesManagedBean() {
    }
    
    
    public Users  getSalesPersonIdSelected(){
        Users user = userRepository.finduserIdByuserName(salesPersonNameString);
        return user;
        
    }
    public Users getOrderedCustomerId(){
        Users user = null;
        FacesContext fc = FacesContext.getCurrentInstance();
        if (fc != null) {
//              ELContext context = fc.getELContext();
//        userManagedBean reBean = (userManagedBean)fc.getApplication().getELResolver()
//                .getValue(context, null, "reBean");

        userManagedBean reBean = (userManagedBean)fc.getApplication()
                .createValueBinding("#{registerManagedBean}").getValue(fc);
        user = reBean.getUser();
        if (null == user) {
            System.out.println("@@@@@@@@@################31444444444122222221333333312222222222");
            
        }else{
            System.out.println("222222222222222222     nullnullnullnullnullnull2222222");
        }
        }
        
        return user;
    }
    
    public String getOrderedCarId(){
     String orderCarId = FacesContext.getCurrentInstance()
             .getExternalContext().getRequestParameterMap()
             .get("CarId");
     return orderCarId;
    }
    
    public String getCurrentTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间
    }

    public List<Sales> getSalesByCustomer() {
        salesByCustomer = saleRepository.customerOrderQuery(getOrderedCustomerId().getId());
        return salesByCustomer;
    }

    public void setSalesByCustomer(List<Sales> salesByCustomer) {
        this.salesByCustomer = salesByCustomer;
    }

    public String getSalesPersonNameString() {
        return salesPersonNameString;
    }

    public void setSalesPersonNameString(String salesPersonNameString) {
        this.salesPersonNameString = salesPersonNameString;
    }

    public List<Sales> getSales() {
        sales = saleRepository.queryAll();
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }
    
    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getSalesPersonId() {
        return salesPersonId;
    }

    public void setSalesPersonId(int salesPersonId) {
        this.salesPersonId = salesPersonId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    
    /**
     *
     * @return
     */
    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getSaleTimeString() {
        return saleTimeString;
    }

    public void setSaleTimeString(String saleTimeString) {
        this.saleTimeString = saleTimeString;
    }

    public boolean isSaleState() {
        return saleState;
    }

    public void setSaleState(boolean saleState) {
        this.saleState = saleState;
    }

    public String getMessageString() {
        return messageString;
    }

    public void setMessageString(String messageString) {
        this.messageString = messageString;
    }

    public Sales getSale() {
        return sale;
    }

    public void setSale(Sales sale) {
        this.sale = sale;
    }

    public List<Sales> getNewSales() {
        return newSales;
    }

    public void setNewSales(List<Sales> newSales) {
        this.newSales = newSales;
    }
    
}
