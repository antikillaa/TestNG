package stgwp.stg.m27613.com;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.mustache.Value;

import javax.xml.soap.Text;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.jar.Attributes;
import java.util.stream.Stream;

import static java.lang.System.in;

/**
 * Created by stanislav.peshkur on 6/28/17.
 */
public class GameList {

    public String baseUrl = "http://stgwp.stg.m27613.com";
    public WebDriver driver;
    private static final String driverPath = FilenameUtils.separatorsToSystem( "webdriver//chromedriver" );

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

        driver.findElement( By.id( "menu-item-172" ) ).click();
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
    public void AmazonLadySlot() throws InterruptedException {

        driver.findElement( By.xpath( "//div[@class='game-title']" +
                "//div[@class='game-title-text' and contains(text(), 'Fu FISH')]" ) ).click();
        System.out.println( "Game popup is open" );

        selectGame();

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
    public void game() throws InterruptedException {

        List<WebElement> elements = driver.findElements( By.xpath( "//div[@class='game-title']//div[@class='game-title-text']" ) );

        for(int i = 0; i < elements.size(); i++) {
            //driver.findElement( By.xpath( "//div[@class='game-title']//div[@class='game-title-text']" ) ).getText();
            System.out.print(elements.get(i));
        }


        driver.close();
    }


    public void selectGame() {
        List<WebElement> elements = driver.findElements( By.xpath( "//div[@class='game-title']//div[@class='game-title-text']" ) );

        for(int i = 0; i < elements.size(); i++) {
            driver.findElement( By.xpath( "//div[@class='game-title']//div[@class='game-title-text']" ) ).getText();
            System.out.print(elements.get(i));
        }


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



