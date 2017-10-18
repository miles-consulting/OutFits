package com.outfittery.assignment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditUserContactDetailPage extends AbstractPage {

    @FindBy(name = "phoneNumber")
    private WebElement phoneNumberTextBox;

    @FindBy(name = "submit")
    private WebElement submitButton;

    public void editContactInfo(String phoneNumber) {
        enterTextTo(phoneNumberTextBox, phoneNumber);
        clickOnElement(submitButton);
    }


}
