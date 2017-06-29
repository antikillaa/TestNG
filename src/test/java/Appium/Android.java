package Appium;

import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Android {

    @Test
    public void test1() throws MalformedURLException {
        DesiredCapabilities capabilities=DesiredCapabilities.android();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserType.CHROME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM,Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.VERSION,"8.0");

        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        String context = driver.getContext(); // = "CHROMIUM"
        driver.context("NATIVE_APP");
        driver.findElement(By.id("com.android.chrome:id/terms_accept")).click();
        driver.findElement(By.id("com.android.chrome:id/negative_button")).click();
        driver.context(context);

        driver.get("http://www.fb.com");

        driver.findElement(By.name("email")).sendKeys("mukesh@gmail.com");

        driver.findElement(By.name("pass")).sendKeys("mukesh_selenium");

        driver.findElement(By.id("u_0_5")).click();

        driver.close();
        System.out.println("Browser closed");
    }


}