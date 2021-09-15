package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeavePage extends BasePage {
    protected WebDriver driver;

    public LeavePage (WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()='Leave']")
    public WebElement leaveBtn;

    @FindBy(xpath = "//*[text()='Apply']")
    public WebElement applyBtn;

}
