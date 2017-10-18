package com.outfittery.assignment.pages;

import com.outfittery.assignment.utils.ContextManager;
import com.outfittery.assignment.utils.KEYS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage {
    @FindBy(id = "username")
    private WebElement userNameTextBox;

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(id = "submit")
    private WebElement submitButton;
    private ContextManager contextManager = ContextManager.getInstance();

    public void enterUserCredentials(String userName, String password) {
        enterTextTo(userNameTextBox, userName);
        enterTextTo(passwordTextBox, password);
        clickOnElement(submitButton);
    }
}
