package com.outsystems.digital.automatedtesting.step;

import cucumber.api.java.en.*;

import com.outsystems.digital.automatedtesting.framework.*;
import com.outsystems.digital.automatedtesting.util.*;

public class StepWebsite {

    @Given("^I open the OutSystems website$")
    public void i_open_the_OutSystems_website() {

        //Open HomePage
        com.outsystems.digital.automatedtesting.framework.Website.getInstance();
    }

    @Given("^I navigate to \"([^\"]*)\" section$")
    public void i_navigate_to_section(String pInDestination){

        switch (pInDestination) {
            case "IT Resources":
                //Navigate
                Website.getInstance().Navigate(Website.Label.LearnAndSupport);
                Website.getInstance().Navigate(Website.Label.ItResources);
                break;
            case "Community":
                Website.getInstance().Navigate(Website.Label.LearnAndSupport);
                Website.getInstance().Navigate(Website.Label.Community);

                //Make community tab active
                Browser.getInstance().switchTab(1);
                break;
            default:
                throw (new RuntimeException(String.format("Can't find navigation label [%s]", pInDestination)));
        }
    }
}