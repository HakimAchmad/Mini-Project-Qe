package Starter.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class ProductPage extends PageObject  {

    private By qualityRating(){
        return By.xpath("//*[@class='black--text text--lighten-2 text-caption mr-2']");
    }

    @Step
    public boolean validateRatingProduct(){
        return $(qualityRating()).isDisplayed();
    }
    @Step
    public boolean qualityRatingProduct(){
        return $(qualityRating()).equals(2);
    }

}
