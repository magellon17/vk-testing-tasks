package ru.siobko.testing.tasks.selenide.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    protected static final SelenideElement groupsButton = $(byXpath(".//*[@data-l='t,userAltGroup']"));
    protected static final SelenideElement friendsButton = $(byXpath(".//*[@data-l='t,userFriend']"));
    protected static final SelenideElement navigationPanel = $(byClassName("navigation"));
    protected static final SelenideElement navigationToolBar = $(byClassName("toolbar_decor"));
    protected static final SelenideElement possibleFriendsList = $(byClassName("content__phat2"));
    protected static final SelenideElement onlineFriendsList = $(byClassName("online-fr_list"));
    protected static final SelenideElement publishButton = $(byXpath(".//*[@data-testid='ddm-button']"));

}
