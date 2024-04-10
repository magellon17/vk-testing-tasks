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

    protected SettingsBasePage() {
        checkPage();
    }

    private void checkPage() {
        $(settingsNavigationMenu).shouldBe(
                visible.because("Settings navigation menu should be visible on all settings pages.")
        );
        $(privacySettingsButton).shouldBe(
                visible.because("Button 'Публичность' should be visible on all settings pages.")
        );
        $(generalSettingsButton).shouldBe(
                visible.because("Button 'Основные' menu should be visible on all settings pages.")
        );
    }

    public boolean checkProfileNameContains(String newUserName) {
        return $(profileButton).getText().contains(newUserName);
    }
}
