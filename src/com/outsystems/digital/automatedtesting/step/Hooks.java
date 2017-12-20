package com.outsystems.digital.automatedtesting.step;

import cucumber.api.java.*;

import com.outsystems.digital.automatedtesting.util.*;

public class Hooks {

    @Before
    public void beforeScenario(){

        //Maximize window
        Browser.getInstance().maximize();
    }

    @After
    public void afterScenario(){

        //Close browser
        Browser.getInstance().close();
    }
}
