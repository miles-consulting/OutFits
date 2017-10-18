package com.outfittery.assignment.businessflow;

import com.outfittery.assignment.pages.DashboardPage;
import com.outfittery.assignment.pages.SignInPage;
import com.outfittery.assignment.utils.CustomAsserts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.outfittery.assignment.utils.CustomAsserts.assertThat;

public class Login {
    public Logger LOGGER = LogManager.getLogger(this.getClass());

    public void loginWithMyCredentials() {
        LOGGER.info("Login with credentials");
        new SignInPage().enterUserCredentials();
        CustomAsserts.assertThat("Not able to login",new DashboardPage().isDashboardVisible());
    }
}
