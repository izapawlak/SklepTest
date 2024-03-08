package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;


public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver); //super - wywołuje konstruktor klasy nadrzędnej, driver - przekazuje obiekt driver do konstruktora klasy nadrzędnej, który może wtedy użyć obiektu do inicjalizacji swoich pól i przygotowania do dalszej pracy
    }

    public AccountPage shouldBeOnAccountPage() {
        String actualAccountUrl = driver.getCurrentUrl();
        assertEquals("https://skleptest.pl/my-account/", actualAccountUrl);
        return this;
    }

    //ODTĄD ROBIŁAM
    //REJESTRACJA
    //rejestracja mail
    @FindBy(id = "reg_email") // @FindBy mają żyć na górze
    private WebElement registrationEmail;

    /**
     * send keys to registration email field
     *
     * @param email
     * @return this AccountPage
     */
    public AccountPage typeRegistrationEmail(final String email) {
        registrationEmail.sendKeys(email);
        return this;
    }

    //rejestracja hasło
    @FindBy(id = "reg_password")
    private WebElement registrationPassword;

    public AccountPage typeRegistrationPassword() {
        registrationPassword.sendKeys("random");
        return this;
    }

    //kliknięcie przycisku register
    @FindBy(name = "register")
    private WebElement registerBtn;

    public AccountPage clickRegisterBtn() {
        registerBtn.click();
        return this;
    }

    //asercja
    @FindBy(xpath = "//h1[contains(text(), 'My account')]")
    private WebElement myAccountText;

    public void isAccountTextCorrect() {
        String actualAccountText = myAccountText.getText();
        assertEquals("my account", actualAccountText.toLowerCase()); //czy mogę to wrzucić w małe litery?
    }


    //LOGOWANIE
    //Logowanie username
    @FindBy(id = "username")
    private WebElement loginUsername;

    public void typeLoginUsername() {
        loginUsername.sendKeys("random@random.com");
    }

    //Logowanie password
    @FindBy(id = "password")
    private WebElement loginPassword;

    public void typeLoginPassword() {
        loginPassword.sendKeys("random");
    }

    //kliknięcie przycisku login
    @FindBy(id = "login")
    private WebElement loginBtn;

    public void clickLoginBtn() {
        loginBtn.click();
    }


    //LOG OUT
    //wylogowanie
    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    private WebElement logOutBtn;

    @FindBy(xpath = "//a[contains(text(), 'Confirm')]")
    private WebElement confirmLogOut;

    public MainPage logOut() {
        logOutBtn.click();
        confirmLogOut.click();
        return new MainPage(driver);
    }


    //ORDERS TAB
    //przejście na orders
    @FindBy(xpath = "//a[contains(text(), 'Orders')]")
    public WebElement ordersTab;

    public OrdersPage openOrdersTab() {
        ordersTab.click();
        return new OrdersPage(driver);
    }
}



/*
        ZROBIONE:
        //Przejście do zakładki Account i potwierdzenie
        public static void openAccountTab() {
        WebElement accountTab = driver.findElement(By.className("top-account"));
        accountTab.click();
        String actualAccountUrl = driver.getCurrentUrl();
        assertEquals("https://skleptest.pl/my-account/", actualAccountUrl);
        }

        public static void userRegistration() {
        //wpisanie wartości w polu email
        WebElement emailAddress = driver.findElement(By.id("reg_email"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value = 'random@random.com';", emailAddress);

        //wpisanie wartości w polu password
        WebElement password = driver.findElement(By.id("reg_password"));
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].value = 'random';", password);

        //kliknięcie przycisku register
        WebElement registerButton = driver.findElement(By.name("register"));
        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click()", registerButton);

        //asercja
        WebElement myAccountText = driver.findElement(By.xpath("//h1[contains(text(), 'My account')]"));
        String actualAccountText = myAccountText.getText();
        //System.out.println(actualAccountText);
        assertEquals("my account", actualAccountText.toLowerCase());
        }


        //Wylogowanie
        public static void logOut() {
        WebElement logOut = driver.findElement(By.xpath("//a[contains(text(), 'Logout')]"));
        JavascriptExecutor executor4 = (JavascriptExecutor) driver;
        executor4.executeScript("arguments[0].click()", logOut);

        WebElement confirmLogOut = driver.findElement(By.xpath("//a[contains(text(), 'Confirm')]"));
        JavascriptExecutor executor5 = (JavascriptExecutor) driver;
        executor4.executeScript("arguments[0].click()", confirmLogOut);

        NIEZROBIONE:
    }*/

