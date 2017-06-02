package SiteBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.*;

public class MainPage {

    public String baseUrl = "http://qawp.stg.m27613.com/";
    String driverPath = "//Users//stanislav.peshkur//Documents//webdriver//chromedriver";
    public WebDriver driver ;

/**
    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception{
        if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.firefox.driver", "//Users//stanislav.peshkur//Documents//webdriver//geckodriver");
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","//Users//stanislav.peshkur//Documents//webdriver//chromedriver");
            driver = new ChromeDriver();
        }
        else{
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
*/

    @Test (priority = 0)
    public void Login() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.findElement(By.className("site-header-login-icon")).click();
        driver.findElement(By.name("username")).sendKeys("Testeri4");
        driver.findElement(By.name("password")).sendKeys("Zasatec}{123");
        driver.findElement(By.name("password")).submit();
        System.out.println("User login!!!");
    }

    @Test (priority = 1)
    public void GamePage() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.findElement(By.className("site-header-login-icon")).click();
        driver.findElement(By.name("username")).sendKeys("Testeri4");
        driver.findElement(By.name("password")).sendKeys("Zasatec}{123");
        driver.findElement(By.name("password")).submit();
        System.out.println("User login!!!");
        driver.findElement(By.xpath(".//*[@id='masthead']/div[3]/div/button")).click();
        driver.findElement(By.xpath(".//*[@id='menu-item-408']/a")).click();
        System.out.println("Game page is opened!!!");
    }

    @AfterMethod

    public void afterMethod() {

        driver.close();
    }

}
