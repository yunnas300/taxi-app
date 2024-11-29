import com.example.shaitantaxi.Region;
import com.example.shaitantaxi.TaxiOrder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaxiOrderTest {

    @Test
    void testTaxiOrderCreation() {
        Region start = new Region('A', 1);
        Region end = new Region('B', 2);
        TaxiOrder order = new TaxiOrder(start, end, "Economy", "Credit Card", true, false, false, 3);

        assertEquals(start, order.getStartRegion());
        assertEquals(end, order.getEndRegion());
        assertEquals("Economy", order.getCarType());
        assertEquals("Credit Card", order.getPaymentMethod());
        assertTrue(order.isChildSeat());
        assertFalse(order.isPetTransport());
        assertFalse(order.isAfterParty());
        assertEquals(3, order.getNumPeople());
    }
}
