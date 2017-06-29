package GamePopup;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;


public class Template {

    public String baseUrl = "http://stgwp.stg.m27613.com";
    String driverPath = "//Users//stanislav.peshkur//Documents//webdriver//chromedriver";
    public WebDriver driver;


    @Test(priority = 0)
    public void LoginLogout() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().setSize(new Dimension(1280, 768));
        System.out.println("Site is open");

        driver.findElement(By.name("username")).sendKeys("Testeri4");
        driver.findElement(By.name("password")).sendKeys("Zasatec}{123");
        driver.findElement(By.name("password")).submit();
        System.out.println("User login!!!");

        Thread.sleep(3500);

        driver.findElement(By.xpath("//div[@class='site']//div[@class='site-header-lower-container']" +
                "//div[@class='site-header-columns site-container']" +
                "//div[@class='site-header-loggedin-container flyout-layer']" +
                "//div[@class='site-header-user-nav']" +
                "//div[@class='site-header-user-nav-icon']")).click();
        System.out.println("Nav button opened");
        driver.findElement(By.linkText("Logout")).click();
        System.out.println("User logout");

        driver.close();
        System.out.println("Browser closed");
    }

    @Test(priority = 1)
    public void OpenMyProfile() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().setSize(new Dimension(1280, 768));
        System.out.println("Site is open");

        driver.findElement(By.name("username")).sendKeys("Testeri4");
        driver.findElement(By.name("password")).sendKeys("Zasatec}{123");
        driver.findElement(By.name("password")).submit();
        System.out.println("User login!!!");

        Thread.sleep(3500);

        driver.findElement(By.xpath("//div[@class='site']//div[@class='site-header-lower-container']" +
                "//div[@class='site-header-columns site-container']" +
                "//div[@class='site-header-loggedin-container flyout-layer']" +
                "//div[@class='site-header-user-nav']" +
                "//div[@class='site-header-user-nav-icon']")).click();
        System.out.println("Nav button opened");
        driver.findElement(By.linkText("Profile")).click();
        System.out.println("Profile page is opened");

        driver.close();
        System.out.println("Browser closed");
    }

    @Test(priority = 0)
    public void ChangeProfileInformation() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().setSize(new Dimension(1280, 768));
        System.out.println("Site is open");

        driver.findElement(By.name("username")).sendKeys("Testeri4");
        driver.findElement(By.name("password")).sendKeys("Zasatec}{123");
        driver.findElement(By.name("password")).submit();
        System.out.println("User login!!!");

        driver.findElement(By.xpath("//div[@class='site']//div[@class='site-header-lower-container']" +
                "//div[@class='site-header-columns site-container']" +
                "//div[@class='site-header-loggedin-container flyout-layer']" +
                "//div[@class='site-header-user-nav']" +
                "//div[@class='site-header-user-nav-icon']")).click();
        System.out.println("Nav button opened");

        driver.findElement(By.linkText("Profile")).click();
        System.out.println("Profile page is opened");

        driver.findElement(By.id("registration_form-2sdfsdfs-firstname")).clear();
        driver.findElement(By.id("registration_form-2sdfsdfs-firstname")).sendKeys("testname");
        System.out.println("First name changed");

        driver.findElement(By.id("registration_form-2sdfsdfs-lastname")).clear();
        driver.findElement(By.id("registration_form-2sdfsdfs-lastname")).sendKeys("testlastname");
        System.out.println("Last name changed");

        new Select (driver.findElement(By.className("day"))).selectByValue("");
        new Select (driver.findElement(By.className("month"))).selectByValue("");
        new Select (driver.findElement(By.className("year"))).selectByValue("");

        new Select (driver.findElement(By.className("day"))).selectByValue("03");
        new Select (driver.findElement(By.className("month"))).selectByValue("06");
        new Select (driver.findElement(By.className("year"))).selectByValue("1987");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Changes submitted");

        String actualFirstname =
                driver.findElement(By.id("registration_form-2sdfsdfs-firstname")).getAttribute("value");
        String expectFirstname = "testname";
        Assert.assertEquals(actualFirstname, expectFirstname);
        System.out.println("First name Expected");

        String actualLastname =
                driver.findElement(By.id("registration_form-2sdfsdfs-lastname")).getAttribute("value");
        String expectLastname = "testlastname";
        Assert.assertEquals(actualLastname, expectLastname);
        System.out.println("Last name Expected");

        driver.close();
        System.out.println("Browser closed");

    }

    @Test(priority = 1)
    public void ChangeDateOfBirth() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().setSize(new Dimension(1280, 768));
        System.out.println("Site is open");

        driver.findElement(By.name("username")).sendKeys("Testeri4");
        driver.findElement(By.name("password")).sendKeys("Zasatec}{123");
        driver.findElement(By.name("password")).submit();
        System.out.println("User login!!!");

        Thread.sleep(3500);

        driver.findElement(By.xpath("//div[@class='site']//div[@class='site-header-lower-container']" +
                "//div[@class='site-header-columns site-container']" +
                "//div[@class='site-header-loggedin-container flyout-layer']" +
                "//div[@class='site-header-user-nav']" +
                "//div[@class='site-header-user-nav-icon']")).click();
        System.out.println("Nav button opened");
        driver.findElement(By.linkText("Profile")).click();
        System.out.println("Profile page is opened");

        new Select (driver.findElement(By.className("day"))).selectByValue("03");
        new Select (driver.findElement(By.className("month"))).selectByValue("06");
        new Select (driver.findElement(By.className("year"))).selectByValue("1987");

        driver.close();
        System.out.println("Browser closed");
    }

}