package com.product_merchant_relation.InventoryAPI.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = PidMidRelationEntity.TABLE_NAME)
public class PidMidRelationEntity {

    public static final String TABLE_NAME = "pidMidRelation";
    public static final String ID_COLUMN = "pmId";


    @Id
    @Column(name = PidMidRelationEntity.ID_COLUMN)
    private String pmId;
    private int productId;
    private String merchantId;
    private int cost;
    private int inventory;


    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getIdColumn() {
        return ID_COLUMN;
    }

    public String getPmId() {
        return pmId;
    }

    public void setPmId(String pmId) {
        this.pmId = pmId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
