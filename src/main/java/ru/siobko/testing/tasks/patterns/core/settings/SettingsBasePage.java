package ru.siobko.testing.tasks.patterns.core.settings;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.tasks.patterns.core.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public abstract class SettingsBasePage extends BasePage {
    private static final Logger LOG = LoggerFactory.getLogger(SettingsBasePage.class);

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
                visible.because("Не отобразилась панель навигации по настройкам.")
        );
        $(PRIVACY_SETTINGS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка настроек приватности.")
        );
        $(GENERAL_SETTINGS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка основных настроек.")
        );
        return true;
    }

    public boolean checkProfileNameContains(String newUserName) {
        LOG.info("Проверяем, что имя профиля содержит {}", newUserName);
        return $(PROFILE_BUTTON).shouldBe(
                        visible.because("Не отобразилась кнопка профиля.")
                ).getText()
                .contains(newUserName);
    }
}
