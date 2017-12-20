package com.outsystems.digital.automatedtesting.step;

import cucumber.api.java.en.*;

import com.outsystems.digital.automatedtesting.framework.*;

public class StepCommunity {

    @When("^I search for \"([^\"]*)\" in community$")
    public void i_search_for_in_community(String pInSearchKeyword) {

        //Search for keyworkd
        Community.getInstance().searchFor(pInSearchKeyword);
    }

    @Then("^I see community search results are displayed$")
    public void i_see_community_search_results_are_displayed() {

        //Check if search results are shown
        assert (Community.getInstance().areResultsShown());
    }
}
