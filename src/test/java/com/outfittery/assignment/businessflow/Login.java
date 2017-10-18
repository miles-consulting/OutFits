package com.outfittery.assignment.businessflow;

import com.outfittery.assignment.pages.HomePage;
import com.outfittery.assignment.pages.SignInPage;
import com.outfittery.assignment.pages.UserDataPage;
import com.outfittery.assignment.utils.ContextManager;
import com.outfittery.assignment.utils.KEYS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Login {
    public Logger LOGGER = LogManager.getLogger(this.getClass());
    private ContextManager contextManager = ContextManager.getInstance();

    public void loginWithMyCredentials(String userName, String password) {
        LOGGER.info("Login with credentials");
        new HomePage().navigateToSignin();
        new SignInPage().enterUserCredentials(userName, password);
    }

    public void logOutAndReloginWithNewCredentials() {
        new UserDataPage().logout();
        new SignInPage().enterUserCredentials(contextManager.get(KEYS.OUTFITTERY_USER).toString(), contextManager.get(KEYS.NEWPASSWORD).toString());
    }
}
