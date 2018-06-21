package com.Kharido.postgresAPI.services.impl;

import com.Kharido.postgresAPI.dto.MerchantDetail;

import com.Kharido.postgresAPI.dto.MerchantLoginDetails;
import com.Kharido.postgresAPI.entity.MerchantDetailsEntity;
import com.Kharido.postgresAPI.repository.MerchantDetailsRepository;
import com.Kharido.postgresAPI.services.MerchantDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MerchantDetailServiceImpl implements MerchantDetailsService {

    @Autowired
    MerchantDetailsRepository merchantDetailsRepository;

    @Override
    public Optional<MerchantDetailsEntity> findOne(String emailId) {
        return (merchantDetailsRepository.findById(emailId));
    }

    @Override
    public MerchantDetail save(MerchantDetail merchantDetail) {
        MerchantDetailsEntity merchantDetailsEntity = new MerchantDetailsEntity();
        merchantDetail.setNumberProducts(0);
        merchantDetail.setNumberRatings(0);
        merchantDetail.setRating("3.5");
        merchantDetail.setSold(0);
        merchantDetail.setStock(0);
        BeanUtils.copyProperties(merchantDetail, merchantDetailsEntity);
        merchantDetailsRepository.save(merchantDetailsEntity);
        System.out.println(merchantDetailsEntity.getMerchantId());
        MerchantDetail response = new MerchantDetail();
        BeanUtils.copyProperties(merchantDetailsEntity, response);
        return response;
    }

    @Override
    public boolean exists(String merchantId) {
        return merchantDetailsRepository.existsById(merchantId);
    }

    @Override
    public List<MerchantDetailsEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<MerchantDetailsEntity> findAll(Iterable<String> MerchantId) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(String MerchantId) {

    }

    @Override
    public void delete(MerchantDetailsEntity employee) {

    }

    @Override
    public void deleteAll() {

    }

    //  @Override
//    public List<MerchantDetailsEntity> getByFirstName(String fullName) {
//        return null;
//    }

    @Override
    public MerchantDetailsEntity getOneByMerchantId(String merchantId) {
        MerchantDetailsEntity merchantDetailsEntity = merchantDetailsRepository.findById(merchantId).get();
        return merchantDetailsEntity;
    }

    @Override
    public String merchantLogin(MerchantLoginDetails merchantLoginDetails) {
        if (merchantDetailsRepository.existsById(merchantLoginDetails.getMerchantId()) == false) {

            return ("Email is not registered !!");
        }

        MerchantDetailsEntity merchantDetailsEntity = merchantDetailsRepository.findById(merchantLoginDetails.getMerchantId()).get();
//        if (merchantDetailsEntity == null) {
//            //Todo : Phani : remove system.out.println, use logger instead
//            System.out.println("User Not Found...");
//            return ("Email is not registered...");
//        }
        boolean merchantPassWordCheck = merchantDetailsEntity.getPassword().equals(merchantLoginDetails.getPassword());
        if (merchantPassWordCheck == false) {
            return ("Username/Password incorrect !!");
        }
        return ("true");

    }


}
