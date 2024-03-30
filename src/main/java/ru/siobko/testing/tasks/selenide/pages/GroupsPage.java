package ru.siobko.testing.tasks.selenide.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class GroupsPage extends BasePage{

    public GroupsPage(){
        check();
    }

    private void check(){
        createGroupButton.shouldBe(visible);
        popularGroupsListBlock.shouldBe(visible);
        userGroupsCatalogHeaderBlock.shouldBe(visible);
    }

    public final SelenideElement createGroupButton = $(byText("Создать группу"));
    public final SelenideElement popularGroupsListBlock = $(byId("hook_Block_PopularGroupsListBlock"));
    public final SelenideElement userGroupsCatalogHeaderBlock = $(byId("hook_Block_UserGroupsCatalogHeaderBlock"));
    public final SelenideElement chooseGroupByInterest = $(byText("Группа по интересам"));
    public final SelenideElement groupNameField = $(byId("field_name"));
    public final SelenideElement thematicsList = $("[class = 'it js-multi-select_visual-input']");
    public final SelenideElement autosButton = $(byText("Автомобили"));
    public final SelenideElement createButton = $("[data-l = 't,confirm']");



    public GroupPage createGroup(String Title){
        groupsButton.click();
        createGroupButton.click();
        chooseGroupByInterest.click();
        groupNameField.setValue(Title);
        thematicsList.click();
        autosButton.click();
        createButton.click();
        return new GroupPage();
    }
}
