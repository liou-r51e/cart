package com.merchant_past.MerchantDataAPI.services;

import com.merchant_past.MerchantDataAPI.dto.MerchantData;
import com.merchant_past.MerchantDataAPI.entity.MerchantDataEntity;

public interface MerchantDataService {

    //save
    //add product(quantity)
    //add/decrease stock and produc
    //getrating
    //calculating the rating

    public MerchantData save(MerchantData merchantData);


    public boolean addStock(String merchandId, int stock);

    public boolean decreaseStock(String merchandId, int stock);

    public boolean addProduct(String merchandId, int Product);

    public boolean decreaseProduct(String merchandId, int Product);

    public int getProduct(String merchantId);

    public int getStock(String merchantId);

    public MerchantDataEntity getOne(String merchantId);

    public Double getRating(String merchantId);

    public int getNumberOfRatings(String merchantId);

}
