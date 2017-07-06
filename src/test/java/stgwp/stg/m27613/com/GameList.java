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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public void Gamelist() throws IOException {

        FileReader file = new FileReader( new File( "/Users/stanislav.peshkur/Documents/TestNG/src/test/java/stgwp/stg/m27613/com/source.txt" ) );

        BufferedReader read = new BufferedReader( file );

        String line = null;

        while ((line = read.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                if (Character.isLetter( line.charAt( i ) )) {
                    System.out.print( line.charAt( i ) );
                }
            }
        }
    }
}
