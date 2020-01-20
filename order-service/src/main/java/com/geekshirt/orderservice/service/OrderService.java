package com.geekshirt.orderservice.service;


import com.geekshirt.orderservice.client.CustomerServiceClient;
import com.geekshirt.orderservice.dto.AccountDto;
import com.geekshirt.orderservice.dto.OrderRequest;
import com.geekshirt.orderservice.entities.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private CustomerServiceClient customerClient;

    public Order createOrder(OrderRequest orderRequest){


        AccountDto account = customerClient.findAccountById(orderRequest.getAccountId());

        AccountDto dummyAccount = customerClient.createDummyAcount();
        //dummyAccount = customerClient.createAccount(dummyAccount);
        dummyAccount = customerClient.createAccountBody(dummyAccount);

        dummyAccount.getAddress().setZipCode("99999");
        customerClient.updateAccount(dummyAccount);

        AccountDto updateAccount = customerClient.findAccountById(orderRequest.getAccountId());
        log.info(updateAccount.toString());

        customerClient.deleteAccount(dummyAccount);

        Order response = new Order();
        response.setAccountId(orderRequest.getAccountId());
        response.setOrderId("9999");
        response.setStatus("PENDING");
        response.setTotalAmount(100.00);
        response.setTotalTax(10.00);
        response.setTransactionDate(new Date());


        return response;

    }

    public List<Order> findAllOrders(){
        List<Order> orderList = new ArrayList();

        Order response = new Order();
        response.setAccountId("999819");
        response.setOrderId("111123");
        response.setStatus("PENDING");
        response.setTotalAmount(100.00);
        response.setTotalTax(10.00);
        response.setTransactionDate(new Date());

        Order response02 = new Order();
        response02.setAccountId("999819");
        response02.setOrderId("111124");
        response02.setStatus("PENDING");
        response02.setTotalAmount(120.00);
        response02.setTotalTax(12.00);
        response02.setTransactionDate(new Date());

        orderList.add(response);
        orderList.add(response02);

        return orderList;
    }

    public Order findOrderById(String orderId){

        Order response = new Order();
        response.setAccountId("999819");
        response.setOrderId(orderId);
        response.setStatus("PENDING");
        response.setTotalAmount(100.00);
        response.setTotalTax(10.00);
        response.setTransactionDate(new Date());

        return response;
    }

}
