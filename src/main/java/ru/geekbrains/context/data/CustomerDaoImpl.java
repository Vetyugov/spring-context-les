package ru.geekbrains.context.data;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.geekbrains.context.services.SessionFactoryUtils;

import java.util.ArrayList;
import java.util.List;


@Component
public class CustomerDaoImpl implements CustomerDao {

    private SessionFactoryUtils sessionFactoryUtils;

    public CustomerDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public List<Product> getAllProducts(Long id) {
        //Пока не реализовал
        return null;
    }

    @Override
    public List<Order> getOrders(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, 1L);
            List<Order> listOfOrders = customer.getOrders();
            for (Order order : listOfOrders) {
                System.out.println(order);
            }
            session.getTransaction().commit();
            return listOfOrders;
        }

    }

    @Override
    public Customer findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.getTransaction().commit();
            return customer;
        }
    }
}
