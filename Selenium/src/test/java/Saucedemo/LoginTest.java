package Saucedemo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginTest {
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
    }

    @Test
    public void testLogarComSucesso(){
        login("standard_user", "secret_sauce");

        String validarTitulo = driver.findElement(By.cssSelector(".app_logo")).getText();
        Assert.assertEquals("Swag Labs", validarTitulo);
    }

    @Test
    public void testLogarSemSucessoUserErrado(){
        login("user", "secret_sauce");
    }

    @Test
    public void testLogarEscrevendoLoginTrocandoCases(){
        login("Standard_User", "secret_sauce");
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
