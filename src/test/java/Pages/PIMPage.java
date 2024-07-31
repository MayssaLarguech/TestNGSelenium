package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
public class PIMPage {

    @FindBy(partialLinkText = "Add Employee")
    public WebElement addEmployeeLinkText;

    @FindBy(className = "oxd-switch-input")
    WebElement checkBox;

    @FindBy(className = "oxd-input")
    public List<WebElement> inputFields;


    @FindBy(css = "[type=submit]")
    public WebElement submitBtn;

    public PIMPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void checkUserName(String userName) {
        checkBox.click();
        inputFields.get(5).sendKeys(userName);
    }

    @FindBy(className = "oxd-input-field-error-message")
    public WebElement userNameErrorMessage;

    public void addEmployee(String firstName, String lastName, String userName, String pass, String confirmPass){
        checkBox.click();
        inputFields.get(1).sendKeys(firstName);
        inputFields.get(3).sendKeys(lastName);
        inputFields.get(5).sendKeys(userName);
        inputFields.get(6).sendKeys(pass);
        inputFields.get(7).sendKeys(confirmPass);
        submitBtn.click();
    }

}
