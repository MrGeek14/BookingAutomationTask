package utils;

import java.time.LocalDate;

public class BookingCalender {

    public static String getCheckInDate(){
        return String.valueOf(LocalDate.now());
    }

    public static String getCheckOutDate(){
        return String.valueOf(LocalDate.now().plusMonths(1));
    }
}
