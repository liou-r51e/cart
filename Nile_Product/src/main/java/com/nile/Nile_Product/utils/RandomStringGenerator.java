package com.nile.Nile_Product.utils;

import java.util.UUID;

/**
 * Created by ppatchava on 1/3/18.
 */
public class RandomStringGenerator {
    public static String generateRandomString(){
        return UUID.randomUUID().toString();
    }
}
