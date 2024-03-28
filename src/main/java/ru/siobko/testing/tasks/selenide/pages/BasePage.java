package ru.siobko.testing.tasks.selenide.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    public final SelenideElement groupsButton = $("[data-l = 't,userAltGroup']");
    public final SelenideElement friendsButton = $("[data-l = 't,userFriend']");
    public final SelenideElement navigationPanel = $(byClassName("navigation"));
    public final SelenideElement navigationToolBar = $(byClassName("toolbar_decor"));
    public final SelenideElement possibleFriendsList = $(byClassName("content__phat2"));
    public final SelenideElement onlineFriendsList = $(byClassName("online-fr_list"));
    public final SelenideElement publishButton = $("[data-testid = 'ddm-button']");

}
