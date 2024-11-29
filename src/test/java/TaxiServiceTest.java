import com.example.shaitantaxi.Region;
import com.example.shaitantaxi.TaxiOrder;
import com.example.shaitantaxi.TaxiService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaxiServiceTest {

    @Test
    void testCalculatePrice() {
        Region start = new Region('A', 1);
        Region end = new Region('B', 2);
        TaxiOrder order = new TaxiOrder(start, end, "Economy", "Credit Card", false, false, false, 1);

        double price = TaxiService.calculatePrice(order);
        double expectedPrice = 10.0 * Math.sqrt(1 + 1) * 1.0; // Дистанция 1 по X и 1 по Y

        assertEquals(expectedPrice, price, 0.01);
    }

    @Test
    void testCarTypeMultiplier() {
        Region start = new Region('A', 1);
        Region end = new Region('B', 2);
        TaxiOrder orderEconomy = new TaxiOrder(start, end, "Economy", "Credit Card", false, false, false, 1);
        TaxiOrder orderComfort = new TaxiOrder(start, end, "Comfort", "Credit Card", false, false, false, 1);
        TaxiOrder orderBusiness = new TaxiOrder(start, end, "Business", "Credit Card", false, false, false, 1);

        double priceEconomy = TaxiService.calculatePrice(orderEconomy);
        double priceComfort = TaxiService.calculatePrice(orderComfort);
        double priceBusiness = TaxiService.calculatePrice(orderBusiness);

        assertTrue(priceComfort > priceEconomy);
        assertTrue(priceBusiness > priceComfort);
    }
}
