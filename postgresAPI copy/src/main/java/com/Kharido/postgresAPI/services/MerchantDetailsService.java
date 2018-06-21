package com.Kharido.postgresAPI.services;

import com.Kharido.postgresAPI.dto.MerchantDetail;
import com.Kharido.postgresAPI.dto.MerchantLoginDetails;
import com.Kharido.postgresAPI.entity.MerchantDetailsEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



public interface MerchantDetailsService {
    public Optional<MerchantDetailsEntity> findOne(String userId);

    public MerchantDetail save(MerchantDetail merchantDetail);

    public boolean exists(String userId);

    public List<MerchantDetailsEntity> findAll();

    public Iterable<MerchantDetailsEntity> findAll(Iterable<String> userId);

    public long count();

    public void delete(String userId);

    public void delete(MerchantDetailsEntity employee);

    public void deleteAll();

    // public List<MerchantDetailsEntity> getByFirstName(String fullName);

    public MerchantDetailsEntity getOneByMerchantId(String merchantId);

    public String merchantLogin(MerchantLoginDetails merchantLoginDetails);


}
