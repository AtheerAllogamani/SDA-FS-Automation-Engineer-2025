import org.junit.AfterEach;
import org.junit.BeforeEach;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class OldStyleSelectMenuTest {
    private WebDriver driver;
    private Select dropdown;

    @BeforeEach
    void setUp() {
        driver= new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testOldStyleSelectMenu() {
        // Print all dropdown options
        dropdown.getOptions().forEach(option -> System.out.println(option.getText()));

        // Select by index, visible text, and value
        dropdown.selectByIndex(4); // Select 'Purple'
        dropdown.selectByVisibleText("Magenta"); // Select 'Magenta'
        dropdown.selectByValue("5"); // Assuming value for another option
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
