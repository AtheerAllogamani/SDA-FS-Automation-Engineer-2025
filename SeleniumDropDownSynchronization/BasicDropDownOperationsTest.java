import org.junit.AfterEach;
import org.junit.BeforeEach;
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

    @BeforeEach
    void setUp() {
        driver= new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
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

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
