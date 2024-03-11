package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;

public class MainPage extends BasePage {


    /**
     * Constructor for the MainPage class.
     *
     * @param driver
     */
    public MainPage(final WebDriver driver) {
        super(driver);
    }



    @FindBy(className = "top-account")
    private WebElement topAccount;



    /**
     *  * Verifies if the current page URL matches the expected URL ("https://skleptest.pl/").
     */
    public void isUrlCorrect() {
        driver.getCurrentUrl();
        assertEquals("https://skleptest.pl/", driver.getCurrentUrl());
    }


    /**
     * Opens the Account tab.
     *
     * @return AccountPage
     */
    public AccountPage openAccountTab() {
        topAccount.click();
        return new AccountPage(driver);
    }
}

//metody statyczne nie mogą korzystać z pól niestatycznych
//ctrl + alt + o -> wywala niepotrzebne importy

