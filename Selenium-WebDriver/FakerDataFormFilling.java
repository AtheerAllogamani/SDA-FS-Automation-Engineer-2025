import com.github.javafaker.Faker;
import org.junit.AfterEach;
import org.junit.BeforeEach;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class FakerDataFormTest {
    private WebDriver driver;
    private Faker faker;


    @BeforeEach
    void setUp() {
        driver= new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
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

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
