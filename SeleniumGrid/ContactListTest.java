import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ContactListTest {
    private RemoteWebDriver driver;
    private ContactListPage contactListPage;

    @BeforeEach
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
        contactListPage = new ContactListPage(driver);
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
    }

    @Test
    public void testCreateUserAndManageContacts() {
        contactListPage.navigateToSignUp()
                       .createUserAccount("testuser", "password123")
                       .addContact("John Doe", "john@example.com");

        Assertions.assertTrue(contactListPage.isContactPresent("John Doe"));

        contactListPage.editContact("John Doe", "John Smith", "johnsmith@example.com");
        Assertions.assertTrue(contactListPage.isContactPresent("John Smith"));

        contactListPage.deleteContact("John Smith");
        Assertions.assertFalse(contactListPage.isContactPresent("John Smith"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
