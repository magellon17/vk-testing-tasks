package ru.siobko.testing.tasks.selenide.pages.main;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage extends BaseMainPage {
    private final SelenideElement aboutGroupPanel = $(byXpath(".//div[@data-module='GroupInfoPanel']"));
    private final SelenideElement groupMembersButton = $(byXpath(".//a[@data-l='outlandermenu,altGroupMembers']"));
    private final SelenideElement groupName = $(byClassName("group-name_h"));
    private final SelenideElement groupFeed = $(byXpath(".//div[@data-l='fL,group']"));
    private final SelenideElement moreActionsButton = $(byXpath(".//li[@class='u-menu_li expand-action-item']"));

    //Ниже идут поля окон, которые появляются в процессе удаления группы.
    private final SelenideElement deleteButton = $(byText("Удалить"));
    private final SelenideElement confirmDeletionButton = $(byXpath(".//*[@data-l='t,confirm']"));

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

    public void deleteGroup() {
        moreActionsButton.click();
        deleteButton.click();
        confirmDeletionButton.click();
    }
}
