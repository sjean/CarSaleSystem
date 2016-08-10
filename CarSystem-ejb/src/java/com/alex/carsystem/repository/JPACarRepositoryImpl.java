/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.carsystem.repository;

import com.alex.carsystem.entity.Car;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@PermitAll
@Stateless
public class JPACarRepositoryImpl implements CarRepository {

    @PersistenceContext
    private EntityManager em;
    public static final String PERSISTENT_UNIT = "CarSaleSystemPU";

    public JPACarRepositoryImpl() {
//        emFactory = Persistence.createEntityManagerFactory(PERSISTENT_UNIT);
//        em = emFactory.createEntityManager();
    }

    @Override
    public void createCar(Car car) {
        em.persist(car);
    }

    @Override
    public void deleteCar(Car car){
        if (null != car) {
            em.remove(car);
        }
        
    }
    
    @Override
    public void removeCar(String carId) {
        Car car = em.find(Car.class, carId);
        if (null != car) {
            em.remove(car);
        }
    }
    
    @Override
    public void updateCar(Car car) {
        em.merge(car);
    }

    @Override
    public List<Car> queryAll() {
        Query query = em.createNamedQuery(Car.FIND_ALL);
        return query.getResultList();
    }

    @Override
    public List<Car> queryCar(String manufacturer, String modelName, String modelNo, int carType) {
        Query query = em.createQuery("select c from Car c where c.modelName = :modelName AND c.modelNo = :modelNo AND c.manufacturer = :manufacturer AND c.carType = :carType");
        query.setParameter("modelName", modelName);
        query.setParameter("modelNo", modelNo);
        query.setParameter("manufacturer", manufacturer);
        query.setParameter("carType", carType);
        return query.getResultList();
    }
    @Override
    public List<Car> queryCar(String VIN, String manufacture, String modelName, String modelNo, int type) {
        Query query = em.createQuery("select c from Car c where c.vIN =:VIN and  c.modelName = :modelName AND c.modelNo = :modelNo AND c.manufacturer = :manufacturer AND c.carType = :carType");
        query.setParameter("vIN", VIN);
        query.setParameter("modelName", modelName);
        query.setParameter("modelNo", modelNo);
        query.setParameter("manufacturer", manufacture);
        query.setParameter("carType", type);
        return query.getResultList();

    }


    @Override
    public Car QueryCar(String carId) {
        return em.find(Car.class, carId);
    }

    @Override
    public void close() {
        if (em != null) {
            em.close();
            em = null;
        }

    }

    @Override
    public Car queryCar(String carId) {
        return em.find(Car.class, carId);
    }

    @Override
    public List<Car> combinedSearch(int type, String modelNo, String modeNameString, String make) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    

}
