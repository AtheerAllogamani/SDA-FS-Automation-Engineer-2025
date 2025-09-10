package TestPackage;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GrowingClickableElementTest  {
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
        WebElement button = driver.findElement(By.id("growbutton"));

        // Waiting until the "Event Triggered" (growbuttonstatus) shows
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("growbuttonstatus")));


        // Retrieve the result message and verify the message contains "Event Triggered"
        String message = driver.findElement(By.id("growbuttonstatus")).getText();
        System.out.println("Retrieved message: " + message);
        Assertions.assertEquals("Event Triggered",message);
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
