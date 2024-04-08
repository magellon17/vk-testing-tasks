package ru.siobko.testing.tasks.junit.core.main;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage extends BaseMainPage {
    private final By aboutGroupPanel = byXpath(".//div[@data-module='GroupInfoPanel']");
    private final By groupMembersButton = byXpath(".//a[@data-l='outlandermenu,altGroupMembers']");
    private final By groupName = byClassName("group-name_h");
    private final By groupFeed = byXpath(".//div[@data-l='fL,group']");
    private final By moreActionsButton = byXpath(".//li[@class='u-menu_li expand-action-item']");

    //Ниже идут поля окон, которые появляются в процессе удаления группы.
    private final By deleteButton = byText("Удалить");
    private final By confirmDeletionButton = byXpath(".//*[@data-l='t,confirm']");

    public GroupPage() {
        checkPage();
    }

    private void checkPage() {
        $(aboutGroupPanel).shouldBe(visible);
        $(groupFeed).shouldBe(visible);
        $(groupMembersButton).shouldBe(visible);
    }

    public void deleteGroup() {
        $(moreActionsButton).click();
        $(deleteButton).click();
        $(confirmDeletionButton).click();
    }

    public boolean checkGroupNameEquals(String myGroup) {
        return $(groupName).getText().equals(myGroup);
    }
}
