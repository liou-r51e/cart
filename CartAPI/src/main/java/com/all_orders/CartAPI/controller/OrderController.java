package com.all_orders.CartAPI.controller;


import com.all_orders.CartAPI.dto.OrderDetail;
import com.all_orders.CartAPI.entity.OrderDetailEntity;
import com.all_orders.CartAPI.services.OrderDetailService;
import com.all_orders.CartAPI.services.impl.OrderDetailServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/all_orders/")
public class OrderController {

    @Autowired
    OrderDetailServiceImpl orderDetailService;


    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public ResponseEntity<List<OrderDetail>> getAllEmployees() {
        List<OrderDetailEntity> orderDetailEntityList = orderDetailService.findAll();
        List<OrderDetail> orders = new ArrayList<>();
        for (OrderDetailEntity orderDetailEntity : orderDetailEntityList) {
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

    @RequestMapping(method = RequestMethod.POST, value = "add")
    public ResponseEntity<String> addOrUpdateEmployee(@RequestBody OrderDetail orderDetail) {
        System.out.println(orderDetail);

        OrderDetail orderDetail1 = orderDetailService.save(orderDetail);
        return new ResponseEntity<String>(orderDetail1.getSessionId(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "update/quantity/{sessionID}/{quantity}")
    public ResponseEntity<Boolean> updateQuantity(@PathVariable("sessionID") int sessionId, @PathVariable("quantity") int quantity) {
        Boolean bool = orderDetailService.updateQuantity(sessionId, quantity);
        return new ResponseEntity<Boolean>(bool, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "update/cost/{sessionID}/{cost}")
    public ResponseEntity<Boolean> updateCost(@PathVariable("sessionID") int sessionId, @PathVariable("cost") int cost) {
        Boolean bool = orderDetailService.updateCost(sessionId, cost);
        return new ResponseEntity<Boolean>(bool, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "update/status/{sessionID}/{status}")
    public ResponseEntity<Boolean> updateStatus(@PathVariable("sessionID") int sessionId, @PathVariable("status") String status) {
        Boolean bool = orderDetailService.updateStatus(sessionId, status);
        return new ResponseEntity<Boolean>(bool, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "get/cost/{sessionId}")
    public ResponseEntity<Integer> getCost(@PathVariable("sessionId") String sessionId) {
        int cost = orderDetailService.getCost(sessionId);
        return new ResponseEntity<Integer>(cost, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "get/status/{sessionId}")
    public ResponseEntity<String> getSession(@PathVariable("sessionId") String sessionId) {
        String status = orderDetailService.getStatus(sessionId);
        return new ResponseEntity<String>(status, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "get/quantity/{sessionId}")
    public ResponseEntity<Integer> getQuantity(@PathVariable("sessionId") String sessionId) {
        int quantity = orderDetailService.getQuantity(sessionId);
        return new ResponseEntity<Integer>(quantity, HttpStatus.OK);
    }


}
