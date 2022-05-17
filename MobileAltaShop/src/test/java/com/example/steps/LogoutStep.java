package com.example.steps;

import com.example.app.pages.HomePage;
import com.example.app.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutStep {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("I am on landing page")
    public void iValidateLandingPage() {
        homePage.verifyHeaderProductDisplayed();
    }
    @And("I choose button to login page")
    public void iChooseButtonLoginPage() {
        homePage.clickArrowLogin();
    }

    @And("I Input {string} email")
    public void iInputEmail(String email) throws InterruptedException {
        loginPage.inputEmail(email);
    }

    @And("I Input {string} password")
    public void iInputPassword(String password) throws InterruptedException {
        loginPage.inputPassword(password);
    }

    @And("I Click login button")
    public void iClickLoginButton() {
        loginPage.clickButtonLogin();
    }

    @When("I am on the homepage")
    public void iAmOnTheHomepage() {
        homePage.verifyArrowLogoutDisplayed();
    }

    @And("I choose button logout")
    public void iChooseButtonLogout() {
        homePage.clickArrowLogout();
    }

    @Then("I get success logout")
    public void iGetSuccessLogout() {
        homePage.verifyArrowLoginDisplayed();
    }
}
