package BO.ui;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class loginBOpage {

    private static WebElement element = null;

    public static WebElement TextBoxAccessKey(WebDriver driver){

        element = driver.findElement(By.xpath("//div[@class='input-group']" +
                "/input[@class='form-control ng-untouched ng-pristine ng-invalid']"));
        return element;
    }

    public static WebElement ButtonAccessKey(WebDriver driver){

        element = driver.findElement(By.xpath("//div[@class='input-group']" +
                "/div[@class='input-group-btn']"));
        return element;
    }

    public static WebElement ButtonProceedWithKey(WebDriver driver){

        element = driver.findElement(By.xpath("//button[@class='btn bg-slate-400 btn-block']"));
        return element;
    }

    public static WebElement TextBoxUsername(WebDriver driver){

        element = driver.findElement(By.id( "inputUsername" ));
        return element;
    }

    public static WebElement TextBoxPassword(WebDriver driver){

        element = driver.findElement(By.id( "inputPassword" ));
        return element;
    }
    public static WebElement ButtonLogin(WebDriver driver){

        element = driver.findElement(By.xpath("//button[@class='btn bg-slate-400 btn-block']"));
        return element;
    }
}
