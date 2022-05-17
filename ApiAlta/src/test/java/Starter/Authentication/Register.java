package Starter.Authentication;

import Utils.Random;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class Register {
    Random random = new Random();
    String email;

    String base_url = "https://be-qa.alta.id/api/";

    public String getEndpointRegister(){
        return base_url + "auth/register/";
    }

    @Step("I request detail email")
    public String getEmail(){
       return this.email;
    }

    @Step("I request detail user")
    public void requestDetailUser(String fullname, String email, String password){
        JSONObject requestData = new JSONObject();
        if (email.equals("New")){
            this.email = random.randomEmail();
            try (FileWriter file = new FileWriter("src//test//resources//filejson//email.json")) {
                file.write(this.email);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (email.equals("Same")){
            this.email = "hakim001@gmail.com";
        }

        requestData.put("fullname", fullname);
        requestData.put("email", this.email);
        requestData.put("password", password);

        SerenityRest.given().header("Content-Type", "application/json").body(requestData.toJSONString());
        SerenityRest.when().post(getEndpointRegister());
    }

    @Step("I validate the status code is {int}")
    public void validateStatusCode(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }
}
