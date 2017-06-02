package firsttestngpackage;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class firsttestngfile {
    public String baseUrl = "http://newtours.demoaut.com/";
    String driverPath = "//Users//stanislav.peshkur//Documents//webdriver//geckodriver";
    public WebDriver driver ;

    @Test
    public void verifyHomepageTitle() {

        System.out.println("launching Chrome browser");
        System.setProperty("webdriver.firefox.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.close();
    }
}
