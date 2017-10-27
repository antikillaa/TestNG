package Lobby.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private static WebElement element = null;
    public WebDriver driver;

    public static WebElement TextBoxPlayerCode(WebDriver driver) {
        element = driver.findElement( By.name( "playerCode" ));
        return element;
    }

    public static WebElement TextBoxPassoword(WebDriver driver) {
        element = driver.findElement( By.name( "password" ));
        return element;
    }

    public static WebElement ButtonLogin(WebDriver driver) {
        element = driver.findElement( By.xpath( "//div[@class='btn-square']/button[@class='btn-square-inner']" ));
        return element;
    }

}
