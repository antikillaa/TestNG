package stgwp.stg.m27613.com;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.split;
import static org.apache.commons.lang3.StringUtils.strip;


public class Template {

    public String baseUrl = "http://stgwp.stg.m27613.com";
    private static final String driverPath = FilenameUtils.separatorsToSystem("webdriver//chromedriver");
    public WebDriver driver;

    @BeforeMethod
    public void start() {

        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().setSize(new Dimension(1280, 768));
        System.out.println("Site is open");
    }

    @AfterMethod
    public void cleanup() {

        driver.quit();
        System.out.println("Browser closed");
    }


    @Test(priority = 1)
    public void LoginLogoutAccrossPopup() throws InterruptedException {

        /**
         Check that user able login/logout using login popup
         */

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
    }

    @Test(priority = 1)
    public void LoginLogoutAccrossLoginPage() throws InterruptedException {

        /**
         Check that user able login/logout using login page
         */

        driver.findElement(By.name("username")).sendKeys("Testeri4");
        driver.findElement(By.name("password")).sendKeys("Zasatec}");
        driver.findElement(By.name("password")).submit();
        System.out.println("Login page is displayed");

        driver.findElement(By.name("authorization_form-profile_login[username]")).clear();
        driver.findElement(By.name("authorization_form-profile_login[password]")).clear();
        System.out.println("Login fields cleared");


        driver.findElement(By.name("authorization_form-profile_login[username]")).sendKeys("Testeri4");
        driver.findElement(By.name("authorization_form-profile_login[password]")).sendKeys("Zasatec}{123");
        driver.findElement(By.name("authorization_form-profile_login[password]")).submit();
        System.out.println("User is Login");

        Thread.sleep(3500);

        driver.findElement(By.xpath("//div[@class='site']//div[@class='site-header-lower-container']" +
                "//div[@class='site-header-columns site-container']" +
                "//div[@class='site-header-loggedin-container flyout-layer']" +
                "//div[@class='site-header-user-nav']" +
                "//div[@class='site-header-user-nav-icon']")).click();
        System.out.println("Nav button opened");


        driver.findElement(By.linkText("Logout")).click();
        System.out.println("User logout");
    }


    @Test(priority = 3)
    public void OpenMyProfile() throws InterruptedException {

        /**
         Check that profile page opens
         */

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


        driver.findElement(By.id("registration_form-2sdfsdfs-firstname"));
        System.out.println("Firstname field are displayed");


        driver.findElement(By.id("registration_form-2sdfsdfs-lastname"));
        System.out.println("Lastname field are displayed");

    }

    @Test(priority = 1)
    public void ChangeProfileInformation() throws InterruptedException {

        /**
         Check Change some profile information and check that new profile information saved
         */

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


        driver.findElement(By.xpath("//div[@class='sw-form-holder']//button[@type='submit']")).click();
        System.out.println("Changes submitted");

        Thread.sleep(10000);

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

    }


    @Test(priority = 0)
    public void GetWithdrawal() throws InterruptedException {

        /**
         Check Withdrawal process
         */


        driver.findElement(By.name("username")).sendKeys("Testeri4");
        driver.findElement(By.name("password")).sendKeys("Zasatec}{123");
        driver.findElement(By.name("password")).submit();
        System.out.println("User login!!!");


        String actualBalanceStr = driver.findElement(By.xpath("//div[@class='balance-value-current']" +
                "/div[@class='balance-value']")).getText();
        System.out.println("Get balance");
        String actualBalance = actualBalanceStr.split(" ")[0];
        Double actualBalanceDouble = Double.parseDouble(actualBalance);
        System.out.println("Actual balance is " + actualBalanceDouble);


        driver.findElement(By.linkText("Withdrawal")).click();
        System.out.println("Withdrawal page is opened");

/**
        driver.findElement(By.name("withdrawal_password")).sendKeys("1234");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        System.out.println("Go to the next step of withdrawal");
*/

        new Select(driver.findElement(By.id("payment_methods"))).selectByValue("skywind");
        driver.findElement(By.xpath("//input[@class='sw-form-control withdrawal_amount']")).clear();
        driver.findElement(By.xpath("//input[@class='sw-form-control withdrawal_amount']")).sendKeys("100");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        System.out.println("Withdrawal value sent");

        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println("Alert accepted");

        Thread.sleep(2000);

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(5000);
        driver.findElement(By.name("submit")).click();
        System.out.println("Withdrawal confirmed");


        String orderIdText = driver.findElement( By.xpath( "//div[1]/div/div/div/div/div/div[2]" ) ).getText();
        System.out.println("orderIdText is " + orderIdText);

        String actualorderId = orderIdText.split( "\n" )[1].split( "orderId:" )[1].trim();
        System.out.println("actuaorderId is " + actualorderId);


        driver.close();
        System.out.println("Payment window are closed");


        driver.switchTo().window(tabs2.get(0));
        driver.navigate().refresh();
        System.out.println("Page refreshed");


        String expectBalanceStr = driver.findElement(By.xpath("//div[@class='balance-value-current']" +
                "/div[@class='balance-value']")).getText();
        System.out.println("Get balance");


        String expectBalance = expectBalanceStr.split(" ")[0];
        Double expectBalanceDouble = Double.parseDouble(expectBalance);
        System.out.println("Expect balance is " + expectBalanceDouble);


        String exorderId = driver.findElement( By.xpath( "//div[@class='sw-table-scroller']//tbody//tr" ) ).getText();
        String expectorderId = exorderId.split(" ")[0];
        System.out.println("Expect OrderID is " + expectorderId);


        Assert.assertEquals(actualorderId, expectorderId);
        System.out.println("Payment ID is correct");

        Assert.assertEquals(actualBalanceDouble, expectBalanceDouble + 100);
        System.out.println("New balance value are correct");
    }


    @Test(priority = 0)
    public void Registration() throws InterruptedException {

        /**
        Check registration process
         */

        String a = RandomStringUtils.randomAlphanumeric(20).toLowerCase();
        System.out.println("Random prefix is " + a);


        driver.findElement(By.linkText("Join Now")).click();
        System.out.println("Registration form is opened");


        driver.findElement(By.name("registration_form-customer[username]")).sendKeys("Test" + a);
        System.out.println("username sended");

        String expectUsername = "Test" + a;
        System.out.println("Expect username is " + expectUsername);


        driver.findElement(By.name("registration_form-customer[password]")).sendKeys("Zasatec}{123");
        System.out.println("password sended");


        driver.findElement(By.name("registration_form-customer[confirmPassword]")).sendKeys("Zasatec}{123");
        System.out.println("Confirm Password sended");


        driver.findElement(By.name("registration_form-customer[withdrawal_password]")).sendKeys("1234");
        System.out.println("withdrawal_password sended");


        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Registration submitted");

        Thread.sleep( 5000 );

        driver.findElement(By.xpath("//div[@class='site']//div[@class='site-header-lower-container']" +
                "//div[@class='site-header-columns site-container']" +
                "//div[@class='site-header-loggedin-container flyout-layer']" +
                "//div[@class='site-header-user-nav']" +
                "//div[@class='site-header-user-nav-icon']")).click();
        System.out.println("Nav button opened");

        String actualUsername = driver.findElement( By.xpath( "//div[@class='site-header-user-nav-list']" +
                "/div[@class='site-header-user-nav-item site-header-user-nav-item-username']")).getText();
        System.out.println("actualUsername is " + actualUsername);


        Assert.assertEquals(actualUsername, expectUsername);
        System.out.println("Actual and expect name is match");
    }

    @Test(priority = 0)
    public void GetDepositSkyWind() throws InterruptedException {

        /**
         Check Get Deposit process
         */

        driver.findElement(By.name("username")).sendKeys("Testeri4");
        driver.findElement(By.name("password")).sendKeys("Zasatec}{123");
        driver.findElement(By.name("password")).submit();
        System.out.println("User login!!!");


        String actualBalanceStr = driver.findElement(By.xpath("//div[@class='balance-value-current']" +
                "/div[@class='balance-value']")).getText();
        System.out.println("Get balance");
        String actualBalance = actualBalanceStr.split(" ")[0];
        Double actualBalanceDouble = Double.parseDouble(actualBalance);
        System.out.println("Actual balance is " + actualBalanceDouble);


        driver.findElement(By.linkText("Deposit")).click();
        System.out.println("Deposit page is opened");


        new Select(driver.findElement(By.id("payment_methods"))).selectByValue("skywind");

        driver.findElement(By.xpath("//input[@class='sw-form-control deposit-amount']")).clear();
        driver.findElement(By.xpath("//input[@class='sw-form-control deposit-amount']")).sendKeys("100");
        driver.findElement(By.xpath("//input[@type='button']")).click();
        System.out.println("Deposit value sent");

        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println("Alert accepted");

        Thread.sleep(2000);


        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(5000);
        driver.findElement(By.name("amount")).clear();
        driver.findElement(By.name("amount")).sendKeys("100");
        driver.findElement(By.name("submit")).click();
        System.out.println("Payment amount sended");
        Thread.sleep(3000);


        String orderId = driver.findElement( By.xpath( "//div[@class='panel panel-body login-form']" +
                "//div[@class='alert alert-success no-border']" ) ).getText();
        String actualorderId = orderId.split("\n")[2];
        System.out.println("actuaorderId is " + actualorderId);

        driver.close();
        System.out.println("Payment window are closed");
        driver.switchTo().window(tabs2.get(0));

        driver.navigate().refresh();
        System.out.println("Page refreshed");


        String exorderId = driver.findElement( By.xpath( "//div[@class='sw-table-scroller']//tbody//tr" ) ).getText();
        String expectorderId = exorderId.split(" ")[0];
        System.out.println("Expect OrderID is " + expectorderId);


        String expectBalanceStr = driver.findElement(By.xpath("//div[@class='balance-value-current']" +
                "/div[@class='balance-value']")).getText();
        System.out.println("Get balance");
        String expectBalance = expectBalanceStr.split(" ")[0];
        Double expectBalanceDouble = Double.parseDouble(expectBalance);
        System.out.println("Expect balance is " + expectBalanceDouble);


        Assert.assertEquals(actualorderId, expectorderId);
        System.out.println("Payment ID is correct");


        Assert.assertEquals(actualBalanceDouble + 100, expectBalanceDouble);
        System.out.println("New balans value are correct");

    }


    @Test(priority = 0)
    public void GetDepositZPayOnlineBank() throws InterruptedException {

        /**
         Check Get Deposit process
         */

        driver.findElement(By.name("username")).sendKeys("yuan1234");
        driver.findElement(By.name("password")).sendKeys("Yuan1234");
        driver.findElement(By.name("password")).submit();
        System.out.println("User login!!!");


        String actualBalanceStr = driver.findElement(By.xpath("//div[@class='balance-value-current']" +
                "/div[@class='balance-value']")).getText();
        System.out.println("Get balance");
        String actualBalance = actualBalanceStr.split(" ")[0];
        Double actualBalanceDouble = Double.parseDouble(actualBalance);
        System.out.println("Actual balance is " + actualBalanceDouble);


        driver.findElement(By.linkText("Deposit")).click();
        System.out.println("Deposit page is opened");


        new Select(driver.findElement(By.id("payment_methods"))).selectByValue("zpayOnlineBank");

        driver.findElement(By.xpath("//input[@class='sw-form-control deposit-amount']")).clear();
        driver.findElement(By.xpath("//input[@class='sw-form-control deposit-amount']")).sendKeys("100");
        driver.findElement(By.xpath("//input[@type='button']")).click();
        System.out.println("Deposit value sent");

        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println("Alert accepted");

        Thread.sleep(2000);


        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(5000);

        driver.findElement(By.name("TransferBank_1$btnTstRecFunc")).click();
        System.out.println("Payment amount sended");
        Thread.sleep(3000);


        String orderId = driver.findElement( By.xpath( "//div[@class='panel panel-body login-form']" +
                "//div[@class='alert alert-success no-border']" ) ).getText();
        String actualorderId = orderId.split("\n")[2];
        System.out.println("actuaorderId is " + actualorderId);

        driver.close();
        System.out.println("Payment window are closed");
        driver.switchTo().window(tabs2.get(0));

        driver.navigate().refresh();
        System.out.println("Page refreshed");


        String exorderId = driver.findElement( By.xpath( "//div[@class='sw-table-scroller']//tbody//tr" ) ).getText();
        String expectorderId = exorderId.split(" ")[0];
        System.out.println("Expect OrderID is " + expectorderId);


        String expectBalanceStr = driver.findElement(By.xpath("//div[@class='balance-value-current']" +
                "/div[@class='balance-value']")).getText();
        System.out.println("Get balance");
        String expectBalance = expectBalanceStr.split(" ")[0];
        Double expectBalanceDouble = Double.parseDouble(expectBalance);
        System.out.println("Expect balance is " + expectBalanceDouble);


        Assert.assertEquals(actualorderId, expectorderId);
        System.out.println("Payment ID is correct");


        Assert.assertEquals(actualBalanceDouble + 100, expectBalanceDouble);
        System.out.println("New balans value are correct");

    }

    @Test(priority = 0)
    public void GetDepositZpayWechat() throws InterruptedException {

        /**
         Check Get Deposit process
         */

        driver.findElement(By.name("username")).sendKeys("yuan1234");
        driver.findElement(By.name("password")).sendKeys("Yuan1234");
        driver.findElement(By.name("password")).submit();
        System.out.println("User login!!!");


        String actualBalanceStr = driver.findElement(By.xpath("//div[@class='balance-value-current']" +
                "/div[@class='balance-value']")).getText();
        System.out.println("Get balance");
        String actualBalance = actualBalanceStr.split(" ")[0];
        Double actualBalanceDouble = Double.parseDouble(actualBalance);
        System.out.println("Actual balance is " + actualBalanceDouble);


        driver.findElement(By.linkText("Deposit")).click();
        System.out.println("Deposit page is opened");


        new Select(driver.findElement(By.id("payment_methods"))).selectByValue("zpayWechat");

        driver.findElement(By.xpath("//input[@class='sw-form-control deposit-amount']")).clear();
        driver.findElement(By.xpath("//input[@class='sw-form-control deposit-amount']")).sendKeys("100");
        driver.findElement(By.xpath("//input[@type='button']")).click();
        System.out.println("Deposit value sent");

        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println("Alert accepted");

        Thread.sleep(2000);


        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(5000);

        driver.findElement(By.name("TransferBank_1$btnTstRecFunc")).click();
        System.out.println("Payment amount sended");
        Thread.sleep(3000);


        String orderId = driver.findElement( By.xpath( "//div[@class='panel panel-body login-form']" +
                "//div[@class='alert alert-success no-border']" ) ).getText();
        String actualorderId = orderId.split("\n")[2];
        System.out.println("actuaorderId is " + actualorderId);

        driver.close();
        System.out.println("Payment window are closed");
        driver.switchTo().window(tabs2.get(0));

        driver.navigate().refresh();
        System.out.println("Page refreshed");


        String exorderId = driver.findElement( By.xpath( "//div[@class='sw-table-scroller']//tbody//tr" ) ).getText();
        String expectorderId = exorderId.split(" ")[0];
        System.out.println("Expect OrderID is " + expectorderId);


        String expectBalanceStr = driver.findElement(By.xpath("//div[@class='balance-value-current']" +
                "/div[@class='balance-value']")).getText();
        System.out.println("Get balance");
        String expectBalance = expectBalanceStr.split(" ")[0];
        Double expectBalanceDouble = Double.parseDouble(expectBalance);
        System.out.println("Expect balance is " + expectBalanceDouble);


        Assert.assertEquals(actualorderId, expectorderId);
        System.out.println("Payment ID is correct");


        Assert.assertEquals(actualBalanceDouble + 100, expectBalanceDouble);
        System.out.println("New balans value are correct");

    }

    @Test(priority = 0)
    public void GetDepositZpayAlipay() throws InterruptedException {

        /**
         Check Get Deposit process
         */

        driver.findElement(By.name("username")).sendKeys("yuan1234");
        driver.findElement(By.name("password")).sendKeys("Yuan1234");
        driver.findElement(By.name("password")).submit();
        System.out.println("User login!!!");


        String actualBalanceStr = driver.findElement(By.xpath("//div[@class='balance-value-current']" +
                "/div[@class='balance-value']")).getText();
        System.out.println("Get balance");
        String actualBalance = actualBalanceStr.split(" ")[0];
        Double actualBalanceDouble = Double.parseDouble(actualBalance);
        System.out.println("Actual balance is " + actualBalanceDouble);


        driver.findElement(By.linkText("Deposit")).click();
        System.out.println("Deposit page is opened");


        new Select(driver.findElement(By.id("payment_methods"))).selectByValue("zpayAlipay");

        driver.findElement(By.xpath("//input[@class='sw-form-control deposit-amount']")).clear();
        driver.findElement(By.xpath("//input[@class='sw-form-control deposit-amount']")).sendKeys("100");
        driver.findElement(By.xpath("//input[@type='button']")).click();
        System.out.println("Deposit value sent");

        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println("Alert accepted");

        Thread.sleep(2000);


        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(5000);

        driver.findElement(By.name("TransferBank_1$btnTstRecFunc")).click();
        System.out.println("Payment amount sended");
        Thread.sleep(3000);


        String orderId = driver.findElement( By.xpath( "//div[@class='panel panel-body login-form']" +
                "//div[@class='alert alert-success no-border']" ) ).getText();
        String actualorderId = orderId.split("\n")[2];
        System.out.println("actuaorderId is " + actualorderId);

        driver.close();
        System.out.println("Payment window are closed");
        driver.switchTo().window(tabs2.get(0));

        driver.navigate().refresh();
        System.out.println("Page refreshed");


        String exorderId = driver.findElement( By.xpath( "//div[@class='sw-table-scroller']//tbody//tr" ) ).getText();
        String expectorderId = exorderId.split(" ")[0];
        System.out.println("Expect OrderID is " + expectorderId);


        String expectBalanceStr = driver.findElement(By.xpath("//div[@class='balance-value-current']" +
                "/div[@class='balance-value']")).getText();
        System.out.println("Get balance");
        String expectBalance = expectBalanceStr.split(" ")[0];
        Double expectBalanceDouble = Double.parseDouble(expectBalance);
        System.out.println("Expect balance is " + expectBalanceDouble);


        Assert.assertEquals(actualorderId, expectorderId);
        System.out.println("Payment ID is correct");


        Assert.assertEquals(actualBalanceDouble + 100, expectBalanceDouble);
        System.out.println("New balans value are correct");

    }

    @Test(priority = 0)
    public void GetDepositZpayPointCard() throws InterruptedException {

        /**
         Check Get Deposit process
         */

        driver.findElement(By.name("username")).sendKeys("yuan1234");
        driver.findElement(By.name("password")).sendKeys("Yuan1234");
        driver.findElement(By.name("password")).submit();
        System.out.println("User login!!!");


        String actualBalanceStr = driver.findElement(By.xpath("//div[@class='balance-value-current']" +
                "/div[@class='balance-value']")).getText();
        System.out.println("Get balance");
        String actualBalance = actualBalanceStr.split(" ")[0];
        Double actualBalanceDouble = Double.parseDouble(actualBalance);
        System.out.println("Actual balance is " + actualBalanceDouble);


        driver.findElement(By.linkText("Deposit")).click();
        System.out.println("Deposit page is opened");


        new Select(driver.findElement(By.id("payment_methods"))).selectByValue("zpayPointCard");

        driver.findElement(By.xpath("//input[@class='sw-form-control deposit-amount']")).clear();
        driver.findElement(By.xpath("//input[@class='sw-form-control deposit-amount']")).sendKeys("100");
        driver.findElement(By.xpath("//input[@type='button']")).click();
        System.out.println("Deposit value sent");

        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println("Alert accepted");

        Thread.sleep(2000);


        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(5000);

        driver.findElement(By.name("TransferBank_1$btnTstRecFunc")).click();
        System.out.println("Payment amount sended");
        Thread.sleep(3000);


        String orderId = driver.findElement( By.xpath( "//div[@class='panel panel-body login-form']" +
                "//div[@class='alert alert-success no-border']" ) ).getText();
        String actualorderId = orderId.split("\n")[2];
        System.out.println("actuaorderId is " + actualorderId);

        driver.close();
        System.out.println("Payment window are closed");
        driver.switchTo().window(tabs2.get(0));

        driver.navigate().refresh();
        System.out.println("Page refreshed");


        String exorderId = driver.findElement( By.xpath( "//div[@class='sw-table-scroller']//tbody//tr" ) ).getText();
        String expectorderId = exorderId.split(" ")[0];
        System.out.println("Expect OrderID is " + expectorderId);


        String expectBalanceStr = driver.findElement(By.xpath("//div[@class='balance-value-current']" +
                "/div[@class='balance-value']")).getText();
        System.out.println("Get balance");
        String expectBalance = expectBalanceStr.split(" ")[0];
        Double expectBalanceDouble = Double.parseDouble(expectBalance);
        System.out.println("Expect balance is " + expectBalanceDouble);


        Assert.assertEquals(actualorderId, expectorderId);
        System.out.println("Payment ID is correct");


        Assert.assertEquals(actualBalanceDouble + 100, expectBalanceDouble);
        System.out.println("New balans value are correct");

    }

    @Test(priority = 0)
    public void GetDepositJarvis() throws InterruptedException {

        /**
         Check Get Deposit process
         */

        driver.findElement(By.name("username")).sendKeys("yuan1234");
        driver.findElement(By.name("password")).sendKeys("Yuan1234");
        driver.findElement(By.name("password")).submit();
        System.out.println("User login!!!");


        String actualBalanceStr = driver.findElement(By.xpath("//div[@class='balance-value-current']" +
                "/div[@class='balance-value']")).getText();
        System.out.println("Get balance");
        String actualBalance = actualBalanceStr.split(" ")[0];
        Double actualBalanceDouble = Double.parseDouble(actualBalance);
        System.out.println("Actual balance is " + actualBalanceDouble);


        driver.findElement(By.linkText("Deposit")).click();
        System.out.println("Deposit page is opened");


        new Select(driver.findElement(By.id("payment_methods"))).selectByValue("jarvis");

        driver.findElement(By.xpath("//input[@class='sw-form-control deposit-amount']")).clear();
        driver.findElement(By.xpath("//input[@class='sw-form-control deposit-amount']")).sendKeys("100");
        driver.findElement(By.xpath("//input[@type='button']")).click();
        System.out.println("Deposit value sent");

        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println("Alert accepted");

        Thread.sleep(2000);


        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(5000);

        driver.findElement(By.name( "submit" )).click();
        System.out.println("Deposit value sent");
        Thread.sleep(3000);


        String orderId = driver.findElement( By.xpath( "//div[@class='panel panel-body login-form']" +
                "//div[@class='alert alert-success no-border']" ) ).getText();
        String actualorderId = orderId.split("\n")[2];
        System.out.println("actuaorderId is " + actualorderId);

        driver.close();
        System.out.println("Payment window are closed");
        driver.switchTo().window(tabs2.get(0));

        driver.navigate().refresh();
        System.out.println("Page refreshed");


        String exorderId = driver.findElement( By.xpath( "//div[@class='sw-table-scroller']//tbody//tr" ) ).getText();
        String expectorderId = exorderId.split(" ")[0];
        System.out.println("Expect OrderID is " + expectorderId);


        String expectBalanceStr = driver.findElement(By.xpath("//div[@class='balance-value-current']" +
                "/div[@class='balance-value']")).getText();
        System.out.println("Get balance");
        String expectBalance = expectBalanceStr.split(" ")[0];
        Double expectBalanceDouble = Double.parseDouble(expectBalance);
        System.out.println("Expect balance is " + expectBalanceDouble);


        Assert.assertEquals(actualorderId, expectorderId);
        System.out.println("Payment ID is correct");


        Assert.assertEquals(actualBalanceDouble + 100, expectBalanceDouble);
        System.out.println("New balans value are correct");

    }

}