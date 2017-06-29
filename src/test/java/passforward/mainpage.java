package passforward;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class mainpage {

    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception {
        //Check if parameter passed from TestNG is 'firefox'
        if (browser.equalsIgnoreCase("firefox")) {
            //create firefox instance
            System.setProperty("webdriver.firefox.driver", "//Users//stanislav.peshkur//Documents//webdriver//geckodriver");
            driver = new FirefoxDriver();
            driver.manage().window().setSize(new Dimension(1024, 768));

            driver.get("https://demo.passitforward.com/");

        }
        //Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("chrome")) {
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver", "//Users//stanislav.peshkur//Documents//webdriver//chromedriver");
            //create chrome instance
            driver = new ChromeDriver();
            driver.manage().window().setSize(new Dimension(1024, 768));
            driver.get("https://demo.passitforward.com/");

        } else {
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void opensite() throws InterruptedException {
        driver.manage().window().setSize(new Dimension(1024, 768));
        System.out.println("Side menu is open");

        driver.findElement(By.xpath("//div[@id='wrapper']//*[@id='big-sexy']/*[@class='icon-menu pearl']")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Nav panel opened");
        driver.findElement(By.xpath(".//*[@id='site-menu']/a[2]")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Login page is open");
        driver.findElement(By.xpath(".//*[@id='loginemail']")).sendKeys("antikillaaaa@gmail.com");
        driver.findElement(By.xpath(".//*[@id='loginpassword']")).sendKeys("Zasatec}{12");
        driver.findElement(By.xpath(".//*[@id='submitlogin']")).submit();

        System.out.println("User login!");

    }



    @AfterTest
    @Parameters("browser")
    public void quit(String browser) throws Exception {
        if (browser.equalsIgnoreCase("firefox")) {
            driver.close();
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver.close();
        }
    }
}