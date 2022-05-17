package Starter.Stepdefinitions;

import Starter.Products.PostProduct;
import Starter.Products.GetAllProduct;
import Starter.Products.GetByIdProduct;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

public class ProductStep {

    @Steps
    GetAllProduct getAllProduct;

    @Steps
    GetByIdProduct getByIdProduct;

    @Steps
    PostProduct postProduct;

    @Given("I set endpoint for get list products")
    public void iSetEndpointForGetListProduct() {
        getAllProduct.getEndpointProductAll();
    }

    @When("I request get list products")
    public void iRequestGetListProduct() {
        getAllProduct.requestGetListProduct();
    }

    @Then("verify status code is {int}")
    public void verifyStatusCodeIs(int code) {
        getAllProduct.verifyStatusCode(code);
        getByIdProduct.verifyStatusCode(code);
    }

    @Given("I set endpoint for get by id products")
    public void iSetEndpointForGetByIdProducts() {
        getByIdProduct.getEndpointProductID();
    }

    @When("I request get products by id")
    public void iRequestGetProductsById() throws IOException {
        getByIdProduct.requestGetByIdProduct();
    }

    @Given("I set an endpoint for create product")
    public void iSetAnEndpointForCreateProduct() {
        postProduct.getEndpointProduct();
    }

    @When("I input {string} name product")
    public void iInputWith(String nameProduct) {
        postProduct.requestPostProduct(nameProduct);
    }

    @Then("validate create product status code is {int}")
    public void validateCreateProductStatusCodeIs(int arg0) {
        postProduct.validateStatusCode(arg0);
    }

    @And("validate the {string} after request create product")
    public void validateTheAfterRequestCreateProduct(String message) {
        postProduct.validateDataDetail(message);
    }

    @And("get idProduct if {string} for other request")
    public void getIdProductIfForOtherRequest(String message) {
        if (message.equals("success")){
            postProduct.getIdProduct();
        }
    }

}
