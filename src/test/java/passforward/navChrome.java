package passforward;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class navChrome {

    public String baseUrl = "https://demo.passitforward.com/";
    String driverPath = "//Users//stanislav.peshkur//Documents//webdriver//chromedriver";
    public WebDriver driver;

    @Test
    public void Login() {
        System.setProperty("webdriver.chrome.driver", driverPath);
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

    @Test
    public void CheckProfileTabs() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.findElement(By.linkText("Got it!")).click();
        System.out.println("Side menu is open");
        driver.findElement(By.xpath("//div[@id='wrapper']//*[@id='big-sexy']//*[@class='icon-menu pearl']")).click();
        System.out.println("Nav panel opened");
        driver.findElement(By.xpath(".//*[@id='site-menu']/a[2]")).click();
        System.out.println("Login page is open");
        driver.findElement(By.xpath(".//*[@id='loginemail']")).sendKeys("stanislav.peshkur@skywindgroup.com");
        driver.findElement(By.xpath(".//*[@id='loginpassword']")).sendKeys("Zasatec}{12");
        driver.findElement(By.id("submitlogin")).click();
        System.out.println("User login!");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath(".//*[@id='dashboardTour']/a")).click();
        System.out.println("Dashboard opened!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath(".//*[@id='campaignsTour']/a")).click();
        System.out.println("Compaigns opened!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath(".//*[@id='givebacksTour']/a")).click();
        System.out.println("Givebacks opened!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath(".//*[@id='donationsTour']/a")).click();
        System.out.println("Donations opened!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();


        System.out.println("Browser closed");

    }


    @Test
    public void checkPassitForwardtoplink() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        System.out.println("Site is open");
        driver.manage().window().setSize(new Dimension(1024, 768));

        driver.findElement(By.xpath("//div[@id='wrapper']//a[@class='float-left']")).click();
        System.out.println("TopLinkClicked");

        driver.quit();
        System.out.println("Browser closed");
    }
}
