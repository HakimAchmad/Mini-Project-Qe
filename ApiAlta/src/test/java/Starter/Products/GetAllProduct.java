package Starter.Products;

import static net.serenitybdd.rest.RestRequests.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;

public class GetAllProduct {
    String base_url = "https://be-qa.alta.id/api/";

    public String getEndpointProductAll(){
        return base_url + "products/";
    }

    public void requestGetListProduct(){
        given().when().get(getEndpointProductAll());
    }

    public void verifyStatusCode(int code){
        then().statusCode(equalTo(code));
    }
}
