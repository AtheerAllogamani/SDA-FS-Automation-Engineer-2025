public class ContactListPage {
    private RemoteWebDriver driver;

    public ContactListPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public ContactListPage navigateToSignUp() {
        driver.findElement(By.linkText("Click here to sign up!")).click();
        return this;
    }

    public ContactListPage createUserAccount(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        return this;
    }

    public ContactListPage addContact(String name, String email) {
        driver.findElement(By.id("add-contact")).click();
        driver.findElement(By.id("contact-name")).sendKeys(name);
        driver.findElement(By.id("contact-email")).sendKeys(email);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        return this;
    }

    public ContactListPage editContact(String oldName, String newName, String newEmail) {
        List<WebElement> contacts = driver.findElements(By.cssSelector(".contact-item"));
        for (WebElement contact : contacts) {
            if (contact.getText().contains(oldName)) {
                contact.findElement(By.cssSelector(".edit-button")).click();
                driver.findElement(By.id("contact-name")).clear();
                driver.findElement(By.id("contact-name")).sendKeys(newName);
                driver.findElement(By.id("contact-email")).clear();
                driver.findElement(By.id("contact-email")).sendKeys(newEmail);
                driver.findElement(By.cssSelector("input[type='submit']")).click();
                break;
            }
        }
        return this;
    }

    public ContactListPage deleteContact(String name) {
        List<WebElement> contacts = driver.findElements(By.cssSelector(".contact-item"));
        for (WebElement contact : contacts) {
            if (contact.getText().contains(name)) {
                contact.findElement(By.cssSelector(".delete-button")).click(); 
                break;
            }
        }
        return this;
    }

    public boolean isContactPresent(String name) {
        List<WebElement> contacts = driver.findElements(By.cssSelector(".contact-item"));
        for (WebElement contact : contacts) {
            if (contact.getText().contains(name)) {
                return true; 
            }
        }
        return false; 
    }
}
