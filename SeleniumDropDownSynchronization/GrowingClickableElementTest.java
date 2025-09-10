import org.junit.AfterEach;
import org.junit.BeforeEach;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertTrue;

public class GrowingClickableElementTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver= new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test
    public void testGrowingClickable() {
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");        
        driver.findElement(By.id("clickable")).click();
        String message = driver.findElement(By.id("result")).getText();
        assertTrue("Event Triggered message not displayed", message.contains("Event Triggered"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
