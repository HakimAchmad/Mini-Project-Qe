package Starter.Categories;

import Utils.Random;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

public class PostCategories {

    Random random = new Random();
    String nameCategories;

    String base_url = "https://be-qa.alta.id/api/";

    public String getEndpointCategories(){
        return base_url + "categories/";
    }

        @Step("I request detail categories")
        public void requestDetailCategories(String nameCategories){
            JSONObject requestData = new JSONObject();
        if (nameCategories.equals("New")){
            this.nameCategories = random.randomCategory();
        } else if (nameCategories.equals("Empty")){
            this.nameCategories = null;
        }

            requestData.put("name", this.nameCategories);

            SerenityRest.given().header("Content-Type", "application/json").body(requestData.toJSONString());
            SerenityRest.when().post(getEndpointCategories());
    }

    @Step("validate create category status code is {int}")
    public void validateStatusCode(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }

}
