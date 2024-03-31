package ru.siobko.testing.tasks.selenide.pages.main;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class FeedPage extends BaseMainPage {
    private final SelenideElement profileAvatar = $(byId("hook_Block_Avatar"));
    private final SelenideElement onlineFriendsPanel = $(byId("online-fr_block"));
    private final SelenideElement feedFilterMenu = $(byXpath(".//hybrid-feed-filter[@data-bundle-name='contents_hybrid-feed-filter']"));
    private final SelenideElement publishPostButton = $(byXpath(".//*[@class='item-container__7e56q']"));

    //Ниже идут поля окон, которые появляются в процессе создания текстового поста.
    private final SelenideElement postTextBox = $(byXpath(".//div[@data-module='postingForm/mediaText']"));
    private final SelenideElement submitButton = $(byXpath(".//button[@data-l='t,button.submit']"));

    public FeedPage() {
        checkPage();
    }

    private void checkPage() {
        profileAvatar.shouldBe(visible);
        feedFilterMenu.shouldBe(visible);
        onlineFriendsPanel.shouldBe(visible);
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
