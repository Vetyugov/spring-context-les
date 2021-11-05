package ru.geekbrains.context;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface ProductRepository {
    Product findProductById(Long id);
    List<Product> getProductList();
}
