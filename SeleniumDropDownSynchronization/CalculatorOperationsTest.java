import org.junit.AfterEach;
import org.junit.BeforeEach;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class CalculatorOperationsTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver= new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testCalculatorOperations() {
        // Input numbers
        driver.findElement(By.id("number1")).sendKeys("10");
        driver.findElement(By.id("number2")).sendKeys("5");

        // Perform calculations
        String[] operations = {"add", "subtract", "multiply", "divide"};
        String[] expectedResults = {"15", "5", "50", "2"};
        
        for (int i = 0; i < operations.length; i++) {
            driver.findElement(By.id(operations[i])).click();
            String result = driver.findElement(By.id("answer")).getText();
            assertEquals("Result for " + operations[i] + " is incorrect", expectedResults[i], result);
        }
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
