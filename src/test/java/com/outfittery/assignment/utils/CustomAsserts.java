package com.outfittery.assignment.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matcher;

import java.util.ArrayList;

public class CustomAsserts {
    public static Logger LOGGER = LogManager.getLogger(CustomAsserts.class);
    private static ArrayList<String> verificationFailures = new ArrayList<String>();

    public static <T> void assertThat(String reason, T actual, Matcher<? super T> matcher) {
        try {
            org.hamcrest.MatcherAssert.assertThat(reason, actual, matcher);
        } catch (AssertionError ae) {
            LOGGER.error("*****Custom Assertion Error" + reason + "*****\n" + ae.toString());
            ScreenShotUtils.saveScreenShotAs(reason, reason);
            throw ae;
        }
    }

    public static void assertThat(String reason, boolean assertion) {
        try {
            org.hamcrest.MatcherAssert.assertThat(reason, assertion);
        } catch (AssertionError ae) {
            LOGGER.error("*****Custom Assertion Error" + reason + "*****\n" + ae.toString());
            ScreenShotUtils.saveScreenShotAs(reason, reason);
            throw ae;
        }
    }

    public static <T> void verifyThat(String reason, T actual, Matcher<? super T> matcher) {
        try {
            org.hamcrest.MatcherAssert.assertThat(reason, actual, matcher);
        } catch (AssertionError ae) {
            LOGGER.error("*****Custom Assertion Error" + reason + "*****\n" + ae.toString());
            ScreenShotUtils.saveScreenShotAs(reason, reason);
            String verificationFailureMessage = "\nVerification Failure";
            verificationFailureMessage += "\nException: " + ae.toString();
            addVerificationFailure(verificationFailureMessage);
        }
    }

    public static void verifyThat(String reason, boolean assertion) {
        try {
            org.hamcrest.MatcherAssert.assertThat(reason, assertion);
        } catch (AssertionError ae) {
            LOGGER.error("*****Custom Assertion Error" + reason + "*****\n" + ae.toString());
            ScreenShotUtils.saveScreenShotAs(reason, reason);
            String verificationFailureMessage = "\nVerification Failure";
            verificationFailureMessage += "\t" + reason + "\n\t\tExpected: " + !assertion + "\n\t\t  Actual: "
                    + assertion;
            verificationFailureMessage += "\nException: " + ae.toString();
            addVerificationFailure(verificationFailureMessage);
        }
    }

    private static void addVerificationFailure(String verificationFailureMessage) {
        verificationFailures.add(verificationFailureMessage);
    }

    public static ArrayList<String> getVerificationFailures() {
        return verificationFailures;
    }

    public static void resetVerificationFailures() {
        verificationFailures.clear();
    }

}
