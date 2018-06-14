package com.Kharido.postgresAPI.services;

import com.Kharido.postgresAPI.dto.MerchantDetail;
import com.Kharido.postgresAPI.dto.UserDetail;
import com.Kharido.postgresAPI.entity.MerchantDetailsEntity;
import com.Kharido.postgresAPI.entity.UserDetailsEntity;

import java.util.List;

public interface MerchantDetailsService {
    public MerchantDetailsEntity findOne(String userId);

    public MerchantDetail save(MerchantDetail merchantDetail);

    public boolean exists(String userId);

    public List<MerchantDetailsEntity> findAll();

    public Iterable<MerchantDetailsEntity> findAll(Iterable<String> userId);

    public long count();

    public void delete(String userId);

    public void delete(MerchantDetailsEntity employee);

    public void deleteAll();

    public List<MerchantDetailsEntity> getByFirstName(String fullName);

    public MerchantDetailsEntity getOneByMerchantId(String merchantId);


}
