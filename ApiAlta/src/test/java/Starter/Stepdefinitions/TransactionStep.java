package Starter.Stepdefinitions;

import Starter.Transactions.GetAllTransactions;
import Starter.Transactions.GetByIdTransactions;
import Starter.Transactions.PostTransactions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class TransactionStep {

    @Steps
    GetAllTransactions getAllTransactions;

    @Steps
    GetByIdTransactions getByIdTransactions;

    @Steps
    PostTransactions postTransactions;


    @Given("I set endpoint for get all transactions")
    public void iSetAnEndpointForGETAllTransactions() {
        getAllTransactions.setAnEndpointForGetAllTransaction();
    }

    @When("I request get detail all transactions")
    public void iRequestGETDetailAllTransactions() throws Exception{
        getAllTransactions.requestGetDetailAllTransactions();
    }

    @Then("I verify status code get transactions is {int}")
    public void verifyStatusCodeIs(int code) {
        getAllTransactions.validateStatusCodeTransactions(code);
        getByIdTransactions.validateStatusCodeTransactions(code);
    }

    @Given("I set endpoint for get by id transactions")
    public void iSetEndpointForGetByIdTransactions() {
        getByIdTransactions.setAnEndpointForGetByIdTransaction();
    }

    @When("I request get transactions by id")
    public void iRequestGetTransactionsById() throws Exception{
        getByIdTransactions.requestGetDetailByIdTransactions();
    }

    @And("validate the data transactions by id detail valid")
    public void validateTheDataTransactionsByIdDetailValid() {
        getByIdTransactions.validateDataDetailTransactions();
    }

    @Given("I set an endpoint for create transaction")
    public void iSetAnEndpointForCreateTransaction() {
        postTransactions.setAnEndpointForCreateTransaction();
    }

    @When("I input {string} and {string}")
    public void iInputProductIdWithQuantity(String productId, String quantity) throws Exception{
        postTransactions.requestPostTransactionsInvalid(productId,quantity);
    }

    @Then("I validate status code is {int}")
    public void iValidateStatusCodeIsStatus_code(int arg0) {
        postTransactions.validateStatusCode(arg0);
    }

    @And("validate the {string} after request transaction invalid")
    public void validateTheAfterRequestTransaction(String message) {
        postTransactions.validateDataDetail(message);
    }

    @When("I input {int} and {int}")
    public void iInputProductIdAndQuantity(Integer ProductId, Integer Quantity) throws Exception{
        postTransactions.requestPostTransactionsvalid(ProductId,Quantity);
    }

    @And("validate the {string} after request transaction valid")
    public void validateTheAfterRequestTransactionValid(String Message) {
        postTransactions.validateDataDetailValid(Message);
    }
}
