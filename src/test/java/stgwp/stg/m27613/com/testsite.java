package stgwp.stg.m27613.com;

import com.sun.tools.corba.se.idl.constExpr.ShiftLeft;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class testsite {

    public String baseUrl = "https://test-site.stg.m27613.com/";
    public WebDriver driver;
    private static final String driverPath = FilenameUtils.separatorsToSystem( "webdriver//chromedriver" );
    public String credentials = "{\n" +
            "  \"secretKey\": \"a6fcffac-4270-47a9-a821-299a883bd8be\",\n" +
            "  \"username\": \"swftest2_USER\",\n" +
            "  \"password\": \"123456qaB\"\n" +
            "}";
    public String username = "Testeri4";
    public String password = "Password!1";

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
    }

    public void login() {

    driver.findElement( By.id( "api_credential" ) ).clear();
    driver.findElement( By.id( "api_credential" ) ).sendKeys(credentials);
    driver.findElement( By.xpath( "//*[@id='settings']/div[3]/button[2]" )).click();

        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
/**
        Alert alert = driver.switchTo().alert();
        alert.accept();
*/
    driver.findElement( By.xpath( "//*[@id='sign_before']/button" ) ).click();

        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    driver.findElement( By.id( "sign_username" ) ).sendKeys( username );
    driver.findElement( By.id( "sign_password" ) ).clear();
    driver.findElement( By.id( "sign_password" ) ).sendKeys( password );
    driver.findElement( By.xpath( "//*[@id='sign']/div/div/div[4]/div[2]/button" ) ).click();

        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    public void checkGame(String title) {

        ArrayList<String> tabs1 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs1.get( 1 ) );

        try {
            Thread.sleep( 15000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String actual = driver.getTitle();
        Assert.assertEquals( actual, title );

        checkservererror();

        driver.close();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        try {
            Thread.sleep( 1000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String actual2 = driver.getTitle();
        Assert.assertEquals( actual2, title );

        checkservererror();

        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    public void checkservererror() {

        Boolean isPresent = driver.findElements(By.xpath( "//div[@class='wrapper-popup']//p[@class='popup-description']" )).size() > 0;
        Assert.assertFalse( isPresent);

    }

    @Test(priority = 1)
    public void Turtles() throws InterruptedException {
        String title = "888turtles";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_888t') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_888t') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void FuBaoBao() throws InterruptedException {
        String title = "Fu Bao Bao";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_fbb') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_fbb') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void FuFish() throws InterruptedException {
        String title = "Fu Fish";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_fufish_intw') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_fufish_intw') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void LegendofDragonKoi() throws InterruptedException {
        String title = "Legend of Dragon Koi";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_lodk') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_lodk') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void MrMonkeySlot() throws InterruptedException {
        String title = "Mr Monkey";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_mrmnky') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_mrmnky') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void RamessesFortune() throws InterruptedException {
        String title = "Ramesses Fortune";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_rf') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_rf') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void ShenLongBaoShi() throws InterruptedException {
        String title = "Shen Long Bao Shi";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_slbs') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_slbs') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void TigerCash() throws InterruptedException {
        String title = "Tiger Cash";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_tc') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_tc') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void DaHeiCiFu() throws InterruptedException {
        String title = "Da Hei Ci Fu";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_dhcf') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_dhcf') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void PandaChef() throws InterruptedException {
        String title = "Panda Chef";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_pc') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_pc') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void AmazonLady() throws InterruptedException {
        String title = "Amazon Lady";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_al') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_al') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void FlamingPhoenix() throws InterruptedException {
        String title = "Flaming Phoenix";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_fp') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_fp') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void GorillaMoon() throws InterruptedException {
        String title = "Gorilla Moon";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_gm') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_gm') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void MermaidsBeauty() throws InterruptedException {
        String title = "Mermaid Beauty";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_mer') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_mer') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void NewYearsFortune() throws InterruptedException {
        String title = "New Year's Fortune";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_nyf') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_nyf') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void RespinMania() throws InterruptedException {
        String title = "Respin Mania";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_rm') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_rm') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void SanFu() throws InterruptedException {
        String title = "San Fu";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_sf') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_sf') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void SymphonyOfDiamonds() throws InterruptedException {
        String title = "Symphony of Diamonds";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_sod') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_sod') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }


    @Test(priority = 1)
    public void YingCaiShen() throws InterruptedException {
        String title = "Ying Cai Shen";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_ycs') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_ycs') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void DoubleJungle() throws InterruptedException {
        String title = "Double Jungle";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_dj') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_dj') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void FuFISHJackpot() throws InterruptedException {
        String title = "Fu Fish Jackpot";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_fufish-jp') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_fufish-jp') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void DoubleBonus() throws InterruptedException {
        String title = "Double Bonus";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_db') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_db') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 6)
    public void FuFISH() throws InterruptedException {
        String title = "Fu Fish";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_fufish') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_fufish') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void GodofLightning() throws InterruptedException {
        String title = "God of Lightning";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_gol') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_gol') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void ManekiFortune() throws InterruptedException {
        String title = "Maneki Fortune";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_mf') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_mf') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void QueensofIceandFire() throws InterruptedException {
        String title = "QueensOfIceAndFire";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_qoiaf') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_qoiaf') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void RisingSamurai() throws InterruptedException {
        String title = "Rising Samurai";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_rs') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_rs') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void ShuiGuoCaiFu() throws InterruptedException {
        String title = "Shui Guo Cai Fu";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_sgcf') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_sgcf') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void SnowfallQueen() throws InterruptedException {
        String title = "Snowfall Queen";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_sq') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_sq') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void DolphinDelight() throws InterruptedException {
        String title = "Dolphin Delight";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_dd') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_dd') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void OldMasterQ() throws InterruptedException {
        String title = "Old Master Q";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_omqjp') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_omqjp') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void  WildQilin() throws InterruptedException {
        String title = "Wild Qilin";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_wq') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_wq') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void  GoldenGarden() throws InterruptedException {
        String title = "Golden Garden";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_ggdn') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_ggdn') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void  HeavenlyPhoenix() throws InterruptedException {
        String title = "Heavenly Phoenix";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_hp') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_hp') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void Sons1King() throws InterruptedException {
        String title = "9 Sons 1 King";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_9s1k') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_9s1k') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void LegendaryDragons() throws InterruptedException {
        String title = "Legendary Dragons";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_ld') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_ld') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void HearttoHeart() throws InterruptedException {
        String title = "Heart 2 Heart";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_h2h') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_h2h') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

}