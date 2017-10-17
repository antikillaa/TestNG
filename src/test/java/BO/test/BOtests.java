package BO.test;

import BO.testData.logins;
import BO.ui.loginBOpage;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
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
    loginBOpage.TextBoxAccessKey( driver ).sendKeys( logins.AccessKeySuperadmin );
    loginBOpage.ButtonAccessKey( driver ).click();
    loginBOpage.ButtonProceedWithKey( driver ).click();
    try {
        Thread.sleep( 1000 );
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    loginBOpage.TextBoxUsername( driver ).sendKeys( logins.LoginSuperAdmin );
    loginBOpage.TextBoxPassword( driver ).sendKeys( logins.PasswordSuperAdmin );
    loginBOpage.ButtonLogin( driver ).click();
    try {
        Thread.sleep( 2000 );
    } catch (InterruptedException e) {
        e.printStackTrace();
        }
    }



    @Test()
    public void OpenBusinessManagment() throws InterruptedException {
        login();
    BO.ui.navigationPanel.LinkBusinessManagment( driver ).click();
    BO.ui.navigationPanel.LinkAgents( driver ).click();

    }

    @Test()
    public void CreateAgent() throws InterruptedException {
            OpenBusinessManagment();
        Thread.sleep( 500 );
        BO.ui.AgentsPage.ButtonCreateAgent( driver ).click();
        Thread.sleep( 500 );
        BO.ui.CreateAgentPopup.TextBoxAgenttitle( driver ).sendKeys( "TestUser" + logins.RandomName);
        BO.ui.CreateAgentPopup.TextBoxDomain( driver ).sendKeys( logins.Domain );
        BO.ui.CreateAgentPopup.textBoxAffiliateID( driver ).sendKeys( logins.AffiliateID );
        BO.ui.CreateAgentPopup.ButtonSaveChanges( driver ).click();
    }

    @Test()
    public void OpenBusinessStructure() throws InterruptedException {
        login();
        BO.ui.navigationPanel.LinkBusinessManagment( driver ).click();
        BO.ui.navigationPanel.LinkBusinessStructure( driver ).click();

    }

}