package Lobby.tests;

import BO.testData.logins;
import BO.ui.loginBOpage;
import Lobby.testData;
import org.apache.commons.io.FilenameUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import java.util.ArrayList;


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

    public void CheckMainPage() {
        Lobby.ui.MainPage.ButtonLogout( driver );
        Lobby.ui.MainPage.ButtonAbout( driver );
        Lobby.ui.MainPage.ButtonHelp( driver );
        Lobby.ui.MainPage.ButtonLock( driver );
        Lobby.ui.MainPage.ButtonLogout( driver );
        Lobby.ui.MainPage.ButtonNavMenu( driver );
        Lobby.ui.MainPage.ButtonSearch( driver );
        Lobby.ui.MainPage.ButtonSettings( driver );
    }

    public void CheckLoginPage() {
        Lobby.ui.LoginPage.ButtonLogin( driver );
        Lobby.ui.LoginPage.TextBoxPassoword( driver );
        Lobby.ui.LoginPage.TextBoxPlayerCode( driver );
        Lobby.ui.LoginPage.ButtonLogin( driver ).click();
        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Lobby.ui.LoginPage.TextInvalidError( driver );
    }

    public void CheckTitle() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, testData.Title);
    }

    public void CheckNavPanel() {
        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Lobby.ui.MainPage.ButtonNavMenu( driver ).click();
        Lobby.ui.GameCategoriesNavigation.LinkAllSkywindGames( driver );
        Lobby.ui.GameCategoriesNavigation.LinkBestRated( driver );
        Lobby.ui.GameCategoriesNavigation.LinkHotSlots( driver );
        Lobby.ui.GameCategoriesNavigation.LinkNewGames( driver );
        Lobby.ui.GameCategoriesNavigation.LinkPTLiveGames( driver );
        Lobby.ui.MainPage.ButtonNavMenu( driver ).click();
    }


    public void Login() {
        CheckLoginPage();
        Lobby.ui.LoginPage.TextBoxPlayerCode(driver).sendKeys( testData.PlayerCode );
        Lobby.ui.LoginPage.TextBoxPassoword(driver).sendKeys( testData.Password );
        Lobby.ui.LoginPage.ButtonLogin(driver).click();

        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CheckInstallationPage();
        CheckTitle();
        CheckMainPage();
    }

    public void Logout() {
        Lobby.ui.MainPage.ButtonLogout( driver ).click();
        CheckLoginPage();

    }

    public void LoginBO() {
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

    public void checkservererror() {

        Boolean isPresent = driver.findElements(By.xpath( "//div[@class='wrapper-popup']//p[@class='popup-description']" )).size() > 0;
        Assert.assertFalse( isPresent);

    }


    public void Lock() {
        Lobby.ui.MainPage.ButtonLock( driver ).click();
        CheckLoginPage();

    }

    public void CheckOptions() {
        Lobby.ui.MainPage.ButtonSettings( driver ).click();
        //check elements
        Lobby.ui.Settings.TextOptions( driver );
        Lobby.ui.Settings.LinkGeneral( driver ).click();
        Lobby.ui.Settings.LinkSound( driver ).click();
        Lobby.ui.Settings.LinkGame( driver ).click();
        Lobby.ui.Settings.ButtonOk( driver ).click();
    }

    @Test
    public void LoginToLobby() throws InterruptedException {
        Login();
    }


    @Test
    public void LogoutLobby() throws InterruptedException {
        Login();
        Logout();
    }

    @Test
    public void NavPanel() throws InterruptedException {
        Login();
        CheckNavPanel();
        Logout();
    }

    @Test
    public void AboutPage() throws InterruptedException {
        Login();
        Lobby.ui.MainPage.ButtonAbout( driver ).click();
        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );
        driver.close();
        driver.switchTo().window( tabs2.get( 0 ) );
        Logout();
    }

    @Test
    public void HelpPage() throws InterruptedException {
        Login();
        Lobby.ui.MainPage.ButtonHelp( driver ).click();
        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );
        driver.close();
        driver.switchTo().window( tabs2.get( 0 ) );
        Logout();
    }

    @Test
    public void CheckTabsOptions() throws InterruptedException {
        Login();
        CheckOptions();
    }


    @Test
    public void Turtles888() throws InterruptedException {
        Login();
        Lobby.ui.Games.Turtles888( driver ).click();
        Thread.sleep( 10000 );
        checkservererror();
        Lobby.ui.Games.ButtonClose( driver ).click();
    }

    @Test
    public void AmazonLady() throws InterruptedException {
        Login();
        Lobby.ui.Games.AmazonLady( driver ).click();
        Thread.sleep( 10000 );
        checkservererror();
        Lobby.ui.Games.ButtonClose( driver ).click();
    }

    @Test
    public void ChoisTravellingShow() throws InterruptedException {
        Login();
        Lobby.ui.Games.ChoisTravellingShow( driver ).click();
        Thread.sleep( 10000 );
        checkservererror();
        Lobby.ui.Games.ButtonClose( driver ).click();
    }

    @Test
    public void DaHeiCiFuSlot() throws InterruptedException {
        Login();
        Lobby.ui.Games.DaHeiCiFuSlot( driver ).click();
        Thread.sleep( 10000 );
        checkservererror();
        Lobby.ui.Games.ButtonClose( driver ).click();
    }

    @Test
    public void DolphinDelight() throws InterruptedException {
        Login();
        Lobby.ui.Games.DolphinDelight( driver ).click();
        Thread.sleep( 10000 );
        checkservererror();
        Lobby.ui.Games.ButtonClose( driver ).click();
    }

    @Test
    public void DoubleBonus() throws InterruptedException {
        Login();
        Lobby.ui.Games.DoubleBonus( driver ).click();
        Thread.sleep( 10000 );
        checkservererror();
        Lobby.ui.Games.ButtonClose( driver ).click();
    }

    @Test
    public void FlamingPhoenix() throws InterruptedException {
        Login();
        Lobby.ui.Games.FlamingPhoenix( driver ).click();
        Thread.sleep( 10000 );
        checkservererror();
        Lobby.ui.Games.ButtonClose( driver ).click();
    }

    @Test
    public void Fortune777() throws InterruptedException {
        Login();
        Lobby.ui.Games.Fortune777( driver ).click();
        Thread.sleep( 10000 );
        checkservererror();
        Lobby.ui.Games.ButtonClose( driver ).click();
    }

    @Test
    public void FortuneCastle() throws InterruptedException {
        Login();
        Lobby.ui.Games.FortuneCastle( driver ).click();
        Thread.sleep( 10000 );
        checkservererror();
        Lobby.ui.Games.ButtonClose( driver ).click();
    }

    @Test
    public void FuBaoBao() throws InterruptedException {
        Login();
        Lobby.ui.Games.FuBaoBao( driver ).click();
        Thread.sleep( 10000 );
        checkservererror();
        Lobby.ui.Games.ButtonClose( driver ).click();
    }

    @Test
    public void GemKing() throws InterruptedException {
        Login();
        Lobby.ui.Games.GemKing( driver ).click();
        Thread.sleep( 10000 );
        checkservererror();
        Lobby.ui.Games.ButtonClose( driver ).click();
    }

    @Test
    public void GodofLightningSlot() throws InterruptedException {
        Login();
        Lobby.ui.Games.GodofLightningSlot( driver ).click();
        Thread.sleep( 10000 );
        checkservererror();
        Lobby.ui.Games.ButtonClose( driver ).click();
    }

    @Test
    public void GoldenGarden() throws InterruptedException {
        Login();
        Lobby.ui.Games.GoldenGarden( driver ).click();
        Thread.sleep( 10000 );
        checkservererror();
        Lobby.ui.Games.ButtonClose( driver ).click();
    }

    @Test
    public void GorillaMoon() throws InterruptedException {
        Login();
        Lobby.ui.Games.GorillaMoon( driver ).click();
        Thread.sleep( 10000 );
        checkservererror();
        Lobby.ui.Games.ButtonClose( driver ).click();
    }

    @Test
    public void HearttoHeart() throws InterruptedException {
        Login();
        Lobby.ui.Games.HearttoHeart( driver ).click();
        Thread.sleep( 10000 );
        checkservererror();
        Lobby.ui.Games.ButtonClose( driver ).click();
    }

    @Test
    public void LegendofDragonKoi() throws InterruptedException {
        Login();
        Lobby.ui.Games.LegendofDragonKoi( driver ).click();
        Thread.sleep( 10000 );
        checkservererror();
        Lobby.ui.Games.ButtonClose( driver ).click();
    }

    @Test
    public void MagicofOz() throws InterruptedException {
        Login();
        Lobby.ui.Games.MagicofOz( driver ).click();
        Thread.sleep( 10000 );
        checkservererror();
        Lobby.ui.Games.ButtonClose( driver ).click();
    }

    @Test
    public void PandaChef() throws InterruptedException {
        Login();
        Lobby.ui.Games.PandaChef( driver ).click();
        Thread.sleep( 10000 );
        checkservererror();
        Lobby.ui.Games.ButtonClose( driver ).click();
    }

    @Test
    public void RamessesFortune() throws InterruptedException {
        Login();
        Lobby.ui.Games.RamessesFortune( driver ).click();
        Thread.sleep( 10000 );
        checkservererror();
        Lobby.ui.Games.ButtonClose( driver ).click();
    }

    @Test
    public void RespinMania() throws InterruptedException {
        Login();
        Lobby.ui.Games.RespinMania( driver ).click();
        Thread.sleep( 10000 );
        checkservererror();
        Lobby.ui.Games.ButtonClose( driver ).click();
    }

    @Test
    public void SanFu() throws InterruptedException {
        Login();
        Lobby.ui.Games.SanFu( driver ).click();
        Thread.sleep( 10000 );
        checkservererror();
        Lobby.ui.Games.ButtonClose( driver ).click();
    }

    @After
    public void teardown() {
        driver.quit();
    }




}
