package com.product.productRestApi.services;

import com.product.productRestApi.dtos.ProductDetailsDto;
import com.product.productRestApi.dtos.ProductSummaryDto;
import com.product.productRestApi.entity.Categories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
public class ProductServicesImpl implements ProductServices{

    @Override
    public Categories[] getCategories() {
        //List<Categories> lc = Categories.values();
        return Categories.values();
    }

    @Override
    public List<ProductSummaryDto> getProducts() {
        return null;
    }

    @Override
    public List<ProductSummaryDto> getProducts(Categories categories) {
        return null;
    }

    @Override
    public List<ProductSummaryDto> getProducts(String subcategory) {
        return null;
    }

    @Override
    public ProductDetailsDto getProductDetails(int productId) {
        return null;
    }
}
