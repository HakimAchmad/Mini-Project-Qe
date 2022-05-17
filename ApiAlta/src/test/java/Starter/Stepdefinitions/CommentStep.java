package Starter.Stepdefinitions;

import Starter.Comment.GetComment;
import Starter.Comment.PostComment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CommentStep {
    @Steps
    GetComment getComment;

    @Steps
    PostComment postComment;

    @Given("I set endpoint for get comment by id")
    public void iSetEndpointForGetCommentById() {
        getComment.getEndpointComment();
    }

    @When("I request get comment products by id")
    public void iRequestGetProductComment() {
        getComment.requestGetByIdComment();
    }

    @Then("I verify status code comment is {int}")
    public void verifyStatusCodeIs(int code) {
        getComment.verifyStatusCode(code);
    }

    @Given("I set an endpoint for create comment")
    public void iSetAnEndpointForCreateComment() {
        postComment.setEndpointComment();
    }

    @When("I input {string}")
    public void iInput(String comment) throws Exception{
        postComment.requestDetailComment(comment);
    }

    @Then("I validate comment status code is {int}")
    public void iValidateCommentStatusCodeIs(int arg0) {
        postComment.validateStatusCode(arg0);
    }

    @And("validate the {string} after request comment")
    public void validateTheAfterRequestComment(String Message) {
        postComment.validateDataDetail(Message);
    }

}
