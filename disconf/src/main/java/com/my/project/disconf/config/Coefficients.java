package com.my.project.disconf.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.baidu.disconf.client.common.annotations.DisconfItem;

@Configuration
public class Coefficients {

    @Value("2.0d")
    private static double discount;

    private final static String key = "discount";

    @DisconfItem(key = key)
    public static double getDiscount() {
        return discount;
    }

    public static void setDiscount(double discount2) {
        discount = discount2;
    }

}
