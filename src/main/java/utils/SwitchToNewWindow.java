package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class SwitchToNewWindow {
    public WebDriver driver;

    public SwitchToNewWindow(WebDriver driver) {
        this.driver = driver;
    }


    public void switchToChildWindow() {

        String parentWindow = driver.getWindowHandle();
        Set<String> childWindows = driver.getWindowHandles();
        for (String newWindow : childWindows) {
            if (!newWindow.equalsIgnoreCase(parentWindow)) {
                driver.switchTo().window(newWindow);
            }
        }
    }

}
