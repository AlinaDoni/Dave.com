package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.DriverHelper;

import java.util.concurrent.TimeUnit;

public class testBase {
    public WebDriver driver= DriverHelper.getDriver();
    @BeforeTest
    public void setup(){
        this.driver.navigate().to("https://www.dave.com/");


    }
   @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
