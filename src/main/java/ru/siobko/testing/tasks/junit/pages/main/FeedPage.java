package ru.siobko.testing.tasks.junit.pages.main;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FeedPage extends BaseMainPage {
    private final By profileAvatar = byId("hook_Block_Avatar");
    private final By onlineFriendsPanel = byId("online-fr_block");
    private final By feedFilterMenu = byXpath(".//hybrid-feed-filter[@data-bundle-name='contents_hybrid-feed-filter']");
    private final By publishPostButton = byXpath(".//*[@class='item-container__7e56q']");

    //Поля окон, которые появляются в процессе создания текстового поста.
    private final By postTextBox = byXpath(".//div[@data-module='postingForm/mediaText']");
    private final By submitButton = byXpath(".//button[@data-l='t,button.submit']");

    public FeedPage() {
        checkPage();
    }

    private void checkPage() {
        $(profileAvatar).shouldBe(visible);
        $(feedFilterMenu).shouldBe(visible);
        $(onlineFriendsPanel).shouldBe(visible);
    }

    public void publishTextPost(String postText) {
        $(publishButton).click();
        $(publishPostButton).click();
        $(postTextBox).setValue(postText);
        $(submitButton).click();
    }

    public MyProfilePage openMyProfilePage() {
        $(myProfileButton).click();
        return new MyProfilePage();
    }
}
