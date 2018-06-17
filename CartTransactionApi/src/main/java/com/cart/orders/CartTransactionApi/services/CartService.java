package com.cart.orders.CartTransactionApi.services;

import com.cart.orders.CartTransactionApi.dtos.OrderDetailsDto;
import com.cart.orders.CartTransactionApi.entities.OrderDetailsEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CartService {


    public OrderDetailsDto addOrder(OrderDetailsEntity orderDetailsEntity);
    public OrderDetailsDto updateOrder(OrderDetailsEntity orderDetailsEntity);
    public boolean cancelOrder(int sessionId);
    public boolean cancelCart(List<Integer> sessionIds);
    public List<OrderDetailsDto> viewCart();
    public List<OrderDetailsDto> buy(List<OrderDetailsEntity> orderDetailsEntities);



}
