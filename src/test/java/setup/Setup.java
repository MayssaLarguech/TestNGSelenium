package setup;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Utils.Utils;
import com.github.javafaker.Faker;

import java.time.Duration;
public class Setup {
    public WebDriver driver;
    @BeforeTest
    public void setup (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @AfterTest
    public void closeDriver() {
        driver.close();
    }
}