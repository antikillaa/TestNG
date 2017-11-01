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
        element = driver.findElement( By.xpath( "//button[@class='btn-square-inner']" ));
        return element;
    }

    public static WebElement TextInvalidError(WebDriver driver) {
        element = driver.findElement( By.xpath("//div[@class='login-form']/form[@class='form ng-untouched ng-pristine ng-valid']/div[@class='form-error']"));
        return element;
    }

}
