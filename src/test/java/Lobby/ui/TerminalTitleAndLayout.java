package Lobby.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TerminalTitleAndLayout {

    private static WebElement element = null;
    public WebDriver driver;

    public static WebElement TextBoxTitle(WebDriver driver) {
        element = driver.findElement( By.xpath( "//div[@class='section']/input[@class='input title ng-untouched ng-pristine ng-valid']" ) );
        return element;
    }

    public static WebElement ButtonBioshockLobby(WebDriver driver) {
        element = driver.findElement( By.xpath( "//div[@class='carousel-caption']/div[@class='carousel-title' and contains(text(), 'Bioshock lobby')]" ) );
        return element;
    }

    public static WebElement ButtonAnotherCrownLobby(WebDriver driver) {
        element = driver.findElement( By.xpath( "//div[@class='carousel-caption']/div[@class='carousel-title' and contains(text(), 'Another crown lobby')]" ) );
        return element;
    }

    public static WebElement ButtonAnotherDefaultLobby(WebDriver driver) {
        element = driver.findElement( By.xpath( "//div[@class='carousel-caption']/div[@class='carousel-title' and contains(text(), 'Another default lobby')]" ) );
        return element;
    }

    public static WebElement ButtonBack(WebDriver driver) {
        element = driver.findElement( By.xpath( "//div[@class='footer']/span[@class='btn back']" ) );
        return element;
    }

    public static WebElement ButtonCreateTerminal(WebDriver driver) {
        element = driver.findElement( By.xpath( "//div[@class='footer']/span[@class='btn']" ) );
        return element;
    }

}
