import com.example.shaitantaxi.TaxiOrderController;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TaxiOrderControllerTest {

    private TaxiOrderController controller;
    private TextField startRegionField;
    private TextField endRegionField;
    private ComboBox<String> carTypeComboBox;
    private ComboBox<String> paymentMethodComboBox;
    private ComboBox<Integer> numPeopleComboBox;

    @BeforeEach
    void setUp() {
        controller = new TaxiOrderController();

        startRegionField = mock(TextField.class);
        endRegionField = mock(TextField.class);
        carTypeComboBox = mock(ComboBox.class);
        paymentMethodComboBox = mock(ComboBox.class);
        numPeopleComboBox = mock(ComboBox.class);

        controller.startRegionField = startRegionField;
        controller.endRegionField = endRegionField;
        controller.carTypeComboBox = carTypeComboBox;
        controller.paymentMethodComboBox = paymentMethodComboBox;
        controller.numPeopleComboBox = numPeopleComboBox;
    }

    @Test
    void testHandleOrderButtonActionValid() {
        when(startRegionField.getText()).thenReturn("A1");
        when(endRegionField.getText()).thenReturn("B2");
        when(carTypeComboBox.getValue()).thenReturn("Economy");
        when(paymentMethodComboBox.getValue()).thenReturn("Cash");
        when(numPeopleComboBox.getValue()).thenReturn(2);

        controller.handleOrderButtonAction();

        verify(startRegionField).getText();
        verify(endRegionField).getText();
    }

    @Test
    void testHandleCalculatePriceButtonActionInvalidRegion() {
        when(startRegionField.getText()).thenReturn("X1");
        when(endRegionField.getText()).thenReturn("Y2");

        controller.handleCalculatePriceButtonAction();

        assertEquals("Невірний регіон", controller.priceLabel.getText());
    }
}
