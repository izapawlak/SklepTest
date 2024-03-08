package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;




public class OrdersPage extends BasePage {

    public OrdersPage(WebDriver driver) {
        super(driver);
    }

    //asercja
    @FindBy(xpath = "//div[@class = 'woocommerce-MyAccount-content']/div")
    public WebElement noOrders;

    public void areAnyOrders() {
        String actualOrdersText = noOrders.getText();
        assertTrue(actualOrdersText.contains("No order has been made yet"));
    }
}


   /* public static void openOrdersTab(){
        //Przejście do zakładki orders
        WebElement ordersTab = driver.findElement(By.xpath("//a[contains(text(), 'Orders')]"));
        JavascriptExecutor executor3 = (JavascriptExecutor) driver;
        executor3.executeScript("arguments[0].click()", ordersTab);

        //Sprawdzenie braku zamówień
        WebElement noOrders = driver.findElement(By.xpath("//div[@class = 'woocommerce-MyAccount-content']/div"));
        String actualOrdersText = noOrders.getText();
        //System.out.println(actualOrdersText);
        assertTrue(actualOrdersText.contains("No order has been made yet"));
    }
*/
