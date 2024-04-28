package ru.siobko.testing.tasks.junit.core.settings;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SettingsGeneralPersonalInformationPage extends SettingsBasePage {
    private static final By NAME_FIELD = byName("fr.name");
    private static final By SURNAME_FIELD = byName("fr.surname");
    private static final By SUBMIT_BUTTON = byXpath(".//input[@data-l='t,profile_form_settings']");

    public SettingsGeneralPersonalInformationPage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        $(NAME_FIELD).shouldBe(
                visible.because("Field 'Имя' should be visible on page 'Личные данные'.")
        );
        $(SURNAME_FIELD).shouldBe(
                visible.because("Field 'Фамилия' should be visible on page 'Личные данные'.")
        );
        $(SUBMIT_BUTTON).shouldBe(
                visible.because("Submit button should be visible on page 'Личные данные'.")
        );
        return true;
    }

    public SettingsGeneralPersonalInformationPage enterName(String name) {
        $(NAME_FIELD).shouldBe(
                visible.because("Field 'Имя' should be visible on page 'Личные данные'.")
        ).setValue(name);
        return this;
    }

    public void clickSubmit() {
        $(SUBMIT_BUTTON).shouldBe(
                visible.because("Submit button should be visible on page 'Личные данные'.")
        ).click();
    }
}
