package ru.siobko.testing.tasks.selenide.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class FeedPage extends BasePage {

    public FeedPage(){
        check();
    }

    public final SelenideElement profileAvatar = $(byId("hook_Block_Avatar"));
    public final SelenideElement userPageButton = $("[data-l = 't,userPage']");

    public GroupsPage openGroupsPage(){
        groupsButton.click();
        return new GroupsPage();
    }

    private void check(){
        profileAvatar.shouldBe(visible);
    }
}
