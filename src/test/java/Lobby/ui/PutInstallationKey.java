package Lobby.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PutInstallationKey {

    private static WebElement element = null;
    public WebDriver driver;

    public static WebElement TextBoxToken(WebDriver driver) {
        element = driver.findElement( By.xpath( "//div[@class='section']/textarea[@class='input area ng-untouched ng-pristine ng-valid']" ) );
        return element;
    }

    public static WebElement ButtonNext(WebDriver driver) {
        element = driver.findElement( By.xpath( "//div[@class='install']/div[@class='footer']/span[@class='btn next']" ) );
        return element;
    }

}
