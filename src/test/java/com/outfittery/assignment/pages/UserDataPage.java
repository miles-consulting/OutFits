package com.outfittery.assignment.pages;

import com.outfittery.assignment.utils.ContextManager;
import com.outfittery.assignment.utils.KEYS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserDataPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='user-content']")
    private WebElement userContentText;

    @FindBy(xpath = "//a[@href='/account/settings/personalinfo']")
    private WebElement editContatInfoLink;

    @FindBy(xpath = "//a[@href='/account/settings/addresses']")
    private WebElement editAddressInfoLink;

    @FindBy(xpath = "//div[@href='/account/settings/change-password']")
    private WebElement changePasswordLink;

    @FindBy(xpath = "//div[@class='container']")
    private WebElement userAddressText;

    private ContextManager contextManager = ContextManager.getInstance();


    public EditUserContactDetailPage editUserContact() {
        clickOnElement(editContatInfoLink);
        return new EditUserContactDetailPage();
    }


    public boolean hasPhoneNumberUpdated(String phoneNumber) {
        waitForElementToBeVisible(userContentText);
        return userContentText.getText().contains(phoneNumber);
    }

    public EditUserAddressPage editUserAddress() {
        clickOnElement(editAddressInfoLink);
        return new EditUserAddressPage();
    }

    public boolean hasAddressUpdated() {
        waitForElementToBeVisible(userContentText);
        String rawUserAddressText = userAddressText.getText();
        String expectedStreetAddress = contextManager.get(KEYS.USERSTREET).toString();
        String expectedStreetNo = contextManager.get(KEYS.USERSTREETNO).toString();
        String expectedZip = contextManager.get(KEYS.USERZIP).toString();
        String expectedCity = contextManager.get(KEYS.USERCITY).toString();
        return rawUserAddressText.contains(expectedStreetAddress)
                && rawUserAddressText.contains(expectedStreetNo)
                && rawUserAddressText.contains(expectedZip)
                && rawUserAddressText.contains(expectedCity);
    }

    public EditPasswordPage editPassword() {
        clickOnElement(changePasswordLink);
        return new EditPasswordPage();
    }
}
