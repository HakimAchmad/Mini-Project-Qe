package Starter.StepDefinitions;

import Starter.Pages.HomePage;
import Starter.Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginStep {
    @Steps
    LoginPage loginPage;

    @Steps
    HomePage homePage;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.openUrl("https://qa.alta.id/auth/login");
        loginPage.validateOnLoginPage();
    }

    @And("click login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @When("I input {string} email")
    public void iInputEmail(String email) {
        loginPage.inputEmail(email);
    }

    @And("I input {string} password")
    public void iInputPassword(String password) {
        loginPage.inputPassword(password);
    }

    @Then("I get the {string}")
    public void iGetThe(String result) {
        if (result.equals("home page")){
            homePage.headerAppears();
            homePage.headerTextEqual();
        }else {
            loginPage.errorMessageAppears();
            loginPage.errorMessageEquals(result);
      }
   }
}
