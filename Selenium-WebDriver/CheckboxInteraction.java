import org.junit.AfterEach;
import org.junit.BeforeEach;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class CheckboxInteractionTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver= new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testCheckboxInteraction() {
        WebElement checkbox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[2]"));

        // Ensure both are selected
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }

        // Verify both checkboxes are checked
        assertTrue("Checkbox 1 should be selected", checkbox1.isSelected());
        assertTrue("Checkbox 2 should be selected", checkbox2.isSelected());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
