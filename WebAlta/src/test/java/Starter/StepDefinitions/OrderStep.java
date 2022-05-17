package Starter.StepDefinitions;

import Starter.Pages.HomePage;
import Starter.Pages.LoginPage;
import Starter.Pages.OrderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OrderStep {
    @Steps
    LoginPage loginPage;
    @Steps
    HomePage homePage;
    @Steps
    OrderPage orderPage;


    @Given("I am login account AltaShop")
    public void iAmOnTheLoginPage() {
        loginPage.openUrl("https://qa.alta.id/auth/login");
        loginPage.validateOnLoginPage();
    }
    @And("I enter {string} Email")
    public void iInputEmail(String email) {
        loginPage.inputEmail(email);
    }
    @And("I enter {string} Password")
    public void iInputPassword(String password) {
        loginPage.inputPassword(password);
    }
    @And("I click login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }
    @And("I choose buy product")
    public void iClickButtonBuy() {
        homePage.clickProductSatu();
    }
    @When("I click button cart")
    public void clickButtonCart() {
        homePage.clickButtonCart();
    }

    @And("I click button plus")
    public void iClickButtonPlus() {
        orderPage.clickAddQuantity();
    }
    @Then("I get add amount order")
    public void iGetAddAmountOrder() {
        orderPage.validateQuantity();
    }
    @And("I click button minus")
    public void iClickButtonMinus() {
        orderPage.clickMinusQuantity();
        orderPage.emptyTextEqual();
    }
    @Then("I get minus amount order")
    public void iGetMinusAmountOrder() {
        orderPage.validateQuantity();
        orderPage.amountTextEqual();
    }

}
