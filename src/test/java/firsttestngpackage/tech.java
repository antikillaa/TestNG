import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class tech {

    public String baseUrl = "http://api.cd2.d.skywind-tech.com:8000/managekeys";
    public WebDriver driver;
    private static final String driverPath = FilenameUtils.separatorsToSystem( "webdriver//chromedriver" );
    public String usernameCD2 = "swftest_IB_USER";
    public String passwordCD2 = "swftest_QaZ321";
    public String keyCD2 = "85ea52c7-5dfb-4a18-978d-49db5d95f19e";

    @BeforeMethod
    public void OpenUrl() {

        System.setProperty( "webdriver.chrome.driver", driverPath );
        driver = new ChromeDriver();
        driver.get( baseUrl );
        driver.manage().window().setSize( new Dimension( 1920, 1080 ) );
    }

    @AfterMethod
    public void cleanup() {

        driver.quit();
        System.out.println( "Browser closed" );
    }

    public void loginCD2() {

    driver.findElement( By.xpath( "//div[@class='content']" +
            "//div[@class='input-group']" +
            "//input[@class='form-control ng-untouched ng-pristine ng-invalid']" )).sendKeys(keyCD2);

    driver.findElement( By.xpath( "//div[@class='content']" +
                "//div[@class='input-group']" +
                "//div[@class='input-group-btn']" )).click();

    driver.findElement( By.xpath( "//div[@class='content']" +
                "//button[@class='btn bg-slate-400 btn-block']")).click();

    driver.findElement( By.xpath( "//div[@class='content']" +
                "//button[@class='btn bg-slate-400 btn-block']")).click();

        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement( By.id( "inputUsername" )).sendKeys( usernameCD2 );
        driver.findElement( By.id( "inputPassword" )).sendKeys( passwordCD2 );

        driver.findElement( By.xpath( "//div[@class='content']" +
                "//button[@class='btn bg-slate-400 btn-block']")).click();
    }

    @Test(priority = 1)
    public void loginin() throws InterruptedException {

        loginCD2();

    }


}