package ru.geekbrains.context;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Primary
public class InMemProductRepository implements ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread"),
                new Product(2L, "Milk"),
                new Product(3L, "Apples"),
                new Product(4L, "Oranges"),
                new Product(5L, "Bananas")
        ));
    }

    @Override
    public Product findProductById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Product> getProductList(){
        if (products != null){
            return products;
        }else {
            throw new RuntimeException("products is null");
        }
    }
}
