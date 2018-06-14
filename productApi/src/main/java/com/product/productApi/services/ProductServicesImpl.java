package com.product.productApi.services;

import com.product.productApi.entity.Categories;

import java.util.List;

public class ProductServicesImpl implements ProductServices{

    @Override
    public Categories[] getCategories() {
        //List<Categories> lc = Categories.values();
        return Categories.values();
    }
}
