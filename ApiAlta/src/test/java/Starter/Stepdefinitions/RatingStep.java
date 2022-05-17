package Starter.Stepdefinitions;

import Starter.Ratings.GetProductRatings;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RatingStep {
    @Steps
    GetProductRatings getProductRatings;

    @Given("I set endpoint for get products rating")
    public void iSetEndpointForGetRatingProduct() {
        getProductRatings.getEndpointRatings();
    }

    @When("I request get products ratings")
    public void iRequestGetProductRating() {
        getProductRatings.requestGetByIdRatings();
    }

    @Then("I get verify status code is {int}")
    public void verifyStatusCodeIs(int code) {
        getProductRatings.verifyStatusCode(code);
    }

}
