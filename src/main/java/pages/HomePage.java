package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

public class HomePage {

    WebDriver driver;
    ElementActions elementActions;
    By signInInfoPopupCloseBtn=By.xpath("//button[@aria-label='Dismiss sign-in info.']");
    By destinationTxtBox=By.xpath("//div[@data-testid='destination-container']//input");
    By datesContainer=By.xpath("//div[@data-testid='searchbox-dates-container']");
    By searchBtn=By.xpath("//button[@type='submit']");


    public HomePage(WebDriver driver){
        this.driver=driver;
        elementActions= new ElementActions(driver);
    }

    public void closeSignInPopup(){
         elementActions.click(signInInfoPopupCloseBtn);
    }

    public void enterDestination(String location){
        elementActions.typeInTextField(destinationTxtBox,location);
        elementActions.click(By.xpath("(//div[text()='"+location+"'])[1]"));
    }
    public void setCheckInOutDates(String checkIn,String checkOut){
        elementActions.click(datesContainer);
        elementActions.click(datesContainer);
        elementActions.click(By.xpath("//span[@data-date='"+checkIn+"']"));
        elementActions.click(By.xpath("//span[@data-date='"+checkOut+"']"));
    }
    public SearchResultsPage searchForDeals(String location,String checkIn,String checkOut){
        enterDestination(location);
        setCheckInOutDates(checkIn,checkOut);
        elementActions.click(searchBtn);

        return new SearchResultsPage(driver);
    }
}
