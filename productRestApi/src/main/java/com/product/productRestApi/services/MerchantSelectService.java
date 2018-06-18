package com.product.productRestApi.services;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.productRestApi.dtos.MerchantDetailsDto;
import com.product.productRestApi.entity.MerchantDetailsEntity;
import com.product.productRestApi.entity.PidMidRelationEntity;
import com.product.productRestApi.entity.ProductDetailEntity;
import com.product.productRestApi.httpSend.HttpURLConnectionExample;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MerchantSelectService {

    ObjectMapper objectMapper = new ObjectMapper();

    String pid_mid_IP = "http://localhost:8091/pid_mid/";
    String login_IP = "http://localhost:809*/merchantGateway/";

    JavaType listtype = objectMapper.getTypeFactory().constructCollectionType(List.class, PidMidRelationEntity.class);

    public void addMerchants(ProductDetailEntity productDetailEntity) {
        List<PidMidRelationEntity> pidMidRelationEntities = null;
        String responseUrl = null;
        try {
            responseUrl = HttpURLConnectionExample.sendGet(pid_mid_IP + "get/merchants/" + productDetailEntity.getProductId());

            pidMidRelationEntities = objectMapper.readValue(responseUrl, listtype);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<MerchantDetailsDto> merchantDetailsDtos = getMerchants(pidMidRelationEntities);
        productDetailEntity.setMerchantDetailsDtos(merchantDetailsDtos);
        for (MerchantDetailsDto i:merchantDetailsDtos) {
            productDetailEntity.getCost().add(findCost(i.getMerchantId(),pidMidRelationEntities));
        }
    }


    public List<MerchantDetailsDto> getMerchants(List<PidMidRelationEntity> pidMidRelationEntities) {

        List<MerchantDetailsDto> merchantDetailsDtos = new ArrayList<>();

        for (PidMidRelationEntity i : pidMidRelationEntities) {
            String responseUrl = null;
            try {
                responseUrl = HttpURLConnectionExample.sendGet(login_IP + "getMerchantDetails/" + i.getMerchantId());
                MerchantDetailsEntity merchantDetailsEntity = objectMapper.readValue(responseUrl, MerchantDetailsEntity.class);
                MerchantDetailsDto merchantDetailsDto = new MerchantDetailsDto();
                BeanUtils.copyProperties(merchantDetailsEntity,merchantDetailsDto);
                merchantDetailsDtos.add(merchantDetailsDto);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


        Collections.sort(merchantDetailsDtos, (m1, m2) -> {
            if (m1.getRating() > m2.getRating())
                return 1;
            if (m1.getRating() < m2.getRating())
                return -1;
            return 0;
        });
        return merchantDetailsDtos;
    }

    int findCost(String merchantId, List<PidMidRelationEntity> pidMidRelationEntities){
        for (int i=0;i<pidMidRelationEntities.size();i++){
            if(merchantId==pidMidRelationEntities.get(i).getMerchantId()){
                return pidMidRelationEntities.get(i).getCost();
            }
        }
        return 0;
    }

}
