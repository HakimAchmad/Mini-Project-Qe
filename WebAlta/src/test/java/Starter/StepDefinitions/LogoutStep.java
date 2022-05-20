package Starter.StepDefinitions;

import Starter.Pages.HomePage;
import Starter.Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LogoutStep {
    @Steps
    LoginPage loginPage;
    @Steps
    HomePage homePage;

    @Given("I am login account page")
    public void iAmOnTheLoginPage() {
        loginPage.openUrl("https://qa.alta.id/auth/login");
        loginPage.validateOnLoginPage();
    }

    @And("I Input {string} email")
    public void iInputEmail(String email) {
        loginPage.inputEmail(email);
    }

    @And("I Input {string} password")
    public void iInputPassword(String password) {
        loginPage.inputPassword(password);
    }

    @And("I Click login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @When("I Click button account")
    public void clickButtonAccount() {
        homePage.clickButtonAccount();
    }

    @And("I choose button logout")
    public void iClickButtonLogout() {
        homePage.clickButtonLogout();
    }

    @Then("I get success logout")
    public void iGetSuccessLogout() {
        loginPage.headerAppears();
        loginPage.headerTextEqual();
        loginPage.validateOnLoginPage();
    }
}
