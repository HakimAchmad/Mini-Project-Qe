package com.example.steps;

import com.example.app.pages.HomePage;
import com.example.app.pages.LoginPage;
import com.example.app.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStep {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();


    @Given("I am on the Landing page")
    public void iValidateLandingPage() {
        homePage.verifyHeaderProductDisplayed();
    }
    @And("I choose button to Login page")
    public void iClickButtonLoginPage() {
        homePage.clickArrowLogin();
    }

    @And("I Click text register")
    public void iClickTextRegister() {
        loginPage.clickTextRegister();
    }

    @When("I input {string} fullName")
    public void iInputFullName(String fullName) throws InterruptedException {
        registerPage.inputName(fullName);
    }

    @And("I input {string} Email")
    public void iInputEmail(String Email) throws InterruptedException {
        registerPage.inputEmail(Email);
    }

    @And("I input {string} Password")
    public void iInputPassword(String Password) throws InterruptedException {
        registerPage.inputPassword(Password);
    }

    @And("click register button")
    public void clickRegisterButton() {
        registerPage.clickButtonRegister();
    }

    @Then("I Get the {string}")
    public void iGetThe(String output) {
        switch (output) {
            case "Success":
                homePage.verifyArrowLoginDisplayed();
                break;
            case "Error Name":
                registerPage.verifyErrorNameDisplayed();
//                registerPage.verifyErrorNameEqual();
                break;
            case "Error Email":
                registerPage.verifyErrorEmailDisplayed();
//                registerPage.verifyErrorEmailEqual();
                break;
            case "Error Password":
                registerPage.verifyErrorPasswordDisplayed();
                registerPage.verifyErrorPasswordEqual();
                break;
            default:
                registerPage.verifyErrorAllDisplayed();
                registerPage.verifyErrorAllEqual();
                break;
        }
    }
}
