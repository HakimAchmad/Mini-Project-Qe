package Starter.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class OrderPage extends PageObject {

    private By quantityOrder() {
        return By.id("label-total-quantity");
    }
    private By emptyOrder(){
            return By.className("v-alert__content");
    }
    private By addQuantity() {
        return By.xpath("//*[span[text()='+']]");
    }
    private By minusQuantity() {
        return By.xpath("//*[span[text()='-']]");
    }

    @Step
    public boolean validateQuantity(){
        return $(quantityOrder()).isDisplayed();
    }
    @Step
    public void clickAddQuantity(){
        $(addQuantity()).click();
    }
    @Step
    public void clickMinusQuantity(){
        $(minusQuantity()).click();
    }
    @Step
    public boolean emptyTextEqual(){
           return $(emptyOrder()).getText().equals("Order is empty!");
    }
    @Step
    public boolean amountTextEqual(){
        return $(quantityOrder()).equals(2);
    }
}
