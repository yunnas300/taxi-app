import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.shaitantaxi.Database;
import com.example.shaitantaxi.Order;
import com.example.shaitantaxi.OrderRequest;
import com.example.shaitantaxi.TaxiOrderProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaxiOrderIntegrationTest {

    private Database mockDatabase;
    private TaxiOrderProcessor orderProcessor;

    @BeforeEach
    public void setUp() {
        mockDatabase = mock(Database.class);
        orderProcessor = new TaxiOrderProcessor(mockDatabase);
    }

    @Test
    public void testSuccessfulOrderSubmission() {
        OrderRequest request = new OrderRequest("Region A", "Region B", "Economy", 2, "Card");

        doNothing().when(mockDatabase).save(any(Order.class));

        String result = orderProcessor.processOrder(request);

        assertEquals("Успешно: Заказ создан", result, "Должно быть успешное создание заказа.");
        verify(mockDatabase, times(1)).save(any(Order.class));
    }

    @Test
    public void testInvalidOrderData() {
        OrderRequest invalidRequest = new OrderRequest("", "", "", 0, "");

        String result = orderProcessor.processOrder(invalidRequest);

        assertEquals("Ошибка: Незаполнены обязательные поля", result, "Должно быть сообщение об ошибке.");
        verify(mockDatabase, never()).save(any(Order.class));
    }

    @Test
    public void testDatabaseUnavailable() {
        OrderRequest request = new OrderRequest("Region A", "Region B", "Economy", 2, "Card");

        doThrow(new RuntimeException("Database unavailable")).when(mockDatabase).save(any(Order.class));

        String result = orderProcessor.processOrder(request);

        assertEquals("Ошибка: Database unavailable", result, "Должно быть сообщение о проблемах с базой данных.");
    }

    @Test
    public void testMockDatabaseInteraction() {
        OrderRequest request = new OrderRequest("Region A", "Region B", "Economy", 2, "Card");

        doNothing().when(mockDatabase).save(any(Order.class));

        String result = orderProcessor.processOrder(request);

        assertEquals("Успешно: Заказ создан", result, "Должно быть успешное создание заказа.");
        verify(mockDatabase, times(1)).save(any(Order.class));
    }
}
