package Lobby.tests;

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
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        }

        @Test
        public void test() throws InterruptedException {


            }


    @After
    public void teardown() {
        driver.quit();
    }
    }
