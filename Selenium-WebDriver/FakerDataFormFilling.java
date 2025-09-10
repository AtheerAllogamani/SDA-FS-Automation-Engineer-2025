import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class FakerDataFormTest {
    private WebDriver driver;
    private Faker faker;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        faker = new Faker();
        driver.get("https://demoqa.com/text-box");
    }

    @Test
    public void testFakerDataFormFilling() {
        driver.findElement(By.id("userName")).sendKeys(faker.name().fullName());
        driver.findElement(By.id("userEmail")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("currentAddress")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.id("permanentAddress")).sendKeys(faker.address().fullAddress());
        
        driver.findElement(By.id("submit")).click();

        WebElement output = driver.findElement(By.id("output"));
        String outputText = output.getText();
        assertTrue("Output should contain the entered data", outputText.contains(faker.name().fullName()));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
