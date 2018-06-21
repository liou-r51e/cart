package com.all_orders.CartAPI.repository;

import com.all_orders.CartAPI.entity.OrderDetailEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<OrderDetailEntity, String> {

    public List<OrderDetailEntity> findByEmailIdAndStatus(String emailId, String status);

    public List<OrderDetailEntity> findByMerchantId(String merchantId);

    public List<OrderDetailEntity> findByEmailId(String emailId);

    public OrderDetailEntity findBySessionId(int sessionId);

    public Boolean deleteBySessionId(int sessionId);
}
