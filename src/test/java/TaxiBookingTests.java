import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TaxiBookingTests {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path_to_your_chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testTaxiTypesAvailable() {
        driver.get("https://your-taxi-app.com");

        Assertions.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Economy')]")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Business')]")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Cargo')]")).isDisplayed());
    }

    @Test
    public void testTaxiOrderWithOptions() {
        driver.get("https://your-taxi-app.com");

        driver.findElement(By.id("orderTaxiButton")).click();

        driver.findElement(By.id("childSeatOption")).click();
        driver.findElement(By.id("submitOrderButton")).click();

        WebElement confirmationMessage = driver.findElement(By.xpath("//div[contains(text(), 'Order Successful')]"));
        Assertions.assertTrue(confirmationMessage.isDisplayed());
    }

    @Test
    public void testUserRegistration() {
        driver.get("https://your-taxi-app.com/register");

        driver.findElement(By.id("nameField")).sendKeys("John Doe");
        driver.findElement(By.id("emailField")).sendKeys("john.doe@example.com");
        driver.findElement(By.id("phoneField")).sendKeys("+1234567890");

        driver.findElement(By.id("registerButton")).click();

        WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(), 'Registration successful')]"));
        Assertions.assertTrue(successMessage.isDisplayed());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}