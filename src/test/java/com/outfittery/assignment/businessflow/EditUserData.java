package com.outfittery.assignment.businessflow;

import com.outfittery.assignment.pages.DashboardPage;
import com.outfittery.assignment.pages.UserDataPage;
import com.outfittery.assignment.utils.ContextManager;
import com.outfittery.assignment.utils.KEYS;

import java.util.Map;

import static com.outfittery.assignment.utils.CustomAsserts.assertThat;

public class EditUserData {
    private ContextManager contextManager = ContextManager.getInstance();

    public void editPhoneNumber(String phoneNumber) {
        new DashboardPage().navigateToSettingPage();
        contextManager.addToContext(KEYS.USERCONTACT, phoneNumber);
        new UserDataPage().editUserContact().editContactInfo(phoneNumber);
    }

    public void checkUpdatedPhoneNumber() {
        assertThat("Phone Number is not updated", new UserDataPage().hasPhoneNumberUpdated(contextManager.get(KEYS.USERCONTACT).toString()));
    }

    public void editUserAddress(Map<String, String> userDataMap) {
        new DashboardPage().navigateToSettingPage();
        contextManager.addToContext(KEYS.USERSTREET, userDataMap.get("Street"));
        contextManager.addToContext(KEYS.USERSTREETNO, userDataMap.get("StreetNo"));
        contextManager.addToContext(KEYS.USERZIP, userDataMap.get("Zip"));
        contextManager.addToContext(KEYS.USERCITY, userDataMap.get("City"));
        new UserDataPage().editUserAddress().editAddress(userDataMap);
    }

    public void checkUpdatedAddress() {
        assertThat("Address is not updated", new UserDataPage().hasAddressUpdated());
    }

    public void editPassword() {
        new DashboardPage().navigateToSettingPage();
        contextManager.addToContext(KEYS.NEWPASSWORD,"abcd1234");
        new UserDataPage().editPassword().changePassword();
    }
}
