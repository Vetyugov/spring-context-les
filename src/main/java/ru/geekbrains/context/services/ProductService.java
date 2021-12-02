package ru.geekbrains.context.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.context.data.Product;
import ru.geekbrains.context.data.ProductDaoImpl;

import java.util.List;

@Service
public class ProductService {
    private ProductDaoImpl productDao;

    public ProductService(ProductDaoImpl productDao) {
        this.productDao = productDao;
    }

    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    public void deleteProduct(Long id){
        productDao.deleteProduct(id);
    }

    public void changeAmountForProduct(Long id, Integer delta) {
        productDao.updateAmountById(id, delta);
    }
}
