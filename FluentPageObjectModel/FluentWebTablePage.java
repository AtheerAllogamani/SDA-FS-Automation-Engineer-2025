package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class FluentWebTablePage {
    private WebDriver driver;

    public FluentWebTablePage(WebDriver driver) {
        this.driver = driver;
    }

    public FluentWebTablePage addRecord(String name, String age, String country) {
        WebElement addButton = driver.findElement(By.id("addRecordButton")); 
        addButton.click();

        WebElement nameField = driver.findElement(By.id("name"));
        WebElement ageField = driver.findElement(By.id("age"));
        WebElement countryDropdown = driver.findElement(By.id("country"));
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='button']"));

        nameField.sendKeys(name);
        ageField.sendKeys(age);
        countryDropdown.click(); 
        WebElement countryOption = driver.findElement(By.xpath("//option[text()='" + country + "']"));
        countryOption.click();

        submitButton.click();

        Assert.assertTrue(isRecordPresent(name, age, country), "Record was not added successfully: " + name);
        return this; 
    }

    private boolean isRecordPresent(String name, String age, String country) {
        List<WebElement> rows = driver.findElements(By.cssSelector("tr"));
        for (WebElement row : rows) {
            if (row.getText().contains(name) && row.getText().contains(age) && row.getText().contains(country)) {
                return true;
            }
        }
        return false;
    }

    public FluentWebTablePage deleteRecord(String name) {
        List<WebElement> rows = driver.findElements(By.cssSelector("tr")); 
        for (WebElement row : rows) {
            if (row.getText().contains(name)) {
                WebElement deleteButton = row.findElement(By.cssSelector("button.delete"));
                deleteButton.click();
                break;
            }
        }
        Assert.assertFalse(isRecordPresent(name, "", ""), "Record was not deleted successfully: " + name);
        return this;
    }
}
