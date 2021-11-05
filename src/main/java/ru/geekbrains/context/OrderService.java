package ru.geekbrains.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class OrderService {
    private FileOutputStream fileOut;

    @Autowired
    public void setFileOut(FileOutputStream fileOut) {
        this.fileOut = fileOut;
    }

    public void createOrderFromCart(Cart cart) {
        System.out.println("Заказ создан:");
        try {
            fileOut.write("NEW ORDER\n".getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            cart.getProductsInCart().forEach(product -> stringBuilder.append(product.toString()).append("\n"));
            fileOut.write(stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
            fileOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}