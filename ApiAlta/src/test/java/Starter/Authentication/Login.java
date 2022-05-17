package Starter.Authentication;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import static org.hamcrest.Matchers.equalTo;

public class Login {
    String email,token;

    String base_url = "https://be-qa.alta.id/api/";

    public String getEndpointLogin(){
        return base_url + "auth/login/";
    }

    @Step("I request detail Email Account User")
    public String getEmailUser(){
        return this.email;
    }

    @Step("I request detail account user")
    public void requestDetailAccountUser(String email, String password){
        JSONObject requestData = new JSONObject();

        requestData.put("email", email);
        requestData.put("password", password);

        SerenityRest.given().header("Content-Type", "application/json").body(requestData.toJSONString());
        SerenityRest.when().post(getEndpointLogin());
    }

    @Step("validate status code is {int}")
    public void validateStatusCode(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }

    @Step("validate the data detail after request login")
    public void validateDataDetail(String message){
        if (message.equals("success")){
            SerenityRest.then().body("email", equalTo(this.email));
        } else {
            SerenityRest.then().body("email", equalTo(null));
        }
    }

    @Step("Get bearerToken from the response")
    public String getBearerToken(){
        Response response = SerenityRest.lastResponse();
        String bearerToken = response.body().path("data");
        try (FileWriter file = new FileWriter("src//test//resources//filejson//token.json")) {
            file.write(bearerToken);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(bearerToken);
        return bearerToken;
    }
}
