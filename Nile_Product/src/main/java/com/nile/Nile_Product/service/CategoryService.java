package com.nile.Nile_Product.service;

import com.nile.Nile_Product.entity.CategoryEntity;


import java.util.List;

public interface CategoryService {
    public List<CategoryEntity> findAll();
    public CategoryEntity insertOrUpdate(CategoryEntity categoryEntity);
}
