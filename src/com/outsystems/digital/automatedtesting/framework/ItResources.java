package com.outsystems.digital.automatedtesting.framework;

import org.openqa.selenium.*;

import com.outsystems.digital.automatedtesting.util.*;

public class ItResources extends Page {

    //Singleton object
    private static ItResources _instance = null;

    //Constructor
    private ItResources() {
    }

    //Singleton Instance
    public static ItResources getInstance() {
        if (_instance == null) {
            _instance = new ItResources();
        }
        return (_instance);
    }

    public void SelectReport(String pInResourceName) throws RuntimeException {

        //Check redirection type
        switch (pInResourceName) {
            case "Gartner Names OutSystems a Leader in High-Productivity aPaaS":
                Browser.getInstance().findElement(By.id("wt12_wtcontent_wt5_wtcard_list_ctl14_wt15"))
                        .click();
                break;
            default:
                throw (new RuntimeException(String.format("Can't find resource [%s]", pInResourceName)));
        }
    }
}




