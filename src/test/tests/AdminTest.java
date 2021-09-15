package tests;

import base.BaseTest;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AdminPage;

import java.util.List;


public class AdminTest extends BaseTest {
    AdminPage adminPage;

    @BeforeMethod
    public void setUp(){
        adminPage = new AdminPage(driver);
    }

    @Test(description = "Verify new nationality is added to the table", groups = {"smokeTest", "regression"})
    public void test01(){

        adminPage.adminBtn.click();
        adminPage.natinalBtn.click();
        adminPage.addBtn.click();
        adminPage.natInput.sendKeys("AAAKaz");
        adminPage.saveBtn.click();

        String expected = "AAAKaz";
        String actual = driver.findElement(By.xpath("//*[text()='AAAKaz']")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test( testName = "add new Username")
    public void test02() throws InterruptedException {
        Faker faker = new Faker();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String username = faker.funnyName().name();

        adminPage.adminBtn.click();
        adminPage.userMngBtn.click();
        adminPage.addBtn.click();

        adminPage.employeeNameInput.sendKeys("Alice Duval");
        adminPage.userNameInput.sendKeys(username);
        adminPage.passInput.sendKeys("Abc+123+321");
        adminPage.passConfInput.sendKeys("Abc+123+321");

        wait.until(ExpectedConditions.elementToBeClickable(adminPage.saveBtn));
        adminPage.saveBtn.click();

        if (driver.findElements(By.xpath("//*[text()='System Users']")).size() < 1){
            adminPage.saveBtn.click();
        }

        Thread.sleep(3000);

        List<WebElement> users = driver.findElements(By.xpath("//tr/td/a"));
        int tableSizeBeforeDelete = users.size();

        driver.findElement(By.xpath("//*[text()='"+ username + "']/parent::td/preceding-sibling::td")).click();
        adminPage.deleteBtn.click();
        driver.findElement(By.id("dialogDeleteBtn")).click();

        Thread.sleep(2000);

        List <WebElement> users1 = driver.findElements(By.xpath("//tr/td/a"));
        int tableSizeAfterDelete = users1.size();

        Assert.assertNotEquals(tableSizeAfterDelete, tableSizeBeforeDelete);
    }

    @Test()
    public void filterSearchTest(){
        adminPage.adminBtn.click();

        Select select = new Select(adminPage.roleSel);
        select.selectByVisibleText("Admin");
        adminPage.searchBtn.click();

        List<WebElement> userRoles = driver.findElements(By.xpath("//tbody/tr/td[3]"));
        for(WebElement role: userRoles){
            if (!role.getText().equals("Admin")){
                Assert.fail();
            }
        }
    }
}
