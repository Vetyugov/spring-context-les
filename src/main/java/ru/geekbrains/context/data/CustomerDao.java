package ru.geekbrains.context.data;

import java.util.List;

public interface CustomerDao {
    List<Product> getAllProducts(Long id);
    List<Order> getOrders (Long id);
    Customer findById(Long id);

}
