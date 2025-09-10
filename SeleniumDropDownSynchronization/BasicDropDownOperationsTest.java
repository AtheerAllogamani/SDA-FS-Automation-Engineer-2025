import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BasicDropDownOperationsTest {
    private WebDriver driver;
    private Select dropdown;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        dropdown = new Select(driver.findElement(By.id("dropdown")));
    }

    @Test
    public void selectByIndexTest() {
        dropdown.selectByIndex(0); // Select Option 1
    }

    @Test
    public void selectByValueTest() {
        dropdown.selectByValue("2"); // Select Option 2
    }

    @Test
    public void selectByVisibleTextTest() {
        dropdown.selectByVisibleText("Option 1");
    }

    @Test
    public void printAllTest() {
        List<WebElement> options = dropdown.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        assertTrue("Dropdown should contain Option 2", options.stream().anyMatch(option -> option.getText().equals("Option 2")));
    }

    @Test
    public void printFirstSelectedOptionTest() {
        WebElement selectedOption = dropdown.getFirstSelectedOption();
        System.out.println("First selected option: " + selectedOption.getText());
    }

    @Test
    public void verifyDropdownSize() {
        assertEquals("Dropdown should have 3 options", 3, dropdown.getOptions().size());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
