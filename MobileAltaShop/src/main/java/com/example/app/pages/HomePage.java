package com.example.app.pages;

import com.example.app.base.BasePageObject;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class HomePage extends BasePageObject {
    By textProduct(){ return MobileBy.AccessibilityId("Products");}
    By arrowLogin() {return By.xpath("//android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");}
    By cartZero() {return MobileBy.AccessibilityId("0");}
    By cartOne() {return MobileBy.AccessibilityId("1");}
    By arrowLogout() {return By.xpath("//android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");}
    By buyProduct() {return By.xpath("(//android.widget.Button[@content-desc=\"Beli\"])[1]");}
    By detailProduct() {return By.xpath("//android.widget.ScrollView/android.view.View[1]");}


    public void verifyHeaderProductDisplayed(){
        Assertions.assertTrue(find(textProduct()).isDisplayed());
    }
    public void verifyArrowLogoutDisplayed(){
        Assertions.assertTrue(find(arrowLogout()).isDisplayed());
    }
    public void verifyArrowLoginDisplayed(){
        Assertions.assertTrue(find(arrowLogin()).isDisplayed());
    }
    public void clickArrowLogin(){
    click(arrowLogin());
}
    public void clickArrowLogout(){
        click(arrowLogout());
    }
    public void clickDetailProduct(){
        click(detailProduct());
    }
    public void clickButtonBuy(){
        click(buyProduct());
    }
    public void clickButtonCart(){
        click(cartZero());
    }
    public void verifyCartZeroDisplayed(){
        Assertions.assertTrue(find(cartZero()).isDisplayed());
    }
    public void verifyCartOneDisplayed(){
        Assertions.assertTrue(find(cartOne()).isDisplayed());
    }
    public void verifyCartZeroEqual(){
        Assertions.assertEquals("", getText(cartZero()));
    }
    public void verifyCartOneEqual(){
        Assertions.assertEquals("", getText(cartOne()));
    }

}
