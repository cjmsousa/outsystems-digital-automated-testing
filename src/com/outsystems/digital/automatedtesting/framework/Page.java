package com.outsystems.digital.automatedtesting.framework;

import org.openqa.selenium.*;

import com.outsystems.digital.automatedtesting.util.*;


public class Page {

    //Enum with possible redirections
    public enum Label {
        LearnAndSupport,
        ItResources,
        Community
    }

    //Public Methods
    public void Navigate(Website.Label pInLabel) {

        //Check redirection type
        switch (pInLabel) {
            case LearnAndSupport:
                Browser.getInstance().findElement(By.id("wt8_wtheader_wt3_wt4_wt4_wtListSections_ctl08_wt9")).click();
                break;
            case ItResources:
                Browser.getInstance().findElement(By.linkText("Whitepapers and eBooks")).click();
                break;
            case Community:
                Browser.getInstance().findElement(By.linkText("Home")).click();
                break;
            default:
                throw (new RuntimeException(String.format("Can't find navigation label [%s]", pInLabel.name())));
        }
    }
}
