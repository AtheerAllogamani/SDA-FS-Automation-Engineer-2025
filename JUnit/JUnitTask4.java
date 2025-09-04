import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleNavigationTest {
    private static WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testMultipleNavigationAndVerification() {
        // Test 1: Navigate to Google, YouTube, and LinkedIn
        driver.get("https://www.google.com/");
        assertEquals("Google", driver.getTitle(), "Title should be Google");

        driver.get("https://www.youtube.com/");
        assertEquals("YouTube", driver.getTitle(), "Title should be YouTube");

        driver.get("https://www.linkedin.com/");
        assertEquals("LinkedIn", driver.getTitle(), "Title should be LinkedIn");
    }

    @Test
    public void testBackAndForwardNavigation() {
        // Navigate back twice and assert the URL of Google
        driver.get("https://www.google.com/");
        driver.get("https://www.youtube.com/");
        driver.get("https://www.linkedin.com/");
        
        driver.navigate().back();
        driver.navigate().back();
        assertEquals("https://www.google.com/", driver.getCurrentUrl(), "URL should be Google");

        // Navigate forward twice and assert URL of LinkedIn
        driver.navigate().forward();
        driver.navigate().forward();
        assertEquals("https://www.linkedin.com/", driver.getCurrentUrl(), "URL should be LinkedIn");
    }

    @AfterAll
    public static void tearDown() {
        // Quit the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
