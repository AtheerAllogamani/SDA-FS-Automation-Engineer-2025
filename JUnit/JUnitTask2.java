import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageSourceValidationTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testSeleniumPageSource() {
        // Test 1: Navigate to Selenium and check for "WebDriver"
        driver.get("https://www.selenium.dev/");
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("WebDriver"), "Page source should contain 'WebDriver'");
    }

    @Test
    public void testPythonPageSource() {
        // Test 2: Navigate to Python and check for "Python"
        driver.get("https://www.python.org/");
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Python"), "Page source should contain 'Python'");
    }

    @AfterEach
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
