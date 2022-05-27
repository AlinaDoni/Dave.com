package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BrowserUtils {
    //we create browser util to be able to call reusable methods from here to reduce amount of code


    public static void ScrollWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public static void ScrollWithXYCordinates(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Point location = element.getLocation();
        int xCord = location.getX();
        int yCord = location.getY();
        js.executeScript("window.scrollTo(" + xCord + "," + yCord + ")");
    }
    public static void SwitchByTitle(WebDriver driver,String title){
        Set<String> allPageId= driver.getWindowHandles();
        for (String id:allPageId){
            driver.switchTo().window(id);
            if (driver.getTitle().contains(title)){
                break;
            }
        }
    }

    public static void getScreenShot(WebDriver driver, String packageName){
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String location= System.getProperty("user.dir")+"/src/java/screenshot"+ packageName;
        try {
            FileUtils.copyFile(file, new File(location+System.currentTimeMillis()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
