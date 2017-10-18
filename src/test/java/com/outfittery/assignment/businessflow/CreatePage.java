package com.outfittery.assignment.businessflow;

import com.outfittery.assignment.pages.DashboardPage;

import java.util.Map;

public class CreatePage {

    public void createNewPageWith(Map<String, String> pageDetails) {
        new DashboardPage().createNewPage(pageDetails);
    }
}
