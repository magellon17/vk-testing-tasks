package ru.siobko.testing.tasks.selenide.pages.settings;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SettingsBasicPage extends SettingsBasePage {
    private final SelenideElement personaDataForm = $(byXpath(".//a[@data-l='t,profile_form']"));
    private final SelenideElement passwordForm = $(byXpath(".//a[@data-l='t,set_password']"));
    private final SelenideElement emailForm = $(byXpath(".//a[@data-l='t,set_email']"));

    public SettingsBasicPage() {
        checkPage();
    }

    private void checkPage() {
        personaDataForm.shouldBe(visible);
        passwordForm.shouldBe(visible);
        emailForm.shouldBe(visible);
    }

    public SettingsBasicPersonalDataPage openPersonalDataPage() {
        personaDataForm.click();
        return new SettingsBasicPersonalDataPage();
    }

}
