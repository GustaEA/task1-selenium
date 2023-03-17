package Saucedemo.pages;

import Saucedemo.utils.Elements;
import org.openqa.selenium.By;

public class BasePage extends Elements{
    // Clicar
    public static void click(By by){
        waitElement(by);
        element(by).click();
    }

    //Escrever
    public static void sendKeys(By by, String texto){
        waitElement(by);
        element(by).sendKeys(texto);
    }

    //ler Texto
    public static String getText(By by){
        waitElement(by);
        return element(by).getText();
    }
}
