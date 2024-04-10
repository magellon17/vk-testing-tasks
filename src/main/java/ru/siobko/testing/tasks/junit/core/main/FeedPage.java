package ru.siobko.testing.tasks.junit.core.main;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FeedPage extends BaseMainPage {
    private static final By profileAvatar = byId("hook_Block_Avatar");
    private static final By onlineFriendsPanel = byId("online-fr_block");
    private static final By feedFilterMenu = byXpath(".//hybrid-feed-filter[@data-bundle-name='contents_hybrid-feed-filter']");

    private static final String PROFILE_AVATAR_LOG_INFO = "Profile avatar should be visible on page 'Лента'.";
    private static final String FEED_FILTER_LOG_INFO = "Feed filter menu should be visible on page 'Лента'.";
    private static final String ONLINE_FRIENDS_PANEL_LOG_INFO = "Panel 'Друзья на сайте' should be visible on page 'Лента'.";
    private static final String PUBLISH_POST_BUTTON_LOG_INFO = "Button 'Запись' should be visible after clicking button 'Опубликоать'.";
    private static final String POST_TEXTBOX_LOG_INFO = "Post textbox should be visible while creating post.";
    private static final String SUBMIT_BUTTON_LOG_INFO = "Button 'Поделиться' should be visible while creating post.";

    public FeedPage() {
        checkPage();
    }

    public static boolean checkPage() {
        $(profileAvatar).shouldBe(
                visible.because(PROFILE_AVATAR_LOG_INFO)
        );
        $(feedFilterMenu).shouldBe(
                visible.because(FEED_FILTER_LOG_INFO)
        );
        $(onlineFriendsPanel).shouldBe(
                visible.because(ONLINE_FRIENDS_PANEL_LOG_INFO)
        );
        return true;
    }

    public void publishTextPost(String postText) {
        $(publishButton).shouldBe(
                visible.because(PUBLISH_BUTTON_LOG_INFO)
        ).click();
        $(publishPostButton).shouldBe(
                visible.because(PUBLISH_POST_BUTTON_LOG_INFO)
        ).click();
        $(postTextBox).shouldBe(
                visible.because(POST_TEXTBOX_LOG_INFO)
        ).setValue(postText);
        $(submitButton).shouldBe(
                visible.because(SUBMIT_BUTTON_LOG_INFO)
        ).click();
    }

    public MyProfilePage openMyProfilePage() {
        $(myProfileButton).shouldBe(
                visible.because(MY_PROFILE_BUTTON_LOG_INFO)
        ).click();
        return new MyProfilePage();
    }


    public boolean checkProfileNameContains(String email) {
        return $(myProfileButton).shouldBe(
                        visible.because(MY_PROFILE_BUTTON_LOG_INFO)
                ).getText()
                .contains(email);
    }
}
