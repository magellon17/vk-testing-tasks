package ru.siobko.testing.tasks.junit.core.settings;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SettingsGeneralPage extends SettingsBasePage {
    private static final By PERSONA_INFORMATION_FORM = byXpath(".//a[@data-l='t,profile_form']");
    private static final By PASSWORD_FORM = byXpath(".//a[@data-l='t,set_password']");
    private static final By EMAIL_FORM = byXpath(".//a[@data-l='t,set_email']");

    public SettingsGeneralPage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        $(PERSONA_INFORMATION_FORM).shouldBe(
                visible.because("Personal information form should be visible on general settings page.")
        );
        $(PASSWORD_FORM).shouldBe(
                visible.because("Password form should be visible on general settings page.")
        );
        $(EMAIL_FORM).shouldBe(
                visible.because("Email form should be visible on general settings page.")
        );
        return true;
    }

    public SettingsGeneralPersonalInformationPage openPersonalInformationPage() {
        $(PERSONA_INFORMATION_FORM).shouldBe(
                visible.because("Personal information form should be visible on general settings page.")
        ).click();
        return new SettingsGeneralPersonalInformationPage();
    }

}
