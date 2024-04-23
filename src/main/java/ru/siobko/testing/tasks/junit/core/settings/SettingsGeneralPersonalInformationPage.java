package ru.siobko.testing.tasks.junit.core.settings;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SettingsGeneralPersonalInformationPage extends SettingsBasePage {
    private static final By nameField = byName("fr.name");
    private static final By surnameField = byName("fr.surname");
    private static final By submitButton = byXpath(".//input[@data-l='t,profile_form_settings']");

    public SettingsGeneralPersonalInformationPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(nameField).shouldBe(
                visible.because("Field 'Имя' should be visible on page 'Личные данные'.")
        );
        $(surnameField).shouldBe(
                visible.because("Field 'Фамилия' should be visible on page 'Личные данные'.")
        );
        $(submitButton).shouldBe(
                visible.because("Submit button should be visible on page 'Личные данные'.")
        );
        return true;
    }

    public SettingsGeneralPersonalInformationPage enterName(String name) {
        $(nameField).shouldBe(
                visible.because("Field 'Имя' should be visible on page 'Личные данные'.")
        ).setValue(name);
        return this;
    }

    public void clickSubmit() {
        $(submitButton).shouldBe(
                visible.because("Submit button should be visible on page 'Личные данные'.")
        ).click();
    }
}
