package Starter.StepDefinitions;

import Starter.Pages.HomePage;
import Starter.Pages.LoginPage;
import Starter.Pages.OrderPage;
import Starter.Pages.TransactionsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class TransactionsStep {

    @Steps
    LoginPage loginPage;
    @Steps
    HomePage homePage;
    @Steps
    OrderPage orderPage;
    @Steps
    TransactionsPage transactionsPage;

    @Given("I am login account")
    public void iAmOnTheLoginPage() {
        loginPage.openUrl("https://qa.alta.id/auth/login");
        loginPage.validateOnLoginPage();
    }

    @And("I Input {string} Email")
    public void iInputEmail(String email) {
        loginPage.inputEmail(email);
    }

    @And("I Input {string} Password")
    public void iInputPassword(String password) {
        loginPage.inputPassword(password);
    }

    @And("I click button login")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @And("I click buy product")
    public void iClickButtonBuy() {
        homePage.clickProductSatu();
    }

    @When("I choose button cart")
    public void clickButtonCart() {
        homePage.clickButtonCart();
    }
    @And("I choose button plus")
    public void iClickButtonPlus() {
        orderPage.clickAddQuantity();
    }
    @And("I click button pay")
    public void iClickButtonPay() {
        transactionsPage.clickPayOrder();
    }
    @Then("I get success transaction")
    public void iGetSuccessTransaction() {
        transactionsPage.headerAppears();
        transactionsPage.headerTextEqual();
    }
    @Given("I am on the HomePage")
    public void iAmOnTheHomePage() {
        homePage.headerAppears();
        homePage.headerTextEqual();
        homePage.validateOnHomePage();
    }
    @Then("I get redirect login page")
    public void iGetRedirectLoginPage() {
        loginPage.headerAppears();
        loginPage.headerTextEqual();
        loginPage.validateOnLoginPage();
    }
}
