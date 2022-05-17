package Starter.Comment;

import static net.serenitybdd.rest.RestRequests.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;

public class GetComment {
    String base_url = "https://be-qa.alta.id/api/";

    public String getEndpointComment(){
        return base_url + "products/1/comments/";
    }

    public void requestGetByIdComment(){
        given().when().get(getEndpointComment());
    }

    public void verifyStatusCode(int code){
        then().statusCode(equalTo(code));
    }
}
