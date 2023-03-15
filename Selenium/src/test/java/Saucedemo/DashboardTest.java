package Saucedemo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DashboardTest {
    public WebDriver driver;
    public WebDriverWait wait;



    @Before
    public void testAbrirNavegador(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 40);

        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
        login("standard_user", "secret_sauce");
    }

    @Test
    public void testAddItemToCart(){
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();

        String validarCarrinho = driver.findElement(By.cssSelector("#shopping_cart_container > a > span"))
                .getText();
        WebElement span = driver.findElement(By.cssSelector("#shopping_cart_container > a > span"));

        Assert.assertNotNull(span);
        Assert.assertEquals("1", validarCarrinho);
    }

    @Test
    public void testOrganizaMenorPreco(){
        driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > div > span > select > option:nth-child(3)"))
                .click();

        String preco = driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(1) > div.inventory_item_description > div.pricebar > div"))
                .getText();
        Assert.assertEquals("$7.99", preco);
    }

    @Test
    public void testOrganizaMaiorPreco(){
        driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > div > span > select > option:nth-child(4)"))
                .click();

        String preco = driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(1) > div.inventory_item_description > div.pricebar > div"))
                .getText();
        Assert.assertEquals("$49.99", preco);
    }

    @Test
    public void testOrganizaOrdemAlfabeticaAZ(){
        driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > div > span > select > option:nth-child(1)"))
                .click();

        String nameItem = driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(1) > div.inventory_item_description > div.inventory_item_label > a > div"))
                .getText();
        Assert.assertEquals("Sauce Labs Backpack", nameItem);

    }

    @Test
    public void testOrganizaOrdemAlfabeticaZA(){
        driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > div > span > select > option:nth-child(2)"))
                .click();

        String nameItem = driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(1) > div.inventory_item_description > div.inventory_item_label > a > div"))
                .getText();
        Assert.assertEquals("Test.allTheThings() T-Shirt (Red)", nameItem);
    }

    @Test
    public void testLogout(){
        driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
        driver.findElement(By.cssSelector("#logout_sidebar_link")).click();

        Assert.assertNotNull(driver.findElement(By.cssSelector("#login-button")));
    }

    @Test
    public void testAbout(){
        driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
        driver.findElement(By.cssSelector("#about_sidebar_link")).click();

        String url = driver.getCurrentUrl();

        Assert.assertEquals("https://saucelabs.com/", url);
    }

    @Test
    public void testGoToCart(){
        driver.findElement(By.cssSelector("#shopping_cart_container > a")).click();

        String yourCart = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"))
                .getText();
        Assert.assertEquals("Your Cart", yourCart);
    }

    @Test
    public void testAddToCartAndGoToCart(){
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.cssSelector("#shopping_cart_container > a")).click();

        String yourCart = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"))
                .getText();
        Assert.assertEquals("Your Cart", yourCart);

        String nameItem = driver.findElement(By.cssSelector("#item_4_title_link > div"))
                .getText();
        Assert.assertEquals("Sauce Labs Backpack", nameItem);
    }

    @Test
    public void testGoToBackpackPage(){
        String itemName = driver.findElement(By.cssSelector("#item_4_title_link > div")).getText();
        driver.findElement(By.cssSelector("#item_4_title_link")).click();

        String title = driver.findElement(By.cssSelector("#inventory_item_container > div > div > div.inventory_details_desc_container > div.inventory_details_name.large_size"))
                .getText();
        Assert.assertEquals(itemName, title);
    }

    @Test
    public void testGoToBikeLightPage(){
        String itemName = driver.findElement(By.cssSelector("#item_0_title_link > div")).getText();
        driver.findElement(By.cssSelector("#item_0_title_link")).click();

        String title = driver.findElement(By.cssSelector("#inventory_item_container > div > div > div.inventory_details_desc_container > div.inventory_details_name.large_size"))
                .getText();
        Assert.assertEquals(itemName, title);
    }

    @Test
    public void testGoToBoltShirtPage(){
        String itemName = driver.findElement(By.cssSelector("#item_1_title_link > div")).getText();
        driver.findElement(By.cssSelector("#item_1_title_link")).click();

        String title = driver.findElement(By.cssSelector("#inventory_item_container > div > div > div.inventory_details_desc_container > div.inventory_details_name.large_size"))
                .getText();
        Assert.assertEquals(itemName, title);
    }

    @Test
    public void testGoToFleeceJacketPage(){
        String itemName = driver.findElement(By.cssSelector("#item_5_title_link > div")).getText();
        driver.findElement(By.cssSelector("#item_5_title_link")).click();

        String title = driver.findElement(By.cssSelector("#inventory_item_container > div > div > div.inventory_details_desc_container > div.inventory_details_name.large_size"))
                .getText();
        Assert.assertEquals(itemName, title);
    }

    @Test
    public void testGoToOnesiePage(){
        String itemName = driver.findElement(By.cssSelector("#item_2_title_link > div")).getText();
        driver.findElement(By.cssSelector("#item_2_title_link")).click();

        String title = driver.findElement(By.cssSelector("#inventory_item_container > div > div > div.inventory_details_desc_container > div.inventory_details_name.large_size"))
                .getText();
        Assert.assertEquals(itemName, title);
    }

    @Test
    public void testGoToRedShirtPage(){
        String itemName = driver.findElement(By.cssSelector("#item_3_title_link > div")).getText();
        driver.findElement(By.cssSelector("#item_3_title_link")).click();

        String title = driver.findElement(By.cssSelector("#inventory_item_container > div > div > div.inventory_details_desc_container > div.inventory_details_name.large_size"))
                .getText();
        Assert.assertEquals(itemName, title);
    }

    @Test
    public void testGoToTwitter(){
        driver.findElement(By.cssSelector("#page_wrapper > footer > ul > li.social_twitter > a"))
                .click();

        //String url = driver.getCurrentUrl();

        //Assert.assertEquals("https://twitter.com/saucelabs", url);
    }

    @Test
    public void testGoToFacebook(){
        driver.findElement(By.cssSelector("#page_wrapper > footer > ul > li.social_facebook > a"))
                .click();

        //String url = driver.getCurrentUrl();

        //Assert.assertEquals("https://www.facebook.com/saucelabs", url);
    }

    @Test
    public void testGoToLinkedin(){
        driver.findElement(By.cssSelector("#page_wrapper > footer > ul > li.social_linkedin > a"))
                .click();

        //String url = driver.getCurrentUrl();

        //Assert.assertEquals("https://www.linkedin.com/company/sauce-labs/?original_referer=", url);
    }

    public void login(String user, String password) {
        driver.findElement(By.cssSelector("#user-name"))
                .sendKeys(user);

        driver.findElement(By.cssSelector("#password"))
                .sendKeys(password);

        driver.findElement(By.cssSelector("#login-button"))
                .click();
    }
}
