package Starter.Pages;

import Utils.RandomNumber;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.SerenityActions;
import net.serenitybdd.screenplay.actions.OpenUrl;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.time.Duration;

public class RegisterPage extends PageObject {

    private By fullNameField(){
        return By.xpath("//*[label[text()= 'Nama Lengkap']]//input");
    }
    private By emailField(){
        return By.xpath("//*[label[text()= 'Email']]//input");
    }
    private By passwordField(){
        return By.xpath("//*[label[text()= 'Password']]//input");
    }
    private By registerButton() {
        return By.cssSelector("button[class='v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default primary'] span[class='v-btn__content']");
    }
    private By errorMessage(){
        return By.className("v-alert__content");
    }
    private By alertField() { return By.className("v-alert__wrapper");
    }
    private By interactionsText(){
        return By.xpath("//div[text() = 'Register']");
    }

    @Step
    public static OpenUrl url (String targetUrl){
        return new OpenUrl("https://qa.alta.id/auth/register");
    }
    @Step
    public boolean validateOnRegisterPage(){
        return $(registerButton()).isDisplayed();
    }
    @Step
    public void inputFullName(String fullName){
        $(fullNameField()).type(fullName);
    }

    @Step
    public void inputEmail(String email){
        if (email.equals("New")) {
            $(emailField()).type(RandomNumber.randomEmail());
        } else{
            $(emailField()).type(email);
        }
    }
    @Step
    public void inputPassword(String password){
        $(passwordField()).type(password);
    }
    @Step
    public void clickRegisterButton(){
        $(registerButton()).click();
    }
    @Step
    public void scrollTo(){
        SerenityActions actions = new SerenityActions(getDriver());
        actions.moveToElement($(interactionsText())).perform();
    }
    @Step
    public boolean errorMessageAppears(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return $(errorMessage()).isDisplayed();
    }
    @Step
    public boolean errorMessageEquals(String text){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return $(errorMessage()).getText().equals(text);
    }
    @Step
    public boolean errorFieldAlert(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return $(alertField()).isSelected();
    }
}
