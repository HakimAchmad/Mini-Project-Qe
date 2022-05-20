package Starter.StepDefinitions;

import Starter.Pages.LoginPage;
import Starter.Pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RegisterStep {

    @Steps
    RegisterPage registerPage;

    @Steps
    LoginPage loginPage;

    @Given("I am on the register page")
    public void iAmOnTheRegisterPage() {
        registerPage.openUrl("https://qa.alta.id/auth/register");
        registerPage.validateOnRegisterPage();
    }
    @When("I input {string} fullName")
    public void iInputFullName(String fullName) {
        registerPage.inputFullName(fullName);
    }
    @And("I input {string} Email")
    public void iInputEmail(String email) {
        registerPage.inputEmail(email);
    }
    @And("I input {string} Password")
    public void iInputPassword(String password) {
        registerPage.inputPassword(password);
    }
    @And("click register button")
    public void clickRegisterButton() {
        registerPage.scrollTo();
        registerPage.clickRegisterButton();
    }
    @Then("I Get the {string}")
    public void iGetThe(String output) {
        if (output.equals("login page")){
            loginPage.headerAppears();
            loginPage.headerTextEqual();
        }else {
            registerPage.errorFieldAlert();
            registerPage.errorMessageAppears();
        }
    }
}
