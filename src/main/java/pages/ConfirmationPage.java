package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

public class ConfirmationPage {
    WebDriver driver;
    ElementActions elementActions;

    By selectedHotelName=By.xpath("//div[contains(@class,'property-details')]//h1");


    public ConfirmationPage(WebDriver driver){
        this.driver=driver;
        elementActions= new ElementActions(driver);
    }

    public String getSelectedHotelName(){
        return elementActions.getElementTextValue(selectedHotelName);
    }

}
