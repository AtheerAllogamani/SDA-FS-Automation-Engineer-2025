import org.junit.After;
import org.junit.Before;
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

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        dropdown = new Select(driver.findElement(By.id("oldSelectMenu")));
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

    @After
    public void tearDown() {
        driver.quit();
    }
}
