package BO.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AgentsPage {

    private static WebElement element = null;

    public static WebElement ButtonCreateAgent(WebDriver driver){

        element = driver.findElement( By.xpath("//div[@class='heading-elements']/button[@class='btn bg-slate-400 btn-xs']"));
        return element;
    }

}
