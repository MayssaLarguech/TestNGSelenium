package testrunners;

import Pages.LoginPage;
import setup.Setup;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestRunner extends Setup {
    LoginPage loginPage;
    @Test(priority = 1, description = "Login with invalid password")
    public void doFailedLogin() throws InterruptedException {
        loginPage = new LoginPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.doLogin("Admin", "wrongPassword");
        String expectedText = "Invalid credentials";
        String actualText = driver.findElement(By.className("oxd-alert-content-text")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
        Thread.sleep(2000);
    }
    @Test(priority = 2, description = "Login with valid username and valid password")
    public void doLogin() throws InterruptedException {
        loginPage = new LoginPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.doLogin("Admin", "admin123");
        Thread.sleep(5000);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "dashboard";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }
}
