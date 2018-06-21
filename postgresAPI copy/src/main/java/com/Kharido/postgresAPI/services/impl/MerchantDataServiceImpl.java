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

    @Autowired
    MerchantDataRepository merchantDataRepository;

    @Override
    public MerchantDetail save(MerchantDetail merchantData) {

        MerchantDetailsEntity merchantDetailsEntity = new MerchantDetailsEntity();
        BeanUtils.copyProperties(merchantData, merchantDetailsEntity);
        merchantDataRepository.save(merchantDetailsEntity);
         System.out.println(merchantDetailsEntity.getMerchantId());
         MerchantDetail response = new MerchantDetail();
        BeanUtils.copyProperties(merchantDetailsEntity, response);
        return response;
    }

    @Override
    public boolean addProduct(String merchandId, int product) {
        MerchantDetailsEntity merchantDataEntity = (MerchantDetailsEntity) merchantDataRepository.findById(merchandId).get();
        int numberOfProducts = merchantDataEntity.getNumberProducts();
        merchantDataEntity.setNumberProducts(numberOfProducts + product);
       // merchantDataRepository.deleteById(merchandId);
        return merchantDataEntity.getNumberProducts() == merchantDataRepository.save(merchantDataEntity).getNumberProducts();

    }

    @Override
    public boolean decreaseProduct(String merchandId, int product) {
        MerchantDetailsEntity merchantDataEntity = (MerchantDetailsEntity) merchantDataRepository.findById(merchandId).get();
        int numberOfProducts = merchantDataEntity.getNumberProducts();
        merchantDataEntity.setNumberProducts(numberOfProducts - product);
    //    merchantDataRepository.deleteById(merchandId);
        return merchantDataEntity.getNumberProducts() == merchantDataRepository.save(merchantDataEntity).getNumberProducts();

    }

    @Override
    public boolean addStock(String merchandId, int stock) {
        MerchantDetailsEntity merchantDataEntity = (MerchantDetailsEntity) merchantDataRepository.findById(merchandId).get();
        int numberOfStocks = merchantDataEntity.getStock();
        merchantDataEntity.setStock(numberOfStocks + stock);
    //    merchantDataRepository.deleteById(merchandId);
        return merchantDataEntity.getStock() == merchantDataRepository.save(merchantDataEntity).getStock();

    }

    @Override
    public boolean decreaseStock(String merchandId, int stock) {
        MerchantDetailsEntity merchantDataEntity = (MerchantDetailsEntity) merchantDataRepository.findById(merchandId).get();
        int numberOfStocks = merchantDataEntity.getStock();
        merchantDataEntity.setStock(numberOfStocks - stock);
     //   merchantDataRepository.deleteById(merchandId);
        return merchantDataEntity.getStock() == merchantDataRepository.save(merchantDataEntity).getStock();

    }

    //    @Override
//    public MerchantDetailsEntity getOne(String merchantId) {
//        MerchantDetailsEntity merchantDataEntity = merchantDataRepository.findById(merchantId).get();
//        return merchantDataEntity;
//    }
    @Override
    public boolean addSold(String merchandId, int sold) {
        MerchantDetailsEntity merchantDataEntity = (MerchantDetailsEntity) merchantDataRepository.findById(merchandId).get();
        int numberOfStocks = merchantDataEntity.getSold();
        merchantDataEntity.setSold(numberOfStocks + sold);
      //  merchantDataRepository.deleteById(merchandId);
        return merchantDataEntity.getSold() == merchantDataRepository.save(merchantDataEntity).getSold();

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
        return new Double(merchantDataEntity.getRating());
    }

    @Override
    public boolean setRating(String merchantId, double rating) {
        MerchantDetailsEntity merchantDataEntity = merchantDataRepository.findById(merchantId).get();
        merchantDataEntity.setRating(String.valueOf(rating));
    //    merchantDataRepository.deleteById(merchantId);
        return merchantDataEntity.getRating() == merchantDataRepository.save(merchantDataEntity).getRating();

    }

    @Override
    public int getNumberOfRatings(String merchantId) {
        MerchantDetailsEntity merchantDataEntity = merchantDataRepository.findById(merchantId).get();
        return merchantDataEntity.getNumberRatings();
    }

    @Override
    public boolean setNumberOfRatings(String merchantId, int numberRating) {
        MerchantDetailsEntity merchantDataEntity = merchantDataRepository.findById(merchantId).get();
        merchantDataEntity.setNumberRatings(numberRating);
    //    merchantDataRepository.deleteById(merchantId);
        return merchantDataEntity.getNumberRatings() == merchantDataRepository.save(merchantDataEntity).getNumberRatings();


    }

    @Override
    public boolean addReview(String merchandId, int ratingNew) {
        double pastRating = getRating(merchandId);
        int pastNumberRating = getNumberOfRatings(merchandId);
        double newRating = (pastRating * pastNumberRating + ratingNew) / (pastNumberRating + 1);
        boolean checkSave = true;
        checkSave &= setRating(merchandId, newRating);
        checkSave &= setNumberOfRatings(merchandId, pastNumberRating + 1);
        return checkSave;
    }
}
