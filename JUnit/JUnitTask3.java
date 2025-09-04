import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrowserSizeAndPositionTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @Test
    public void testBrowserSize() {
        // Test 1: Navigate to BBC and set size
        driver.get("https://www.bbc.com/");
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(800, 600));

        // Assert the window size
        assertEquals(800, driver.manage().window().getSize().getWidth(), "Width should be 800");
        assertEquals(600, driver.manage().window().getSize().getHeight(), "Height should be 600");
    }

    @Test
    public void testBrowserPosition() {
        // Test 2: Move the window to position (100, 100)
        driver.get("https://www.bbc.com/");
        driver.manage().window().setPosition(new Point(100, 100));

        // Assert the window position
        assertEquals(100, driver.manage().window().getPosition().getX(), "X position should be 100");
        assertEquals(100, driver.manage().window().getPosition().getY(), "Y position should be 100");
    }

    @AfterEach
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
