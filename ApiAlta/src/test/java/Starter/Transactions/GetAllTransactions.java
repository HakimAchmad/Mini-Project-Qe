package Starter.Transactions;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.nio.charset.StandardCharsets;

public class GetAllTransactions {
    private String token;
    protected static String base_url = "https://be-qa.alta.id/api";

    @Step("I set an endpoint for GET All Transaction")
    public String setAnEndpointForGetAllTransaction(){
        return base_url + "/orders/" ;
    }

    @Step("I request get detail all transactions")
    public void requestGetDetailAllTransactions() throws Exception{
        token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//token.json"), StandardCharsets.UTF_8);
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(setAnEndpointForGetAllTransaction());
    }

    @Step("I verify status code get all transactions is {int}")
    public void validateStatusCodeTransactions(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }

}
