import com.github.javafaker.Faker;
import org.junit.AfterEach;
import org.junit.BeforeEach;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DynamicListManagementTest {
    private WebDriver driver;
    private Faker faker;


    
    @BeforeEach
    void setUp() {
        driver= new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        faker = new Faker();
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
    }

    @Test
    public void testDynamicListManagement() {
        // Generate and add tasks
        for (int i = 0; i < 5; i++) {
            String taskName = faker.lorem().sentence(1);
            driver.findElement(By.id("new-task")).sendKeys(taskName);
            driver.findElement(By.id("add-task")).click();
        }

        // Mark every other task as completed
        List<WebElement> tasks = driver.findElements(By.cssSelector(".task"));
        for (int i = 0; i < tasks.size(); i += 2) {
            tasks.get(i).click(); // Assuming clicking marks as complete
        }

        // Delete completed tasks
        List<WebElement> completedTasks = driver.findElements(By.cssSelector(".completed"));
        for (WebElement task : completedTasks) {
            task.findElement(By.cssSelector(".delete")).click(); // Assuming a delete button
        }

        // Verify only incomplete tasks remain
        List<WebElement> remainingTasks = driver.findElements(By.cssSelector(".task"));
        assertEquals("Only incomplete tasks should remain", remainingTasks.size(), tasks.size() / 2);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
