package com.example.shaitantaxi;

public class Order {
    private String startRegion;
    private String endRegion;
    private String carClass;
    private int passengers;
    private String paymentMethod;

    public Order(String startRegion, String endRegion, String carClass, int passengers, String paymentMethod) {
        this.startRegion = startRegion;
        this.endRegion = endRegion;
        this.carClass = carClass;
        this.passengers = passengers;
        this.paymentMethod = paymentMethod;
    }

    // Геттеры
    public String getStartRegion() { return startRegion; }
    public String getEndRegion() { return endRegion; }
    public String getCarClass() { return carClass; }
    public int getPassengers() { return passengers; }
    public String getPaymentMethod() { return paymentMethod; }
}
