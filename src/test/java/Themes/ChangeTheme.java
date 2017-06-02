package Themes;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;


public class ChangeTheme {
    public String baseUrl = "http://qawp.stg.m27613.com/admin";
    String driverPath = "//Users//stanislav.peshkur//Documents//webdriver//chromedriver";
    public WebDriver driver;


    @Test(priority = 0)
    public void ChangeToGoldTheme() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.findElement(By.xpath(".//*[@id='userц_login']")).sendKeys("admin");
        driver.findElement(By.xpath(".//*[@id='user_pass']")).sendKeys("TGt*ZEpy)q0io(*PaU");
        driver.findElement(By.xpath(".//*[@id='user_pass']")).submit();
        System.out.println("User login!!!");
        Actions action = new Actions(driver);
        //WebElement we = driver.findElement(By.xpath(".//*[@id='menu-appearance']/a/div[2]"));
        //action.moveToElement(we).build().perform();
        //driver.findElement(By.xpath(".//*[@id='menu-appearance']/ul/li[2]/a")).click();
        driver.findElement(By.xpath(".//*[@id='menu-appearance']/a/div[2]")).click();
        driver.findElement(By.xpath(".//*[@id='og02-name']")).click();

    }


}

