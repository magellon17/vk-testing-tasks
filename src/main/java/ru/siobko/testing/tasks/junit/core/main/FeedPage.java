package ru.siobko.testing.tasks.junit.core.main;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FeedPage extends BaseMainPage {
    private static final By profileAvatar = byId("hook_Block_Avatar");
    private static final By userCardToolbarDropdown = byXpath(".//button[@aria-label='Настройки профиля']");
    private static final By userCardToolbarLogoutButton = byXpath(".//a[@data-l='t,logout']");
    private static final By confirmLogoutButton = byXpath(".//input[@data-l='t,logout']");
    private static final By onlineFriendsPanel = byId("online-fr_block");
    private static final By feedFilterMenu = byXpath(".//hybrid-feed-filter[@data-bundle-name='contents_hybrid-feed-filter']");
    private static final By publishPostButton = byXpath(".//*[@class='item-container__7e56q']");

    //Поля окон, которые появляются в процессе создания текстового поста.
    private static final By postTextBox = byXpath(".//div[@data-module='postingForm/mediaText']");
    private static final By submitButton = byXpath(".//button[@data-l='t,button.submit']");

    public FeedPage() {
        checkPage();
    }

    public static boolean checkPage() {
        $(profileAvatar).shouldBe(
                visible.because("Profile avatar should be visible on page 'Лента'.")
        );
        $(feedFilterMenu).shouldBe(
                visible.because("Feed filter menu should be visible on page 'Лента'.")
        );
        $(onlineFriendsPanel).shouldBe(
                visible.because("Panel 'Друзья на сайте' should be visible on page 'Лента'.")
        );
        return true;
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

    public FeedPage openUserCardToolbar() {
        $(userCardToolbarDropdown).click();
        return this;
    }

    public FeedPage logout() {
        $(userCardToolbarLogoutButton).click();
        return this;
    }

    public LoginPage confirmLogout() {
        $(confirmLogoutButton).click();
        return new LoginPage();
    }

    public boolean checkProfileNameContains(String email) {
        return $(myProfileButton)
                .getText()
                .contains(email);
    }
}
