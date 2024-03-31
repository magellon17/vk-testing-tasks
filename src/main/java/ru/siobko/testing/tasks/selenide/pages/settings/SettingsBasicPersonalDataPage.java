package ru.siobko.testing.tasks.selenide.pages.settings;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SettingsBasicPersonalDataPage extends SettingsBasePage {
    private final SelenideElement nameField = $(byName("fr.name"));
    private final SelenideElement surnameField = $(byName("fr.surname"));
    private final SelenideElement submitButton = $(byXpath(".//input[@data-l='t,profile_form_settings']"));

    public SettingsBasicPersonalDataPage() {
        checkPage();
    }

    private void checkPage() {
        nameField.shouldBe(visible);
        surnameField.shouldBe(visible);
        submitButton.shouldBe(visible);
    }

    public void changeName(String newName) {
        nameField.setValue(newName);
        submitButton.click();
    }
}
