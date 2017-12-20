package com.outsystems.digital.automatedtesting.step;

import cucumber.api.java.en.*;

import com.outsystems.digital.automatedtesting.framework.*;
import com.outsystems.digital.automatedtesting.util.*;

public class StepItResources {

    @When("^I download \"([^\"]*)\" report$")
    public void i_download_report(String pInReportName) {

        //Select eBook
        com.outsystems.digital.automatedtesting.framework.ItResources.getInstance().SelectReport(pInReportName);

        //Make report tab active
        Browser.getInstance().switchTab(1);

        //Fill Marketo form
        Marketo.getInstance().fillForm();

        //Download the report
        Marketo.getInstance().downloadReport();
    }

    @Then("^I see the Thank You page$")
    public void i_see_the_Thank_You_page() {

        //Check if current page is Thank you page

        assert (ThankYou.getInstance().isLoaded());
    }
}