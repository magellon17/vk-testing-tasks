package ru.siobko.testing.tasks.junit.core.main.group;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GroupFeedPage extends BaseGroupPage {
    private static final By ABOUT_GROUP_PANEL = byXpath(".//div[@data-module='GroupInfoPanel']");
    private static final By GROUP_NAME = byClassName("group-name_h");
    private static final By GROUP_FEED = byXpath(".//div[@data-l='fL,group']");
    private static final By MORE_ACTIONS_BUTTON = byXpath(".//li[@class='u-menu_li expand-action-item']");

    //Поля окон, которые появляются в процессе удаления группы.
    private static final By DELETE_BUTTON = byText("Удалить");
    private static final By CONFIRM_DELETION_BUTTON = byXpath(".//*[@data-l='t,confirm']");

    public GroupFeedPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(ABOUT_GROUP_PANEL).shouldBe(
                visible.because("Panel 'О группе' should be visible on group page.")
        );
        $(GROUP_FEED).shouldBe(
                visible.because("Group feed should be visible on group page.")
        );
        return true;
    }

    public GroupFeedPage clickMoreActions() {
        $(MORE_ACTIONS_BUTTON).shouldBe(
                visible.because("More actions button should be visible on group page.")
        ).click();
        return this;
    }

    public GroupFeedPage clickDelete() {
        $(DELETE_BUTTON).shouldBe(
                visible.because("Button 'Удалить' should be visible on more actions menu.")
        ).click();
        return this;
    }

    public void confirmDeletion() {
        $(CONFIRM_DELETION_BUTTON).shouldBe(
                visible.because("Confirm deletion button should be visible while deleting a group.")
        ).click();
    }

    public String getGroupName() {
        return $(GROUP_NAME).shouldBe(
                visible.because("Group name should be visible on group page.")
        ).getText();
    }
}
