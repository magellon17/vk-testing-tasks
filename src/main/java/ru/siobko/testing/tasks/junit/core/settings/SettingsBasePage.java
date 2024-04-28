package ru.siobko.testing.tasks.junit.core.settings;

import org.openqa.selenium.By;
import ru.siobko.testing.tasks.junit.core.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public abstract class SettingsBasePage extends BasePage {
    protected static final By PROFILE_BUTTON = byClassName("compact-profile_a");
    protected static final By SETTINGS_NAVIGATION_MENU = byXpath(".//div[@data-l='eueContainer,settings']");
    protected static final By PRIVACY_SETTINGS_BUTTON = byXpath(".//a[@data-l='t,privacy']");
    protected static final By GENERAL_SETTINGS_BUTTON = byXpath(".//a[@data-l='t,personal_info']");

    protected SettingsBasePage() {
        checkPage();
    }

    @Override
    protected boolean checkPage() {
        $(SETTINGS_NAVIGATION_MENU).shouldBe(
                visible.because("Settings navigation menu should be visible on all settings pages.")
        );
        $(PRIVACY_SETTINGS_BUTTON).shouldBe(
                visible.because("Button 'Публичность' should be visible on all settings pages.")
        );
        $(GENERAL_SETTINGS_BUTTON).shouldBe(
                visible.because("Button 'Основные' menu should be visible on all settings pages.")
        );
        return true;
    }

    public boolean checkProfileNameContains(String newUserName) {
        return $(PROFILE_BUTTON).shouldBe(
                        visible.because("Profile button should be visible on all settings pages.")
                ).getText()
                .contains(newUserName);
    }
}
