package ru.geekbrains.context.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.context.data.CustomerDaoImpl;
import ru.geekbrains.context.data.Order;
import ru.geekbrains.context.data.Product;
import ru.geekbrains.context.data.ProductDaoImpl;

import java.util.List;

@Service
public class CustomerService {
    private CustomerDaoImpl customerDao;

    public CustomerService(CustomerDaoImpl customerDao) {
        this.customerDao = customerDao;
    }

    public List<Product> getAllProducts( Long id) {
        return customerDao.getAllProducts(id);
    }

    public List<Order> getAllOrders(Long id) {
        return customerDao.getOrders(id);
    }
}
