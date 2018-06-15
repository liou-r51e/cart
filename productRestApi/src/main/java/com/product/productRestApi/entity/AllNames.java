package com.product.productRestApi.entity;

import java.util.Map;

public class AllNames {

    public static String[] categories;
    public static Map<String,String[]> subCategories;

    public AllNames(){
        categories = new String[]{"Electronics","Men"};

        subCategories.put(categories[0],new String[]{"Mobiles","Laptop","Fridge"});
        subCategories.put(categories[1],new String[]{"Trouser","T-shirts","Shorts","Jeans","Inner wear","Shoes"});
        subCategories.put(categories[2],new String[]{"",""});
        subCategories.put(categories[3],new String[]{"",""});



    }

}
