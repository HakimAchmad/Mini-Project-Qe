package Starter.Ratings;

import static net.serenitybdd.rest.RestRequests.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;

public class GetProductRatings {
    String base_url = "https://be-qa.alta.id/api/";

    public String getEndpointRatings(){
        return base_url + "products/1/ratings/";
    }

    public void requestGetByIdRatings(){
        given().when().get(getEndpointRatings());
    }

    public void verifyStatusCode(int code){
        then().statusCode(equalTo(code));
    }
}
