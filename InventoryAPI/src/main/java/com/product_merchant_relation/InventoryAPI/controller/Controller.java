package com.product_merchant_relation.InventoryAPI.controller;


import com.product_merchant_relation.InventoryAPI.entity.PidMidRelationEntity;
import com.product_merchant_relation.InventoryAPI.services.PidMidRelationServices;
import com.product_merchant_relation.InventoryAPI.services.PidMidRelationServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pid_mid/")
public class Controller {

    @Autowired
    PidMidRelationServices pidMidRelationServices;


    @RequestMapping(method = RequestMethod.POST, value = "update/inventory/{pmId}")
    public ResponseEntity<Boolean> updateInventory(@PathVariable("pmId")String pmId, @RequestBody int inventory){
        Boolean bool = pidMidRelationServices.updateInventory(pmId,inventory);
        return new ResponseEntity<Boolean>(bool,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "update/cost/{pmId}")
    public ResponseEntity<Boolean> updateCost(@PathVariable("pmId")String pmId, @RequestBody int cost){
        Boolean bool = pidMidRelationServices.updateCost(pmId,cost);
        return new ResponseEntity<Boolean>(bool,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "delete/{pmId}")
    public ResponseEntity<Boolean> deleteInventory(@PathVariable("pmId")String pmId){
        Boolean bool = pidMidRelationServices.deleteInventory(pmId);
        return new ResponseEntity<Boolean>(bool,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "add")
    public ResponseEntity<Boolean> updateInventory(@RequestBody PidMidRelationEntity pidMidRelationEntity){
        Boolean bool = pidMidRelationServices.addInventory(pidMidRelationEntity);
        return new ResponseEntity<Boolean>(bool,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "get/inventory/{pmId}")
    public ResponseEntity<Integer> updateInventory(@PathVariable("pmId")String pmId){
        int inventory = pidMidRelationServices.getInventory(pmId);
        return new ResponseEntity<Integer>(inventory,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "get/{pmId}")
    public ResponseEntity<PidMidRelationEntity> getPidMidRelation(@PathVariable("pmId")String pmId){
        PidMidRelationEntity pidMidRelationEntity = pidMidRelationServices.getPidMidRelation(pmId);
        return new ResponseEntity<PidMidRelationEntity>(pidMidRelationEntity,HttpStatus.OK);
    }

}