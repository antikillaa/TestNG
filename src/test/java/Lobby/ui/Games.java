package Lobby.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Games {
    private static WebElement element = null;
    public WebDriver driver;

    public static WebElement ButtonMinimize (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='inner' and contains(text(), '-')]" ));
        return element;
    }

    public static WebElement ButtonClose (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='inner' and contains(text(), '×')]" ));
        return element;
    }

    public static WebElement Turtles888 (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='wrapper' and contains(text(), '888 Turtles')]" ));
        return element;
    }

    public static WebElement AmazonLady (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='wrapper' and contains(text(), 'Amazon Lady')]" ));
        return element;
    }

    public static WebElement ChoisTravellingShow (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='wrapper' and contains(text(), 'Choi's Travelling Show')]" ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    public static WebElement DaHeiCiFuSlot (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='wrapper' and contains(text(), 'Da Hei Ci Fu Slot')]" ));
        return element;
    }

    public static WebElement DolphinDelight (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='wrapper' and contains(text(), 'Dolphin Delight')]" ));
        return element;
    }

    public static WebElement DoubleBonus (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='wrapper' and contains(text(), 'Double Bonus')]" ));
        return element;
    }

    public static WebElement FlamingPhoenix (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='wrapper' and contains(text(), 'Flaming Phoenix')]" ));
        return element;
    }

    public static WebElement Fortune777 (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='wrapper' and contains(text(), 'Fortune 777')]" ));
        return element;
    }

    public static WebElement FortuneCastle (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='wrapper' and contains(text(), 'Fortune Castle')]" ));
        return element;
    }

    public static WebElement FuBaoBao (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='wrapper' and contains(text(), 'Fu Bao Bao')]" ));
        return element;
    }

    public static WebElement GemKing (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='wrapper' and contains(text(), 'Gem King')]" ));
        return element;
    }

    public static WebElement GodofLightningSlot (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='wrapper' and contains(text(), 'God of Lightning Slot')]" ));
        return element;
    }

    public static WebElement GoldenGarden (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='wrapper' and contains(text(), 'Golden Garden')]" ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    public static WebElement GorillaMoon (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='wrapper' and contains(text(), 'Gorilla Moon')]" ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    public static WebElement HearttoHeart (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='wrapper' and contains(text(), 'Heart to Heart')]" ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    public static WebElement LegendofDragonKoi (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='wrapper' and contains(text(), 'Legend of Dragon Koi')]" ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    public static WebElement MagicofOz (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='wrapper' and contains(text(), 'Magic of Oz')]" ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    public static WebElement PandaChef (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='wrapper' and contains(text(), 'Panda Chef')]" ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        return element;
    }

    public static WebElement RespinMania (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='wrapper' and contains(text(), 'Respin Mania')]" ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    public static WebElement RamessesFortune (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='wrapper' and contains(text(), 'Ramesses Fortune')]" ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        return element;
    }

    public static WebElement SanFu (WebDriver driver) {
        element = driver.findElement( By.xpath( "//span[@class='wrapper' and contains(text(), 'San Fu')]" ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        return element;
    }

}
