package ru.siobko.testing.tasks.selenide.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class GroupsPage extends BasePage {
    private static final SelenideElement createGroupButton = $(byText("Создать группу"));
    private static final SelenideElement popularGroupsListBlock = $(byId("hook_Block_PopularGroupsListBlock"));
    private static final SelenideElement userGroupsCatalogHeaderBlock = $(byId("hook_Block_UserGroupsCatalogHeaderBlock"));
    private static final SelenideElement chooseGroupByInterest = $(byXpath(".//*[@data-l='t,INTEREST']"));
    private static final SelenideElement groupNameField = $(byId("field_name"));
    private static final SelenideElement thematicsList = $(byXpath(".//*[@class='it js-multi-select_visual-input']"));
    private static final SelenideElement autoThematicButton = $(byText("Автомобили"));
    private static final SelenideElement createButton = $(byXpath(".//*[@data-l='t,confirm']"));

    public GroupsPage() {
        checkPage();
    }

    private void checkPage() {
        createGroupButton.shouldBe(visible);
        popularGroupsListBlock.shouldBe(visible);
        userGroupsCatalogHeaderBlock.shouldBe(visible);
    }

    public GroupPage createGroup(String Title) {
        groupsButton.click();
        createGroupButton.click();
        chooseGroupByInterest.click();
        groupNameField.setValue(Title);
        thematicsList.click();
        autoThematicButton.click();
        createButton.click();
        return new GroupPage();
    }
}
