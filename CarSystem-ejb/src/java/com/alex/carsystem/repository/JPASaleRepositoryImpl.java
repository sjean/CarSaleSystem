/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.carsystem.repository;

import com.alex.carsystem.entity.Sales;
import com.alex.carsystem.entity.Users;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Alex
 */
@PermitAll
@Stateless
public class JPASaleRepositoryImpl implements SaleRepository {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Sales> queryAll() {
        Query query = entityManager.createQuery("select s from Sales s");
        return query.getResultList();
    }

    @Override
    public void createOrder(Sales sales) {
        entityManager.persist(sales);
    }

    @Override
    public void deleteOrder(Sales sales) {
        entityManager.remove(sales);
    }

    @Override
    public void updateOrder(Sales sales) {
        entityManager.merge(sales);
    }

    @Override
    public List<Sales> customerOrderQuery(int customerId) {
        Query query = entityManager.createQuery("SELECT s FROM Sales s WHERE s.customerId.id = :customerId");
        query.setParameter("customerId", customerId);
        return query.getResultList();
    }

//    @Override
//    public List<Sales> customerOrderQuery(int customerId) {
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery query = builder.createQuery(Sales.class);
//        Root<Sales> s = query.from(Sales.class);
//        query.select(s);
//        Predicate predicate = builder.equal(s.get("id").as(String.class), s)
//        
//    }
    
    @Override
    public List<Sales> salesmanQuery(int id, String carID) {
        Query query = entityManager.createQuery("SELECT s FROM Sales s WHERE s.id = :id AND s.CarId = :CarId");
        query.setParameter("id", id);
        query.setParameter("CarId", carID);
        return query.getResultList();
    }
    
    
    
}
