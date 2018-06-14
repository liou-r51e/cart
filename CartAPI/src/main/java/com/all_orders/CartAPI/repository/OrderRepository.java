package com.all_orders.CartAPI.repository;

import com.all_orders.CartAPI.entity.OrderDetailEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderDetailEntity,String> {
}
