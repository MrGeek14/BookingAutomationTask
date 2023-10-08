package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

public class ReservationDetailsPage {

    WebDriver driver;
    ElementActions elementActions;
    By searchBoxDatesContainer=By.xpath("//div[@data-testid='searchbox-dates-container']");
    By firstBedOption=By.xpath("(//input[@type='radio' and @value='1'])[1]");
    By firstAmountOptions=By.xpath("(//select[@data-testid='select-room-trigger'])[1]");
    By reserveBtn=By.xpath("//div[@class='hprt-reservation-cta']/button");



    public ReservationDetailsPage(WebDriver driver){
        this.driver=driver;
        elementActions= new ElementActions(driver);
    }

    public boolean isCheckInOutDisplayedCorrectly(String checkIn,String checkOut){
        elementActions.scrollToElement(searchBoxDatesContainer);
        elementActions.click(searchBoxDatesContainer);
        boolean checkInChecked=Boolean.parseBoolean(elementActions.getAttributeValue(By.xpath("//span[@data-date='"+checkIn+"']"),"aria-checked"));
        boolean checkOutChecked=Boolean.parseBoolean(elementActions.getAttributeValue(By.xpath("//span[@data-date='"+checkOut+"']"),"aria-checked"));

        if(checkInChecked&&checkOutChecked){
            return true;
        }
        return false;
    }
    public void selectBed(){
        elementActions.scrollToElement(firstBedOption);
        elementActions.clickWithJS(firstBedOption);
    }
    public void selectAmount(){
        elementActions.scrollToElement(firstAmountOptions);
        elementActions.selectByIndex(firstAmountOptions,1);
    }
    public ConfirmationPage confirmReservation(){
        elementActions.clickWithJS(reserveBtn);

        return new ConfirmationPage(driver);
    }

}
