package TestPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;
import org.openqa.selenium.By;
import java.util.Arrays;
import java.util.List;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;

public class YoungestRecordFinder extends TestBase {
    @Test
    void Task4() {
        //Go to https://claruswaysda.github.io/addRecordWebTable.html
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

        //Add 10 records using Faker
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            driver.findElement(By.id("nameInput")).sendKeys(faker.name().fullName());
            driver.findElement(By.id("ageInput")).sendKeys(faker.number().numberBetween(18, 65) + "");
            new Select(driver.findElement(By.id("countrySelect"))).selectByIndex(faker.number().numberBetween(1, 5));
            driver.findElement(By.xpath("//button[@onclick='addRecord()']")).click();
        }

        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
        String[] names = new String[rows.size()];
        String[] ages = new String[rows.size()];
        String[] countries = new String[rows.size()];
        for (int i = 0; i < rows.size(); i++) {
            names[i] = rows.get(i).findElement(By.xpath(".//td[1]")).getText();
            ages[i] = rows.get(i).findElement(By.xpath(".//td[2]")).getText();
            countries[i] = rows.get(i).findElement(By.xpath(".//td[3]")).getText();
        }

        System.out.println("names = " + Arrays.toString(names));
        System.out.println("ages = " + Arrays.toString(ages));
        System.out.println("countries = " + Arrays.toString(countries));


        //Find the name of the youngest record
        int youngestIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (Integer.parseInt(ages[i]) < Integer.parseInt(ages[youngestIndex])) {
                youngestIndex = i;
            }
        }
        System.out.println("The youngest record is: " + names[youngestIndex] + " with age " + ages[youngestIndex]);
    }
}
