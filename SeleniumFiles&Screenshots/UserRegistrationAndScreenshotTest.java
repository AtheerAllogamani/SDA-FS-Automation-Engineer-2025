package TestPackage;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.io.IOException;


public class UserRegistrationAndScreenshotTest extends TestBase {
        @Test
        void task3() throws InterruptedException, IOException {
            //Go to https://claruswaysda.github.io/homepage.html
            driver.get("https://claruswaysda.github.io/homepage.html");
            takeFullPageScreenshot();

            //Register a user
            driver.findElement(By.id("userIcon")).click();
            driver.findElement(By.xpath("//a[text()='Register']")).click();
            takeFullPageScreenshot();
            Thread.sleep(2000);

            //Fill the registerstion form
            driver.findElement(By.id("ssn")).sendKeys("ssn");
            driver.findElement(By.id("first-name")).sendKeys("firstname");
            driver.findElement(By.id("last-name")).sendKeys("lastname");
            driver.findElement(By.id("address")).sendKeys("address");
            driver.findElement(By.id("phone")).sendKeys("0550000123");
            driver.findElement(By.id("username")).sendKeys("username");
            driver.findElement(By.id("email")).sendKeys("email@gmail.com");
            driver.findElement(By.id("password")).sendKeys("password");
            driver.findElement(By.id("confirm-password")).sendKeys("confirm-password");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@type='submit']")).click();
            takeFullPageScreenshot();

            //Sign in with the registered user
            driver.findElement(By.xpath("//button[@class='login-button']")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("username")).sendKeys("username");
            driver.findElement(By.id("password")).sendKeys("password");
            takeFullPageScreenshot();
            driver.findElement(By.xpath("//*[@type='submit']")).click();
            Thread.sleep(5000);

            //Take all pages' screenshots (in each page I called takeFullPageScreenshot();)
            //Take 'Celebrate Login' button's screenshot
            WebElement celebrateLogin = driver.findElement(By.id("clickMeButton"));
            takeElementsScreenshot(celebrateLogin);

            //Capture a screenshot of the page with confetti
            celebrateLogin.click();
            takeFullPageScreenshot();
        }
}
