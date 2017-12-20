package com.outsystems.digital.automatedtesting.framework;

import org.openqa.selenium.*;

import com.outsystems.digital.automatedtesting.util.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Community extends Page {

    //Singleton object
    private static Community _instance = null;

    //Constructor
    private Community() {
    }

    //Singleton Instance
    public static Community getInstance() {
        if (_instance == null) {
            _instance = new Community();
        }
        return (_instance);
    }

    //Public Methods
    public void searchFor(String pInSearchKeyword) {

        //Fill search textbox
        Browser.getInstance().findElement(By.id("PortalTheme_wt110_block_wtcontent_holder_wt165")).sendKeys(pInSearchKeyword);
        Browser.getInstance().findElement(By.id("PortalTheme_wt110_block_wtcontent_holder_wtSearchLink")).click();
    }

    public Boolean areResultsShown() {


        //Wait for the search counts and first element
        WebElement searchCount = Browser.getInstance().waitForElement((By.xpath("//*[@id=\"PortalTheme_wt46_block_wtcontent_holder_PortalTheme_wt8_block_wtBoxContent_wtResults\"]/div[1]/span[1]")));
        WebElement firstElement = Browser.getInstance().waitForElement(By.id("PortalTheme_wt46_block_wtcontent_holder_PortalTheme_wt8_block_wtBoxContent_wtListRecordsPosts_ctl00_wt3_wt45"));


        //Check webelements value
        return (Integer.parseInt(searchCount.getText()) > 0 && !firstElement.getText().isEmpty());
    }
}




