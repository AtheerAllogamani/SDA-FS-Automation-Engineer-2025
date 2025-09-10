import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertTrue;

public class MultiSelectOperationsTest {
    private WebDriver driver;
    private Select dropdown;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        dropdown = new Select(driver.findElement(By.id("cars")));
    }

    @Test
    public void testMultiSelectOperations() {
        assertTrue("Element should be multi-select", dropdown.isMultiple());

        dropdown.selectByIndex(0); // Select 'Opel'
        dropdown.deselectByIndex(0); // Deselect 'Opel'

        dropdown.selectByValue("saab"); // Select 'Saab'
        dropdown.deselectByValue("saab"); // Deselect 'Saab'

        dropdown.deselectAll(); // Deselect all options
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
