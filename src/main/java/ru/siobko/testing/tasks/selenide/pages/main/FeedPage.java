package ru.siobko.testing.tasks.selenide.pages.main;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class FeedPage extends BaseMainPage {
    private static final SelenideElement profileAvatar = $(byId("hook_Block_Avatar"));
    private static final SelenideElement myProfileButton = $(byXpath(".//a[@data-l='t,userPage']"));
    private static final SelenideElement onlineFriendsPanel = $(byId("online-fr_block"));
    private static final SelenideElement publishPostButton = $(byXpath(".//*[@class='item-container__7e56q']"));
    private static final SelenideElement feedFilterMenu = $(byXpath(".//hybrid-feed-filter[@data-bundle-name='contents_hybrid-feed-filter']"));
    private static final SelenideElement postTextBox = $(byXpath(".//div[@data-module='postingForm/mediaText']"));
    private static final SelenideElement submitButton = $(byXpath(".//button[@data-l='t,button.submit']"));

    public FeedPage() {
        checkPage();
    }

    private void checkPage() {
        profileAvatar.shouldBe(visible);
        feedFilterMenu.shouldBe(visible);
        onlineFriendsPanel.shouldBe(visible);
    }

    public GroupsPage openGroupsPage() {
        groupsButton.click();
        return new GroupsPage();
    }

    public SelenideElement getMyProfileButton() {
        return myProfileButton;
    }

    public void publishTextPost(String postText) {
        publishButton.click();
        publishPostButton.click();
        postTextBox.setValue(postText);
        submitButton.click();
    }

    public MyProfilePage openMyProfilePage() {
        myProfileButton.click();
        return new MyProfilePage();
    }

}
