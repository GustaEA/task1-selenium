package Saucedemo.pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage{
    private static final By checkoutBtn = By.cssSelector("#checkout");
    private static final By continueShoppingBtn = By.cssSelector("#continue-shopping");
    private static final By campoFirstName = By.cssSelector("#first-name");
    private static final By campoLastName = By.cssSelector("#last-name");
    private static final By campoPostalCode = By.cssSelector("#postal-code");
    private static final By continueBtn = By.cssSelector("#continue");
    private static final By finishBtn = By.cssSelector("#finish");
    private static final By cancelBtn = By.cssSelector("#cancel");

    public void clicaCheckoutBtn(){
        click(checkoutBtn);
    }

    public void clicaContinueShopping(){
        click(continueShoppingBtn);
    }

    public void digitarCampoFirtName(String str){
        sendKeys(campoFirstName, str);
    }

    public void digitarCampoLastName(String str){
        sendKeys(campoLastName, str);
    }

    public void digitarCampoPostalCode(String str){
        sendKeys(campoPostalCode, str);
    }

    public void clicarContinueBtn(){
        click(continueBtn);
    }

    public void clicarFinishBtn(){
        click(finishBtn);
    }

    public void clicarCancelBtn(){
        click(cancelBtn);
    }
}
