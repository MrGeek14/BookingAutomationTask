package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;
import utils.SwitchToNewWindow;

public class SearchResultsPage {
    WebDriver driver;
    ElementActions elementActions;
    By paginationNo=By.xpath("//div[@data-testid='pagination']//ol/li/button");
    By lastPaginationItem=By.xpath("(//div[@data-testid='pagination']//ol/li/button)[last()]");
    By tolipHotelAlex=By.xpath("//div[contains(text(),'Tolip Hotel Alexandria')]");
    SwitchToNewWindow switchToNewWindow;


    public SearchResultsPage(WebDriver driver){
        this.driver=driver;
        elementActions= new ElementActions(driver);
        switchToNewWindow=new SwitchToNewWindow(driver);
    }
    public ReservationDetailsPage selectTolipHotelAlexandria() {
        int loop=Integer.parseInt(elementActions.getElementTextValue(lastPaginationItem));
        int index=2;
        for(int i=0;i<loop;i++){
            if(elementActions.isElementDisplayed(tolipHotelAlex)){
                elementActions.scrollToElement(tolipHotelAlex);
                elementActions.click(tolipHotelAlex);
                switchToNewWindow.switchToChildWindow();
                break;
            }
                try {
                    elementActions.click(By.xpath("//div[@data-testid='pagination']//ol/li/button[text()='"+(index++)+"']"));
                }catch (Exception e){
                    System.out.println("Tolip Hotel Alexandria is not exist in search");
                }

        }

        return new ReservationDetailsPage(driver);
    }
}
