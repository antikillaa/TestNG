package firsttestngpackage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class dota2 {
    public String baseUrl = "http://dota2.ru";
    String driverPath = "//Users//stanislav.peshkur//Documents//webdriver//chromedriver";
    public WebDriver driver ;



    @Test
    public void verifyHomepageTitle() {

        System.out.println("launching Chrome browser");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1600, 1440));
        driver.get(baseUrl);
        //driver.close();
    }

    @Test
    public void verifyBlogpage() {
        System.out.println("launching Chrome browser");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1600, 1440));
        driver.get(baseUrl);
        driver.findElement(By.xpath(".//*[@id='global-wrap']/div[1]/section[2]/h2/a")).click();
        //driver.close();
    }

    @AfterMethod

    public void afterMethod() {
        driver.close();
    }

}