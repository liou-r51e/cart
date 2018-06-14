package com.all_orders.CartAPI.services;

import com.all_orders.CartAPI.dto.OrderDetail;
import com.all_orders.CartAPI.entity.OrderDetailEntity;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {


    public Optional<OrderDetailEntity> findOne(String userId);

    public OrderDetail save(OrderDetail orderDetail);

    public boolean exists(String userId);

    public List<OrderDetailEntity> findAll();

    public Iterable<OrderDetailEntity> findAll(Iterable<String> userId);

    public long count();

    public void delete(String userId);

    public void delete(OrderDetailEntity employee);

    public void deleteAll();

    public List<OrderDetailEntity> getByFirstName(String fullName);

    public OrderDetailEntity getOneByEmailId(String firstName);

}
