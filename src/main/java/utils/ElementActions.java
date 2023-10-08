package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Long.parseLong;
import static utils.ConfigReader.getConfig;

import java.time.Duration;

public class ElementActions {
     WebDriver driver;
     Wait<WebDriver> wait;
     JavascriptExecutor executor;
    public ElementActions(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(parseLong(getConfig("waitTime"))));
        executor = (JavascriptExecutor) driver;
    }
    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void clickWithJS(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        executor.executeScript("arguments[0].click();", driver.findElement(locator));
    }
    public void typeInTextField(By locator, String text){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).sendKeys(text);
        wait.until(ExpectedConditions.attributeContains(locator,"value",text));
    }
    public void selectByIndex(By locator, int index) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        Select select = new Select(driver.findElement(locator));
        select.selectByIndex(index);
    }

    public void scrollToElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        executor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }
    public boolean isElementDisplayed(By locator){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public String getAttributeValue(By locator,String attribute){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator).getAttribute(attribute);
    }
    public String getElementTextValue(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

}
