package com.nile.Nile_Product.controller;

import com.nile.Nile_Product.dto.CategoryDTO;
import com.nile.Nile_Product.entity.CategoryEntity;
import com.nile.Nile_Product.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public ResponseEntity<List<CategoryDTO>> getAllCategoey(){

        List<CategoryEntity> categoryEntityList = categoryService.findAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (CategoryEntity categoryEntity : categoryEntityList) {
            CategoryDTO categoryDTO = new CategoryDTO();
            BeanUtils.copyProperties(categoryEntity, categoryDTO);
            categoryDTOList.add(categoryDTO);
        }
        return new ResponseEntity<List<CategoryDTO>>(categoryDTOList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insert/{name}")
    public CategoryDTO addcategory(@PathVariable("name") String name){

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(name);
        categoryEntity = categoryService.insertOrUpdate(categoryEntity);
        CategoryDTO categoryDTO = new CategoryDTO();
        BeanUtils.copyProperties(categoryEntity, categoryDTO);
        return categoryDTO;
    }
}