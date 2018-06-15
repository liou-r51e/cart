package com.Kharido.postgresAPI.services.impl;

import com.Kharido.postgresAPI.dto.MerchantDetail;

import com.Kharido.postgresAPI.dto.UserDetail;
import com.Kharido.postgresAPI.entity.MerchantDetailsEntity;
import com.Kharido.postgresAPI.entity.UserDetailsEntity;
import com.Kharido.postgresAPI.repository.MerchantDetailsRepository;
import com.Kharido.postgresAPI.services.MerchantDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantDetailServiceImpl implements MerchantDetailsService {

    @Autowired
    MerchantDetailsRepository merchantDetailsRepository;

    @Override
    public MerchantDetailsEntity findOne(String emailId) {
        return (merchantDetailsRepository.findOneByMerchantId(emailId));
    }

    @Override
    public MerchantDetail save(MerchantDetail merchantDetail) {
        MerchantDetailsEntity merchantDetailsEntity = new MerchantDetailsEntity();
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

    @Override
    public List<MerchantDetailsEntity> getByFirstName(String fullName) {
        return null;
    }

    @Override
    public MerchantDetailsEntity getOneByMerchantId(String merchantId) {
        MerchantDetailsEntity merchantDetailsEntity = merchantDetailsRepository.findOneByMerchantId(merchantId);
        return merchantDetailsEntity;
    }
}
