package com.all_orders.CartAPI.controller;


import com.all_orders.CartAPI.dto.OrderDetail;
import com.all_orders.CartAPI.entity.OrderDetailEntity;
import com.all_orders.CartAPI.services.impl.OrderDetailServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderDetailServiceImpl orderDetailService;


    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public ResponseEntity<List<OrderDetail>> getAllEmployees(){
        List<OrderDetailEntity> orderDetailEntityList = orderDetailService.findAll();
        List<OrderDetail> orders = new ArrayList<>();
        for (OrderDetailEntity orderDetailEntity: orderDetailEntityList) {
            OrderDetail orderDetail = new OrderDetail();
            BeanUtils.copyProperties(orderDetailEntity, orderDetail);
            orders.add(orderDetail);
        }
        /*OrderDetail orderDetail = new OrderDetail();
        orderDetail.setEmailId("asdf");
        orderDetail.setCost(24);
        orderDetail.setProductId(24);
        orderDetail.setMerchantId("1234");
        orderDetail.setQuantity(10);
        orderDetail.setStatus("Done");
        orderDetail.setSessionId("12");
        */
        return new ResponseEntity<List<OrderDetail>>(orders, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public ResponseEntity<String> addOrUpdateEmployee(@RequestBody OrderDetail orderDetail) {
        System.out.println(orderDetail);

        OrderDetail orderDetail1 = orderDetailService.save(orderDetail);
        return new ResponseEntity<String>(orderDetail1.getSessionId(), HttpStatus.OK);
    }




}
