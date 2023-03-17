package Saucedemo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CartTest {

    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void testAbrirNavegador(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 40);

        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
        login("standard_user", "secret_sauce");
    }

    public void goToCart(){
        driver.findElement(By.cssSelector("#shopping_cart_container > a")).click();
    }

    public void addToCart(){
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
    }

    @Test
    public void testPurchase(){
        addToCart();
        goToCart();
        driver.findElement(By.cssSelector("#checkout")).click();
        driver.findElement(By.cssSelector("#first-name")).sendKeys("Gustavo");
        driver.findElement(By.cssSelector("#last-name")).sendKeys("Assis");
        driver.findElement(By.cssSelector("#postal-code")).sendKeys("123456322");
        driver.findElement(By.cssSelector("#continue")).click();
        driver.findElement(By.cssSelector("#finish")).click();

        String thxMessage = driver.findElement(By.cssSelector("#checkout_complete_container > h2"))
                .getText();
        Assert.assertEquals("Thank you for your order!", thxMessage);
    }

    @Test
    public void testPurchaseFail(){
        goToCart();
        driver.findElement(By.cssSelector("#checkout")).click();

        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/cart.html", url);
    }

    @Test
    public void testCancelPurchaseFirstStep(){
        addToCart();
        goToCart();
        driver.findElement(By.cssSelector("#checkout")).click();
        driver.findElement(By.cssSelector("#cancel")).click();

        String yourCart = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"))
                .getText();
        Assert.assertEquals("Your Cart", yourCart);
    }

    @Test
    public void testCancelPurchaseSecondStep(){
        addToCart();
        goToCart();
        driver.findElement(By.cssSelector("#checkout")).click();
        driver.findElement(By.cssSelector("#first-name")).sendKeys("Gustavo");
        driver.findElement(By.cssSelector("#last-name")).sendKeys("Assis");
        driver.findElement(By.cssSelector("#postal-code")).sendKeys("123456322");
        driver.findElement(By.cssSelector("#continue")).click();
        driver.findElement(By.cssSelector("#cancel")).click();

        String productsTitle = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"))
                .getText();
        Assert.assertEquals("Products", productsTitle);
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
