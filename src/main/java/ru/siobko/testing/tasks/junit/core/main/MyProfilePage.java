package ru.siobko.testing.tasks.junit.core.main;

import org.openqa.selenium.By;
import ru.siobko.testing.tasks.junit.core.settings.SettingsGeneralPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MyProfilePage extends BaseMainPage {
    private static final By settingsButton = byXpath(".//li[@data-l='outlandertarget,settings,t,settings']");
    private static final By profileFeed = byXpath(".//div[@data-block='UserFeed']");
    private static final By lastFeedPostText = byClassName("media-text_cnt");
    private static final By lastFeedPostActionsMenu = byXpath(".//div[@data-l='t,feed-actions-menu']");
    private static final By feedFilterMenu = byXpath(".//div[@data-l='t,filter']");
    private static final By profileNavigationMenu = byXpath(".//nav[@data-l='t,horizontalNavigation']");

    private static final String FEED_FILTER_MENU_LOG_INFO = "Feed filter menu should be visible on my profile page.";
    private static final String PROFILE_NAVIGATION_MENU_LOG_INFO = "Navigation menu of profile feed should be visible on my profile page.";
    private static final String PROFILE_FEED_LOG_INFO = "Profile feed should be visible on my profile page.";
    private static final String LAST_FEED_POST_ACTIONS_MENU_LOG_INFO = "Actions menu of last feed post should be visible on my profile page.";
    private static final String LAST_FEED_POST_TEXT_LOG_INFO = "Text of last feed post should be visible on my profile page.";
    private static final String SETTINGS_BUTTON_LOG_INFO = "Button 'Настройки' should be visible on my profile page.";

    public MyProfilePage() {
        checkPage();
    }

    public static boolean checkPage() {
        $(feedFilterMenu).shouldBe(
                visible.because(FEED_FILTER_MENU_LOG_INFO)
        );
        $(profileNavigationMenu).shouldBe(
                visible.because(PROFILE_NAVIGATION_MENU_LOG_INFO)
        );
        $(profileFeed).shouldBe(
                visible.because(PROFILE_FEED_LOG_INFO)
        );
        return true;
    }

    public SettingsGeneralPage openProfileSettings() {
        $(settingsButton).shouldBe(
                visible.because(SETTINGS_BUTTON_LOG_INFO)
        ).click();
        return new SettingsGeneralPage();
    }

    public boolean checkLastFeedPostContains(String s) {
        return $(lastFeedPostText).shouldBe(
                        visible.because(LAST_FEED_POST_TEXT_LOG_INFO)
                ).getText()
                .contains(s);
    }

    public void deleteLastTextPost() {
        $(lastFeedPostActionsMenu)
                .shouldBe(
                        visible.because(LAST_FEED_POST_ACTIONS_MENU_LOG_INFO)
                ).scrollIntoView("{block: \"center\"}")
                .hover();
        $(byXpath(".//*[text()='Удалить заметку']"))
                .shouldBe(
                        visible.because("Button 'Удалить заметку' should be visible on post actions menu.")
                ).click();
    }
}
