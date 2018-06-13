package com.product_merchant_relation.InventoryAPI.services;


import com.product_merchant_relation.InventoryAPI.entity.PidMidRelationEntity;
import com.product_merchant_relation.InventoryAPI.repository.PidMidRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
public class PidMidRelationServicesImpl implements PidMidRelationServices {

    @Autowired
    PidMidRelationRepository pidMidRelationRepository;

    @Override
    public boolean updateInventory(String pmId, int inventory) {
        PidMidRelationEntity pidMidRelationEntity = pidMidRelationRepository.findById(pmId).get();
        pidMidRelationEntity.setInventory(inventory);
        pidMidRelationRepository.deleteByPmId(pmId);

        return pidMidRelationEntity.equals(pidMidRelationRepository.save(pidMidRelationEntity));
    }

    @Override
    public boolean updateCost(String pmId, int cost) {
        PidMidRelationEntity pidMidRelationEntity = pidMidRelationRepository.findById(pmId).get();
        pidMidRelationEntity.setCost(cost);
        pidMidRelationRepository.deleteByPmId(pmId);

        return pidMidRelationEntity.equals(pidMidRelationRepository.save(pidMidRelationEntity));
    }


    @Override
    public boolean deleteInventory(String pmId) {
        pidMidRelationRepository.deleteByPmId(pmId);
        return false;
    }

    @Override
    public boolean addInventory(PidMidRelationEntity pidMidRelationEntity) {

        return pidMidRelationEntity.equals(pidMidRelationRepository.save(pidMidRelationEntity));
    }

    @Override
    public int getInventory(String pmId) {
        PidMidRelationEntity pidMidRelationEntity = pidMidRelationRepository.findById(pmId).get();
        return pidMidRelationEntity.getInventory();
    }

    @Override
    public PidMidRelationEntity getPidMidRelation(String pmId) {

        return pidMidRelationRepository.findById(pmId).get();
    }
}
