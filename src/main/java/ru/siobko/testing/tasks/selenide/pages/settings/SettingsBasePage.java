package ru.siobko.testing.tasks.selenide.pages.settings;

import com.codeborne.selenide.SelenideElement;
import ru.siobko.testing.tasks.selenide.pages.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public abstract class SettingsBasePage extends BasePage {
    protected final SelenideElement profileButton = $(byClassName("compact-profile_a"));
    protected final SelenideElement settingsNavigationMenu = $(byXpath(".//div[@data-l='eueContainer,settings']"));
    protected final SelenideElement navigationMenu = $(byXpath(".//nav[@data-l='t,horizontalNavigation']"));

    protected SettingsBasePage() {
        checkPage();
    }

    private void checkPage() {
        profileButton.shouldBe(visible);
        settingsNavigationMenu.shouldBe(visible);
        navigationMenu.shouldBe(visible);
    }

    public String getProfileName() {
        return profileButton.getText();
    }
}
