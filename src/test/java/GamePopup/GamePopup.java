package GamePopup;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.ArrayList;


public class GamePopup {

    public String baseUrl = "http://stgwp.stg.m27613.com";
    String driverPath = "//Users//stanislav.peshkur//Documents//webdriver//chromedriver";
    public WebDriver driver;

    @Test (priority = 2)
    public void OpenGamePopup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        System.out.println("Site is open");
        driver.manage().window().setSize(new Dimension(1280, 768));
        driver.findElement(By.id("menu-item-172")).click();
        System.out.println("Game page is open");
        driver.findElement(By.xpath("//div[@class='game-title']//div[@class='game-title-text']")).click();
        System.out.println("Game popup is open");
        driver.close();
    }

    @Test (priority = 2)
    public void CheckAutorizationInPopupForm() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        System.out.println("Site is open");
        driver.manage().window().setSize(new Dimension(1280, 768));

        driver.findElement(By.id("menu-item-172")).click();
        System.out.println("Game page is open");
        driver.findElement(By.xpath("//div[@class='game-title']//div[@class='game-title-text']")).click();
        System.out.println("Game popup is open");
        driver.findElement(By.xpath("//div[@class='play-now-btn display-block']//a[@class='modal-game-btn']")).click();
        System.out.println("Autorization form is displayed");

        driver.findElement(By.xpath("//div[@class='sw-form-line']//input[@class='game-modal-username sw-form-control']"));
        System.out.println("Username field visible");
        driver.findElement(By.xpath("//div[@class='sw-form-line']//input[@class='game-modal-password sw-form-control']"));
        System.out.println("Password field visible");
        driver.close();
    }

    @Test (priority = 1)
    public void AutorizationInPopup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        System.out.println("Site is open");
        driver.manage().window().setSize(new Dimension(1280, 768));

        driver.findElement(By.id("menu-item-172")).click();
        System.out.println("Game page is open");
        driver.findElement(By.xpath("//div[@class='game-title']//div[@class='game-title-text']")).click();
        System.out.println("Game popup is open");
        driver.findElement(By.xpath("//div[@class='play-now-btn display-block']//a[@class='modal-game-btn']")).click();

        Thread.sleep(3500);

        System.out.println("Autorization form is displayed");

        driver.findElement(By.xpath("//div[@class='sw-form-line']//input[@class='game-modal-username sw-form-control']")).sendKeys("Testeri4");
        System.out.println("Username sended");
        driver.findElement(By.xpath("//div[@class='sw-form-line']//input[@class='game-modal-password sw-form-control']")).sendKeys("Zasatec}{123");
        System.out.println("Password sended");
        driver.findElement(By.xpath("//div[@class='sw-form-line']//input[@class='game-modal-password sw-form-control']")).submit();
        System.out.println("User autorised");
        driver.close();
    }


    @Test
    public void UserAlreadyAutorizited() throws InterruptedException {

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
        driver.findElement(By.id("menu-item-172")).click();
        System.out.println("Game page is opened!!!");
        driver.findElement(By.xpath("//div[@class='game-title']//div[@class='game-title-text']")).click();
        System.out.println("Game popup is open");
        driver.findElement(By.xpath("//div[@class='play-now-btn display-block']//a[@class='modal-game-btn']")).click();

        Thread.sleep(3500);

    }

    @Test (priority = 0)
    public void StartGame() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        System.out.println("Site is open");
        driver.manage().window().setSize(new Dimension(1280, 768));

        driver.findElement(By.id("menu-item-172")).click();
        System.out.println("Game page is open");

        driver.findElement(By.xpath("//div[@class='game-title']//div[@class='game-title-text']")).click();
        System.out.println("Game popup is open");

        driver.findElement(By.xpath("//div[@class='play-now-btn display-block']//a[@class='modal-game-btn']")).click();

        Thread.sleep(3500);

        System.out.println("Autorization form is displayed");

        driver.findElement(By.xpath("//div[@class='sw-form-line']//input[@class='game-modal-username sw-form-control']")).sendKeys("Testeri4");
        System.out.println("Username sended");
        driver.findElement(By.xpath("//div[@class='sw-form-line']//input[@class='game-modal-password sw-form-control']")).sendKeys("Zasatec}{123");
        System.out.println("Password sended");
        driver.findElement(By.xpath("//div[@class='sw-form-line']//input[@class='game-modal-password sw-form-control']")).submit();
        System.out.println("User autorised");

        Thread.sleep(2500);

        //driver.findElement(By.xpath("//div[@class='play-now-btn display-block']//a[@class='modal-game-btn']")).click();

        System.out.println("Game is launched");

        Thread.sleep(5000);

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.close();
        System.out.println("Game popup closed");
        driver.switchTo().window(tabs2.get(0));
        System.out.println("Site builder tab closed");
        driver.close();

    }

    @Test (priority = 0)
    public void StartDemoGame() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        System.out.println("Site is open");
        driver.manage().window().setSize(new Dimension(1280, 768));

        driver.findElement(By.id("menu-item-172")).click();
        System.out.println("Game page is open");
        driver.findElement(By.xpath("//div[@class='game-title']//div[@class='game-title-text']")).click();
        System.out.println("Game popup is open");

        driver.findElement(By.xpath("//a[@class='modal-game-btn-link']")).click();

        Thread.sleep(5000);
        System.out.println("Demo game started");
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.close();
        System.out.println("Demo game popup closed");
        driver.switchTo().window(tabs2.get(0));
        System.out.println("Site builder tab closed");
        driver.close();

    }




}



