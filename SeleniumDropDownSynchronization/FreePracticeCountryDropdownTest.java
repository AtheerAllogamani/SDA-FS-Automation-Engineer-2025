import org.junit.AfterEach;
import org.junit.BeforeEach;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class FreePracticeCountryDropdownTest {
    private WebDriver driver;
    private Select countryDropdown;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        countryDropdown = new Select(driver.findElement(By.name("country")));
    }

    @Test
    public void testCountryDropdown() {
        // Print all options in the country dropdown
        List<WebElement> options = countryDropdown.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        // Select a country using index
        countryDropdown.selectByIndex(10); // Example: Select the 11th country

        // Verify the country is selected
        String selectedCountry = countryDropdown.getFirstSelectedOption().getText();
        System.out.println("Selected Country: " + selectedCountry);
        assertTrue("The selected country should be displayed", selectedCountry.equals(options.get(10).getText()));

        // Select a country using visible text
        countryDropdown.selectByVisibleText("CANADA");
        selectedCountry = countryDropdown.getFirstSelectedOption().getText();
        System.out.println("Selected Country: " + selectedCountry);
        assertTrue("The selected country should be CANADA", selectedCountry.equals("CANADA"));

        // Select a country using value
        countryDropdown.selectByValue("AFGHANISTAN"); // Assuming the value for Afghanistan is set correctly
        selectedCountry = countryDropdown.getFirstSelectedOption().getText();
        System.out.println("Selected Country: " + selectedCountry);
        assertTrue("The selected country should be AFGHANISTAN", selectedCountry.equals("AFGHANISTAN"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
