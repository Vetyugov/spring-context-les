package ru.geekbrains.context.data;


import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer_id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product_id;
    @Column(name = "purchase_value")
    private Integer purchase_value;

    public Order(){

    }

    public Order(Long id, Customer customer,  Product product, Integer purchase_value) {
        this.id = id;
        this.customer_id = customer;
        this.product_id = product;
        this.purchase_value = purchase_value;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public Integer getPurchase_value() {
        return purchase_value;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomer_id(Customer customer) {
        this.customer_id = customer;
    }

    public void setProduct_id(Product product) {
        this.product_id = product;
    }

    public void setPurchase_value(Integer purchase_value) {
        this.purchase_value = purchase_value;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer_id +
                ", product=" + product_id +
                ", purchase_value=" + purchase_value +
                '}';
    }
}
