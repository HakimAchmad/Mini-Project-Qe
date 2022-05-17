package Starter.StepDefinitions;

import Starter.Pages.HomePage;
import Starter.Pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ProductStep {

    @Steps
    HomePage homePage;

    @Steps
    ProductPage productPage;

    @Given("I am on the HomePage AltaShop")
    public void iOnTheHomePage() {
        homePage.openUrl("https://qa.alta.id/");
        homePage.validateOnHomePage();
    }
    @When("I don't buy product")
    public void iSeeProduct() {
        homePage.categoryAppears();
    }
    @When("I click button buy product")
    public void iClickButtonBuy() {
        homePage.clickProductSatu();
        homePage.clickProductDua();
    }
    @Then("I get empty cart product")
    public void iGetEmptyCartProduct() {
        homePage.validateEmptyProduct();
        homePage.emptyTextEqual();
    }
    @Then("I get purchase amount product")
    public void iGetPurchaseProduct() {
        homePage.validateAmountProduct();
        homePage.amountTextEqual();
    }

    @When("I click button detail product")
    public void iClickButtonDetailProduct() {
        homePage.clickDetailProduct();
    }


    @Then("I get detail rating product")
    public void iGetDetailRatingProduct() {
        productPage.validateRatingProduct();
        productPage.qualityRatingProduct();
    }
}
