import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrowserHistoryTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testBrowserHistory() {
        // Test 1: Navigate to Wikipedia and Google
        driver.get("https://www.wikipedia.org/");
        assertEquals("Wikipedia", driver.getTitle(), "Title should be Wikipedia");

        driver.get("https://www.google.com/");
        assertEquals("Google", driver.getTitle(), "Title should be Google");

        // Navigate back to Wikipedia
        driver.navigate().back();
        assertEquals("Wikipedia", driver.getTitle(), "Title should be Wikipedia after back");

        // Navigate forward to Google
        driver.navigate().forward();
        assertEquals("Google", driver.getTitle(), "Title should be Google after forward");

        // Navigate back again
        driver.navigate().back();
        assertEquals("Wikipedia", driver.getTitle(), "Title should be Wikipedia after back again");

        // Navigate forward again
        driver.navigate().forward();
        assertEquals("Google", driver.getTitle(), "Title should be Google after forward again");
    }

    @Test
    public void testRefreshOnGoogle() {
        // Test 2: Refresh on Google
        driver.get("https://www.google.com/");
        assertEquals("Google", driver.getTitle(), "Title should be Google before refresh");

        driver.navigate().refresh();
        assertEquals("Google", driver.getTitle(), "Title should still be Google after refresh");
    }

    @AfterEach
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
