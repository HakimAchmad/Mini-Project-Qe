package Starter.Stepdefinitions;

import Starter.Authentication.Register;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RegisterStep {

    public String email;

    @Steps
    Register register;

    @Given("I set an endpoint for create new user")
    public void iSetAnEndpointForCreateNewUser() {
        register.getEndpointRegister();
    }

    @And("I input {string} with {string} and {string}")
    public void iInputField(String fullname, String email, String password) {
        register.requestDetailUser(fullname, email, password);
    }

    @When("I request detail email")
    public void iRequestDetailEmail() {
        this.email = register.getEmail();
    }

    @Then("I validate the status code is {int}")
    public void iValidateTheStatusCodeIsStatus_code(int arg0) {
        register.validateStatusCode(arg0);
    }
}
