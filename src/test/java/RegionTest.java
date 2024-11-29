import com.example.shaitantaxi.Region;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RegionTest {

    @Test
    void testValidRegion() {
        Region region = Region.fromString("A1");
        assertEquals('A', region.getX());
        assertEquals(1, region.getY());
    }

    @Test
    void testInvalidRegion() {
        assertThrows(IllegalArgumentException.class, () -> Region.fromString("A"));
        assertThrows(IllegalArgumentException.class, () -> Region.fromString("Z31"));
        assertThrows(IllegalArgumentException.class, () -> Region.fromString("A32"));
    }

    @Test
    void testIsValidRegion() {
        assertTrue(Region.isValidRegion("A1"));
        assertFalse(Region.isValidRegion("A0"));
        assertFalse(Region.isValidRegion("Z31"));
        assertTrue(Region.isValidRegion("P30"));
    }
}
