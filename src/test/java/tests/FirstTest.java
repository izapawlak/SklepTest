package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.MainPage;
import pages.OrdersPage;
import utils.SetupTests;

public class FirstTest extends SetupTests {

    private MainPage mainPage;
    private AccountPage accountPage;
    private OrdersPage ordersPage;
    private String testRegEmail = "random@random.com";
    private String testRegPassword = "random";
    private String testLogUsername = "random@random.com";
    private String testLogPassword = "random";

    @BeforeTest
    public void setup() {
        mainPage = openMainPage();
    }

    @Test
    public void shouldGoToAccountPage() {
        mainPage.openAccountTab()
                .shouldBeOnAccountPage();
    }

    @Test
    public void registration() {
        mainPage.openAccountTab()
                .shouldBeOnAccountPage()
                .typeRegistrationEmail(testRegEmail) //ctrl+q
                .typeRegistrationPassword(testRegPassword)
                .clickRegisterBtn()
                .isAccountTextCorrect();
    }

    @Test
    public void login(){
        mainPage.openAccountTab()
                .shouldBeOnAccountPage()
                .typeLoginUsername(testLogUsername)
                .typeLoginPassword(testLogPassword)
                .shouldBeOnAccountPage();
    }

    @Test
    public void noOrdersCheck() {
        mainPage.openAccountTab()
                .typeLoginUsername(testLogUsername)
                .typeLoginPassword(testLogPassword)
                .clickLoginBtn()
                .shouldBeOnAccountPage()
                .openOrdersTab()
                .areAnyOrders();
    }

    @Test
    public void logOut(){
        mainPage.openAccountTab()
                .typeLoginUsername(testLogUsername)
                .typeLoginPassword(testLogPassword)
                .clickLoginBtn()
                .logOut()
                .isUrlCorrect();
    }
}


