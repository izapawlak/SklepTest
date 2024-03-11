package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;


public class AccountPage extends BasePage {

    /**
     * Constructor for the AccountPage class.
     *
     * @param driver
     */
    public AccountPage(WebDriver driver) {
        super(driver);
    }



//REJESTRACJA
    @FindBy(id = "reg_email")
    private WebElement regEmail;

    @FindBy(id = "reg_password")
    private WebElement regPassword;

    @FindBy(name = "register")
    private WebElement regBtn;

    @FindBy(xpath = "//h1[contains(text(), 'My account')]")
    private WebElement myAccountText;

//LOGOWANIE
    @FindBy(id = "username")
    private WebElement logUsername;

    @FindBy(id = "password")
    private WebElement logPassword;

    @FindBy(name = "login")
    private WebElement logBtn;

//WYLOGOWANIE
    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    private WebElement logOutBtn;

    @FindBy(xpath = "//a[contains(text(), 'Confirm')]")
    private WebElement confirmLogOut;

//ORDERS TAB
    @FindBy(xpath = "//a[contains(text(), 'Orders')]")
    public WebElement ordersTab;




    /**
     * Verifies that the current page is the user account page.
     *
     * @return AccountPage
     */
    public AccountPage shouldBeOnAccountPage() {
        String actualAccountUrl = driver.getCurrentUrl();
        assertEquals("https://skleptest.pl/my-account/", actualAccountUrl);
        return this;
    }


//REJESTRACJA
    /**
     * Fills the registration email field with the provided email address.
     *
     * @param registrationEmail
     * @return this AccountPage
     */
    public AccountPage typeRegistrationEmail(final String registrationEmail) { //nad tym się pochylić :D
        regEmail.sendKeys(registrationEmail);
        return this;
    }


    /**
     * Fills the registration password field with the provided password.
     *
     * @param registrationPassword
     * @return AccountPage
     */
    public AccountPage typeRegistrationPassword(final String registrationPassword) {
        regPassword.sendKeys(registrationPassword);
        return this;
    }


    /**
     * Clicks the registration button on the page.
     *
     * @return AccountPage
     */
    public AccountPage clickRegisterBtn() {
        regBtn.click();
        return this;
    }


    /**
     * Verifies if the displayed account text on the page matches the expected value "my account".
     */
    public void isAccountTextCorrect() {
        String actualAccountText = myAccountText.getText();
        assertEquals("my account", actualAccountText.toLowerCase());
    }


//LOGOWANIE
    /**
     * Fills the login username field with the provided username.
     *
     * @param loginUsername
     * @return AccountPage
     */
    public AccountPage typeLoginUsername(final String loginUsername) {
        logUsername.sendKeys(loginUsername);
        return this;
    }


    /**
     * Fills the login password field with the provided password.
     *
     * @param loginPassword
     * @return AccountPage
     */
    public AccountPage typeLoginPassword(final String loginPassword) {
        logPassword.sendKeys(loginPassword);
        return this;
    }


    /**
     * Clicks the login button on the page.
     *
     * @return AccountPage
     */
    public AccountPage clickLoginBtn() {
        logBtn.click();
        return this;
    }


//LOG OUT
    /**
     * Logs out of the current account page and returns to the main page.
     *
     * @return MainPage
     */
    public MainPage logOut() {
        logOutBtn.click();
        confirmLogOut.click();
        return new MainPage(driver);
    }


//ORDERS TAB
    /**
     * Opens the Orders tab.
     *
     * @return OrdersPage
     */
    public OrdersPage openOrdersTab() {
        ordersTab.click();
        return new OrdersPage(driver);
    }
}








