package ru.siobko.testing.tasks.junit.core.main;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FeedPage extends BaseMainPage {
    private static final By PROFILE_AVATAR = byId("hook_Block_Avatar");
    private static final By ONLINE_FRIENDS_PANEL = byId("online-fr_block");
    private static final By FEED_FILTER_MENU = byXpath(".//hybrid-feed-filter[@data-bundle-name='contents_hybrid-feed-filter']");

    public FeedPage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        $(PROFILE_AVATAR).shouldBe(
                visible.because("Profile avatar should be visible on page 'Лента'.")
        );
        $(FEED_FILTER_MENU).shouldBe(
                visible.because("Feed filter menu should be visible on page 'Лента'.")
        );
        $(ONLINE_FRIENDS_PANEL).shouldBe(
                visible.because("Panel 'Друзья на сайте' should be visible on page 'Лента'.")
        );
        return true;
    }

    public boolean checkProfileNameContains(String email) {
        return $(MY_PROFILE_BUTTON).shouldBe(
                        visible.because("My profile button should be visible on all main pages.")
                ).getText()
                .contains(email);
    }
}
