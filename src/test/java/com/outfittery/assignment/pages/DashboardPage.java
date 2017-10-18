package com.outfittery.assignment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends AbstractPage {

    @FindBy(xpath = "//div[@href='/account/settings']")
    private WebElement settingPanel;

    public void navigateToSettingPage() {
        clickOnElement(settingPanel);
    }
}
