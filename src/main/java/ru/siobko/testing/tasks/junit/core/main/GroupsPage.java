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
    private static final By groupByInterestButton = byXpath(".//a[@data-l='t,INTEREST']");
    private static final By groupNameField = byId("field_name");
    private static final By thematicsList = byXpath(".//div[@class='it js-multi-select_visual-input']");
    private static final By autoThematicButton = byText("Автомобили");
    private static final By createButton = byXpath(".//input[@data-l='t,confirm']");

    private static final String CREATE_GROUP_BUTTON_LOG_INFO = "Button 'Создать группу' should be visible on page 'Группы'.";
    private static final String GROUPS_SEARCH_FIELD_LOG_INFO = "Group search field should be visible on page 'Группы'.";
    private static final String GROUPS_CATALOG_HEADER_LOG_INFO = "Groups catalog header should be visible on page 'Группы'.";
    private static final String GROUP_BY_INTEREST_BUTTON_LOG_INFO = "Button 'Группа по интересам' should be visible after clicking button 'Создать группу'.";
    private static final String GROUP_NAME_FIELD_LOG_INFO = "Field 'Название' should be visible while creating a group.";
    private static final String THEMATICS_LIST_LOG_INFO = "List 'Тематика' should be visible while creating a group.";
    private static final String AUTO_THEMATIC_BUTTON_LOG_INFO = "Thematic 'Автомобили' should be visible after opening thematic list.";
    private static final String CREATE_BUTTON_LOG_INFO = "Button 'Создать' should be visible while creating a group.";

    public GroupsPage() {
        checkPage();
    }

    public static boolean checkPage() {
        $(createGroupButton).shouldBe(
                visible.because(CREATE_GROUP_BUTTON_LOG_INFO)
        );
        $(groupSearchField).shouldBe(
                visible.because(GROUPS_SEARCH_FIELD_LOG_INFO)
        );
        $(groupsCatalogHeader).shouldBe(
                visible.because(GROUPS_CATALOG_HEADER_LOG_INFO)
        );
        return true;
    }

    public GroupPage createGroup(String Name) {
        $(createGroupButton).shouldBe(
                visible.because(CREATE_GROUP_BUTTON_LOG_INFO)
        ).click();
        $(groupByInterestButton).shouldBe(
                visible.because(GROUP_BY_INTEREST_BUTTON_LOG_INFO)
        ).click();
        $(groupNameField).shouldBe(
                visible.because(GROUP_NAME_FIELD_LOG_INFO)
        ).setValue(Name);
        $(thematicsList).shouldBe(
                visible.because(THEMATICS_LIST_LOG_INFO)
        ).click();
        $(autoThematicButton).shouldBe(
                visible.because(AUTO_THEMATIC_BUTTON_LOG_INFO)
        ).click();
        $(createButton).shouldBe(
                visible.because(CREATE_BUTTON_LOG_INFO)
        ).click();
        return new GroupPage();
    }
}
