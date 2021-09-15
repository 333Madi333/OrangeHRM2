package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends BasePage {
    protected WebDriver driver;

    public AdminPage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Admin")
    public WebElement adminBtn;

    @FindBy(id = "menu_admin_nationality")
    public WebElement natinalBtn;

    @FindBy(id = "btnAdd")
    public WebElement addBtn;

    @FindBy(id = "nationality_name")
    public WebElement natInput;

    @FindBy(id = "btnSave")
    public WebElement saveBtn;


    @FindBy(xpath = "//*[text()='User Management']")
    public WebElement userMngBtn;

    @FindBy(id = "systemUser_employeeName_empName")
    public WebElement employeeNameInput;

    @FindBy(id = "systemUser_userName")
    public WebElement userNameInput;

    @FindBy(id = "systemUser_password")
    public WebElement passInput;

    @FindBy(id = "systemUser_confirmPassword")
    public WebElement passConfInput;

    @FindBy(id = "btnDelete")
    public WebElement deleteBtn;

    @FindBy(id = "searchSystemUser_userType")
    public WebElement roleSel;

    @FindBy(id = "searchBtn")
    public WebElement searchBtn;

}
