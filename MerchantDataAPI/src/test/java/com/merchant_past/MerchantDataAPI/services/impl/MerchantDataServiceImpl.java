package com.merchant_past.MerchantDataAPI.services.impl;

import com.merchant_past.MerchantDataAPI.dto.MerchantData;
import com.merchant_past.MerchantDataAPI.entity.MerchantDataEntity;
import com.merchant_past.MerchantDataAPI.repository.MerchantDataRepository;
import com.merchant_past.MerchantDataAPI.services.MerchantDataService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MerchantDataServiceImpl implements MerchantDataService {

    //save
    //add product(quantity)
    //add/decrease stock and produc
    //get rating
    //calculating the rating
    @Autowired
    MerchantDataRepository merchantDataRepository;

    @Override
    public MerchantData save(MerchantData merchantData) {

        MerchantDataEntity merchantDataEntity = new MerchantDataEntity();
        BeanUtils.copyProperties(merchantData, merchantDataEntity);
        merchantDataRepository.save(merchantDataEntity);
        //Todo : Phani : remove system.out.println
        System.out.println(merchantDataEntity.getMerchantId());
        //Todo : Phani : what is the need of this code?
        MerchantData response = new MerchantData();
        BeanUtils.copyProperties(merchantDataEntity, response);
        return response;
    }

    @Override
    public boolean addProduct(String merchandId, int product) {
        MerchantDataEntity merchantDataEntity = (MerchantDataEntity) merchantDataRepository.findById(merchandId).get();
        int numberOfProducts = merchantDataEntity.getNumberProducts();
        merchantDataEntity.setNumberProducts(numberOfProducts + product);
        merchantDataRepository.deleteById(merchandId);
        return merchantDataEntity.equals(merchantDataRepository.save(merchantDataEntity));

    }

    @Override
    public boolean decreaseProduct(String merchandId, int product) {
        MerchantDataEntity merchantDataEntity = (MerchantDataEntity) merchantDataRepository.findById(merchandId).get();
        int numberOfProducts = merchantDataEntity.getNumberProducts();
        merchantDataEntity.setNumberProducts(numberOfProducts - product);
        merchantDataRepository.deleteById(merchandId);
        return merchantDataEntity.equals(merchantDataRepository.save(merchantDataEntity));

    }

    @Override
    public boolean addStock(String merchandId, int stock) {
        MerchantDataEntity merchantDataEntity = (MerchantDataEntity) merchantDataRepository.findById(merchandId).get();
        int numberOfStocks = merchantDataEntity.getStock();
        merchantDataEntity.setNumberProducts(numberOfStocks + stock);
        merchantDataRepository.deleteById(merchandId);
        return merchantDataEntity.equals(merchantDataRepository.save(merchantDataEntity));

    }

    @Override
    public boolean decreaseStock(String merchandId, int stock) {
        MerchantDataEntity merchantDataEntity = (MerchantDataEntity) merchantDataRepository.findById(merchandId).get();
        int numberOfStocks = merchantDataEntity.getStock();
        merchantDataEntity.setNumberProducts(numberOfStocks - stock);
        merchantDataRepository.deleteById(merchandId);
        return merchantDataEntity.equals(merchantDataRepository.save(merchantDataEntity));

    }

    @Override
    public MerchantDataEntity getOne(String merchantId) {
        MerchantDataEntity merchantDataEntity = merchantDataRepository.findById(merchantId).get();
        return merchantDataEntity;
    }

    @Override
    public int getProduct(String merchantId) {
        MerchantDataEntity merchantDataEntity = merchantDataRepository.findById(merchantId).get();
        return merchantDataEntity.getNumberProducts();
    }


    @Override
    public int getStock(String merchantId) {
        MerchantDataEntity merchantDataEntity = merchantDataRepository.findById(merchantId).get();
        return merchantDataEntity.getStock();
    }

    @Override
    public Double getRating(String merchantId) {
        MerchantDataEntity merchantDataEntity = merchantDataRepository.findById(merchantId).get();
        return merchantDataEntity.getRating();
    }

    @Override
    public int getNumberOfRatings(String merchantId){
        MerchantDataEntity merchantDataEntity = merchantDataRepository.findById(merchantId).get();
        return merchantDataEntity.getNumberRatings();
    }


}
