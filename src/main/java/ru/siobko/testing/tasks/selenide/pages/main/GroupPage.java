package ru.siobko.testing.tasks.selenide.pages.main;

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

    public GroupPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(aboutGroupPanel).shouldBe(
                visible.because("Panel 'О группе' should be visible on group page.")
        );
        $(groupFeed).shouldBe(
                visible.because("Group feed should be visible on group page.")
        );
        $(groupMembersButton).shouldBe(
                visible.because("Button 'Участники' should be visible on group page.")
        );
        return true;
    }

    public void deleteGroup() {
        $(moreActionsButton).shouldBe(
                visible.because("More actions button should be visible on group page.")
        ).click();
        $(deleteButton).shouldBe(
                visible.because("Button 'Удалить' should be visible on more actions menu.")
        ).click();
        $(confirmDeletionButton).shouldBe(
                visible.because("Confirm deletion button should be visible while deleting a group.")
        ).click();
    }

    public boolean checkGroupNameEquals(String myGroup) {
        return $(groupName).shouldBe(
                        visible.because("Group name should be visible on group page.")
                ).getText()
                .equals(myGroup);
    }
}
