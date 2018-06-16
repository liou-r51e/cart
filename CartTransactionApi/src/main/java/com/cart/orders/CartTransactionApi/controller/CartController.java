package com.cart.orders.CartTransactionApi.controller;


import com.cart.orders.CartTransactionApi.dtos.OrderDetailsDto;
import com.cart.orders.CartTransactionApi.entities.OrderDetailsEntity;
import com.cart.orders.CartTransactionApi.services.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public ResponseEntity<OrderDetailsDto> addOrder(@RequestBody OrderDetailsDto orderDetailsDto){
        OrderDetailsEntity orderDetailsEntity = null;
        BeanUtils.copyProperties(orderDetailsDto,orderDetailsEntity);
        orderDetailsDto = cartService.addOrder(orderDetailsEntity);

        return new ResponseEntity<>(orderDetailsDto,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/update")
    public ResponseEntity<OrderDetailsDto> updateOrder(@RequestBody OrderDetailsDto orderDetailsDto){
        OrderDetailsEntity orderDetailsEntity = null;
        BeanUtils.copyProperties(orderDetailsDto,orderDetailsEntity);
        orderDetailsDto = cartService.updateOrder(orderDetailsEntity);

        return new ResponseEntity<>(orderDetailsDto,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/cancel/{sessionId}")
    public ResponseEntity<Boolean> cancel(@PathVariable("sessionId") int sessionId){
        boolean response = cartService.cancelOrder(sessionId);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/cancelCart")
    public ResponseEntity<Boolean> cancelCart(@RequestBody List<OrderDetailsDto> orderDetailsDtos){
        List<Integer> sessionIds = new ArrayList<>();
        for (OrderDetailsDto orderDetailsDto:orderDetailsDtos) {
            sessionIds.add(orderDetailsDto.getSessionId());
        }
        boolean response = cartService.cancelCart(sessionIds);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/viewCart")
    public ResponseEntity<List<OrderDetailsDto>> viewCart(){
        List<OrderDetailsDto> orderDetailsDtos = cartService.viewCart();
        return new ResponseEntity<>(orderDetailsDtos,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/buy")
    public ResponseEntity<List<OrderDetailsDto>> buy(@RequestBody List<OrderDetailsDto> orderDetailsDtos){

        List<OrderDetailsEntity> orderDetailsEntities = new ArrayList<>();
        for (OrderDetailsDto orderDetailsDto : orderDetailsDtos) {
            OrderDetailsEntity orderDetailsEntity = null;
            BeanUtils.copyProperties(orderDetailsDto,orderDetailsEntity);
            orderDetailsDtos.add(orderDetailsDto);
        }
        orderDetailsDtos = cartService.buy(orderDetailsEntities);

        return new ResponseEntity<>(orderDetailsDtos,HttpStatus.OK);
    }


}
