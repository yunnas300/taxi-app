package com.example.shaitantaxi;

public class TaxiOrderProcessor {
    private Database database;  // База данных для сохранения заказов

    public TaxiOrderProcessor(Database database) {
        this.database = database;
    }

    public String processOrder(OrderRequest request) {
        // Проверка на корректность данных
        if (request.getStartRegion().isEmpty() || request.getEndRegion().isEmpty() || request.getCarClass().isEmpty()) {
            return "Ошибка: Незаполнены обязательные поля";
        }

        // Создание заказа и его сохранение
        Order order = new Order(request.getStartRegion(), request.getEndRegion(), request.getCarClass(), request.getPassengers(), request.getPaymentMethod());
        try {
            database.save(order);  // Сохранение в базу данных
            return "Успешно: Заказ создан";
        } catch (Exception e) {
            return "Ошибка: " + e.getMessage();
        }
    }
}
