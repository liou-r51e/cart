package com.cart.orders.CartTransactionApi.services.impl;

import com.cart.orders.CartTransactionApi.dtos.OrderDetailsDto;
import com.cart.orders.CartTransactionApi.entities.OrderDetailsEntity;
import com.cart.orders.CartTransactionApi.httpSend.HttpURLConnectionExample;
import com.cart.orders.CartTransactionApi.services.CartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements CartService {

    ObjectMapper objectMapper = new ObjectMapper();
    String all_order_ip = "http://10.177.1.245/all_orders/";
    String pmId_ip = "http://10.177.1.245/pid_mid/";
    JavaType listtype = objectMapper.getTypeFactory().constructCollectionType(List.class,OrderDetailsDto.class);

    public int checkInventory(OrderDetailsEntity orderDetailsEntity) {
        String pmId = String.valueOf(orderDetailsEntity.getProductId()) + orderDetailsEntity.getMerchantId();
        String responseUrl = null;
        try {
            responseUrl = HttpURLConnectionExample.sendGet(pmId_ip+"get/inventory/"+pmId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int inventory = Integer.valueOf(responseUrl).intValue();
        return inventory;
    }

    public int checkPrice(OrderDetailsEntity orderDetailsEntity){
        String pmId = String.valueOf(orderDetailsEntity.getProductId()) + orderDetailsEntity.getMerchantId();
        String responseUrl = null;
        try {
            responseUrl = HttpURLConnectionExample.sendGet(pmId_ip+"get/cost/"+pmId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int cost = Integer.valueOf(responseUrl).intValue();
        return cost;
    }



    @Override
    public OrderDetailsDto addOrder(OrderDetailsEntity orderDetailsEntity) {
        OrderDetailsDto orderDetailsDto = null;
        BeanUtils.copyProperties(orderDetailsEntity,orderDetailsDto);

        int cost = checkPrice(orderDetailsEntity);
        if(cost!=orderDetailsEntity.getCost()){
            orderDetailsDto.setCost(cost);
            orderDetailsDto.setAdditionalStatus("Price changed, please refresh");
            return orderDetailsDto;
        }

        int inventory = checkInventory(orderDetailsEntity);
        if(inventory>=orderDetailsEntity.getQuantity()){
            orderDetailsEntity.setStatus("In Cart");
            String responseUrl = null;

            try {
                String urlParameters = objectMapper.writeValueAsString(orderDetailsEntity);
                responseUrl = HttpURLConnectionExample.sendPost(all_order_ip+"add", urlParameters);
                orderDetailsEntity.setSessionId(Integer.valueOf(responseUrl).intValue());
                BeanUtils.copyProperties(orderDetailsEntity,orderDetailsDto);
                orderDetailsDto.setAdditionalStatus("Added to Cart");
                return orderDetailsDto;
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            orderDetailsDto.setAdditionalStatus("Error Adding in Cart");
            return orderDetailsDto;
        }
        orderDetailsDto.setAdditionalStatus("Only "+Integer.toString(inventory) + "products are available with this merchant");
        return orderDetailsDto;
    }

    @Override
    public OrderDetailsDto updateOrder(OrderDetailsEntity orderDetailsEntity) {
        OrderDetailsDto orderDetailsDto = null;
        BeanUtils.copyProperties(orderDetailsEntity,orderDetailsDto);

        int cost = checkPrice(orderDetailsEntity);
        if(cost!=orderDetailsEntity.getCost()){
            orderDetailsDto.setCost(cost);
            orderDetailsDto.setAdditionalStatus("Price changed, please refresh");
            return orderDetailsDto;
        }

        int inventory = checkInventory(orderDetailsEntity);
        if(inventory>=orderDetailsEntity.getQuantity()){

            String responseUrl = null;

            try {
                String urlParameters = objectMapper.writeValueAsString(orderDetailsEntity);
                responseUrl = HttpURLConnectionExample.sendPost(all_order_ip+"add", urlParameters);
                orderDetailsEntity.setSessionId(Integer.valueOf(responseUrl).intValue());
                BeanUtils.copyProperties(orderDetailsEntity,orderDetailsDto);
                orderDetailsDto.setAdditionalStatus("Cart Updated");
                return orderDetailsDto;
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            orderDetailsDto.setAdditionalStatus("Error Updating Cart");
            return orderDetailsDto;
        }
        orderDetailsDto.setAdditionalStatus("Only "+Integer.toString(inventory) + "products are available with this merchant");
        return orderDetailsDto;
    }

    @Override
    public boolean cancelOrder(int sessionId) {
        String responseUrl = null;
        try {
            responseUrl = HttpURLConnectionExample.sendGet(all_order_ip+"update/status/"+String.valueOf(sessionId)+"/Cancelled");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseUrl.matches("true");
    }

    @Override
    public boolean cancelCart(List<Integer> sessionIds) {
        boolean flag = true;
        for (int s: sessionIds) {
            flag &= cancelOrder(s);
        }
        return flag;
    }

    @Override
    public List<OrderDetailsDto> viewCart() {
        return null;
    }

    @Override
    public List<OrderDetailsDto> buy(List<OrderDetailsEntity> orderDetailsEntities) {
        List<OrderDetailsDto> orderDetailsDtos = new ArrayList<>();
        boolean flag = true;

        for (OrderDetailsEntity i:orderDetailsEntities) {
            OrderDetailsDto orderDetailsDto = null;
            BeanUtils.copyProperties(i, orderDetailsDto);

            int cost = checkPrice(i);
            if (cost != i.getCost()) {
                orderDetailsDto.setCost(cost);
                orderDetailsDto.setAdditionalStatus("Price changed for this product");
                flag = false;
            }

            int inventory = checkInventory(i);
            if (inventory >= i.getQuantity()) {
                orderDetailsDto.setAdditionalStatus("Only " + Integer.toString(inventory) + "products are available with this merchant");
                flag = false;
            }
            orderDetailsDtos.add(orderDetailsDto);
        }

        if(flag){
            for (int i=0;i<orderDetailsEntities.size();i++) {
                OrderDetailsEntity orderDetailsEntity = orderDetailsEntities.get(i);
                int sessionId = orderDetailsEntity.getSessionId();
                String responseUrl = null;
                try {
                    responseUrl = HttpURLConnectionExample.sendGet(all_order_ip+"update/status/"+String.valueOf(sessionId)+"/Order Placed");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(responseUrl.matches("true")){
                    orderDetailsDtos.get(i).setAdditionalStatus("Order Placed");
                }
                else{
                    orderDetailsDtos.get(i).setAdditionalStatus("Error Placing order");
                }
            }
            //Email Integration

        }
        return orderDetailsDtos;
    }
}
