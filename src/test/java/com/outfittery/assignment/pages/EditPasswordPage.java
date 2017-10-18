package com.outfittery.assignment.pages;

import com.outfittery.assignment.utils.ContextManager;
import com.outfittery.assignment.utils.KEYS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPasswordPage extends AbstractPage {

    @FindBy(xpath = "//input[@name='oldPW']")
    private WebElement oldPasswordTextBox;

    @FindBy(xpath = "//input[@name='newPW']")
    private WebElement newPasswordTextBox;

    @FindBy(xpath = "//input[@name='confirmNewPW']")
    private WebElement newConfirmPasswordTextBox;

    @FindBy(name = "submit")
    private WebElement changePasswordSubmit;

    private ContextManager contextManager = ContextManager.getInstance();

    public void changePassword() {
        enterTextTo(oldPasswordTextBox, contextManager.get(KEYS.OUTFITTERY_PASSWORD).toString());
        enterTextTo(newPasswordTextBox, contextManager.get(KEYS.NEWPASSWORD).toString());
        enterTextTo(newConfirmPasswordTextBox, contextManager.get(KEYS.NEWPASSWORD).toString());
        waitForSeconds();
        clickOnElement(changePasswordSubmit);
    }

    private void waitForSeconds() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
