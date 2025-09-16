package TestPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;

public class WebTableOperationsTest extends TestBase {

    @Test
    void Task4() throws InterruptedException, IOException {
//        Go to https://claruswaysda.github.io/addRecordWebTable.html
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

//        Add 3 records
        addRecord("Alice", "30", "USA");
        addRecord("Bob", "25", "UK");
        addRecord("Charlie", "35", "Canada");
        Thread.sleep(2000);

//        Edit the 5th record
        driver.findElement(By.xpath("//table/tbody/tr[5]/td[4]/button[contains(@class, 'edit-button')]")).click();
        addRecord("Charlie", "35", "Canada");
        Thread.sleep(2000);


//        Delete the 1st record
        driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]/button[contains(@class, 'delete-button')]")).click();
        Thread.sleep(2000);
    }
    private void addRecord(String name, String age, String country) {
        //clear if exist
        driver.findElement(By.id("nameInput")).clear();
        driver.findElement(By.id("ageInput")).clear();
        driver.findElement(By.xpath("//select[@id='countrySelect']//option[text()='" + country + "']")).click();
        //add new value
        driver.findElement(By.id("nameInput")).sendKeys(name);
        driver.findElement(By.id("ageInput")).sendKeys(age);
        driver.findElement(By.xpath("//select[@id='countrySelect']//option[text()='" + country + "']")).click();
       //submit
        driver.findElement(By.xpath("//button[text()='Add Record']")).click();
    }
    
}
