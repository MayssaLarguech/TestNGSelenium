package testrunners;

import Pages.PIMPage;
import Pages.LoginPage;
import Utils.Utils;
import setup.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.github.javafaker.Faker;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;



import java.io.IOException;
import java.util.List;

public class PIMTestRunner extends Setup {
    PIMPage pimPage;
    LoginPage loginPage;

    @BeforeTest
    public void doLogin() throws InterruptedException {
        loginPage = new LoginPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.doLogin("Admin", "admin123");
        Thread.sleep(5000);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "dashboard";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        List<WebElement> menus = driver.findElements(By.className("oxd-main-menu-item--name"));
        menus.get(1).click();
    }
    @Test(priority = 1, description = "Create First Employee")
    public void doAddFirstEmployee() throws InterruptedException, IOException, ParseException {
        pimPage = new PIMPage(driver);
        pimPage.addEmployeeLinkText.click();
        Thread.sleep(5000);
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userName = faker.name().username();
        String id = pimPage.inputFields.get(4).getAttribute("value");
        String password = "Str0ngP@ssword";

        pimPage.addEmployee(firstName,lastName, userName, password, password);
        Thread.sleep(10000);
        String expectedName = firstName + " " + lastName;
        List<WebElement> listH6 = driver.findElements(By.tagName("h6"));
        Utils.waitForElement(driver,listH6.get(1),50);
        String actualName = listH6.get(1).getText();
        Assert.assertTrue(actualName.contains(expectedName));
        if (listH6.get(1).isDisplayed()) {
            Utils.saveJsonList(userName, password, id);
        }
    }

    @Test(priority = 2, description = "Create Second Employee")
    public void doAddSecondEmployee() throws InterruptedException, IOException, ParseException {
        pimPage = new PIMPage(driver);
        pimPage.addEmployeeLinkText.click();
        Thread.sleep(5000);
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userName = faker.name().username();
        String id = pimPage.inputFields.get(4).getAttribute("value");
        String password = "Str0ngP@ssword";

        pimPage.addEmployee(firstName, lastName, userName, password, password);
        Thread.sleep(10000);
        String expectedName = firstName + " " + lastName;
        List<WebElement> listH6 = driver.findElements(By.tagName("h6"));
        Utils.waitForElement(driver, listH6.get(1), 50);
        String actualName = listH6.get(1).getText();
        Assert.assertTrue(actualName.contains(expectedName));
        if (listH6.get(1).isDisplayed()) {
            Utils.saveJsonList(userName, password, id);
        }
    }
        @Test(priority = 3, description = "Create employee with existing username")
        public void doFailedAddEmployee() throws InterruptedException, IOException, ParseException {
            pimPage = new PIMPage(driver);
            pimPage.addEmployeeLinkText.click();
            Thread.sleep(5000);
            String userName = Utils.getLastRegisteredUser();
            pimPage.checkUserName(userName);
            Assert.assertTrue(pimPage.userNameErrorMessage.isDisplayed());
        }


    }

