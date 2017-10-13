package BO.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class navigationPanel {

        private static WebElement element = null;

        public static WebElement LinkBusinessManagment(WebDriver driver){

            element = driver.findElement( By.xpath("//a[@class='al-sidebar-list-link']//span[.='Business Management']"));
            return element;
        }
}
