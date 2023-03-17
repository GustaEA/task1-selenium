package Saucedemo.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    private static final By campoUsername = By.cssSelector("[id=user-name]");
    private static final By campoPassword = By.cssSelector("[id=password]");
    private static final By btnLogin = By.cssSelector("[id=login-button]");

    public void digitarCampoUsername(String str){
        sendKeys(campoUsername, str);
    }

    public void digitarCampoSenha(String str){
        sendKeys(campoPassword, str);
    }

    public void clicarBtnLogin(){
        click(btnLogin);
    }

    public void loginValido(){
        sendKeys(campoUsername, "standard_user");
        sendKeys(campoPassword, "secret_sauce");
        click(btnLogin);
    }
}
