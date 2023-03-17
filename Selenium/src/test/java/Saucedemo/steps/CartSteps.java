package Saucedemo.steps;

import Saucedemo.pages.CartPage;
import Saucedemo.pages.DashboardPage;
import Saucedemo.pages.LoginPage;
import org.junit.*;
import org.openqa.selenium.By;

public class CartSteps extends BaseSteps{
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    CartPage cartPage = new CartPage();

    @Before
    public void logar(){
        loginPage.loginValido();
    }

    @Test
    public void testPurchase(){
        dashboardPage.clicarAddBtnBackpack();
        dashboardPage.clicarCartBtn();
        cartPage.clicaCheckoutBtn();
        cartPage.digitarCampoFirtName("Gustavo");
        cartPage.digitarCampoLastName("Assis");
        cartPage.digitarCampoPostalCode("123456322");
        cartPage.clicarContinueBtn();
        cartPage.clicarFinishBtn();

        String thxMessage = driver.findElement(By.cssSelector("#checkout_complete_container > h2"))
                .getText();
        Assert.assertEquals("Thank you for your order!", thxMessage);
    }

    @Test
    public void testCancelPurchaseFirstStep(){
        dashboardPage.clicarAddBtnBackpack();
        dashboardPage.clicarCartBtn();
        cartPage.clicaCheckoutBtn();
        cartPage.clicarCancelBtn();

        String yourCart = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"))
                .getText();
        Assert.assertEquals("Your Cart", yourCart);
    }

    @Test
    public void testCancelPurchaseSecondStep(){
        dashboardPage.clicarAddBtnBackpack();
        dashboardPage.clicarCartBtn();
        cartPage.clicaCheckoutBtn();
        cartPage.digitarCampoFirtName("Gustavo");
        cartPage.digitarCampoLastName("Assis");
        cartPage.digitarCampoPostalCode("123456322");
        cartPage.clicarContinueBtn();
        cartPage.clicarCancelBtn();

        String productsTitle = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"))
                .getText();
        Assert.assertEquals("Products", productsTitle);
    }

    @Test
    public void testPurchaseFail(){
        dashboardPage.clicarCartBtn();
        cartPage.clicaCheckoutBtn();

        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/cart.html", url);
    }
}
