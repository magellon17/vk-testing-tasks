package ru.siobko.testing.tasks.junit.core.main;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage extends BaseMainPage {
    private static final By aboutGroupPanel = byXpath(".//div[@data-module='GroupInfoPanel']");
    private static final By groupMembersButton = byXpath(".//a[@data-l='outlandermenu,altGroupMembers']");
    private static final By groupName = byClassName("group-name_h");
    private static final By groupFeed = byXpath(".//div[@data-l='fL,group']");
    private static final By moreActionsButton = byXpath(".//li[@class='u-menu_li expand-action-item']");

    //Ниже идут поля окон, которые появляются в процессе удаления группы.
    private static final By deleteButton = byText("Удалить");
    private static final By confirmDeletionButton = byXpath(".//*[@data-l='t,confirm']");

    public GroupPage() {
        checkPage();
    }

    public static boolean checkPage() {
        $(aboutGroupPanel).shouldBe(visible);
        $(groupFeed).shouldBe(visible);
        $(groupMembersButton).shouldBe(visible);
        return true;
    }

    public void deleteGroup() {
        $(moreActionsButton).click();
        $(deleteButton).click();
        $(confirmDeletionButton).click();
    }

    public boolean checkGroupNameEquals(String myGroup) {
        return $(groupName)
                .getText()
                .equals(myGroup);
    }
}
