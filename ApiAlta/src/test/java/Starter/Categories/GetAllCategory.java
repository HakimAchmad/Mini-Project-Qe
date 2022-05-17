package Starter.Categories;

import static net.serenitybdd.rest.RestRequests.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;

public class GetAllCategory {

    String base_url = "https://be-qa.alta.id/api/";

    public String getEndpointCategories(){
        return base_url + "categories/";
    }

    public void requestGetListCategories(){
        given().when().get(getEndpointCategories());
    }

    public void verifyStatusCode(int code){
        then().statusCode(equalTo(code));
    }

}
