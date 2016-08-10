/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.carsystem.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Alex
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Sales.FIND_ALL, query = "SELECT c FROM Users c")
})
public class Sales implements Serializable {
    
    public static final String FIND_ALL = "Sales.findAll";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="customerId",referencedColumnName="id")
    private Users customerId;
    
    private String customerName;
    private String salesTime;
    private String CarId;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="salesPersonId",referencedColumnName="id")
    private Users salesPersonId;
    
    private String salesPersonName;
    private boolean orderState;
            
    public Sales(){}

    public Sales(int id, Users customerId, String customerName, String saleTime, String CarId, Users salesPersonId, String salesPersonName) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.salesTime = saleTime;
        this.CarId = CarId;
        this.salesPersonId = salesPersonId;
        this.salesPersonName = salesPersonName;
    }

    public Sales(Users customerId, String salesTime, String CarId, Users salesPersonId, String salesPersonName, boolean orderState) {
        this.customerId = customerId;
        this.salesTime = salesTime;
        this.CarId = CarId;
        this.salesPersonId = salesPersonId;
        this.salesPersonName = salesPersonName;
        this.orderState = orderState;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Users customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSalesTime() {
        return salesTime;
    }

    public void setSalesTime(String salesTime) {
        this.salesTime = salesTime;
    }

    public String getCarId() {
        return CarId;
    }

    public void setCarId(String CarId) {
        this.CarId = CarId;
    }

    public Users getSalesPersonId() {
        return salesPersonId;
    }

    public void setSalesPersonId(Users salesPersonId) {
        this.salesPersonId = salesPersonId;
    }

    public String getSalesPersonName() {
        return salesPersonName;
    }

    public void setSalesPersonName(String salesPersonName) {
        this.salesPersonName = salesPersonName;
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
        if (!(object instanceof Sales)) {
            return false;
        }
        Sales other = (Sales) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public boolean isOrderState() {
        return orderState;
    }

    public void setOrderState(boolean orderState) {
        this.orderState = orderState;
    }
    
    

    @Override
    public String toString() {
        return "Sales{" + "id=" + id + ", customerId=" + customerId + ", customerName=" + customerName + ", saleTime=" + salesTime + ", CarId=" + CarId + ", salesPersonId=" + salesPersonId + ", salesPersonName=" + salesPersonName + '}';
    }
    
}
