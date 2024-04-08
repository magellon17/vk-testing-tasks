package ru.siobko.testing.tasks.junit.core.settings;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SettingsBasicPage extends SettingsBasePage {
    private final By personaDataForm = byXpath(".//a[@data-l='t,profile_form']");
    private final By passwordForm = byXpath(".//a[@data-l='t,set_password']");
    private final By emailForm = byXpath(".//a[@data-l='t,set_email']");

    public SettingsBasicPage() {
        checkPage();
    }

    private void checkPage() {
        $(personaDataForm).shouldBe(visible);
        $(passwordForm).shouldBe(visible);
        $(emailForm).shouldBe(visible);
    }

    public SettingsBasicPersonalDataPage openPersonalDataPage() {
        $(personaDataForm).click();
        return new SettingsBasicPersonalDataPage();
    }

}
