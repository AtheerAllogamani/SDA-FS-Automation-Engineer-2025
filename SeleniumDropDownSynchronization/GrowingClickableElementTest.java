import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class GrowingClickableElementTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");
    }

    @Test
    public void testGrowingClickable() {
        driver.findElement(By.id("clickable")).click();
        String message = driver.findElement(By.id("result")).getText();
        assertTrue("Event Triggered message not displayed", message.contains("Event Triggered"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
