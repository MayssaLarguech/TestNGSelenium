package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {
    @FindBy(name = "username")
    WebElement usernameInput;
    @FindBy(name = "password")
    WebElement passwordInput;
    @FindBy(css = "[type=submit]")
    WebElement submitBtn;


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void doLogin(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitBtn.click();
    }
}