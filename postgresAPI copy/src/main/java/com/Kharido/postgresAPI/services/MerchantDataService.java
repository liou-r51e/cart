package com.Kharido.postgresAPI.services;

import com.Kharido.postgresAPI.dto.MerchantDetail;
import org.springframework.stereotype.Service;


public interface MerchantDataService {

    public MerchantDetail save(MerchantDetail merchantDetail);

    public boolean addStock(String merchandId, int stock);

    public boolean decreaseStock(String merchandId, int stock);

    public boolean addProduct(String merchandId, int Product);

    public boolean decreaseProduct(String merchandId, int Product);

    public int getProduct(String merchantId);

    public int getStock(String merchantId);

    // public MerchantDetailsEntity getOne(String merchantId);

    public Double getRating(String merchantId);

    public int getNumberOfRatings(String merchantId);

    public boolean addSold(String merchandId, int sold);

    public boolean addReview(String merchandId, int ratingNew);

    public boolean setRating(String merchantId, double rating);

    public boolean setNumberOfRatings(String merchantId, int numberRatings);

}
