package TestDemoSite;

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

/**
 * Created by stanislav.peshkur on 6/28/17.
 */
public class CheckGamesReal {

    public String baseUrl = "https://skywindportal.com/";
    public WebDriver driver;
    private static final String driverPath = FilenameUtils.separatorsToSystem("webdriver//chromedriver");

    @BeforeMethod
    public void LoginGamePageOpens() {

        System.setProperty( "webdriver.chrome.driver", driverPath );
        driver = new ChromeDriver();
        driver.get( baseUrl );
        driver.manage().window().setSize( new Dimension( 1920, 1080 ) );
        System.out.println( "Site is open" );

        driver.findElement( By.name( "username" ) ).sendKeys( "Testeri4" );
        driver.findElement( By.name( "password" ) ).sendKeys( "Zasatec}{123" );
        driver.findElement( By.name( "password" ) ).submit();
        System.out.println( "User login!!!" );

        driver.findElement( By.id( "menu-item-616" ) ).click();
        System.out.println( "Game page is opened!!!" );

        driver.findElement( By.xpath( "//div[@class='game-sort-selected']" ) ).click();

        driver.findElement( By.xpath( "//div[@class='game-sort-list with-labels']" +
                "/div[@data-filter='.vendor-filter-sw']" ) ).click();
    }

    @AfterMethod
    public void cleanup() {

        driver.quit();
        System.out.println( "Browser closed" );
    }


    @Test(priority = 1)
    public void Check888turtlesGame() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), '888 Turtles')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "888turtles";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();

    }

    @Test(priority = 1)
    public void AmazonLadySlot() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Amazon Lady Slot')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Amazon Lady";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void CheckDolphinDelightGame() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Dolphin Delight')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Dolphin Delight";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void CheckDoubleBonusGame() throws InterruptedException {
        Thread.sleep( 5000 );

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Double Bonus Slot')]" ) ).click();


        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Double Bonus";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void CheckFlamingPhoenixSlotGame() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Flaming Phoenix Slot')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Flaming Phoenix";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void FuBaoBao() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Fu Bao Bao')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Fu Bao Bao";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void GodofLightningSlot() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'God of Lightning Slot')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "God of Lightning";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void GoldenGarden() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Golden Garden')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Golden Garden";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void GorillaMoon() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Gorilla Moon')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Gorilla Moon";
        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void LegendofDragonKoi() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Legend of Dragon Koi')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Legend of Dragon Koi";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void ManekiFortunes() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Maneki Fortunes')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Maneki Fortune";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void MayaWheelofLuck() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Maya Wheel of Luck')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Maya Wheel of Luck";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void MermaidsBeautySlot() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Mermaids Beauty Slot')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Mermaid Beauty";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void MrMonkeySlot() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Mr Monkey Slot')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Mr Monkey";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void NewYearsFortune() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'New Years Fortune')]" ) ).click();

        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "New Year's Fortune";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void OldMasterQSlot() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Old Master Q Slot')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Old Master Q";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void PandaChefSlot() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Panda Chef Slot')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Panda Chef";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void RamessesFortune() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Ramesses Fortune')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Ramesses Fortune";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void RespinMania() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Respin Mania')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Respin Mania";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void SanFu() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'San Fu')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "San Fu";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void ShenLongBaoShi() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Shen Long Bao Shi')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Shen Long Bao Shi";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void ShengCaiYouDao() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Sheng Cai You Dao')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Sheng Cai You Dao";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void ShuiGuoCaiFu() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Shui Guo Cai Fu')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Shui Guo Cai Fu";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void SnowfallQueen() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Snowfall Queen')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Snowfall Queen";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void SymphonyOfDiamonds() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Symphony Of Diamonds')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Symphony of Diamonds";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void YingCaiShen() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Ying Cai Shen')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Ying Cai Shen";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    @Test(priority = 1)
    public void FuFISH() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Fu FISH')]" ) ).click();
        System.out.println( "Game popup is open" );

        launchGame();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        Thread.sleep( 10000 );

        String actualTitle = "Fu Fish";

        String expectTitle = driver.getTitle();
        Assert.assertEquals( expectTitle, actualTitle );

        driver.close();
        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }


    public void launchGame() {
        driver.findElement( By.xpath( "//div[@class='play-now-btn display-block']//a[@class='modal-game-btn']" ) ).click();
        System.out.println( "Game is launched" );
        try {
            Thread.sleep( 1000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
