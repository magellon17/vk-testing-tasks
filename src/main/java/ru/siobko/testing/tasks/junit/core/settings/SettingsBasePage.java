package ru.siobko.testing.tasks.junit.core.settings;

import org.openqa.selenium.By;
import ru.siobko.testing.tasks.junit.core.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public abstract class SettingsBasePage extends BasePage {
    protected static final By profileButton = byClassName("compact-profile_a");
    protected static final By settingsNavigationMenu = byXpath(".//div[@data-l='eueContainer,settings']");
    protected static final By privacySettingsButton = byXpath(".//a[@data-l='t,privacy']");
    protected static final By generalSettingsButton = byXpath(".//a[@data-l='t,personal_info']");

    private static final String SETTINGS_NAVIGATION_MENU_LOG_INFO = "Settings navigation menu should be visible on all settings pages.";
    private static final String PRIVACY_SETTINGS_BUTTON_LOG_INFO = "Button 'Публичность' should be visible on all settings pages.";
    private static final String GENERAL_SETTINGS_BUTTON_LOG_INFO = "Button 'Основные' menu should be visible on all settings pages.";
    private static final String PROFILE_BUTTON_LOG_INFO = "Profile button should be visible on all settings pages.";

    protected SettingsBasePage() {
        checkPage();
    }

    private void checkPage() {
        $(settingsNavigationMenu).shouldBe(
                visible.because(SETTINGS_NAVIGATION_MENU_LOG_INFO)
        );
        $(privacySettingsButton).shouldBe(
                visible.because(PRIVACY_SETTINGS_BUTTON_LOG_INFO)
        );
        $(generalSettingsButton).shouldBe(
                visible.because(GENERAL_SETTINGS_BUTTON_LOG_INFO)
        );
    }

    public boolean checkProfileNameContains(String newUserName) {
        return $(profileButton).shouldBe(
                        visible.because(PROFILE_BUTTON_LOG_INFO)
                ).getText()
                .contains(newUserName);
    }
}
