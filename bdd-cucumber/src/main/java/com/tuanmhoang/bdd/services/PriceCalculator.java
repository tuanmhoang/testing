package com.tuanmhoang.bdd.services;

import com.tuanmhoang.bdd.helper.TriFunction;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BiFunction;

public class PriceCalculator {

    private static final int DEFAULT_NUMBER_TO_BE_ROUNDED_UP = 2;

    public double calculatePrice(double priceOfTheItem, int quantityOfTheItem) {
        BiFunction<Double, Integer, Double> price = (p, q) -> p * q;
        return round(price.apply(priceOfTheItem, quantityOfTheItem), DEFAULT_NUMBER_TO_BE_ROUNDED_UP);
    }

    private double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public double calculateFinalPrice(double finalPrice, double shippingFee, double discountPrice) {
        TriFunction<Double, Double, Double, Double> price = (p, s, d) -> p + s - d;
        return round(price.apply(finalPrice, shippingFee, discountPrice),DEFAULT_NUMBER_TO_BE_ROUNDED_UP);
    }
}
