package com.example.coffe.model.dto;

import com.example.coffe.model.entity.ShoppingCart;

import java.util.List;

public class OrderDTO {

    private String orderDescription;
    private List<ShoppingCart> cartItems;
    private Integer idUser;
//    private String userNama;
//    private String userAlamat;
//    private String customerAlamat;
//    private String customerName;
//    private String customerNotelp;

    public OrderDTO() {
    }

    public OrderDTO(String orderDescription, List<ShoppingCart> cartItems,Integer id, String customerName,String customerNotelp, String customerAlamat, String userAlamat, String userNama) {
        this.orderDescription = orderDescription;
        this.cartItems = cartItems;
        this.idUser = id;
//        this.userNama = userNama;
//        this.userAlamat = userAlamat;
//        this.customerAlamat = customerAlamat;
//        this.customerName = customerName;
//        this.customerNotelp = customerNotelp;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    //    public String getCustomerNotelp() {
//        return customerNotelp;
//    }
//
//    public void setCustomerNotelp(String customerNotelp) {
//        this.customerNotelp = customerNotelp;
//    }
//
//
//    public String getUserNama() {
//        return userNama;
//    }
//
//    public void setUserNama(String userNama) {
//        this.userNama = userNama;
//    }
//
//    public String getUserAlamat() {
//        return userAlamat;
//    }
//
//    public void setUserAlamat(String userAlamat) {
//        this.userAlamat = userAlamat;
//    }


    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public List<ShoppingCart> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<ShoppingCart> cartItems) {
        this.cartItems = cartItems;
    }

//    public String getCustomerAlamat() {
//        return customerAlamat;
//    }
//
//    public void setCustomerAlamat(String customerAlamat) {
//        this.customerAlamat = customerAlamat;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderDescription='" + orderDescription + '\'' +
                ", cartItems=" + cartItems +
                ", idUser=" + idUser +
//                ", userNama=" + userNama +
//                ", userAlamat=" + userAlamat +
//                ", customerAlamat='" + customerAlamat + '\'' +
//                ", customerName='" + customerName + '\'' +
//                ", customerNotelp='" + customerNotelp + '\'' +
                '}';
    }
}
