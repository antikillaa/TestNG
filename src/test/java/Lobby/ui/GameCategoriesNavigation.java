package Lobby.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GameCategoriesNavigation {

    private static WebElement element = null;
    public WebDriver driver;

    public static WebElement LinkAllSkywindGames(WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='link']/span[@class='name' and contains(text(), 'All Skywind Games')]" ));
        return element;
    }

    public static WebElement LinkBestRated(WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='link']/span[@class='name' and contains(text(), 'Best Rated')]" ));
        return element;
    }

    public static WebElement LinkHotSlots(WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='link']/span[@class='name' and contains(text(), 'Hot Slots')]" ));
        return element;
    }

    public static WebElement LinkNewGames(WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='link']/span[@class='name' and contains(text(), 'New Games')]" ));
        return element;
    }

    public static WebElement LinkPTLiveGames(WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='link']/span[@class='name' and contains(text(), 'PT Live Games')]" ));
        return element;
    }




}
