package com.example.shaitantaxi;

import java.util.HashMap;
import java.util.Map;

public class TaxiService {
    private static final double BASE_PRICE = 10.0; // base price for any trip
    private static final Map<String, Double> carTypeMultipliers = new HashMap<>();

    static {
        carTypeMultipliers.put("Economy", 1.0);
        carTypeMultipliers.put("Comfort", 1.5);
        carTypeMultipliers.put("Business", 2.0);
    }

    public static double calculatePrice(TaxiOrder order) {
        double distance = calculateDistance(order.getStartRegion(), order.getEndRegion());
        double carTypeMultiplier = carTypeMultipliers.getOrDefault(order.getCarType(), 1.0);
        return BASE_PRICE * distance * carTypeMultiplier;
    }

    private static double calculateDistance(Region startRegion, Region endRegion) {
        int xDistance = Math.abs(startRegion.getX() - endRegion.getX());
        int yDistance = Math.abs(startRegion.getY() - endRegion.getY());
        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }
}
