package com.example.steps;

import com.example.app.pages.HomePage;
import com.example.app.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStep {

    HomePage homePage = new HomePage();


    @Given("I am on the landing page AltaShop")
    public void iValidateLandingPage() {
        homePage.verifyHeaderProductDisplayed();
    }

    @When("I don't buy product")
    public void iDonTBuyProduct() {
        homePage.clickDetailProduct();
    }

    @And("I click button cart")
    public void iClickButtonCart() {
        homePage.clickButtonCart();
    }

    @Then("I get cart empty product")
    public void iGetCartEmptyProduct() {
        homePage.verifyCartZeroDisplayed();
        homePage.verifyCartZeroEqual();
    }

    @When("I click button buy product")
    public void iClickButtonBuyProduct() {
        homePage.clickButtonBuy();
    }

    @Then("I get cart there is product")
    public void iGetCartThereIsProduct() {
        homePage.verifyCartOneDisplayed();
        homePage.verifyCartOneEqual();
    }
}
