package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.MainPage;
import pages.OrdersPage;
import utils.SetupTests;

import static pages.AccountPage.*;
import static pages.MainPage.*;

public class FirstTest extends SetupTests {

    private MainPage mainPage;
    private AccountPage accountPage;
    private OrdersPage ordersPage;
    private String testEmail = "random@random.com";

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
                .typeRegistrationEmail(testEmail) //ctrl+q oraz stosować java doki
                .typeRegistrationPassword()
                .clickRegisterBtn()
                .isAccountTextCorrect();
    }

    @Test //nie zadziała, bo nie będę zalogowana :-)
    public void noOrdersCheck() {

        accountPage.typeLoginUsername();
        accountPage.typeLoginPassword();
        accountPage.clickLoginBtn();
        mainPage.openAccountTab()
                .shouldBeOnAccountPage();
        ordersPage.areAnyOrders();
    }

    @Test
    public void logOut(){
        accountPage.logOut();
        mainPage.isUrlCorrect();
    }
}



/*    @Test
    public void uberTest(){
        openMainPage();
        isUrlCorrect();
        openAccountTab();
        userRegistration();
        openOrdersTab();
        logOut();
        isUrlCorrect();
    }*/



