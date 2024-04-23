package ru.siobko.testing.tasks.selenide.pages.main;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FeedPage extends BaseMainPage {
    private static final By profileAvatar = byId("hook_Block_Avatar");
    private static final By onlineFriendsPanel = byId("online-fr_block");
    private static final By feedFilterMenu = byXpath(".//hybrid-feed-filter[@data-bundle-name='contents_hybrid-feed-filter']");

    public FeedPage() {
        checkPage();
    }

    public boolean checkPage() {
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

    public boolean checkProfileNameContains(String email) {
        return $(myProfileButton).shouldBe(
                        visible.because("My profile button should be visible on all main pages.")
                ).getText()
                .contains(email);
    }
}
