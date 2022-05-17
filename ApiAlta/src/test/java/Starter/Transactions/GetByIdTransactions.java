package Starter.Transactions;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.nio.charset.StandardCharsets;
import static org.hamcrest.Matchers.equalTo;

public class GetByIdTransactions {
    private String token;
    protected static String base_url = "https://be-qa.alta.id/api";

    @Step("I set an endpoint for GET ById Transaction")
    public String setAnEndpointForGetByIdTransaction(){
        return base_url + "/orders/1" ;
    }

    @Step("I request get detail ById transactions")
    public void requestGetDetailByIdTransactions() throws Exception{
        token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//token.json"), StandardCharsets.UTF_8);
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(setAnEndpointForGetByIdTransaction());
    }

    @Step("I verify status code get all transactions is {int}")
    public void validateStatusCodeTransactions(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }

    @Step("validate the data transactions by id detail valid")
    public void validateDataDetailTransactions(){
        SerenityRest.then().body("data.ID", equalTo(1));
    }
}
