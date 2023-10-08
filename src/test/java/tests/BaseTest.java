package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;



import static utils.ConfigReader.getConfig;

public class BaseTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeTest
    public void setDriver(){
      if(getConfig("browser").equals("chrome")){
          driver=new ChromeDriver();
      } else if (getConfig("browser").equals("firefox")) {
          driver=new FirefoxDriver();
      }else if (getConfig("browser").equals("edge")) {
          driver=new EdgeDriver();
      }

      driver.get(getConfig("url"));
      driver.manage().window().maximize();
      homePage=new HomePage(driver);
      homePage.closeSignInPopup();
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
