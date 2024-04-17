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

    //Поля окон, которые появляются в процессе удаления группы.
    private static final By deleteButton = byText("Удалить");
    private static final By confirmDeletionButton = byXpath(".//*[@data-l='t,confirm']");

    private static final String ABOUT_GROUP_PANEL_LOG_INFO = "Panel 'О группе' should be visible on group page.";
    private static final String GROUP_FEED_LOG_INFO = "Group feed should be visible on group page.";
    private static final String GROUP_MEMBERS_BUTTON_LOG_INFO = "Button 'Участники' should be visible on group page.";
    private static final String GROUP_NAME_LOG_INFO = "Group name should be visible on group page.";
    private static final String MORE_ACTIONS_BUTTON_LOG_INFO = "More actions button should be visible on group page.";
    private static final String DELETE_BUTTON_LOG_INFO = "Button 'Удалить' should be visible on more actions menu.";
    private static final String CONFIRM_DELETION_BUTTON_LOG_INFO = "Confirm deletion button should be visible while deleting a group.";

    public GroupPage() {
        checkPage();
    }

    public static boolean checkPage() {
        $(aboutGroupPanel).shouldBe(
                visible.because(ABOUT_GROUP_PANEL_LOG_INFO)
        );
        $(groupFeed).shouldBe(
                visible.because(GROUP_FEED_LOG_INFO)
        );
        $(groupMembersButton).shouldBe(
                visible.because(GROUP_MEMBERS_BUTTON_LOG_INFO)
        );
        return true;
    }

    public void deleteGroup() {
        $(moreActionsButton).shouldBe(
                visible.because(MORE_ACTIONS_BUTTON_LOG_INFO)
        ).click();
        $(deleteButton).shouldBe(
                visible.because(DELETE_BUTTON_LOG_INFO)
        ).click();
        $(confirmDeletionButton).shouldBe(
                visible.because(CONFIRM_DELETION_BUTTON_LOG_INFO)
        ).click();
    }

    public boolean checkGroupNameEquals(String myGroup) {
        return $(groupName).shouldBe(
                        visible.because(GROUP_NAME_LOG_INFO)
                ).getText()
                .equals(myGroup);
    }
}
