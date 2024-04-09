package ru.siobko.testing.tasks.junit.core.settings;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SettingsBasicPersonalDataPage extends SettingsBasePage {
    private static final By nameField = byName("fr.name");
    private static final By surnameField = byName("fr.surname");
    private static final By submitButton = byXpath(".//input[@data-l='t,profile_form_settings']");

    public SettingsBasicPersonalDataPage() {
        checkPage();
    }

    public static boolean checkPage() {
        $(nameField).shouldBe(visible);
        $(surnameField).shouldBe(visible);
        $(submitButton).shouldBe(visible);
        return true;
    }

    public void changeName(String newName) {
        $(nameField).setValue(newName);
        $(submitButton).click();
    }
}
