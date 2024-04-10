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

    private static final String NAME_FIELD_LOG_INFO = "Field 'Имя' should be visible on page 'Личные данные'.";
    private static final String SURNAME_FIELD_LOG_INFO = "Field 'Фамилия' should be visible on page 'Личные данные'.";
    private static final String SUBMIT_BUTTON_LOG_INFO = "Submit button should be visible on page 'Личные данные'.";

    public SettingsGeneralPersonalInformationPage() {
        checkPage();
    }

    public static boolean checkPage() {
        $(nameField).shouldBe(
                visible.because(NAME_FIELD_LOG_INFO)
        );
        $(surnameField).shouldBe(
                visible.because(SURNAME_FIELD_LOG_INFO)
        );
        $(submitButton).shouldBe(
                visible.because(SUBMIT_BUTTON_LOG_INFO)
        );
        return true;
    }

    public void changeName(String newName) {
        $(nameField).shouldBe(
                visible.because(NAME_FIELD_LOG_INFO)
        ).setValue(newName);
        $(submitButton).shouldBe(
                visible.because(SUBMIT_BUTTON_LOG_INFO)
        ).click();
    }
}
