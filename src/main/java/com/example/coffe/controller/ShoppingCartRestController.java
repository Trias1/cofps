package com.example.coffe.controller;

import com.example.coffe.model.dto.OrderDTO;
import com.example.coffe.model.dto.ResponseOrderDTO;
import com.example.coffe.model.entity.Customer;
import com.example.coffe.model.entity.Menu;
import com.example.coffe.model.entity.Order;
import com.example.coffe.model.entity.User;
import com.example.coffe.repository.LoginUserRepository;
import com.example.coffe.service.ServiceAdminUser;
import com.example.coffe.service.ServiceCustomer;
import com.example.coffe.service.ServiceMenuImp;
import com.example.coffe.service.ServiceOrderImp;
import com.example.coffe.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/orders")
public class ShoppingCartRestController {

    private ServiceOrderImp serviceOrderImp;

    private ServiceMenuImp serviceMenuImp;

    private ServiceCustomer serviceCustomer;

    @Autowired
    private LoginUserRepository loginUserRepository;


    public ShoppingCartRestController(ServiceOrderImp serviceOrderImp, ServiceMenuImp serviceMenuImp, ServiceCustomer serviceCustomer) {
        this.serviceOrderImp = serviceOrderImp;
        this.serviceMenuImp = serviceMenuImp;
        this.serviceCustomer = serviceCustomer;
    }

    private Logger logger = LoggerFactory.getLogger(ShoppingCartRestController.class);

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<Menu>> getAllProducts() {

        List<Menu> productList = serviceMenuImp.getAllProducts();

        return ResponseEntity.ok(productList);
    }

    @GetMapping("/getOrders/{orderId}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable Integer orderId) {

        Order order = serviceOrderImp.getOrderDetail(orderId);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/getOrders")
    public ResponseEntity<List<Order>> getAllOrder() {

        List<Order> order = serviceOrderImp.getAllOrders();
        return ResponseEntity.ok(order);
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<ResponseOrderDTO> placeOrder(@RequestBody OrderDTO orderDTO) {
        logger.info("Request Payload " + orderDTO.toString());

        ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();
       // float amount = serviceOrderImp.getCartAmount(orderDTO.getCartItems());

//        Customer customer = new Customer(orderDTO.getCustomerName(), orderDTO.getCustomerAlamat(), orderDTO.getCustomerNotelp());
//        Integer customerIdFromDb = serviceCustomer.isCustomerPresent(customer);
        User user = convert(responseOrderDTO);
        Optional<User> u = loginUserRepository.findById(orderDTO.getIdUser());
        if (u.isPresent()){
            responseOrderDTO.setMessage("Ada");
            responseOrderDTO.setStatus(Boolean.TRUE);
        }else {
            responseOrderDTO.setMessage("data ngga");
        }

//        if (customerIdFromDb != null) {
//            customer.setId(customerIdFromDb);
//            logger.info("Id Customer sudah ada : " + customerIdFromDb);
//        }else{
//            customer = serviceCustomer.saveCustomer(customer);
//            logger.info("Simpan Customer beserta id : " + customer.getId());
//        }

//        Order order = new Order(orderDTO.getOrderDescription(), customer, orderDTO.getCartItems());
//        order = serviceOrderImp.saveOrder(order);
//        logger.info("Order proses sukses..");
//
//        responseOrderDTO.setAmount(amount);
//        responseOrderDTO.setDate(DateUtil.getCurrentDateTime());
//        responseOrderDTO.setInvoiceNumber(new Random().nextInt(1000));
//        responseOrderDTO.setOrderId(order.getId());
//        responseOrderDTO.setOrderDescription(orderDTO.getOrderDescription());
//
//        logger.info("test push..");

        return ResponseEntity.ok(responseOrderDTO);
    }

    @PostMapping("/neworders")
    public ResponseEntity<ResponseOrderDTO> order(@RequestBody OrderDTO orderDTO){
        ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();
        User user = convert(responseOrderDTO);
         float amount = serviceOrderImp.getCartAmount(orderDTO.getCartItems());

         Order order = new Order(orderDTO.getOrderDescription(), orderDTO.getCartItems());
        order = serviceOrderImp.saveOrder(order);
        logger.info("Order proses sukses..");

        responseOrderDTO.setAmount(amount);
        responseOrderDTO.setDate(DateUtil.getCurrentDateTime());
        responseOrderDTO.setInvoiceNumber(new Random().nextInt(1000));
        responseOrderDTO.setOrderId(order.getId());
        responseOrderDTO.setOrderDescription(orderDTO.getOrderDescription());
        responseOrderDTO.setIdUser(user.getIdUser());

        logger.info("test push..");

        return ResponseEntity.ok(responseOrderDTO);
    }

    public User convert(ResponseOrderDTO responseOrderDTO){
        User user = new User();
        user.setIdUser(responseOrderDTO.getIdUser());
        user.setNama(responseOrderDTO.getNama());
        return user;
    }

//    public Menu converts (ResponseOrderDTO responseOrderDTO){
//        Menu menu = new Menu();
//        menu.setIdMenu(responseOrderDTO.);
//    }

}
