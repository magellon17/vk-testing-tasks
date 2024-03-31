package ru.siobko.testing.tasks.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage extends BasePage {
    private static final SelenideElement aboutGroupPanel = $(byId("hook_Block_LeftColumnTopCardAltGroup"));
    private static final SelenideElement mainContentHeader = $(byId("hook_Block_MainContentHeader"));
    private static final SelenideElement groupName = $(byClassName("group-name_h"));
    private static final SelenideElement moreActionsButton = $(byXpath(".//*[@class='u-menu_a toggle-dropdown button-clear']"));
    private static final SelenideElement deleteButton = $(byText("Удалить"));
    private static final SelenideElement confirmDeletionButton = $(byXpath(".//*[@data-l='t,confirm']"));

    public GroupPage() {
        checkPage();
    }

    private void checkPage() {
        mainContentHeader.shouldBe(visible);
        aboutGroupPanel.shouldBe(visible);
    }

    public SelenideElement getGroupName() {
        return groupName;
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
