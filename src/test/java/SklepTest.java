import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SklepTest {
    static WebDriver driver = new ChromeDriver();

    //Metoda główna
    public static void main(String[] args) {
        openMainPage();
        isUrlCorrect();
        openAccountTab();
        userRegistration();
        openOrdersTab();
        logOut();
        isUrlCorrect();
        driver.quit();
    }

    //Otwieranie strony
    static void openMainPage() {
        driver.manage().window().maximize();
        driver.get("https://skleptest.pl/");
    }

    //Potwierdzenie wyświetlenia strony głównej
    static void isUrlCorrect(){
        String actualMainUrl = driver.getCurrentUrl();
        assertEquals("https://skleptest.pl/", actualMainUrl);
    }

    //Przejście do zakładki Account i test potwierdzający
    static void openAccountTab(){
        WebElement accountTab = driver.findElement(By.className("top-account"));
        accountTab.click();
        String actualAccountUrl = driver.getCurrentUrl();
        assertEquals("https://skleptest.pl/my-account/", actualAccountUrl);
    }


    //Rejestracja i test potwierdzający
    static void userRegistration(){
        //wpisanie wartości w polu email
        WebElement emailAddress = driver.findElement(By.id("reg_email"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value = 'random@random.com';", emailAddress);

        //wpisanie wartości w polu password
        WebElement password = driver.findElement(By.id("reg_password"));
        //JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value = 'random';", password);

        //kliknięcie przycisku register
        WebElement registerButton = driver.findElement(By.name("register"));
        //JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", registerButton);

        //asercja
        WebElement myAccountText = driver.findElement(By.xpath("//h1[contains(text(), 'My account')]"));
        String actualAccountText = myAccountText.getText();
        //System.out.println(actualAccountText);
        assertEquals("my account", actualAccountText.toLowerCase());
    }

    //Przejście na zakładkę zamówień
    static void openOrdersTab(){
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

    //Wylogowanie
    static void logOut(){
        WebElement logOut = driver.findElement(By.xpath("//a[contains(text(), 'Logout')]"));
        JavascriptExecutor executor4 = (JavascriptExecutor) driver;
        executor4.executeScript("arguments[0].click()", logOut);

        WebElement confirmLogOut = driver.findElement(By.xpath("//a[contains(text(), 'Confirm')]"));
        JavascriptExecutor executor5 = (JavascriptExecutor) driver;
        executor4.executeScript("arguments[0].click()", confirmLogOut);

    }

}
