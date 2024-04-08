package ru.siobko.testing.tasks.junit.core.settings;

import org.openqa.selenium.By;
import ru.siobko.testing.tasks.junit.core.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public abstract class SettingsBasePage extends BasePage {
    protected final By profileButton = byClassName("compact-profile_a");
    protected final By settingsNavigationMenu = byXpath(".//div[@data-l='eueContainer,settings']");
    protected final By navigationMenu = byXpath(".//nav[@data-l='t,horizontalNavigation']");

    protected SettingsBasePage() {
        checkPage();
    }

    private void checkPage() {
        $(profileButton).shouldBe(visible);
        $(settingsNavigationMenu).shouldBe(visible);
        $(navigationMenu).shouldBe(visible);
    }

    public boolean checkProfileNameContains(String newUserName) {
        return $(profileButton).getText().contains(newUserName);
    }
}
