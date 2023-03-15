import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class primeiroTest {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void abrirNavegador(){

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 40);

        //driver.get("https://www.saucedemo.com");
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);

    }


    public void fecharNavegador(){
        driver.quit();
    }

    @Test
    public void testLoginComSucesso(){

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id=user-name]")));
        driver.findElement(By.cssSelector("[id=user-name]")).sendKeys("standard_user");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id=password]")));
        driver.findElement(By.cssSelector("[id=password]")).sendKeys("secret_sauce");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id=login-button]")));
        driver.findElement(By.cssSelector("[id=login-button")).click();

        String validarTitulo = driver.findElement(By.cssSelector(".app_logo")).getText();

        Assert.assertEquals("Swag Labs", validarTitulo);
    }

    @Test
    public void testRegistrarComSucesso(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#basicBootstrapForm > div:nth-child(1) > div:nth-child(2) > input")));
        driver.findElement(By.cssSelector("#basicBootstrapForm > div:nth-child(1) > div:nth-child(2) > input"))
                .sendKeys("Gustavo");

        driver.findElement(By.cssSelector("#basicBootstrapForm > div:nth-child(1) > div:nth-child(3) > input"))
                .sendKeys("Assis");

        driver.findElement(By.cssSelector("#basicBootstrapForm > div:nth-child(2) > div > textarea"))
                .sendKeys("Rua Guido Alberto Werlang, 205, Rubem Berta - POA");

        driver.findElement(By.cssSelector("#eid > input"))
                .sendKeys("gustavo123escoto@gmail.com");

        driver.findElement(By.cssSelector("#basicBootstrapForm > div:nth-child(4) > div > input"))
                .sendKeys("51985369874");

        driver.findElement(By.cssSelector("#basicBootstrapForm > div:nth-child(5) > div > label:nth-child(1) > input"))
                .click();

        driver.findElement(By.cssSelector("#checkbox2"))
                .click();

        driver.findElement(By.cssSelector("#Skills > option:nth-child(6)"))
                .click();

        driver.findElement(By.cssSelector("#basicBootstrapForm > div:nth-child(10) > div > span > span.selection > span"))
                .click();

        driver.findElement(By.cssSelector("#select2-country-results > li:nth-child(7)"))
                .click();

        driver.findElement(By.cssSelector("#yearbox > option:nth-child(86)"))
                .click();

        driver.findElement(By.cssSelector("#basicBootstrapForm > div:nth-child(11) > div:nth-child(3) > select > option:nth-child(7)"))
                .click();

        driver.findElement(By.cssSelector("#daybox > option:nth-child(21)"))
                .click();

        driver.findElement(By.cssSelector("#firstpassword"))
                .sendKeys("123456789Ab");

        driver.findElement(By.cssSelector("#secondpassword"))
                .sendKeys("123456789Ab");

    }
}
