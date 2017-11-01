package Lobby.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

        private static WebElement element = null;
        public WebDriver driver;

    public static WebElement ButtonNavMenu(WebDriver driver) {
            element = driver.findElement( By.xpath( "//div[@class='border']" ));
            return element;
        }

    public static WebElement ButtonLock(WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='btn']/div[@class='btn-inner lock']" ));
        return element;
    }

    public static WebElement ButtonLogout(WebDriver driver) {
        element = driver.findElement( By.xpath( "//ul[@class='buttons']/li[3]//div[@class='btn-border']" ));
        return element;
    }

    public static WebElement ButtonSearch(WebDriver driver) {
        element = driver.findElement( By.xpath( "//a[@class='btn']/div[@class='btn-inner off']" ));
        return element;
    }

    public static WebElement ButtonAbout(WebDriver driver) {
        element = driver.findElement( By.xpath( "//div[@class='btn green']" ));
        return element;
    }

    public static WebElement ButtonHelp(WebDriver driver) {
        element = driver.findElement( By.xpath( "//div[@class='btn brown']" ));
        return element;
    }

    public static WebElement ButtonSettings(WebDriver driver) {
        element = driver.findElement( By.xpath( "//div[@class='btn blue']" ));
        return element;
    }

    }

