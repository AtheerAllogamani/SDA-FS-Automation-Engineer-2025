import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxInteraction {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // Locate checkboxes
        WebElement checkbox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[2]"));

        // Check current state and ensure both are selected
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }

        // Verify both checkboxes are checked
        System.out.println("Checkbox 1 is selected: " + checkbox1.isSelected());
        System.out.println("Checkbox 2 is selected: " + checkbox2.isSelected());

        driver.quit();
    }
}
