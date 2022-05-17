package Starter.Transactions;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.equalTo;

public class PostTransactions {

    private String token;
    public Integer ProductId,Quantity;
    public String productId,quantity;
    protected static String base_url = "https://be-qa.alta.id/api";

    @Step("I set an endpoint for create Transaction")
    public String setAnEndpointForCreateTransaction(){
        return base_url + "/orders/" ;
    }

    @Step("Build request data invalid")
    public List<JSONObject> bodyDataInvalid(String productId, String quantity){
        List<JSONObject> body = new ArrayList<>();

        JSONObject data = new JSONObject();
        data.put("product_id", productId);
        data.put("quantity", quantity);

        body.add(data);
        return body;
    }

    @Step("I request create transactions invalid")
    public void requestPostTransactionsInvalid(String productId, String quantity) throws Exception{
        String token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//token.json"), StandardCharsets.UTF_8);

        given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(bodyDataInvalid(productId,quantity))
                .when().post(setAnEndpointForCreateTransaction());
    }

    @Step("validate create product status code is {int}")
    public void validateStatusCode(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }

    @Step("validate the data detail after request transaction invalid")
    public void validateDataDetail(String message){
        if (message.equals("required")){
            SerenityRest.then().body( "data",equalTo(null));
        }
    }

    @Step("Build request data valid")
    public List<JSONObject> bodyDataValid(Integer ProductId, Integer Quantity){
        List<JSONObject> body = new ArrayList<>();

        JSONObject data = new JSONObject();
        data.put("product_id", ProductId);
        data.put("quantity", Quantity);

        body.add(data);
        return body;
    }

    @Step("I request create transactions valid")
    public void requestPostTransactionsvalid(Integer ProductId, Integer Quantity) throws Exception{
        String token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//token.json"), StandardCharsets.UTF_8);

        given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(bodyDataValid(ProductId,Quantity))
                .when().post(setAnEndpointForCreateTransaction());
    }
    @Step("validate the data detail after request transaction valid")
    public void validateDataDetailValid(String Message){
        if (Message.equals("success")){
            SerenityRest.then().body( "data[0].Quantity",equalTo(Quantity));
        }
    }
}
