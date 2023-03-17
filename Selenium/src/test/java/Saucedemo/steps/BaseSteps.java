package Saucedemo.steps;

import Saucedemo.utils.Browser;
import org.junit.*;

import java.util.concurrent.TimeUnit;


public class BaseSteps extends Browser {

    @Before
    public void abrirNavegador(){
        abrirNavegadorB("https://www.saucedemo.com");
    }


    public void fecharNavegador(){
        driver.manage().timeouts().implicitlyWait(50000, TimeUnit.MILLISECONDS);
        fecharNavegadorB();
    }
}
