package Lobby.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Settings {
    private static WebElement element = null;
    public WebDriver driver;

    public static WebElement TextOptions(WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='gradient-text']" ));
        return element;
    }

    public static WebElement LinkGeneral(WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='icon m-general']" ));
        return element;
    }

    public static WebElement LinkSound(WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='icon m-sound']" ));
        return element;
    }

    public static WebElement LinkGame(WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='icon m-game']" ));
        return element;
    }

    public static WebElement ButtonOk(WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='btn-inner' and contains(text(), 'Ok')]" ));
        return element;
    }

}
