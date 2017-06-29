package passforward;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class navFirefox {

    public String baseUrl = "https://demo.passitforward.com/";
    String driverPathFF = "//Users//stanislav.peshkur//Documents//webdriver//geckodriver";
    String driverPathChr = "//Users//stanislav.peshkur//Documents//webdriver//chromedriver";
    public WebDriver driver;

    @Test
    public void LoginFirefox() {
        System.setProperty("webdriver.firefox.driver", driverPathFF);
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        driver.manage().window().setSize(new Dimension(1024, 768));
        //driver.findElement(By.linkText("Got it!")).click();

        System.out.println("Side menu is open");

        WebElement element = driver.findElement(By.xpath("//div[@id='wrapper']//*[@id='big-sexy']//*[@class='icon-menu pearl']"));
        element.click();
        System.out.println("Nav panel opened");


        driver.findElement(By.xpath("//div[@id='site-menu']//*[@class='btn btns btn-square bluish-green-bg pearl f13 bold']")).click();
        System.out.println("Login page is open");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath(".//*[@id='loginemail']")).sendKeys("antikillaaaa@gmail.com");
        driver.findElement(By.xpath(".//*[@id='loginpassword']")).sendKeys("Zasatec}{12");
        driver.findElement(By.id("submitlogin")).click();

        System.out.println("User login!");

        driver.quit();

        System.out.println("Browser closed");

    }


    @Test (priority = 1)
    public void LoginChrome() {
        System.setProperty("webdriver.chrome.driver", driverPathChr);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.findElement(By.linkText("Got it!")).click();

        System.out.println("Side menu is open");

        //driver.findElement(By.xpath("//div[@id='wrapper']//*[@id='big-sexy']/*[@class='icon-menu pearl']")).click();

        driver.findElement(By.xpath("//div[@id='wrapper']//*[@id='big-sexy']//*[@class='icon-menu pearl']")).click();

        //WebElement element = driver.findElement(By.xpath("//div[@id='wrapper']//*[@id='big-sexy']/*[@class='icon-menu pearl']"));
        //element.click();
        System.out.println("Nav panel opened");
        driver.findElement(By.xpath(".//*[@id='site-menu']/a[2]")).click();



        System.out.println("Login page is open");
        driver.findElement(By.xpath(".//*[@id='loginemail']")).sendKeys("antikillaaaa@gmail.com");
        driver.findElement(By.xpath(".//*[@id='loginpassword']")).sendKeys("Zasatec}{12");
        driver.findElement(By.id("submitlogin")).click();

        System.out.println("User login!");

        driver.quit();

        System.out.println("Browser closed");

    }

}
