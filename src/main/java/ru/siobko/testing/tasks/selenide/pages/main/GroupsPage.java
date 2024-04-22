package ru.siobko.testing.tasks.selenide.pages.main;

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

    public GroupsPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(createGroupButton).shouldBe(
                visible.because("Button 'Создать группу' should be visible on page 'Группы'.")
        );
        $(groupSearchField).shouldBe(
                visible.because("Group search field should be visible on page 'Группы'.")
        );
        $(groupsCatalogHeader).shouldBe(
                visible.because("Groups catalog header should be visible on page 'Группы'.")
        );
        return true;
    }

    public GroupPage createGroup(String Name) {
        $(createGroupButton).shouldBe(
                visible.because("Button 'Создать группу' should be visible on page 'Группы'.")
        ).click();
        $(groupByInterestButton).shouldBe(
                visible.because("Button 'Группа по интересам' should be visible after clicking button 'Создать группу'.")
        ).click();
        $(groupNameField).shouldBe(
                visible.because("Field 'Название' should be visible while creating a group.")
        ).setValue(Name);
        $(thematicsList).shouldBe(
                visible.because("List 'Тематика' should be visible while creating a group.")
        ).click();
        $(autoThematicButton).shouldBe(
                visible.because("Thematic 'Автомобили' should be visible after opening thematic list.")
        ).click();
        $(createButton).shouldBe(
                visible.because("Button 'Создать' should be visible while creating a group.")
        ).click();
        return new GroupPage();
    }
}
