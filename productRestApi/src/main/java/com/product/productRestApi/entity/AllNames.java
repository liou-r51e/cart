package com.product.productRestApi.entity;

import java.util.HashMap;

public class AllNames {

    public static String[] categories;
    public static HashMap<String,String[]> subCategories =new HashMap<>();// = new Map<String, String[]>() {};

    public AllNames(){
        categories = new String[]{"Electronics","Men","Women","Health"};
        //System.out.println(categories[1]);
        subCategories.put(categories[0],new String[]{"Mobiles","Speakers"});
        subCategories.put(categories[1],new String[]{"Trouser","T-shirts","Shorts","Jeans","Inner wear","Shoes"});
        //subCategories.put(categories[2],new String[]{"",""});
        //subCategories.put(categories[3],new String[]{"",""});



    }

}
