package ru.siobko.testing.tasks.junit.core.main;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class GroupsPage extends BaseMainPage {
    private final By groupSearchField = byXpath(".//group-search-input[@data-bundle-name='search_group-search-input']");
    private final By groupsCatalogHeader = byClassName("groups-catalog-header");
    private final By createGroupButton = byText("Создать группу");

    //Поля окон, которые появляются в процессе создания группы.
    private final By chooseGroupByInterest = byXpath(".//a[@data-l='t,INTEREST']");
    private final By groupNameField = byId("field_name");
    private final By thematicsList = byXpath(".//div[@class='it js-multi-select_visual-input']");
    private final By chooseAutoThematic = byText("Автомобили");
    private final By createButton = byXpath(".//input[@data-l='t,confirm']");

    public GroupsPage() {
        checkPage();
    }

    private void checkPage() {
        $(createGroupButton).shouldBe(visible);
        $(groupSearchField).shouldBe(visible);
        $(groupsCatalogHeader).shouldBe(visible);
    }

    public GroupPage createGroup(String Name) {
        $(createGroupButton).click();
        $(chooseGroupByInterest).click();
        $(groupNameField).setValue(Name);
        $(thematicsList).click();
        $(chooseAutoThematic).click();
        $(createButton).click();
        return new GroupPage();
    }
}
