package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage {
    protected WebDriver driver;

    public MyInfoPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
