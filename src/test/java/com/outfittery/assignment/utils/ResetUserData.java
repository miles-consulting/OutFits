package com.outfittery.assignment.utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ResetUserData {
    static String authToken = "8b442fc063ce4b03b061ed987608cad9";
    static String authUID = "736871752";
    static String contentType = "application/json";
    static String acceptVersion = "2.0.0";


    public static void resetPhoneNumber() {
        RestAssured.baseURI = "https://api.apps.outfittery.de";
        RequestSpecification rspec;
        RequestSpecBuilder build = new RequestSpecBuilder();
        build.addParam("id", authUID);
        build.addParam("salutation", 1);
        build.addParam("firstName", "Outfittery");
        build.addParam("lastName", "Gentleman");
        build.addParam("email", "it_test_dimitri@outfittery.com");
        build.addParam("newsletter", false);
        build.addParam("countryCode", "GB");
        build.addParam("nationalIdVerified", false);
        build.addParam("guestAccount", false);
        build.addParam("defaultPaymentMethod", "null");
        build.addParam("stylistId", 118566682);
        build.addParam("hasDefaultStylist", true);
        build.addParam("profile", "{}");
        build.addParam("phoneNumber", "+00111111111");
        rspec = build.build();
        given()
                .header("x-auth-token", authToken)
                .header("x-auth-uid", authUID)
                .header("Content-Type", contentType)
                .header("accept-version", acceptVersion)
                .when()
                .spec(rspec)
                .put("/customers/736871752")
                .then()
                .assertThat()
                .statusCode(200);

    }

    public static void resetUserAddress() {

    }

    public static void resetDefaultPassword() {

    }
}
