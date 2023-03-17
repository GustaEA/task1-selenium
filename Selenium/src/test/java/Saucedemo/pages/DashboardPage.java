package Saucedemo.pages;

import org.openqa.selenium.By;

public class DashboardPage extends BasePage{
    private static final By itemBackpackLinkBtn = By.cssSelector("#item_4_title_link");
    private static final By addCartBtnBackpack = By.cssSelector("#add-to-cart-sauce-labs-backpack");
    private static final By itemBikeLigthLinkBtn = By.cssSelector("#item_0_title_link");
    private static final By addCartBtnBikeLight = By.cssSelector("#add-to-cart-sauce-labs-bike-light");
    private static final By itemBoltShirtLinkBtn = By.cssSelector("#item_1_title_link");
    private static final By addCartBtnBoltShirt = By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt");
    private static final By itemFleeceJacketLinkBtn = By.cssSelector("#item_5_title_link");
    private static final By addCartBtnFleeceJacket = By.cssSelector("#add-to-cart-sauce-labs-fleece-jacket");
    private static final By itemOnesieLinkBtn = By.cssSelector("#item_2_title_link");
    private static final By addCartBtnOnesie = By.cssSelector("#add-to-cart-sauce-labs-onesie");
    private static final By itemRedShirtLinkBtn = By.cssSelector("#item_3_title_link");
    private static final By addCartBtnRedShirt = By.cssSelector("#add-to-cart-test\\.allthethings\\(\\)-t-shirt-\\(red\\)");
    private static final By cartBtn = By.cssSelector("#shopping_cart_container > a");
    private static final By hamburgerBtn = By.cssSelector("#react-burger-menu-btn");
    private static final By logoutBtn = By.cssSelector("#logout_sidebar_link");
    private static final By orderMinPrecBtn = By.cssSelector("#header_container > div.header_secondary_container > div > span > select > option:nth-child(3)");
    private static final By orderMaxPrecBtn = By.cssSelector("#header_container > div.header_secondary_container > div > span > select > option:nth-child(4)");
    private static final By orderAlfabetAZ = By.cssSelector("#header_container > div.header_secondary_container > div > span > select > option:nth-child(1)");
    private static final By getOrderAlfabetZA = By.cssSelector("#header_container > div.header_secondary_container > div > span > select > option:nth-child(2)");

    public void clicarLinkBackpack(){
        click(itemBackpackLinkBtn);
    }

    public void clicarAddBtnBackpack(){
        click(addCartBtnBackpack);
    }

    public void clicarLinkBikeLight(){
        click(itemBikeLigthLinkBtn);
    }
    public void clicarAddBtnBikeLight(){
        click(addCartBtnBikeLight);
    }

    public void clicarLinkBoltShirt(){
        click(itemBoltShirtLinkBtn);
    }

    public void clicarAddBtnBoltShirt(){
        click(addCartBtnBoltShirt);
    }

    public void clicarLinkFleeceJacket(){
        click(itemFleeceJacketLinkBtn);
    }

    public void clicarAddBtnFleeceJacket(){
        click(addCartBtnFleeceJacket);
    }

    public void clicarLinkOnesie(){
        click(itemOnesieLinkBtn);
    }

    public void clicarAddBtnOnesie(){
        click(addCartBtnOnesie);
    }

    public void clicarLinkRedShirt(){
        click(itemRedShirtLinkBtn);
    }

    public void clicarAddBtnRedShirt(){
        click(addCartBtnRedShirt);
    }

    public void clicarCartBtn(){
        click(cartBtn);
    }

    public void clicarBurgerBtn(){
        click(hamburgerBtn);
    }

    public void clicarLogoutBtn(){
        click(logoutBtn);
    }

    public void clicarOrdenarMenorPreco(){
        click(orderMinPrecBtn);
    }

    public void clicarOrdenarMaiorPreco(){
        click(orderMaxPrecBtn);
    }

    public void clicarOrdenarAlfabetAZ(){
        click(orderAlfabetAZ);
    }

    public void clicarOrdenarAlfabetZA(){
        click(getOrderAlfabetZA);
    }
}
