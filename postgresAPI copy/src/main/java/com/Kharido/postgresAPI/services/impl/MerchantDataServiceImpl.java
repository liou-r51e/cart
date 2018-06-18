package com.Kharido.postgresAPI.services.impl;

import com.Kharido.postgresAPI.dto.MerchantDetail;
import com.Kharido.postgresAPI.entity.MerchantDetailsEntity;
import com.Kharido.postgresAPI.repository.MerchantDataRepository;
import com.Kharido.postgresAPI.services.MerchantDataService;
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
    public MerchantDetail save(MerchantDetail merchantData) {

        MerchantDetailsEntity merchantDetailsEntity = new MerchantDetailsEntity();
        BeanUtils.copyProperties(merchantData, merchantDetailsEntity);
        merchantDataRepository.save(merchantDetailsEntity);
        //Todo : Phani : remove system.out.println
        System.out.println(merchantDetailsEntity.getMerchantId());
        //Todo : Phani : what is the need of this code?
        MerchantDetail response = new MerchantDetail();
        BeanUtils.copyProperties(merchantDetailsEntity, response);
        return response;
    }

    @Override
    public boolean addProduct(String merchandId, int product) {
        MerchantDetailsEntity merchantDataEntity = (MerchantDetailsEntity) merchantDataRepository.findById(merchandId).get();
        int numberOfProducts = merchantDataEntity.getNumberProducts();
        merchantDataEntity.setNumberProducts(numberOfProducts + product);
        merchantDataRepository.deleteById(merchandId);
        return merchantDataEntity.equals(merchantDataRepository.save(merchantDataEntity));

    }

    @Override
    public boolean decreaseProduct(String merchandId, int product) {
        MerchantDetailsEntity merchantDataEntity = (MerchantDetailsEntity) merchantDataRepository.findById(merchandId).get();
        int numberOfProducts = merchantDataEntity.getNumberProducts();
        merchantDataEntity.setNumberProducts(numberOfProducts - product);
        merchantDataRepository.deleteById(merchandId);
        return merchantDataEntity.equals(merchantDataRepository.save(merchantDataEntity));

    }

    @Override
    public boolean addStock(String merchandId, int stock) {
        MerchantDetailsEntity merchantDataEntity = (MerchantDetailsEntity) merchantDataRepository.findById(merchandId).get();
        int numberOfStocks = merchantDataEntity.getStock();
        merchantDataEntity.setNumberProducts(numberOfStocks + stock);
        merchantDataRepository.deleteById(merchandId);
        return merchantDataEntity.equals(merchantDataRepository.save(merchantDataEntity));

    }

    @Override
    public boolean decreaseStock(String merchandId, int stock) {
        MerchantDetailsEntity merchantDataEntity = (MerchantDetailsEntity) merchantDataRepository.findById(merchandId).get();
        int numberOfStocks = merchantDataEntity.getStock();
        merchantDataEntity.setNumberProducts(numberOfStocks - stock);
        merchantDataRepository.deleteById(merchandId);
        return merchantDataEntity.equals(merchantDataRepository.save(merchantDataEntity));

    }

    @Override
    public MerchantDetailsEntity getOne(String merchantId) {
        MerchantDetailsEntity merchantDataEntity = merchantDataRepository.findById(merchantId).get();
        return merchantDataEntity;
    }

    @Override
    public int getProduct(String merchantId) {
        MerchantDetailsEntity merchantDataEntity = merchantDataRepository.findById(merchantId).get();
        return merchantDataEntity.getNumberProducts();
    }


    @Override
    public int getStock(String merchantId) {
        MerchantDetailsEntity merchantDataEntity = merchantDataRepository.findById(merchantId).get();
        return merchantDataEntity.getStock();
    }

    @Override
    public Double getRating(String merchantId) {
        MerchantDetailsEntity merchantDataEntity = merchantDataRepository.findById(merchantId).get();
        return merchantDataEntity.getRating();
    }

    @Override
    public int getNumberOfRatings(String merchantId){
        MerchantDetailsEntity merchantDataEntity = merchantDataRepository.findById(merchantId).get();
        return merchantDataEntity.getNumberRatings();
    }


}
