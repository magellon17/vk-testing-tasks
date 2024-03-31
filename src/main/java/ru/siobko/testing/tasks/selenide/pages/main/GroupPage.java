package ru.siobko.testing.tasks.selenide.pages.main;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage extends BaseMainPage {
    private static final SelenideElement aboutGroupPanel = $(byXpath(".//div[@data-module='GroupInfoPanel']"));
    private static final SelenideElement groupMembersButton = $(byXpath(".//a[@data-l='outlandermenu,altGroupMembers']"));
    private static final SelenideElement groupName = $(byClassName("group-name_h"));
    private static final SelenideElement groupThematic = $(byClassName("group-name_info"));
    private static final SelenideElement moreActionsButton = $(byXpath(".//li[@class='u-menu_li expand-action-item']"));
    private static final SelenideElement deleteButton = $(byText("Удалить"));
    private static final SelenideElement confirmDeletionButton = $(byXpath(".//*[@data-l='t,confirm']"));
    private static final SelenideElement groupFeed = $(byXpath(".//div[@data-l='fL,group']"));

    public GroupPage() {
        checkPage();
    }

    private void checkPage() {
        aboutGroupPanel.shouldBe(visible);
        groupFeed.shouldBe(visible);
        groupMembersButton.shouldBe(visible);
    }

    public String getGroupName() {
        return groupName.getText();
    }

    public String getGroupThematic() {
        return groupThematic.getText();
    }

    public SelenideElement getMoreActionsButton() {
        return moreActionsButton;
    }

    public SelenideElement getDeleteButton() {
        return deleteButton;
    }

    public SelenideElement getConfirmDeletionButton() {
        return confirmDeletionButton;
    }
}
