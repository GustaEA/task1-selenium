package Saucedemo.steps;

import Saucedemo.pages.BasePage;
import Saucedemo.pages.DashboardPage;
import Saucedemo.pages.LoginPage;
import org.junit.*;
import org.openqa.selenium.By;

public class DashboardSteps extends BaseSteps {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Before
    public void logar(){
        loginPage.loginValido();
    }

    @Test
    public void testGoToBackpackPage(){
        dashboardPage.clicarLinkBackpack();

        String validarTitulo = BasePage.getText(
                By.cssSelector("#inventory_item_container > div > div > div.inventory_details_desc_container > div.inventory_details_name.large_size"));
        Assert.assertEquals("Sauce Labs Backpack", validarTitulo);
    }

    @Test
    public void testGoToBikeLightPage(){
        dashboardPage.clicarLinkBikeLight();

        String validarTitulo = BasePage.getText(
                By.cssSelector("#inventory_item_container > div > div > div.inventory_details_desc_container > div.inventory_details_name.large_size"));
        Assert.assertEquals("Sauce Labs Bike Light", validarTitulo);
    }

    @Test
    public void testGoToBoltShirtPage(){
        dashboardPage.clicarLinkBoltShirt();

        String validarTitulo = BasePage.getText(
                By.cssSelector("#inventory_item_container > div > div > div.inventory_details_desc_container > div.inventory_details_name.large_size"));
        Assert.assertEquals("Sauce Labs Bolt T-Shirt", validarTitulo);
    }

    @Test
    public void testGoToFleeceJacketPage(){
        dashboardPage.clicarLinkFleeceJacket();

        String validarTitulo = BasePage.getText(
                By.cssSelector("#inventory_item_container > div > div > div.inventory_details_desc_container > div.inventory_details_name.large_size"));
        Assert.assertEquals("Sauce Labs Fleece Jacket", validarTitulo);
    }

    @Test
    public void testGoToOnesiePage(){
        dashboardPage.clicarLinkOnesie();

        String validarTitulo = BasePage.getText(
                By.cssSelector("#inventory_item_container > div > div > div.inventory_details_desc_container > div.inventory_details_name.large_size"));
        Assert.assertEquals("Sauce Labs Onesie", validarTitulo);
    }

    @Test
    public void testGoToRedShirtPage(){
        dashboardPage.clicarLinkRedShirt();

        String validarTitulo = BasePage.getText(
                By.cssSelector("#inventory_item_container > div > div > div.inventory_details_desc_container > div.inventory_details_name.large_size"));
        Assert.assertEquals("Test.allTheThings() T-Shirt (Red)", validarTitulo);
    }

    @Test
    public void testAddItemAndGoToCart(){
        String nameItem = BasePage.getText(By.cssSelector("#item_4_title_link > div"));
        dashboardPage.clicarAddBtnBackpack();
        dashboardPage.clicarCartBtn();
        String yourCartTitle = BasePage.getText(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String itemInCart = BasePage.getText(By.cssSelector("#item_4_title_link > div"));
        Assert.assertEquals("Your Cart", yourCartTitle);
        Assert.assertEquals(nameItem, itemInCart);
    }

    @Test
    public void testOrganizarPeloMenorPreco(){
        dashboardPage.clicarOrdenarMenorPreco();

        String preco = BasePage.getText(By.cssSelector("#inventory_container > div > div:nth-child(1) > div.inventory_item_description > div.pricebar > div"));
        Assert.assertEquals("$7.99", preco);
    }

    @Test
    public void testOrganizaPeloMaiorPreco(){
        dashboardPage.clicarOrdenarMaiorPreco();

        String preco = BasePage.getText(By.cssSelector("#inventory_container > div > div:nth-child(1) > div.inventory_item_description > div.pricebar > div"));
        Assert.assertEquals("$49.99", preco);
    }

    @Test
    public void testOrganizaOrdemAlfabeticaAZ(){
        dashboardPage.clicarOrdenarAlfabetAZ();

        String nameItem = BasePage.getText(By.cssSelector("#inventory_container > div > div:nth-child(1) > div.inventory_item_description > div.inventory_item_label > a > div"));
        Assert.assertEquals("Sauce Labs Backpack", nameItem);
    }

    @Test
    public void testOrganizaOrdemAlfabeticaZA(){
        dashboardPage.clicarOrdenarAlfabetZA();

        String nameItem = BasePage.getText(By.cssSelector("#inventory_container > div > div:nth-child(1) > div.inventory_item_description > div.inventory_item_label > a > div"));
        Assert.assertEquals("Test.allTheThings() T-Shirt (Red)", nameItem);
    }

    @Test
    public void testLogout(){
        dashboardPage.clicarBurgerBtn();
        dashboardPage.clicarLogoutBtn();

        Assert.assertNotNull(driver.findElement(By.cssSelector("#login-button")));
    }
}
