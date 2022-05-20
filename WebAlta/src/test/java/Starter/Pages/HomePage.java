package Starter.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.actions.OpenUrl;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import java.time.Duration;

public class HomePage extends PageObject  {

    private By homeHeader(){
        return By.xpath("//*[@class='v-icon notranslate fas fa-user theme--dark']");
    }
    private By seeProduct(){
        return By.className("v-select__selections");
    }
    private By productSatu() {
         return By.xpath("//*[@class = 'col-md-4 col-lg-3 col-6'][1]//span[text() = 'Beli']");
    }
    private By productDua() {
        return By.xpath("//*[@class = 'col-md-4 col-lg-3 col-6'][2]//span[text() = 'Beli']");
    }
    private By cartButton(){
        return By.xpath("//*[@class='v-badge v-badge--bottom v-badge--left v-badge--overlap theme--dark']");
    }
    private By detailButton(){
        return By.xpath("//div[1]/div/div[3]/div[2]/button[1]/span");
    }
    private By emptyProduct(){
        return By.xpath("//*[@aria-live='polite']");
    }
    private By amountProduct() {
        return By.xpath("//*[@aria-live='polite']");
    }
    private By accountButton(){
        return By.xpath("//*[@class='v-icon notranslate fas fa-user theme--dark']");
    }
    private By logoutButton(){
        return By.xpath("//*[@class='v-icon notranslate fas fa-sign-in theme--light']");
    }


    @Step
    public boolean headerAppears(){
        return $(homeHeader()).isDisplayed();
    }
    @Step
    public boolean headerTextEqual(){
        return $(homeHeader()).getText().equals("");
    }
    @Step
    public static OpenUrl url (String targetUrl){
        return new OpenUrl("https://qa.alta.id/");
    }
    @Step
    public boolean validateOnHomePage(){
        return $(cartButton()).isDisplayed();
    }
    @Step
    public boolean categoryAppears(){
        return $(seeProduct()).isDisplayed();
    }
    @Step
    public boolean validateEmptyProduct(){
        return $(emptyProduct()).isDisplayed();
    }
    @Step
    public boolean validateAmountProduct(){
        return $(amountProduct()).isDisplayed();
    }
    @Step
    public void clickProductSatu(){
        $(productSatu()).click();
    }
    @Step
    public void clickProductDua(){
        $(productDua()).click();
    }
    @Step
    public void clickButtonCart(){
        $(cartButton()).click();
    }
    @Step
    public void clickButtonAccount(){
        $(accountButton()).click();
    }
    @Step
    public void clickDetailProduct(){
        $(detailButton()).click();
    }
    @Step
    public void clickButtonLogout(){
        $(logoutButton()).click();
    }
    @Step
    public boolean emptyTextEqual(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return $(emptyProduct()).getText().equals("");
    }
    @Step
    public boolean amountTextEqual(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return $(amountProduct()).getText().equals("2");
    }

}
