package com.outfittery.assignment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//a[@href='/login/auth']")
    private WebElement loginLink;


    public void navigateToSignin() {
        clickOnElement(loginLink);
    }
}
