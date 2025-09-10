import org.junit.AfterEach;
import org.junit.BeforeEach;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class RadioButtonSelectionTest {
    private WebDriver driver;


    @BeforeEach
    void setUp() {
        driver= new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
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

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
