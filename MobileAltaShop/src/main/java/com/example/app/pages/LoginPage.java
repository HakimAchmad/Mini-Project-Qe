package com.example.app.pages;

import com.example.app.base.BasePageObject;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class LoginPage extends BasePageObject {
    By textLogin() {return By.xpath("//android.view.View[@content-desc=\"Login\"]");}
    By fieldEmail() {return By.xpath("//android.widget.EditText[1]");}
    By fieldPassword() {return By.xpath("//android.widget.EditText[2]");}
    By buttonLogin() {return By.xpath("//android.widget.Button[@content-desc=\"Login\"]");}
    By errorEmail() {return MobileBy.AccessibilityId("email can not empty");}
    By errorPassword() {return MobileBy.AccessibilityId("password can not empty");}
    By errorDouble() {return MobileBy.AccessibilityId("Email atau password tidak valid.");}
    By textRegister() {return MobileBy.AccessibilityId("Register");}


    public void inputEmail(String email) throws InterruptedException {
        onWait();
        click(fieldEmail());
        Thread.sleep(30,100);
        sendKeys(fieldEmail(),email);
    }
    public void inputPassword(String password) throws InterruptedException {
        onWait();
        click(fieldPassword());
        Thread.sleep(30,100);
        sendKeys(fieldPassword(), password);
    }
    public void clickButtonLogin(){
    click(buttonLogin());
}
    public void verifyErrorEmailDisplayed() {
        Assertions.assertTrue(isDisplayed(errorEmail()));
    }
    public void verifyErrorPasswordDisplayed() {
        Assertions.assertTrue(isDisplayed(errorPassword()));
    }
    public void verifyErrorDoubleDisplayed() {
        Assertions.assertTrue(isDisplayed(errorDouble()));
    }
    public void clickTextRegister(){
        click(textRegister());
    }
    public void verifyErrorEmailEqual(){
        Assertions.assertEquals("", getText(errorEmail()));
    }
    public void verifyErrorPasswordEqual(){
        Assertions.assertEquals("password can not empty", getText(errorPassword()));
    }
    public void verifyErrorDoubleEqual(){
        Assertions.assertEquals("Email atau password tidak valid", getText(errorDouble()));
    }
}
