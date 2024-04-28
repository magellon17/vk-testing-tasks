package ru.siobko.testing.tasks.junit.core.main.groups;

import org.openqa.selenium.By;
import ru.siobko.testing.tasks.junit.core.main.BaseMainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public abstract class BaseGroupsPage extends BaseMainPage {
    protected static final By GROUP_SEARCH_FIELD = byXpath(".//group-search-input[@data-bundle-name='search_group-search-input']");
    protected static final By GROUPS_CATALOG_HEADER = byClassName("groups-catalog-header");
    protected static final By OFFICIAL_GROUPS_BUTTON = byXpath(".//a[@aria-label='Официальные']");

    protected BaseGroupsPage() {
        checkPage();
    }

    @Override
    protected boolean checkPage() {
        $(GROUP_SEARCH_FIELD).shouldBe(
                visible.because("Group search field should be visible on page 'Группы'.")
        );
        $(GROUPS_CATALOG_HEADER).shouldBe(
                visible.because("Groups catalog header should be visible on page 'Группы'.")
        );
        return true;
    }

    public OfficialGroupsPage openOfficialGroupsCatalog() {
        $(OFFICIAL_GROUPS_BUTTON).shouldBe(
                visible.because("Button 'Создать' should be visible while creating a group.")
        ).click();
        return new OfficialGroupsPage();
    }

}
