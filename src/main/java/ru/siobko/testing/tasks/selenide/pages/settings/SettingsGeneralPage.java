package ru.siobko.testing.tasks.selenide.pages.settings;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SettingsGeneralPage extends SettingsBasePage {
    private static final By personaInformationForm = byXpath(".//a[@data-l='t,profile_form']");
    private static final By passwordForm = byXpath(".//a[@data-l='t,set_password']");
    private static final By emailForm = byXpath(".//a[@data-l='t,set_email']");

    public SettingsGeneralPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(personaInformationForm).shouldBe(
                visible.because("Personal information form should be visible on general settings page.")
        );
        $(passwordForm).shouldBe(
                visible.because("Password form should be visible on general settings page.")
        );
        $(emailForm).shouldBe(
                visible.because("Email form should be visible on general settings page.")
        );
        return true;
    }

    public SettingsGeneralPersonalInformationPage openPersonalInformationPage() {
        $(personaInformationForm).shouldBe(
                visible.because("Personal information form should be visible on general settings page.")
        ).click();
        return new SettingsGeneralPersonalInformationPage();
    }

}
