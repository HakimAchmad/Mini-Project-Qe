package Starter.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class TransactionsPage extends PageObject {

    private By paymentOrder() {
        return By.id("button-bayar");
    }
    private By transactionHeader(){
        return By.xpath("//*[text()='Transactions']");
    }

    @Step
    public void clickPayOrder(){
        $(paymentOrder()).click();
    }
    @Step
    public boolean headerAppears(){
        return $(transactionHeader()).isDisplayed();
    }
    @Step
    public boolean headerTextEqual(){
        return $(transactionHeader()).getText().equals("Transactions");
    }
}
