package Starter.Stepdefinitions;

import Starter.Categories.GetAllCategory;
import Starter.Categories.GetByIdCategory;
import Starter.Categories.PostCategories;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CategoriesStep {

    @Steps
    GetAllCategory getAllCat;

    @Steps
    GetByIdCategory getIdCat;

    @Steps
    PostCategories postCategories;

    @Given("I set endpoint for get list categories")
    public void iSetEndpointForGetListCategories() {
        getAllCat.getEndpointCategories();
    }

    @When("I request get list categories")
    public void iRequestGetListCategories() {
        getAllCat.requestGetListCategories();
    }

    @Then("I verify status code is {int}")
    public void iVerifyStatusCodeIs(int code) {
        getAllCat.verifyStatusCode(code);
        getIdCat.verifyStatusCode(code);
    }

    @Given("I set endpoint for get by id categories")
    public void iSetEndpointForGetByIdCategories() {
        getIdCat.getEndpointCategoriesId();
    }

    @When("I request get categories by id")
    public void iRequestGetCategoriesById() {
        getIdCat.requestGetIdCategories();
    }

    @Given("I set an endpoint for create categories")
    public void iSetAnEndpointForCreateCategories() {
        postCategories.getEndpointCategories();
    }

    @When("I input {string} name categories")
    public void iInput(String nameCategories) {
        postCategories.requestDetailCategories(nameCategories);
    }

    @Then("validate create category status code is {int}")
    public void validateCreateCategoryStatusCodeIs(int arg0) {
        postCategories.validateStatusCode(arg0);
    }

}
