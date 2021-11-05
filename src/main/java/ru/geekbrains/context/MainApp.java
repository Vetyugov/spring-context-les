package ru.geekbrains.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Cart cart = null;
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Scanner scanner = new Scanner(System.in);
        OrderService orderService = context.getBean(OrderService.class);
        while (true){
            System.out.println("===================");
            System.out.println("Продукты в магазине:");
            productRepository.getProductList().forEach(product -> System.out.println(product.toString()));
            System.out.println("===================");
            System.out.println("Корзина:");
            if (cart != null){
                cart.getProductsInCart().forEach(product -> System.out.println(product.toString()));
            }
            System.out.println("===================");
            System.out.println("Введите команду");
            System.out.println("1 - Создать новую корзину");
            System.out.println("2 - Добавить товар в козину");
            System.out.println("3 - Удалить товар из корзины");
            System.out.println("4 - Создать заказ");
            System.out.println("5 - Выйти");
            boolean goAway = false;
            switch (scanner.next()){
                case "1":
                    cart = context.getBean(Cart.class);
                    break;
                case "2":
                    System.out.println("Введите id товара: ");
                    if(cart != null){
                        cart.addProduct(Long.parseLong(scanner.next()));
                    } else {
                        System.out.println("Создайте корзину");
                    }
                    break;
                case "3":
                    System.out.println("Введите id товара: ");
                    if(cart != null){
                        if(cart.getProductsInCart().isEmpty()){
                            System.out.println("Корзина пуста");
                        }
                        cart.deleteProduct(Long.parseLong(scanner.next()));
                    } else {
                        System.out.println("Создайте корзину");
                    }
                    break;
                case "4":
                    if(cart != null){
                        orderService.createOrderFromCart(cart);
                    } else {
                        System.out.println("Создайте корзину");
                    }
                case "5":
                    goAway = true;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + scanner.next());
            }
            if(goAway){
                break;
            }
        }
        context.close();
    }
}
