package com.netflow.utils;

import java.util.UUID;

/**
 * @author 汪培林
 * @data 2020-12-24  20:34:54
 */
public class UUIDKeyGenerator {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","").toLowerCase();
    }
}
