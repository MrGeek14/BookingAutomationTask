package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConfirmationPage;
import pages.ReservationDetailsPage;
import pages.SearchResultsPage;
import utils.ExcelReader;
import static utils.BookingCalender.*;

public class BookingTolipHotelAlexandriaTest extends BaseTest{

    @Test(dataProviderClass =ExcelReader.class,dataProvider = "getLocationAndHotelData")
    public void bookTolipHotelAlexandriaTest(String location,String hotel){
        SearchResultsPage searchResultsPage=homePage.searchForDeals(location,getCheckInDate(),getCheckOutDate());
        ReservationDetailsPage reservationDetailsPage=searchResultsPage.selectTolipHotelAlexandria();
        boolean isCheckInOutDisplayedCorrectly= reservationDetailsPage.isCheckInOutDisplayedCorrectly(getCheckInDate(),getCheckOutDate());
        reservationDetailsPage.selectBed();
        reservationDetailsPage.selectAmount();
        ConfirmationPage confirmationPage=reservationDetailsPage.confirmReservation();
        String displayedHotelName=confirmationPage.getSelectedHotelName();

        Assert.assertTrue(isCheckInOutDisplayedCorrectly);
        Assert.assertEquals(displayedHotelName,hotel);

    }
}
