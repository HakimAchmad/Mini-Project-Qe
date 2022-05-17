package com.example.app.pages;

import com.example.app.base.BasePageObject;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import java.util.concurrent.ThreadLocalRandom;

public class RegisterPage extends BasePageObject {

static int random = ThreadLocalRandom.current().nextInt();

    By fieldName() {return By.xpath("//android.widget.EditText[1]");}
    By fieldEmail() {return By.xpath("//android.widget.EditText[2]");}
    By fieldPassword() {return By.xpath("//android.widget.EditText[3]");}
    By buttonRegister() {return By.xpath("//android.widget.Button[@content-desc=\"Register\"]");}
    By errorName() {return By.xpath("//android.view.View[@content-desc=\"fullname can not empty\"]");}
    By errorEmail() {return MobileBy.AccessibilityId("email can not empty");}
    By errorPassword() {return MobileBy.AccessibilityId("password can not empty");}
    By errorAll() {return MobileBy.AccessibilityId("Gagal :(");}

    public void inputName(String fullName) throws InterruptedException {
        onWait();
        click(fieldName());
        Thread.sleep(30,100);
        sendKeys(fieldName(), fullName);
    }

    public void inputEmail(String Email) throws InterruptedException {
        onWait();
        click(fieldEmail());
        if (Email.equals("New")) {
            sendKeys(fieldEmail(), String.valueOf((randomEmail())));
        } else {
            sendKeys(fieldEmail(),(Email));

            Thread.sleep(30, 100);
            sendKeys(fieldEmail(),(Email));
        }
    }

    private Object randomEmail() {
        return random +  "hakim@gmail.com";
    }

    public void inputPassword(String Password) throws InterruptedException {
        onWait();
        click(fieldPassword());
        Thread.sleep(30,100);
        sendKeys(fieldPassword(), Password);
    }
    public void clickButtonRegister(){
        click(buttonRegister());
    }
    public void verifyErrorNameDisplayed() {
        Assertions.assertTrue(isDisplayed(errorName()));
    }
    public void verifyErrorEmailDisplayed() {
        Assertions.assertTrue(isDisplayed(errorEmail()));
    }
    public void verifyErrorPasswordDisplayed() {
        Assertions.assertTrue(isDisplayed(errorPassword()));
    }
    public void verifyErrorAllDisplayed() {
        Assertions.assertTrue(isDisplayed(errorAll()));
    }
    public void verifyErrorNameEqual(){
        Assertions.assertEquals("", getText(errorName()));
    }
    public void verifyErrorEmailEqual(){
        Assertions.assertEquals("", getText(errorEmail()));
    }
    public void verifyErrorPasswordEqual(){
        Assertions.assertEquals("", getText(errorPassword()));
    }
    public void verifyErrorAllEqual(){
        Assertions.assertEquals("", getText(errorAll()));
    }

}
