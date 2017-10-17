package BO.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BusinessStructure {

    private static WebElement element = null;

    public static WebElement TitleBusinessManagment(WebDriver driver){

        element = driver.findElement( By.xpath("//div[@class='content-wrapper']//ba-content-top//div//div//div//h4//i//span[@class='text-semibold']"));
        return element;
    }
}
