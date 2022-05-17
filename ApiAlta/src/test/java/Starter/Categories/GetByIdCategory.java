package Starter.Categories;

import static net.serenitybdd.rest.RestRequests.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;

public class GetByIdCategory {
    String base_url = "https://be-qa.alta.id/api/";

    public String getEndpointCategoriesId(){
        return base_url + "categories/1";
    }

    public void requestGetIdCategories(){
        given().when().get(getEndpointCategoriesId());
    }

    public void verifyStatusCode(int code){
        then().statusCode(equalTo(code));
    }
}
