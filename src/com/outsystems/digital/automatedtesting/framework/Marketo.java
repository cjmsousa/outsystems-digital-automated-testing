package com.outsystems.digital.automatedtesting.framework;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import com.outsystems.digital.automatedtesting.util.*;

public class Marketo extends Page {

    //Singleton object
    private static Marketo _instance = null;

    //Constructor
    private Marketo() {
    }

    //Singleton Instance
    public static Marketo getInstance() {
        if (_instance == null) {
            _instance = new Marketo();
        }
        return (_instance);
    }

    public void fillForm() {
        //Switch to Marketo frame and waits for it to appear
        Browser.getInstance().switchFrame("mkto_frame", By.xpath("//button[@type='submit']"));

        //Fill form fields
        Browser.getInstance().findElement(By.id("FirstName")).sendKeys("Automated");
        Browser.getInstance().findElement(By.id("LastName")).sendKeys("Testing");
        Browser.getInstance().findElement(By.id("Email")).sendKeys("automated.testing@outsystems.com");
        Browser.getInstance().findElement(By.id("Company")).sendKeys("OutSystems");
        (new Select(Browser.getInstance().findElement(By.id("employeeRange")))).selectByIndex(5);
        (new Select(Browser.getInstance().findElement(By.id("Country__c")))).selectByValue("Portugal");
    }

    public void downloadReport() {

        //Hit download button
        Browser.getInstance().findElement(By.xpath("//button[@type='submit']")).click();
    }
}




