package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FluentSignInPage;

public class TestSignIn {
    private WebDriver driver;
    private FluentSignInPage signInPage;

    @BeforeClass
    public void setUp() {
        driver.get("https://claruswaysda.github.io/signIn.html");
        signInPage = new FluentSignInPage(driver);
    }

    @Test
    public void testNegativeScenarios() {
        signInPage.performNegativeTests(); 
    }

    @AfterClass
    public void tearDown() {
        driver.quit(); 
    }
}
