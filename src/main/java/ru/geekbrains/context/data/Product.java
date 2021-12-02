package ru.geekbrains.context.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "amount")
    private Integer amount;

    @OneToMany(mappedBy = "product_id")
    private List<Order> orders;

    public Product(){

    }

    public Product(Long id, String name, Integer amount, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.orders = orders;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(Integer delta) {
        Integer amount = this.amount + delta;
        if(amount < 0){
            amount = 0;
        }
        this.amount = amount;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }



    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                "} in Orders ";
    }
}
