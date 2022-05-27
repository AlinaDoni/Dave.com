package test;

import io.cucumber.java.it.Ma;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.CareersPage;
import pages.MainPage;

public class testJob extends testBase{
    MainPage mainPage=new MainPage(driver);
    CareersPage careersPage=new CareersPage(driver);

    @Test
    public void validateJob(){
        mainPage.goToCareersPage();
        careersPage.findJob(driver);
        String expectedJobName="QA Engineer, Automation";
        String actualJobName=careersPage.getJobName();
        Assert.assertEquals(expectedJobName,actualJobName);
        Assert.assertTrue(careersPage.validateReadMore());
    }
    @Test
    public void negativeTest(){
        mainPage.goToCareersPage();
        careersPage.findJob(driver);
        String expectedJobName="Senior QA Engineer";
        String actualJobName=careersPage.getJobName();
        Assert.assertEquals(expectedJobName,actualJobName);
        Assert.assertTrue(careersPage.validateReadMore());
    }
}
