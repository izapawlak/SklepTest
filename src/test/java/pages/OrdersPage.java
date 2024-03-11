package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;




public class OrdersPage extends BasePage {

    /**
     * Constructor for the OrdersPage class.
     *
     * @param driver
     */
    public OrdersPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "//div[@class = 'woocommerce-MyAccount-content']/div")
    public WebElement noOrders;



    /**
     *  Verifies the absence of any orders on the current page.
     */
    public void areAnyOrders() {
        String actualOrdersText = noOrders.getText();
        assertTrue(actualOrdersText.contains("No order has been made yet"));
    }
}

