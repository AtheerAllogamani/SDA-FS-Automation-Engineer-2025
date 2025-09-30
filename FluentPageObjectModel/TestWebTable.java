package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.FluentWebTablePage;

public class TestWebTable {
    private WebDriver driver;
    private FluentWebTablePage webTablePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        webTablePage = new FluentWebTablePage(driver);
    }

    @DataProvider(name = "recordData")
    public Object[][] recordData() {
        return new Object[][]{
            {"Alice", "30", "USA"},
            {"Bob", "25", "UK"},
            {"Charlie", "35", "Canada"},
            {"Diana", "28", "Australia"},
            {"Ethan", "32", "Germany"}
        };
    }

    @Test(dataProvider = "recordData")
    public void testAddRecords(String name, String age, String country) {
        webTablePage.addRecord(name, age, country);
    }

    @Test(dependsOnMethods = {"testAddRecords"})
    public void testDeleteFirstRecord() {
        webTablePage.deleteRecord("Alice");
    }

    @AfterClass
    public void tearDown() {
        driver.quit(); 
    }
}
