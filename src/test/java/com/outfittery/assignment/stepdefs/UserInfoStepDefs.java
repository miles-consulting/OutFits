package com.outfittery.assignment.stepdefs;

import com.outfittery.assignment.businessflow.EditUserData;
import com.outfittery.assignment.businessflow.Login;
import com.outfittery.assignment.utils.ContextManager;
import com.outfittery.assignment.utils.KEYS;
import cucumber.api.DataTable;
import cucumber.api.java8.En;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class UserInfoStepDefs implements En {
    private final ContextManager contextManager = ContextManager.getInstance();
    public Logger LOGGER = LogManager.getLogger(this.getClass());

    public UserInfoStepDefs() {
        Given("^I reset all user data including\\(Address/Phone number/password\\)$", () -> {
            String stepDef = "I reset all user data including\\(Address/Phone number/password\\)";
            LOGGER.info(stepDef);
        });

        Given("^I logged in to outfittery portal$", () -> {
            new Login().loginWithMyCredentials(contextManager.get(KEYS.OUTFITTERY_USER).toString()
                    , contextManager.get(KEYS.OUTFITTERY_PASSWORD).toString());
        });

        When("^I edit phone number to \"([^\"]*)\"$", (String phoneNumber) -> {
            new EditUserData().editPhoneNumber(phoneNumber);
        });

        Then("^Phone number should be updated successfully$", () -> {
            new EditUserData().checkUpdatedPhoneNumber();
        });

        When("^I edit address with below details$", (DataTable dataTable) -> {
            List<Map<String, String>> userData = dataTable.asMaps(String.class, String.class);
            new EditUserData().editUserAddress(userData.get(0));
        });

        Then("^User's address should be updated$", () -> {
            new EditUserData().checkUpdatedAddress();
        });

        When("^I edit password$", () -> {
            new EditUserData().editPassword();
        });

        Then("^password should be updated on next login$", () -> {
            new Login().logOutAndReloginWithNewCredentials();
        });


    }
}
