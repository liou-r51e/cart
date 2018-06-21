package com.all_orders.CartAPI.controller;


import com.all_orders.CartAPI.dto.OrderDetail;
import com.all_orders.CartAPI.entity.OrderDetailEntity;
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

    @RequestMapping(method = RequestMethod.GET, value = "getAll")
    public ResponseEntity<List<OrderDetail>> getAllEmployees() {
        List<OrderDetailEntity> orderDetailEntityList = orderDetailService.findAll();
        List<OrderDetail> orders = new ArrayList<>();
        for (OrderDetailEntity orderDetailEntity : orderDetailEntityList) {
            OrderDetail orderDetail = new OrderDetail();
            BeanUtils.copyProperties(orderDetailEntity, orderDetail);
            orders.add(orderDetail);
        }
        return new ResponseEntity<List<OrderDetail>>(orders, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "add")
    public ResponseEntity<OrderDetail> addOrUpdateEmployee(@RequestBody OrderDetail orderDetail) {
        //System.out.println(orderDetail);

        OrderDetail orderDetail1 = orderDetailService.save(orderDetail);
        return new ResponseEntity<OrderDetail>(orderDetail1, HttpStatus.OK);
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
    public ResponseEntity<Boolean> updateStatus(@PathVariable("sessionID") String sessionId, @PathVariable("status") String status) {
        Boolean bool = orderDetailService.updateStatus(Integer.parseInt(sessionId), status);
        return new ResponseEntity<Boolean>(bool, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "get/cost/{sessionId}")
    public ResponseEntity<Integer> getCost(@PathVariable("sessionId") int sessionId) {
        int cost = orderDetailService.getCost(sessionId);
        return new ResponseEntity<Integer>(cost, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "get/status/{sessionId}")
    public ResponseEntity<String> getSession(@PathVariable("sessionId") int sessionId) {
        String status = orderDetailService.getStatus(sessionId);
        return new ResponseEntity<String>(status, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "get/quantity/{sessionId}")
    public ResponseEntity<Integer> getQuantity(@PathVariable("sessionId") int sessionId) {
        int quantity = orderDetailService.getQuantity(sessionId);
        return new ResponseEntity<Integer>(quantity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "get/pastOrders/{emailId}/{status}")
    public ResponseEntity<List<OrderDetail>> getPastOrdersByUserStatus(@PathVariable("emailId") String emailId, @PathVariable("status") String status) {
        List<OrderDetailEntity> pastOrderList = orderDetailService.getByEmailIdAndStatus(emailId, status);
        List<OrderDetail> orders = new ArrayList<>();
        for (OrderDetailEntity orderDetailEntity : pastOrderList) {
            OrderDetail orderDetail = new OrderDetail();
            BeanUtils.copyProperties(orderDetailEntity, orderDetail);
            orders.add(orderDetail);
        }
        return new ResponseEntity<List<OrderDetail>>(orders, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "get/pastOrdersUser/{emailId}")
    public ResponseEntity<List<OrderDetail>> getPastOrdersByUser(@PathVariable("emailId") String emailId) {
        List<OrderDetailEntity> pastOrderList = orderDetailService.getOrdersByEmailId(emailId);
        List<OrderDetail> orders = new ArrayList<>();
        for (OrderDetailEntity orderDetailEntity : pastOrderList) {
            OrderDetail orderDetail = new OrderDetail();
            BeanUtils.copyProperties(orderDetailEntity, orderDetail);
            orders.add(orderDetail);
        }
        return new ResponseEntity<List<OrderDetail>>(orders, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST, value = "update")
    public ResponseEntity<Boolean> updateInventory(@RequestBody OrderDetail orderDetail) {
        Boolean orderDetail1 = orderDetailService.updateOrder(orderDetail);
        //OrderDetail orderDetail1 = orderDetailService.save(orderDetail);
        return new ResponseEntity<Boolean>(orderDetail1, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "merchantOrders/{merchantId}")
    public ResponseEntity<List<OrderDetail>> merchantOrders(@PathVariable("merchantId") String merchantId) {
        List<OrderDetailEntity> orderDetailEntityList = orderDetailService.merchantOrders(merchantId);
        List<OrderDetail> orders = new ArrayList<>();
        for (OrderDetailEntity orderDetailEntity : orderDetailEntityList) {
            OrderDetail orderDetail = new OrderDetail();
            BeanUtils.copyProperties(orderDetailEntity, orderDetail);
            orders.add(orderDetail);
        }
        return new ResponseEntity<List<OrderDetail>>(orders, HttpStatus.OK);

    }

}
