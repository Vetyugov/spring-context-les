package ru.geekbrains.context.data;

import java.util.List;

public interface ProductDao {
    Product findById(Long id);
    List<Product> findAll();
    void deleteProduct(Long id);
    Product save(Product product);
    void updateAmountById(Long id, Integer delta);
}
