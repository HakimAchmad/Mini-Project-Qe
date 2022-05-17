package com.example.app.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.example.app.drivers.AndroidDriverInit.driver;

public class BasePageObject {
    public AndroidDriver<AndroidElement> getDriver(){
        return driver;
    }

    public WebDriverWait onWait(){
        return new WebDriverWait(getDriver(), 45, 1000);
    }

    public AndroidElement find(By locator){
        return (AndroidElement) onWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator){
        find(locator).click();
    }
    public void sendKeys(By locator, String input){
        find(locator).sendKeys(input);
    }

    public String getText(By locator){
        return find(locator).getText();
    }

    public boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }
}
