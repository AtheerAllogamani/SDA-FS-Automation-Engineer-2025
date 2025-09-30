package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

@Test
public class FluentActionsFormPage {
    private WebDriver driver;
    private Actions actions;

    
//        Go to https://claruswaysda.github.io/ActionsForm.html
        Driver.getDriver().get("https://claruswaysda.github.io/ActionsForm.html");

//        Fill form and submit
        formPage
                .enterName("John")
                .enterAge("30")
                .selectDepartment("IT Department")
                .clickCoding()
                .clickMale()
                .clickGenerate()
                .copyAlertText()
                .sendCodeToAlert();

//        Do all actions and assert
    public FluentActionsFormPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public FluentActionsFormPage fillForm(String name, String age, String department) {
        WebElement nameField = driver.findElement(By.id("name"));
        WebElement ageField = driver.findElement(By.id("age"));
        WebElement departmentDropdown = driver.findElement(By.id("options")); 

        nameField.sendKeys(name); 
        ageField.sendKeys(age);
        departmentDropdown.click(); 

        return this; 
    }


    public FluentActionsFormPage performDragAndDrop(WebElement source, WebElement target) {
        actions.dragAndDrop(source, target).perform(); 
        Assert.assertTrue(isElementInTarget(target, source), "Drag and drop action failed.");
        return this;
    }


    public FluentActionsFormPage performDoubleClick(WebElement element) {
        actions.doubleClick(element).perform()
        Assert.assertTrue(isDoubleClickSuccessful(element), "Double click action failed."); 
        return this;
    }


    public FluentActionsFormPage performRightClick(WebElement element) {
        actions.contextClick(element).perform(); 
        Assert.assertTrue(isRightClickMenuDisplayed(), "Right click action failed."); /
        return this;
    }


    public FluentActionsFormPage submitForm() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='button']"));
        submitButton.click(); 
        Assert.assertTrue(isSubmissionSuccessful(), "Form submission was not successful."); 
        return this;
    }
}
