package com.outfittery.assignment.stepdefs;

import com.outfittery.assignment.utils.ResetUserData;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserInfoStepDefs implements En {
    public Logger LOGGER = LogManager.getLogger(this.getClass());

    public UserInfoStepDefs() {
        Given("^I reset all user data including\\(Address/Phone number/password\\)$", () -> {
            String stepDef="I reset all user data including\\(Address/Phone number/password\\)";
            LOGGER.info(stepDef);
            ResetUserData.resetPhoneNumber();
            ResetUserData.resetUserAddress();
            ResetUserData.resetDefaultPassword();
        });

        Given("^I logged in to outfittery portal$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        When("^I edit phone number to \"([^\"]*)\"$", (String arg1) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        Then("^Phone number should be updated successfully$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        When("^I edit address with below details$", (DataTable arg1) -> {
            // Write code here that turns the phrase above into concrete actions
            // For automatic transformation, change DataTable to one of
            // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
            // E,K,V must be a scalar (String, Integer, Date, enum etc)
            throw new PendingException();
        });

        Then("^User's address should be updated$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        When("^I edit password$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        Then("^password should be updated on next login$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });


    }
}
