package ru.siobko.testing.tasks.junit.core.main;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class GroupsPage extends BaseMainPage {
    private static final By groupSearchField = byXpath(".//group-search-input[@data-bundle-name='search_group-search-input']");
    private static final By groupsCatalogHeader = byClassName("groups-catalog-header");
    private static final By createGroupButton = byText("Создать группу");

    //Поля окон, которые появляются в процессе создания группы.
    private static final By chooseGroupByInterest = byXpath(".//a[@data-l='t,INTEREST']");
    private static final By groupNameField = byId("field_name");
    private static final By thematicsList = byXpath(".//div[@class='it js-multi-select_visual-input']");
    private static final By chooseAutoThematic = byText("Автомобили");
    private static final By createButton = byXpath(".//input[@data-l='t,confirm']");

    public GroupsPage() {
        checkPage();
    }

    public static boolean checkPage() {
        $(createGroupButton).shouldBe(visible);
        $(groupSearchField).shouldBe(visible);
        $(groupsCatalogHeader).shouldBe(visible);
        return true;
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
