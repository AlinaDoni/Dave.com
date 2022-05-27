package test;

import io.cucumber.java.it.Ma;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.CareersPage;
import pages.MainPage;

public class testJob extends testBase{
    MainPage mainPage=new MainPage(driver);
    CareersPage careersPage=new CareersPage(driver);

// we have one positive and one negative scenario for validating the Job name and Read More link
    @Test
    public void validateJob() throws InterruptedException {
        mainPage.goToCareersPage();
        careersPage.findJob(driver);
        Thread.sleep(2000);
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
        Assert.assertNotEquals(expectedJobName,actualJobName);
        Assert.assertTrue(careersPage.validateReadMore());
    }
}
