package ru.siobko.testing.tasks.selenide.pages.main;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class GroupsPage extends BaseMainPage {
    private final SelenideElement groupSearchField = $(byXpath(".//group-search-input[@data-bundle-name='search_group-search-input']"));
    private final SelenideElement groupsCatalogHeader = $(byClassName("groups-catalog-header"));
    private final SelenideElement createGroupButton = $(byText("Создать группу"));

    //Поля окон, которые появляются в процессе создания группы.
    private final SelenideElement chooseGroupByInterest = $(byXpath(".//a[@data-l='t,INTEREST']"));
    private final SelenideElement groupNameField = $(byId("field_name"));
    private final SelenideElement thematicsList = $(byXpath(".//div[@class='it js-multi-select_visual-input']"));
    private final SelenideElement chooseAutoThematic = $(byText("Автомобили"));
    private final SelenideElement createButton = $(byXpath(".//input[@data-l='t,confirm']"));

    public GroupsPage() {
        checkPage();
    }

    private void checkPage() {
        createGroupButton.shouldBe(visible);
        groupSearchField.shouldBe(visible);
        groupsCatalogHeader.shouldBe(visible);
    }

    public GroupPage createGroup(String Name) {
        createGroupButton.click();
        chooseGroupByInterest.click();
        groupNameField.setValue(Name);
        thematicsList.click();
        chooseAutoThematic.click();
        createButton.click();
        return new GroupPage();
    }
}
