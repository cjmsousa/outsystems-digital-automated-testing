package com.outsystems.digital.automatedtesting.util;

import java.util.concurrent.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.chrome.*;

public class Browser {

    //Properties
    private static WebDriver _webDriver = null;

    //Constants
    private static final String CHROME_DRIVER_PATH = "..\\driver\\chromedriver.exe";
    private static final Integer WEBDRIVER_WAIT_TIMEOUT = 30;

    //Singleton object
    private static Browser _instance = null;

    //Constructor
    private Browser() {

        //Define environment variables
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);

        //Initialize driver
        _webDriver = new ChromeDriver();
    }

    //Singleton Instance
    public static Browser getInstance() {
        if (_instance == null) {
            _instance = new Browser();
        }
        return (_instance);
    }

    //WebDriver Accessors
    public WebDriver getWebDriver() {

        //Return WebDriver object
        return (_webDriver);
    }

    private WebDriverWait getWebDriverWait() {

        //Return WebDriverWait object
        return (new WebDriverWait(getWebDriver(), WEBDRIVER_WAIT_TIMEOUT));
    }

    //Public Methods
    public void maximize() {

        //Maximize window
        _webDriver.manage().window().maximize();
    }

    public void close() {

        //Maximize window
        _webDriver.quit();
    }

    public void navigate(String pInUrl) {

        //Navigate to url
        getWebDriver().get(pInUrl);
    }

    public void closeTab(Integer pInTabIndex) {

        //Close tab with given index
        getWebDriver().switchTo().window(getWebDriver().getWindowHandles().toArray()[pInTabIndex].toString());
        getWebDriver().close();
    }

    public void closeTab() {

        //Get window handles
        closeTab(0);
    }

    public void switchTab(Integer pInTabIndex) {

        //Close tab with given index
        getWebDriver().switchTo().window(getWebDriver().getWindowHandles().toArray()[pInTabIndex].toString());
    }

    public void switchFrame(String pInFrameName) {

        //Switch to frame
        switchFrame(pInFrameName, null);
    }

    public void switchFrame( String pInFrameName, By pInReadinessClause) {

        //Switch to frame and wait for it
        getWebDriverWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(pInFrameName));

        //If needed, wait for the element that signals that frame is ready
        if (pInReadinessClause != null) {

            //Wait for element
            waitForElement(pInReadinessClause);
        }
    }

    public WebElement waitForElement(By... pInByClauses) {

        //Iterate clauses
        for (int i = 0; i < pInByClauses.length; i++) {
            try {

                //Wait for element to appear. If it doesn't an exception will risnand interations moves on
                getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(pInByClauses[i]));

                //Return webelement
                return (getWebDriver().findElement(pInByClauses[i]));
            }
            catch (Exception ex) {
                //Just to ensure interation continues
            }
        }

        //Web element not found
        throw (new RuntimeException("Can't wait for element using given By clauses"));
    }

    public WebElement findElement(By... pInByClauses) {

        //Iterate clauses
        for (int i = 0; i < pInByClauses.length; i++) {
            try {

                //If element is found this will work. Otherwise exception and interations moves on
                return (getWebDriver().findElement(pInByClauses[i]));
            } catch (Exception ex) {
                //Just to ensure interation continues
            }
        }

        //Web element not found
        throw (new RuntimeException("Can't find element using given By clauses"));
    }

    public void sleep(Integer pInSeconds) {

        try {
            //Sleep seconds
            TimeUnit.SECONDS.sleep(pInSeconds);
        }
        catch(Exception generalException) {
            // Just to avoid throwing exception
        }
    }
}