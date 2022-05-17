package Starter.Products;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.RestRequests.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;

public class GetByIdProduct {

    String base_url = "https://be-qa.alta.id/api/";

    public String getEndpointProductID(){
        return base_url + "products/{idProduct}";
    }

    public void requestGetByIdProduct() throws IOException {
        String idProduct = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//idProduct.json"), StandardCharsets.UTF_8);
        given()
                .pathParam("idProduct", idProduct).when().get(getEndpointProductID());
    }

    public void verifyStatusCode(int code){
        then().statusCode(equalTo(code));
    }
}
