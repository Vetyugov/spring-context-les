package ru.geekbrains.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class Cart {
    private ProductRepository productRepository;
    private ArrayList<Product> productsInCart = new ArrayList<>();

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(long id){
        productsInCart.add(productRepository.findProductById(id));
    }

    public void deleteProduct (long id){
        productsInCart.removeIf(product -> product.getId() == id);
    }
    public ArrayList<Product> getProductsInCart(){
        return productsInCart;
    }
}
