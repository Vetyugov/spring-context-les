package ru.geekbrains.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.context.data.Customer;
import ru.geekbrains.context.data.CustomerDaoImpl;
import ru.geekbrains.context.services.CustomerService;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerService customerDao = context.getBean(CustomerService.class);
        customerDao.getAllOrders(1L).forEach(System.out::println);
        context.close();

    }
}
