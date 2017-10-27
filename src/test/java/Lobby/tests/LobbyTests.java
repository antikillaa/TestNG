package Lobby.tests;

import Lobby.testData;
import org.apache.commons.io.FilenameUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@RunWith(JUnit4.class)
public class LobbyTests {
    public WebDriver driver;
    private static final String driverPath = FilenameUtils.separatorsToSystem( "webdriver//chromedriver" );

        @Before
        public void setup() {
            System.setProperty( "webdriver.chrome.driver", driverPath );
            ChromeOptions opt = new ChromeOptions();
            opt.setBinary( "electron/sw-lobby.app/contents/MacOS/sw-lobby" );
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability( "chromeOptions", opt );
            capabilities.setBrowserName( "chrome" );

            driver = new ChromeDriver( capabilities );
            if (driver.findElements( By.id( "button-about" ) ).size() > 0)
                driver.findElement( By.id( "button-about" ) ).click();

            try {
                Thread.sleep( 3000 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    public void InstallationPage() {
        Lobby.ui.PutInstallationKey.TextBoxToken( driver ).sendKeys( testData.InstallationKey);

        Actions act = new Actions(driver);
        act.moveToElement(Lobby.ui.PutInstallationKey.ButtonNext( driver ), 30, 30).click().build().perform();

        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Actions act2 = new Actions(driver);
        act2.moveToElement(Lobby.ui.PutInstallationKey.ButtonNext( driver ), 30, 30).click().build().perform();
        Lobby.ui.TerminalTitleAndLayout.TextBoxTitle( driver ).sendKeys( testData.TerminalTitle );
        Lobby.ui.TerminalTitleAndLayout.ButtonBioshockLobby( driver ).click();
        Lobby.ui.TerminalTitleAndLayout.ButtonCreateTerminal( driver ).click();

    }


    public void CheckInstallationPage() {
        if (driver.findElements(By.xpath( "//div[@class='section']/textarea[@class='input area ng-untouched ng-pristine ng-valid']" ) ).size() > 0)
            InstallationPage();
    }

    public void Login() {
        Lobby.ui.LoginPage.TextBoxPlayerCode(driver).sendKeys( testData.PlayerCode );
        Lobby.ui.LoginPage.TextBoxPassoword(driver).sendKeys( testData.Password );
        Lobby.ui.LoginPage.ButtonLogin(driver).click();
    }


    @Test
        public void LoginToLobby() throws InterruptedException {
            CheckInstallationPage();
            Login();
            }


    @After
    public void teardown() {
        driver.quit();
    }
    }
