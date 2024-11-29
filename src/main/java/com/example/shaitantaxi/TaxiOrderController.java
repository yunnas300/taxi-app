package com.example.shaitantaxi;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaxiOrderController {

    @FXML
    private TextField startRegionField;
    @FXML
    private TextField endRegionField;
    @FXML
    private ComboBox<String> carTypeComboBox;
    @FXML
    private ComboBox<String> paymentMethodComboBox;
    @FXML
    private CheckBox childSeatCheckBox;
    @FXML
    private CheckBox petTransportCheckBox;
    @FXML
    private CheckBox afterPartyCheckBox;
    @FXML
    private ComboBox<Integer> numPeopleComboBox;
    @FXML
    private Button orderButton;
    @FXML
    private Button calculatePriceButton;
    @FXML
    private Label priceLabel;

    private static final String ORDERS_FILE_PATH = "orders.txt";
    private BufferedWriter writer;

    @FXML
    public void initialize() {
        carTypeComboBox.getItems().addAll("Economy", "Comfort", "Business");
        paymentMethodComboBox.getItems().addAll("Credit Card", "Cash", "PayPal");
        numPeopleComboBox.getItems().addAll(1, 2, 3, 4, 5, 6);

        orderButton.setOnAction(e -> handleOrderButtonAction());
        calculatePriceButton.setOnAction(e -> handleCalculatePriceButtonAction());

        try {
            writer = new BufferedWriter(new FileWriter(ORDERS_FILE_PATH, true)); // append mode
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleOrderButtonAction() {
        String startRegionStr = startRegionField.getText().toUpperCase();
        String endRegionStr = endRegionField.getText().toUpperCase();

        if (Region.isValidRegion(startRegionStr) && Region.isValidRegion(endRegionStr)) {
            Region startRegion = Region.fromString(startRegionStr);
            Region endRegion = Region.fromString(endRegionStr);
            String carType = carTypeComboBox.getValue();
            String paymentMethod = paymentMethodComboBox.getValue();
            boolean childSeat = childSeatCheckBox.isSelected();
            boolean petTransport = petTransportCheckBox.isSelected();
            boolean afterParty = afterPartyCheckBox.isSelected();
            int numPeople = numPeopleComboBox.getValue();

            TaxiOrder order = new TaxiOrder(startRegion, endRegion, carType, paymentMethod, childSeat, petTransport, afterParty, numPeople);
            saveOrderToFile(order);
            System.out.println("Order placed: " + order);
        } else {
            System.out.println("Invalid regions provided");
        }
    }

    private void handleCalculatePriceButtonAction() {
        String startRegionStr = startRegionField.getText().toUpperCase();
        String endRegionStr = endRegionField.getText().toUpperCase();

        if (Region.isValidRegion(startRegionStr) && Region.isValidRegion(endRegionStr)) {
            Region startRegion = Region.fromString(startRegionStr);
            Region endRegion = Region.fromString(endRegionStr);
            TaxiOrder order = new TaxiOrder(startRegion, endRegion, carTypeComboBox.getValue(), null, false, false, false, 0);
            double price = TaxiService.calculatePrice(order);
            priceLabel.setText("Ціна: " + price + " грн");
        } else {
            priceLabel.setText("Невірний регіон");
        }
    }

    private void saveOrderToFile(TaxiOrder order) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatter);
        String orderDetails = String.format("Order Time: %s, Start Region: %s, End Region: %s, Car Type: %s, Payment Method: %s, Child Seat: %s, Pet Transport: %s, After Party: %s, Num People: %d, Price: %.2f\n",
                timestamp, order.getStartRegion(), order.getEndRegion(), order.getCarType(), order.getPaymentMethod(),
                order.isChildSeat(), order.isPetTransport(), order.isAfterParty(), order.getNumPeople(), TaxiService.calculatePrice(order));

        try {
            writer.write(orderDetails);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void cleanup() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
