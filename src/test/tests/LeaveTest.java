package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LeavePage;


public class LeaveTest extends BaseTest {
    LeavePage leavePage;

    @BeforeMethod
    public void setUp() {
       leavePage = new LeavePage(driver);
    }

    @Test(testName = "Leave")
    public void test() {
        leavePage.leaveBtn.click();
        String expected = "Leave List";
        String actual = driver.findElement(By.xpath("//div[@class='head']")).getText();
        Assert.assertEquals(actual, expected);

        leavePage.applyBtn.click();

        String expected1 = "No Leave Types with Leave Balance";
        String actual1 = driver.findElement(By.xpath("//div[@class='message warning']")).getText();
        Assert.assertEquals(actual1, expected1);
    }

    @Test(testName = "Apply")
    public void test1() {
        leavePage.leaveBtn.click();
        leavePage.applyBtn.click();

        String expected = "No Leave Types with Leave Balance";
        String actual = driver.findElement(By.xpath("//div[@class='message warning']")).getText();
        Assert.assertEquals(actual, expected);

    }
}
