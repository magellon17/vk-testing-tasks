package ru.siobko.testing.tasks.junit.core.main.groups;

import org.openqa.selenium.By;
import ru.siobko.testing.tasks.junit.core.main.group.GroupFeedPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class GroupsPage extends BaseGroupsPage {
    private static final By CREATE_GROUP_BUTTON = byText("Создать группу");

    //Поля окон, которые появляются в процессе создания группы.
    private static final By GROUP_BY_INTEREST_BUTTON = byXpath(".//a[@data-l='t,INTEREST']");
    private static final By GROUP_NAME_FIELD = byId("field_name");
    private static final By THEMATICS_LIST = byXpath(".//div[@class='it js-multi-select_visual-input']");
    private static final By AUTO_THEMATIC_BUTTON = byText("Автомобили");
    private static final By CREATE_BUTTON = byXpath(".//input[@data-l='t,confirm']");

    public GroupsPage clickCreateGroup() {
        $(CREATE_GROUP_BUTTON).shouldBe(
                visible.because("Button 'Создать группу' should be visible on page 'Группы'.")
        ).click();
        return this;
    }

    public GroupsPage clickGroupByInterest() {
        $(GROUP_BY_INTEREST_BUTTON).shouldBe(
                visible.because("Button 'Группа по интересам' should be visible after clicking button 'Создать группу'.")
        ).click();
        return this;
    }

    public GroupsPage enterGroupName(String Name) {
        $(GROUP_NAME_FIELD).shouldBe(
                visible.because("Field 'Название' should be visible while creating a group.")
        ).setValue(Name);
        return this;
    }

    public GroupsPage expandThematicsList() {
        $(THEMATICS_LIST).shouldBe(
                visible.because("List 'Тематика' should be visible while creating a group.")
        ).click();
        return this;
    }

    public GroupsPage clickAutoThematic() {
        $(AUTO_THEMATIC_BUTTON).shouldBe(
                visible.because("Thematic 'Автомобили' should be visible after opening thematic list.")
        ).click();
        return this;
    }

    public GroupFeedPage clickCreate() {
        $(CREATE_BUTTON).shouldBe(
                visible.because("Button 'Создать' should be visible while creating a group.")
        ).click();
        return new GroupFeedPage();
    }
}
