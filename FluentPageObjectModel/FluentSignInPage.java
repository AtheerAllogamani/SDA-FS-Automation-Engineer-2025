package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class FluentSignInPage {
    private WebDriver driver;
    private SoftAssert softAssert;

    public FluentSignInPage(WebDriver driver) {
        this.driver = driver;
        this.softAssert = new SoftAssert();
    }

    public FluentSignInPage enterUsername(String username) {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.clear();
        usernameField.sendKeys(username);
        return this;
    }

    public FluentSignInPage enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public FluentSignInPage submit() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        return this;
    }

    public FluentSignInPage validateErrorMessage(String expectedMessage) {
        WebElement errorMessage = driver.findElement(By.id("error-message")); 
        softAssert.assertEquals(errorMessage.getText(), expectedMessage, "Error message does not match expected.");
        return this; 
    }

    public FluentSignInPage performNegativeTests() {
        enterUsername("").enterPassword("123").submit();
        validateErrorMessage("Username is required.");

        enterUsername("admin").enterPassword("").submit();
        validateErrorMessage("Password is required."); 

        enterUsername("invalid_user!").enterPassword("123").submit();
        validateErrorMessage("Invalid username format."); 

        enterUsername("admin").enterPassword("123").submit();
        validateErrorMessage("Weak password."); 

        enterUsername("<script>alert('XSS')</script>").enterPassword("123").submit();
        validateErrorMessage("Invalid username format.");

        softAssert.assertAll(); 
        return this;
    }
}
