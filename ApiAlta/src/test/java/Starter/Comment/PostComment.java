package Starter.Comment;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.equalTo;

public class PostComment {

    String comment;

    String base_url = "https://be-qa.alta.id/api/";

    public String setEndpointComment(){
        return base_url + "products/1/comments/";
    }

    @Step("I request detail comment")
    public void requestDetailComment(String comment)throws Exception {
        JSONObject requestData = new JSONObject();
        switch (comment) {
            case "True":
                this.comment = "Product Is Good";
                break;
            case "Empty":
                this.comment = null;
                break;
        }
        requestData.put("content", this.comment);

        String token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//token.json"), StandardCharsets.UTF_8);
        SerenityRest.given().header("Content-Type", "application/json")
                            .header("Authorization", "Bearer " + token)
                            .body(requestData.toJSONString());
        SerenityRest.when().post(setEndpointComment());
    }

    @Step("validate create category status code is {int}")
    public void validateStatusCode(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }
    @Step("validate the data detail after request comment")
    public void validateDataDetail(String Message){
        if (Message.equals("success")){
            SerenityRest.then().body( "data.Content",equalTo(comment));
        } else {
            SerenityRest.then().body("data", equalTo(null));
        }
    }
}
