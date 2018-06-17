package com.product_merchant_relation.InventoryAPI.services;

import com.product_merchant_relation.InventoryAPI.entity.PidMidRelationEntity;

import java.util.List;

public interface PidMidRelationServices {

    public boolean updateInventory(String pmId, int inventory);
    public boolean updateCost(String pmId, int cost);
    public boolean deleteInventory(String pmId);
    public boolean addInventory(PidMidRelationEntity pidMidRelationEntity);
    public int getInventory(String pmId);
    public int getCost(String pmId);
    public PidMidRelationEntity getPidMidRelation(String pmId);
    public List<PidMidRelationEntity> getAll();

    public List<PidMidRelationEntity> getMerchants(int productId);
    public List<PidMidRelationEntity> getProducts(String merchantId);
}
