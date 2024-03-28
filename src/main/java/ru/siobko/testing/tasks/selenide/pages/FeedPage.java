package ru.siobko.testing.tasks.selenide.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class FeedPage extends BasePage {
    public final SelenideElement profileAvatar = $(byId("hook_Block_Avatar"));

    public GroupsPage openGroupPage(){
        groupsButton.click();
        return new GroupsPage();
    }


}
