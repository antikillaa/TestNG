package BO.ui;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAgentPopup {

    private static WebElement element = null;

    public static WebElement TextBoxAgenttitle(WebDriver driver){

        element = driver.findElement( By.xpath("//div[@class='col-sm-6']" +
                "/input[@class='form-control ng-untouched ng-pristine ng-invalid' and contains(@formcontrolname, 'title')]"));
        return element;
    }

    public static WebElement TextBoxDomain(WebDriver driver){

        element = driver.findElement( By.xpath("//div[@class='col-sm-6']" +
                "/input[@class='form-control ng-untouched ng-pristine ng-invalid' and contains(@formcontrolname, 'domain')]"));
        return element;
    }

    public static WebElement textBoxAffiliateID(WebDriver driver){

        element = driver.findElement( By.xpath("//div[@class='col-sm-6']" +
                "/input[@class='form-control ng-untouched ng-pristine ng-valid' and contains(@formcontrolname, 'affiliateCode')]"));
        return element;
    }

    public static WebElement ButtonSaveChanges(WebDriver driver){

        element = driver.findElement( By.xpath("//div[@class='text-right']/button[@class='btn btn-default']"));
        return element;
    }

}
