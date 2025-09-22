package TestPackage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;


public class HardAssertLoginTest extends TestBase {

    @Test
    public void testPositiveLogin() {
        driver.get("https://claruswaysda.github.io/signIn.html");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://claruswaysda.github.io/signIn.html", "Expected URL does not match after login.");
        Assert.assertTrue(driver.getPageSource().contains("Employee Table"), "Page does not contain expected text 'Employee Table'.");
    }

}
