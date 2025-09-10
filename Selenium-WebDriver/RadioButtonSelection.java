import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class RadioButtonSelectionTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
    }

    @Test
    public void testRadioButtonSelection() {
        String[] options = {"yesRadio", "impressiveRadio", "noRadio"};

        for (String option : options) {
            WebElement radioButton = driver.findElement(By.id(option));
            System.out.println(option + " is enabled: " + radioButton.isEnabled());
            if (radioButton.isEnabled() && !radioButton.isSelected()) {
                radioButton.click();
                System.out.println(option + " selected.");
                assertTrue(option + " should be selected", radioButton.isSelected());
            }
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
