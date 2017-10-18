package com.outfittery.assignment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class EditUserAddressPage extends AbstractPage {
    @FindBy(xpath = "//a[@class='edit-delete']")
    private WebElement editDeleteLink;

    @FindBy(name = "street")
    private WebElement streetTextbox;

    @FindBy(name = "number")
    private WebElement numberTextbox;

    @FindBy(name = "zip")
    private WebElement zipTextbox;

    @FindBy(name = "city")
    private WebElement cityTextbox;

    @FindBy(name = "submitBtn")
    private WebElement submitButton;


    public void editAddress(Map<String, String> userDataMap) {
        String street = userDataMap.get("Street");
        String streetNo = userDataMap.get("StreetNo");
        String zip = userDataMap.get("Zip");
        String city = userDataMap.get("City");

        clickOnElement(editDeleteLink);
        enterTextTo(streetTextbox, street);
        enterTextTo(numberTextbox, streetNo);
        enterTextTo(zipTextbox, zip);
        enterTextTo(cityTextbox, city);
        clickOnElement(submitButton);
    }
}
