package BO.test;

import BO.ui.loginBOpage;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BOtests {

    public String baseUrl = "http://api.cd.d.skywind-tech.com:8000/";
    public WebDriver driver;
    private static final String driverPath = FilenameUtils.separatorsToSystem( "webdriver//chromedriver" );

    @BeforeMethod
    public void OpenUrl() {

        System.setProperty( "webdriver.chrome.driver", driverPath );
        driver = new ChromeDriver();
        driver.get( baseUrl );
        driver.manage().window().setSize( new Dimension( 1920, 1080 ) );
    }
/**
    @AfterMethod
    public void cleanup() {

        driver.quit();
    }
*/

public void login() {
    loginBOpage.TextBoxAccessKey( driver ).sendKeys( BO.testData.logins.AccessKeyDev_IBUSER );
    loginBOpage.ButtonAccessKey( driver ).click();
    loginBOpage.ButtonProceedWithKey( driver ).click();

    try {
        Thread.sleep( 1000 );
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    loginBOpage.TextBoxUsername( driver ).sendKeys( BO.testData.logins.LoginDev_IBUSER );
    loginBOpage.TextBoxPassword( driver ).sendKeys( BO.testData.logins.PasswordDev_IBUSER );
    loginBOpage.ButtonLogin( driver ).click();
    try {
        Thread.sleep( 1000 );
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }

    @Test()
    public void OpenBusinessManagment() throws InterruptedException {
    login();
    BO.ui.navigationPanel.LinkBusinessManagment( driver ).click();

    }

}
