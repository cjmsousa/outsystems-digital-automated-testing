package com.outsystems.digital.automatedtesting.framework;

import com.outsystems.digital.automatedtesting.util.*;

public class Website extends Page {

    //Constants
    private final String HOMEPAGE_URL = "https://www.outsystems.com";

    //Singleton object
    private static Website _instance = null;

    //Constructor
    private Website() {

        //Open website homepages
        Browser.getInstance().navigate(HOMEPAGE_URL);
    }

    //Singleton Instance
    public static Website getInstance() {
        if (_instance == null) {
            _instance = new Website();
        }
        return (_instance);
    }
}




