package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class CareersPage {
    public CareersPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h4[.='QA Engineer, Automation']")
    WebElement job;

    @FindBy(xpath = "//a[@href='https://jobs.lever.co/dave/c074d7ed-4b16-4773-b4b4-bf89ffac4e44']")
    WebElement readMore;


    public void findJob(WebDriver driver){
        BrowserUtils.ScrollWithJS(driver,job);
    }

    public String getJobName() {
        return job.getText().trim();
    }

    public boolean validateReadMore(){
        return readMore.isDisplayed();

    }

}
