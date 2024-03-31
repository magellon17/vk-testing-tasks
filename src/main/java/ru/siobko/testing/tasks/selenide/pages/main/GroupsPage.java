package ru.siobko.testing.tasks.selenide.pages.main;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class GroupsPage extends BaseMainPage {
    private static final SelenideElement createGroupButton = $(byText("Создать группу"));
    private static final SelenideElement groupsCatalogHeader = $(byClassName("groups-catalog-header"));
    private static final SelenideElement chooseGroupByInterest = $(byXpath(".//a[@data-l='t,INTEREST']"));
    private static final SelenideElement groupNameField = $(byId("field_name"));
    private static final SelenideElement thematicsList = $(byXpath(".//div[@class='it js-multi-select_visual-input']"));
    private static final SelenideElement autoThematicButton = $(byText("Автомобили"));
    private static final SelenideElement createButton = $(byXpath(".//input[@data-l='t,confirm']"));
    private static final SelenideElement groupSearchField = $(byXpath(".//group-search-input[@data-bundle-name='search_group-search-input']"));

    public GroupsPage() {
        checkPage();
    }

    private void checkPage() {
        createGroupButton.shouldBe(visible);
        groupSearchField.shouldBe(visible);
        groupsCatalogHeader.shouldBe(visible);
    }

    public GroupPage createGroup(String Name) {
        groupsButton.click();
        createGroupButton.click();
        chooseGroupByInterest.click();
        groupNameField.setValue(Name);
        thematicsList.click();
        autoThematicButton.click();
        createButton.click();
        return new GroupPage();
    }
}
