package com.outsystems.digital.automatedtesting.framework;

import com.outsystems.digital.automatedtesting.util.*;
import org.openqa.selenium.By;

public class ThankYou extends Page {

    //Singleton object
    private static ThankYou _instance = null;

    //Constructor
    private ThankYou() {
    }

    //Singleton Instance
    public static ThankYou getInstance() {
        if (_instance == null) {
            _instance = new ThankYou();
        }
        return (_instance);
    }

    //Public Methods
    public Boolean isLoaded() {

        //Wait for  age to be open
        Browser.getInstance().waitForElement(By.linkText("Get the Report"));

        //If it works it will return true, otherwise exception will be thrown
        return (true);
    }
}




