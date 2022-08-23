package com.example.coffe.model.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "myorder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String orderDescription;

//    @OneToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "customer_id", referencedColumnName = "id")
//    private Customer customer;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId", referencedColumnName = "id_user")
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = ShoppingCart.class)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private List<ShoppingCart> cartItems;

    public Order() {
    }

    public Order(String orderDescription, List<ShoppingCart> cartItems) {
        this.orderDescription = orderDescription;
//        this.customer = customer;
//        this.user = user;
        this.cartItems = cartItems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

//    public Customer getCustomer() {
//        return customer;
//    }



//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ShoppingCart> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<ShoppingCart> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDescription='" + orderDescription + '\'' +
//                ", customer=" + customer +
                ", user=" + user +
                ", cartItems=" + cartItems +
                '}';
    }
}
