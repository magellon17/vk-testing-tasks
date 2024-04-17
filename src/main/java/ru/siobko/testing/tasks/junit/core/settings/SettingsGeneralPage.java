package ru.siobko.testing.tasks.junit.core.settings;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SettingsGeneralPage extends SettingsBasePage {
    private static final By personaInformationForm = byXpath(".//a[@data-l='t,profile_form']");
    private static final By passwordForm = byXpath(".//a[@data-l='t,set_password']");
    private static final By emailForm = byXpath(".//a[@data-l='t,set_email']");

    private static final String PERSONAL_INFORMATION_FORM_LOG_INFO = "Personal information form should be visible on general settings page.";
    private static final String PASSWORD_FORM_LOG_INFO = "Password form should be visible on general settings page.";
    private static final String EMAIL_FORM_LOG_INFO = "Email form should be visible on general settings page.";

    public SettingsGeneralPage() {
        checkPage();
    }

    public static boolean checkPage() {
        $(personaInformationForm).shouldBe(
                visible.because(PERSONAL_INFORMATION_FORM_LOG_INFO)
        );
        $(passwordForm).shouldBe(
                visible.because(PASSWORD_FORM_LOG_INFO)
        );
        $(emailForm).shouldBe(
                visible.because(EMAIL_FORM_LOG_INFO)
        );
        return true;
    }

    public SettingsGeneralPersonalInformationPage openPersonalInformationPage() {
        $(personaInformationForm).shouldBe(
                visible.because(PERSONAL_INFORMATION_FORM_LOG_INFO)
        ).click();
        return new SettingsGeneralPersonalInformationPage();
    }

}
