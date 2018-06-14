package com.all_orders.CartAPI.services.impl;

import com.all_orders.CartAPI.dto.OrderDetail;
import com.all_orders.CartAPI.entity.OrderDetailEntity;
import com.all_orders.CartAPI.repository.OrderRepository;
import com.all_orders.CartAPI.services.OrderDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

@Autowired
OrderRepository orderRepository;

    @Override
    public Optional<OrderDetailEntity> findOne(String userId) {
        return Optional.empty();
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) {

        OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
        BeanUtils.copyProperties(orderDetail, orderDetailEntity);
        orderRepository.save(orderDetailEntity);
        System.out.println(orderDetailEntity.getSessionId());
        OrderDetail response = new OrderDetail();
        BeanUtils.copyProperties(orderDetailEntity, response);
        return response;
    }

    @Override
    public boolean exists(String userId) {
        return false;
    }

    @Override
    public List<OrderDetailEntity> findAll() {
        return (List)orderRepository.findAll();
    }

    @Override
    public Iterable<OrderDetailEntity> findAll(Iterable<String> userId) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(String userId) {

    }

    @Override
    public void delete(OrderDetailEntity employee) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<OrderDetailEntity> getByFirstName(String fullName) {
        return null;
    }

    @Override
    public OrderDetailEntity getOneByEmailId(String firstName) {
        return null;
    }
}
