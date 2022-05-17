package com.example.steps;

import com.example.app.pages.HomePage;
import com.example.app.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("I am on the landing page")
    public void iValidateLandingPage() {
        homePage.verifyHeaderProductDisplayed();
    }
    @And("I click button to login page")
    public void iClickButtonLoginPage() {
        homePage.clickArrowLogin();
    }

    @When("I input {string} email")
    public void iInputFieldEmailLogin(String email) throws InterruptedException {
        loginPage.inputEmail(email);
    }
    @And("I input {string} password")
    public void iInputFieldPasswordLogin(String password) throws InterruptedException {
        loginPage.inputPassword(password);
    }
    @And("click login button")
    public void iClickLoginButton() {
        loginPage.clickButtonLogin();
    }

    @Then("I get the {string}")
    public void getResultLogin(String result) {
        switch (result) {
            case "Success":
                homePage.verifyArrowLogoutDisplayed();
//                homePage.verifyHeaderProductEqual();
                break;
            case "Error Email":
                loginPage.verifyErrorEmailDisplayed();
                loginPage.verifyErrorEmailEqual();
                break;
            case "Error Password":
                loginPage.verifyErrorPasswordDisplayed();
//                loginPage.verifyErrorPasswordEqual();
                break;
            default:
                loginPage.verifyErrorDoubleDisplayed();
//                loginPage.verifyErrorDoubleEqual();
                break;
        }
    }
}
