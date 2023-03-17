package Saucedemo.steps;

import Saucedemo.pages.BasePage;
import Saucedemo.pages.LoginPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginSteps extends BaseSteps {

    LoginPage loginPage = new LoginPage();

    @Test
    public void testLoginComSucesso(){
        login("standard_user", "secret_sauce");

        String validarTitulo = BasePage.getText(By.cssSelector(".app_logo"));
        Assert.assertEquals("Swag Labs", validarTitulo);
    }

    @Test
    public void testLoginSemSucessoUserInvalido(){
        login("user", "secret_sauce");

        String errorMsg = BasePage.getText(By.cssSelector("#login_button_container > div > form > div.error-message-container.error"));
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", errorMsg);
    }

    @Test
    public void testLoginSemSucessoUserComCaseTrocado(){
        login("Standard_User", "secret_sauce");

        String errorMsg = BasePage.getText(By.cssSelector("#login_button_container > div > form > div.error-message-container.error"));
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", errorMsg);
    }

    public void login(String username, String password){
        loginPage.digitarCampoUsername(username);
        loginPage.digitarCampoSenha(password);
        loginPage.clicarBtnLogin();
    }
}
