package Starter.Products;

import Utils.Random;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.equalTo;

public class PostProduct {
    Random random = new Random();
    String  nameProduct;

    String base_url = "https://be-qa.alta.id/api/";

    public String getEndpointProduct(){
        return base_url + "products/";
    }

    @Step("Build request data post product")
    public JSONObject bodyDataProduct(String nameProduct){
        JSONObject body = new JSONObject();
        List<Integer> data = new ArrayList<>();

        if (nameProduct.equals("New")){
            this.nameProduct = random.randomProduct();
        } else if (nameProduct.equals("Empty")){
            this.nameProduct = null;
        }

        body.put("name", this.nameProduct);
        body.put("price", 250000);

        data.add(3);
        data.add(6);

        body.put("categories", data);
        return body;

    }

    @Step("I request POST create product")
    public void requestPostProduct(String nameProduct) {

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(bodyDataProduct(nameProduct))
                .when().post(getEndpointProduct());
    }

    @Step("validate create product status code is {int}")
    public void validateStatusCode(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }

    @Step("validate the data detail after request product")
    public void validateDataDetail(String message){
        if (message.equals("success")){
            SerenityRest.then().body("data.Name", equalTo(this.nameProduct));
        } else {
            System.out.println("error:invalid character");
        }
    }

    @Step("Get idProduct from the response")
    public String getIdProduct(){
        Response response = SerenityRest.lastResponse();
        String idProduct = response.jsonPath().getString("'data'.'ID'");
        try (FileWriter file = new FileWriter("src//test//resources//filejson//idProduct.json")) {
            file.write(idProduct);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(idProduct);
        return idProduct;
    }
}
