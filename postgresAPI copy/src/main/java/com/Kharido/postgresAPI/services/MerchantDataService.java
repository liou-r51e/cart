package com.Kharido.postgresAPI.services;

import com.Kharido.postgresAPI.dto.MerchantDetail;
import com.Kharido.postgresAPI.entity.MerchantDetailsEntity;

public interface MerchantDataService {

    //save
    //add product(quantity)
    //add/decrease stock and produc
    //getrating
    //calculating the rating

    public MerchantDetail save(MerchantDetail merchantDetail);


    public boolean addStock(String merchandId, int stock);

    public boolean decreaseStock(String merchandId, int stock);

    public boolean addProduct(String merchandId, int Product);

    public boolean decreaseProduct(String merchandId, int Product);

    public int getProduct(String merchantId);

    public int getStock(String merchantId);

    public MerchantDetailsEntity getOne(String merchantId);

    public Double getRating(String merchantId);

    public int getNumberOfRatings(String merchantId);

}
